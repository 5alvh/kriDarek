package com.kriDarek.back.services;

import com.kriDarek.back.dtos.property.PropertyGetDTO;

import java.util.List;

public interface FavoriteService {
    void addToFavorites(Long userId, Long propertyId);
    void removeFromFavorites(Long userId, Long propertyId);
    List<PropertyGetDTO> getUserFavorites(Long userId);
}
