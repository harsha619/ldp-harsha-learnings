package com.sso.security.service;

import com.sso.security.dto.LoginDTO;
import com.sso.security.dto.UserDto;

public interface UserService {
    UserDto save(UserDto user);
    UserDto findUser(Integer id);
    UserDto getUserByEmailAndPassword(LoginDTO loginDTO);

}
