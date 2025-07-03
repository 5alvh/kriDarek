package com.kriDarek.back.mappers;

import com.kriDarek.back.dtos.property.PropertyCreateDto;
import com.kriDarek.back.dtos.property.PropertyDTO;
import com.kriDarek.back.dtos.user.UserDTO;
import com.kriDarek.back.entities.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PropertyMapper {

    public PropertyDTO toDTO(Property property) {
        PropertyDTO dto = new PropertyDTO();
        dto.setId(property.getId());
        dto.setTitle(property.getTitle());
        dto.setDescription(property.getDescription());
        dto.setPrice(property.getPrice());
        dto.setType(property.getType());
        dto.setTransactionType(property.getTransactionType());
        dto.setBedrooms(property.getBedrooms());
        dto.setBathrooms(property.getBathrooms());
        dto.setArea(property.getArea());
        dto.setYearBuilt(property.getYearBuilt());
        dto.setAddress(property.getAddress());
        dto.setImages(mapToImageUrls(property.getImages()));
        dto.setFeatures(mapToFeatureNames(property.getFeatures()));
        dto.setOwner(mapToUserDTO(property.getOwner()));
        dto.setCreatedAt(property.getCreatedAt());
        return dto;
    }

    public Property toEntity(PropertyCreateDto dto) {
        Property property = new Property();
        property.setTitle(dto.title());
        property.setDescription(dto.description());
        property.setPrice(dto.price());
        property.setType(dto.type());
        property.setTransactionType(dto.transactionType());
        property.setBedrooms(dto.bedrooms());
        property.setBathrooms(dto.bathrooms());
        property.setArea(dto.area());
        property.setYearBuilt(dto.yearBuilt());
        property.setAddress(dto.address());
        //property.setImages();
        return property;
    }

    public List<PropertyImage> toImageProperty(List<String> images) {
        return images.stream()
                .map(image -> {
                    PropertyImage propertyImage = new PropertyImage();
                    propertyImage.setImageUrl(image);
                    return propertyImage;
                })
                .collect(Collectors.toList());
    }
    public void updateEntity(PropertyDTO dto, Property property) {
        property.setTitle(dto.getTitle());
        property.setDescription(dto.getDescription());
        property.setPrice(dto.getPrice());
        property.setType(dto.getType());
        property.setTransactionType(dto.getTransactionType());
        property.setBedrooms(dto.getBedrooms());
        property.setBathrooms(dto.getBathrooms());
        property.setArea(dto.getArea());
        property.setYearBuilt(dto.getYearBuilt());
        property.setAddress(dto.getAddress());
    }

    public List<PropertyDTO> toDTOList(List<Property> properties) {
        return properties.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private List<String> mapToImageUrls(List<PropertyImage> images) {
        return images.stream()
                .map(PropertyImage::getImageUrl)
                .collect(Collectors.toList());
    }

    private List<String> mapToFeatureNames(List<PropertyFeature> features) {
        return features.stream()
                .map(pf -> pf.getFeature().getName())
                .collect(Collectors.toList());
    }

    private UserDTO mapToUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        return dto;
    }
}