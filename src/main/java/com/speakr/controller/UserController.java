package com.speakr.controller;

import com.speakr.entity.User;
import com.speakr.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    // TODO: Write tests for this
    @GetMapping("/")
    public String homePage() {
        return "NOT IMPLEMENTED YET";
    }

    // TODO: Write tests for this
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // TODO: Write tests for this
    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable String userId) {
        return this.userService.getUserById(Integer.parseInt(userId));
    }

    // TODO: Write tests for this
    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    // TODO: Write tests for this
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    // TODO: Write tests for this
    @DeleteMapping("/users/{userId}")
    public String deleteByUserId(@PathVariable String userId) {
        return "NOT IMPLEMENTED YET";
        // this.userService.deleteUserById(Integer.parseInt(userId));
    }

}
