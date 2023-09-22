package com.sso.security.controller;


import com.sso.security.config.JWTGenerator;
import com.sso.security.dto.LoginDTO;
import com.sso.security.dto.UserDto;
import com.sso.security.service.UserService;
import com.sso.security.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@CrossOrigin(origins = {"http://localhost:8080"}, methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.PATCH,})

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JWTGenerator jwtGenerator;

    @GetMapping("/dashboard")
    public UserDto getUser(@RequestParam Integer userId){
        return userService.findUser(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
        System.out.println("login dto controller");
        try {
            if(loginDTO.getEmail() == null || loginDTO.getPassword() == null) {
                throw new RuntimeException("UserName or Password is Empty");
            }
            System.out.println(loginDTO);
            UserDto userData = userService.getUserByEmailAndPassword(loginDTO);
            if(userData == null){
                throw new RuntimeException("UserName or Password is Invalid");
            }
            return new ResponseEntity<>(jwtGenerator.generateToken(loginDTO), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
