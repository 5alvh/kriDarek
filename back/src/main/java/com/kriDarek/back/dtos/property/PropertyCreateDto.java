package com.kriDarek.back.dtos.property;

import com.kriDarek.back.dtos.user.UserDTO;
import com.kriDarek.back.entities.Address;
import com.kriDarek.back.enums.PropertyType;
import com.kriDarek.back.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PropertyCreateDto(
         String title,
         String description,
         BigDecimal price,
         PropertyType type,
         TransactionType transactionType,
         Integer bedrooms,
         Integer bathrooms,
         Double area,
         Integer yearBuilt,
         Address address,
         List<String>images,
         List<String> features
) {
}
