package com.kriDarek.back.dtos.property;


import com.kriDarek.back.enums.PropertyType;
import com.kriDarek.back.enums.TransactionType;

import java.math.BigDecimal;
import java.util.List;

public record PropertySearchDTO(
         PropertyType type,
     TransactionType transactionType,
     BigDecimal minPrice,
     BigDecimal maxPrice,
     Integer minBedrooms,
     Integer maxBedrooms,
     String city
){}
