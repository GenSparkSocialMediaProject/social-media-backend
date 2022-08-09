package com.speakr.service;

import com.speakr.entity.User;
import com.speakr.entity.TestUserFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MockUserService implements UserService {

    // TODO: Write tests for this
    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

    // TODO: Write tests for this
    @Override
    public User getUserById(int id) {
        return new User();
    }

    // TODO: Write tests for this
    @Override
    public User addUser(User user) {
        return new User();
    }

    // TODO: Write tests for this
    @Override
    public User updateUser(User user) {
        return new User();
    }

    // TODO: Write tests for this
    @Override
    public User deleteUserById(int id) {
        return new User();
    }

}
