package com.kriDarek.back.dtos.property;


import com.kriDarek.back.enums.PropertyType;
import com.kriDarek.back.enums.TransactionType;

import java.math.BigDecimal;
import java.util.List;

public record PropertySearchDto(
         PropertyType type,
     TransactionType transactionType,
     BigDecimal minPrice,
     BigDecimal maxPrice,
     Integer minBedrooms,
     Integer maxBedrooms,
     Integer minBathrooms,
     Double minArea,
     Double maxArea,
     String city,
     String state,
     List<String> features,
     Double latitude,
     Double longitude,
     Double radius, // km
     String sortBy, // price, area, date
     String sortDirection // asc, desc
){}
