package com.speakr.dao;

import com.speakr.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    default User findUserByUserName(String user_name)
    {
        return this.findAll().stream()
                .filter(user -> Objects.equals(user.getUser_name(), user_name))
                .reduce((a, b) -> { throw new IllegalStateException("Multiple users: " + a + ", " + b);
                })
                .orElse(null);
    }

}
