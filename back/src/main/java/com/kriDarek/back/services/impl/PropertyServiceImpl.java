package com.kriDarek.back.services.impl;

import com.kriDarek.back.dtos.property.PropertyCreateDto;
import com.kriDarek.back.dtos.property.PropertyDTO;
import com.kriDarek.back.dtos.property.PropertySearchDto;
import com.kriDarek.back.entities.Property;
import com.kriDarek.back.entities.User;
import com.kriDarek.back.exceptions.user.UserNotFoundException;
import com.kriDarek.back.mappers.PropertyMapper;
import com.kriDarek.back.repositories.FavoriteRepository;
import com.kriDarek.back.repositories.PropertyRepository;
import com.kriDarek.back.repositories.UserRepository;
import com.kriDarek.back.services.PropertyService;
import jakarta.el.PropertyNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;
    private final FavoriteRepository favoriteRepository;
    private final PropertyMapper propertyMapper;
    private final UserRepository userRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository, FavoriteRepository favoriteRepository, PropertyMapper propertyMapper, UserRepository userRepository) {
        this.propertyRepository = propertyRepository;
        this.favoriteRepository = favoriteRepository;
        this.propertyMapper = propertyMapper;
        this.userRepository = userRepository;
    }

    @Override
    public Page<PropertyDTO> searchProperties(PropertySearchDto searchDTO, Pageable pageable, Long userId) {
        Page<Property> properties = propertyRepository.findBySearchCriteria(
                searchDTO.type(),
                searchDTO.transactionType(),
                searchDTO.minPrice(),
                searchDTO.maxPrice(),
                searchDTO.minBedrooms(),
                searchDTO.maxBedrooms(),
                searchDTO.city(),
                pageable
        );

        return properties.map(property -> {
            PropertyDTO dto = propertyMapper.toDTO(property);
            if (userId != null) {
                dto.setIsFavorite(favoriteRepository.existsByUserIdAndPropertyId(userId, property.getId()));
            }
            return dto;
        });
    }

    @Override
    public PropertyDTO getPropertyById(Long id, Long userId) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Property not found"));

        PropertyDTO dto = propertyMapper.toDTO(property);
        if (userId != null) {
            dto.setIsFavorite(favoriteRepository.existsByUserIdAndPropertyId(userId, id));
        }

        return dto;
    }

    @Override
    public PropertyDTO createProperty(PropertyCreateDto propertyDTO, Long ownerId) {
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        Property property = propertyMapper.toEntity(propertyDTO);
        property.setOwner(owner);
        property.setActive(true);

        Property savedProperty = propertyRepository.save(property);
        return propertyMapper.toDTO(savedProperty);
    }

    //check if the owener of the property is the same as the user
    @Override
    public PropertyDTO updateProperty(Long id, PropertyDTO propertyDTO, Long ownerId) {
        Property existingProperty = propertyRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Property not found"));

        propertyMapper.updateEntity(propertyDTO, existingProperty);
        Property savedProperty = propertyRepository.save(existingProperty);

        return propertyMapper.toDTO(savedProperty);
    }

    //check if the owner of the property is the same as the user
    @Override
    public void deleteProperty(Long id, Long ownerId) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Property not found"));

        property.setActive(false);
        propertyRepository.save(property);
    }

    @Override
    public List<PropertyDTO> getMyProperties(Long ownerId) {
        List<Property> properties = propertyRepository.findByOwnerIdAndActiveTrue(ownerId);
        return propertyMapper.toDTOList(properties);
    }
}
