package com.kriDarek.back.services;

import com.kriDarek.back.dtos.property.PropertyCreateDto;
import com.kriDarek.back.dtos.property.PropertyDTO;
import com.kriDarek.back.dtos.property.PropertySearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PropertyService {
    Page<PropertyDTO> searchProperties(PropertySearchDto searchDTO, Pageable pageable, Long userId);
    PropertyDTO getPropertyById(Long id, Long userId);
    PropertyDTO createProperty(PropertyCreateDto propertyDTO, Long ownerId);
    PropertyDTO updateProperty(Long id, PropertyDTO propertyDTO, Long ownerId);
    void deleteProperty(Long id, Long ownerId);
    List<PropertyDTO> getMyProperties(Long ownerId);
}
