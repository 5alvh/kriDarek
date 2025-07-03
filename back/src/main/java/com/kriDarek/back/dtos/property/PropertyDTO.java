package com.kriDarek.back.dtos.property;


import com.kriDarek.back.dtos.user.UserDTO;
import com.kriDarek.back.entities.Address;
import com.kriDarek.back.enums.PropertyType;
import com.kriDarek.back.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private PropertyType type;
    private TransactionType transactionType;
    private Integer bedrooms;
    private Integer bathrooms;
    private Double area;
    private Integer yearBuilt;
    private Address address;
    private List<String> images;
    private List<String> features;
    private UserDTO owner;
    private Boolean isFavorite;
    private LocalDateTime createdAt;
}