package com.kriDarek.back.services;

import com.kriDarek.back.dtos.user.UserGetDto;
import com.kriDarek.back.dtos.user.UserRegisterDto;

public interface UserService {

    UserGetDto registerUser(UserRegisterDto userRegisterDto);
}
