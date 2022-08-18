package com.speakr.service;

import com.speakr.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

    User addUser(User user);

    User addUser(String userName, String displayName, String bio);

    User updateUser(User user);

    User deleteUserById(int id);

}
