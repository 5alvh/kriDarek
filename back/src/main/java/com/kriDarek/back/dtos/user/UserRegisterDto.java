package com.kriDarek.back.dtos.user;


import com.kriDarek.back.enums.UserRole;

public record UserRegisterDto (String email,
                               String password,
                               String firstName,
                               String lastName,
                               String phone,
                               String avatar,
                               UserRole role){
}
