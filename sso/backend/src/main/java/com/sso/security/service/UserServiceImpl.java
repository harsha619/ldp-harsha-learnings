package com.sso.security.service;

import com.sso.security.dto.LoginDTO;
import com.sso.security.dto.UserDto;
import com.sso.security.entity.User;
import com.sso.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto save(UserDto theUser) {
        return UserDto.convertEntityToDto(userRepository.save(UserDto.convertDtoToEntity(theUser)));
    }

    @Override
    public UserDto findUser(Long id) {
        Optional<User> theUser = userRepository.findById(id);
        return theUser.map(UserDto::convertEntityToDto).orElse(null);
    }

    @Override
    public UserDto getUserByEmailAndPassword(LoginDTO loginDTO) {
        Optional<User> user = userRepository.findByEmailAndPassword(loginDTO.getEmail(),loginDTO.getPassword());
        if(user.isEmpty()){
            throw new RuntimeException("Invalid email and password");
        }
        return UserDto.convertEntityToDto(user.get());
    }
}
