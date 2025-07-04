package com.kriDarek.back.services.impl;

import com.kriDarek.back.dtos.property.PropertyDTO;
import com.kriDarek.back.entities.Favorite;
import com.kriDarek.back.entities.Property;
import com.kriDarek.back.entities.User;
import com.kriDarek.back.exceptions.property.PropertyNotFoundException;
import com.kriDarek.back.exceptions.user.UserNotFoundException;
import com.kriDarek.back.mappers.PropertyMapper;
import com.kriDarek.back.repositories.FavoriteRepository;
import com.kriDarek.back.repositories.PropertyRepository;
import com.kriDarek.back.repositories.UserRepository;
import com.kriDarek.back.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    private UserRepository userRepository;
    @Autowired
    private PropertyMapper propertyMapper;

    public void addToFavorites(Long userId, Long propertyId) {
        if (favoriteRepository.existsByUserIdAndPropertyId(userId, propertyId)) {
            throw new IllegalStateException("Property already in favorites");
        }
        User owner = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new PropertyNotFoundException("Property not found"));

        Favorite favorite = new Favorite();
        favorite.setUser(owner);
        favorite.setProperty(property);

        favoriteRepository.save(favorite);
    }

    public void removeFromFavorites(Long userId, Long propertyId) {
        favoriteRepository.deleteByUserIdAndPropertyId(userId, propertyId);
    }

    public List<PropertyDTO> getUserFavorites(Long userId) {
        List<Favorite> favorites = favoriteRepository.findByUserIdOrderByCreatedAtDesc(userId);
        return favorites.stream()
                .map(favorite -> {
                    PropertyDTO dto = propertyMapper.toDTO(favorite.getProperty());
                    dto.setIsFavorite(true);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
