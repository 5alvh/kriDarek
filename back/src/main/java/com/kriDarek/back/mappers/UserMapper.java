package com.kriDarek.back.mappers;


import com.kriDarek.back.dtos.user.UserGetDto;
import com.kriDarek.back.dtos.user.UserRegisterDto;
import com.kriDarek.back.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public User registerDtoToUser(UserRegisterDto userRegisterDto) {
        return User.builder()
                .email(userRegisterDto.email())
                .password(userRegisterDto.password())
                .firstName(userRegisterDto.firstName())
                .lastName(userRegisterDto.lastName())
                .phone(userRegisterDto.phone())
                .avatar(userRegisterDto.avatar())
                .role(userRegisterDto.role())
                .build();
    }

    public UserGetDto userToGetDto(User user) {
        return UserGetDto.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .avatar(user.getAvatar())
                .role(user.getRole())
                .build();
    }
}
