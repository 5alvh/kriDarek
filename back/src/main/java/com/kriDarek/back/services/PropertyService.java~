package com.kriDarek.back.services;

import com.kriDarek.back.dtos.property.PropertyCreateDTO;
import com.kriDarek.back.dtos.property.PropertyGetDTO;
import com.kriDarek.back.dtos.property.PropertySearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PropertyService {
    Page<PropertyGetDTO> searchProperties(PropertySearchDTO searchDTO, Pageable pageable, Long userId);
    PropertyGetDTO getPropertyById(Long id, Long userId);
    PropertyGetDTO createProperty(PropertyCreateDTO propertyDTO, Long ownerId);
    PropertyGetDTO updateProperty(Long id, PropertyGetDTO propertyGetDTO, Long ownerId);
    void deleteProperty(Long id, Long ownerId);
    List<PropertyGetDTO> getMyProperties(Long ownerId);
}
