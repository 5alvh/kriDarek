package com.kriDarek.back.controller;

import com.kriDarek.back.dtos.property.PropertyCreateDto;
import com.kriDarek.back.dtos.property.PropertyDTO;
import com.kriDarek.back.entities.Property;
import com.kriDarek.back.services.PropertyService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public ResponseEntity<PropertyDTO> create(@RequestBody PropertyCreateDto propertyDTO) {
        //Get the id from the principal
        return ResponseEntity.ok(propertyService.createProperty(propertyDTO, 1L));
    }
}
