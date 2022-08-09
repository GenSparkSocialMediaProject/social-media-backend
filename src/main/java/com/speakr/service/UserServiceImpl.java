package com.speakr.service;

import com.speakr.dao.UserDAO;
import com.speakr.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getAllUsers() {
        return this.userDAO.findAll();
    }

    @Override
    public User getUserById(int id) {
        Optional<User> option = this.userDAO.findById(id);
        return option.orElse(null);
    }

    @Override
    public User addUser(User user) {
        return this.userDAO.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userDAO.save(user);
    }

    @Override
    public User deleteUserById(int id) {
        Optional<User> option = this.userDAO.findById(id);
        return option.orElse(null);
    }

}
