package com.kriDarek.back.services.impl;

import com.kriDarek.back.dtos.user.UserGetDto;
import com.kriDarek.back.dtos.user.UserRegisterDto;
import com.kriDarek.back.entities.User;
import com.kriDarek.back.exceptions.user.UserAlreadyExistsException;
import com.kriDarek.back.mappers.UserMapper;
import com.kriDarek.back.repositories.UserRepository;
import com.kriDarek.back.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserGetDto registerUser(UserRegisterDto userRegisterDto) {
        if (userRepository.existsByEmail(userRegisterDto.email())){
            throw new UserAlreadyExistsException("User with email " + userRegisterDto.email() + " already exists");
        }
        User userToSave = userMapper.registerDtoToUser(userRegisterDto);
        User savedUser = userRepository.save(userToSave);
        return userMapper.userToGetDto(savedUser);
    }
}
