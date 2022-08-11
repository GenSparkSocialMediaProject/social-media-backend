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
    public void testPlaceholder() {
        throw new AssertionError("This test is a placeholder");
    }
    @Test
    public void addUser() {
        User user1 = new User(1,"alacielx","Alaciel D.","Hello");
        this.mockUserService.addUser(user1);
        throw new AssertionError("This test is a placeholder");
    }

}
