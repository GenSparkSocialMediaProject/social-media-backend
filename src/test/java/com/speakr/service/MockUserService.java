package com.speakr.service;

import com.speakr.dao.UserDAO;
import com.speakr.entity.User;
import com.speakr.entity.TestPostFactory;
import com.speakr.entity.TestUserFactory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MockUserService implements UserService {

    @Autowired
    private UserDAO userDAO;


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
        return this.userDAO.save(user);
    }

    @Override
    public User addUser(String userName, String displayName, String bio) {
        return null;
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
