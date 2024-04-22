package com.example.mongodb.service;

import com.example.mongodb.entity.User;
import com.example.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        System.out.println("into service");
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        User userRepo= userRepository.save(user);
        System.out.println(userRepo.getEmail()+"*+"+userRepo.getId());
        return  userRepo;
    }

    public  User getById(String id){
        return  userRepository.findById(id).get();
    }
    public List<User> getAllUsers(){
        return  userRepository.findAll();
    }
    public  User updateUser(User user)
    {
        return userRepository.save(user);
    }
    public  String deleteUserById(String id)
    {
        userRepository.deleteById(id);
        return "User deleted with id "+id;
    }
}
