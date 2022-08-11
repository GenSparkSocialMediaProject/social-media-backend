package com.speakr.controller;

import com.speakr.entity.User;
import com.speakr.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/users/add/{userName}/{displayName}/{bio}")
    public User addUser(@PathVariable String userName,@PathVariable String displayName,@PathVariable String bio){
        return this.userService.addUser(userName,displayName,bio);
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
