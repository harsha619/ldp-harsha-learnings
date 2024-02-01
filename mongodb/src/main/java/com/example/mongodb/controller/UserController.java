package com.example.mongodb.controller;

import com.example.mongodb.entity.User;
import com.example.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User saveUser ( @RequestBody User user){
        System.out.println("into controller");
        User savedUser= userService.createUser(user);
        System.out.println("cont"+savedUser.getId());
         return  savedUser;

    }
    @GetMapping("/get-by-id/{id}")
    public User getUser ( @PathVariable String id){
        System.out.println("into controller");
        User savedUser= userService.getById(id);
        System.out.println("cont"+savedUser.getId());
        return  savedUser;

    }
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updatedUser= userService.updateUser(user);
        ResponseEntity<User> userResponse= new ResponseEntity<User>(user, HttpStatus.CREATED);
        return    userResponse;
    }

    @DeleteMapping("/remove/{id}")
    public  ResponseEntity<String> removeUser(@PathVariable String id){
        String message= userService.deleteUserById(id);
        ResponseEntity<String> userResponse= new ResponseEntity<String>(message, HttpStatus.CREATED);
        return    userResponse;
    }
}
