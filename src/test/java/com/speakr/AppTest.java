package com.speakr;

import com.speakr.entity.User;
import com.speakr.service.MockUserService;
import com.speakr.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Autowired
    MockUserService mockUserService;

    @Test
    public void addUser() {
        String userName = "alacielx";
        String displayName = "Alaciel D.";
        String bio = "Hello";
        User user1 = new User(userName, displayName, bio);
        this.mockUserService.addUser(user1);
        // TODO: Finish writing the test and remove the next line
        throw new AssertionError("Haven't finished writing this test");
    }

}
