package com.speakr.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestUserFactoryTest {

    @Test
    void testCreateNewUser() {
        System.out.println("createNewUser");
        User user = TestUserFactory.createNewUser();
        assert user.getUserName() != null : "User name should not be null";
        assert user.getDisplayName() != null
                : "Display name should not be null";
    }

}
