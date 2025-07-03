package com.kriDarek.back.dtos.user;


import com.kriDarek.back.enums.UserRole;
import lombok.Builder;

@Builder
public record UserGetDto (String email,
                          String firstName,
                          String lastName,
                          String phone,
                          String avatar,
                          UserRole role){
}
