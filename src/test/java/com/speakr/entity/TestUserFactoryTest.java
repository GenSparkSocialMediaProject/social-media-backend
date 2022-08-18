package com.speakr.entity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestUserFactoryTest {

    private static final Random RANDOM = new Random();

    /**
     * Set of all users created during one execution of this test class. Please
     * be sure to add any User created by TestUserFactory.createNewUser() to
     * this set. I am aware that the concern this addresses might be moot in
     * JUnit. It might be relevant in TestNG, I don't know.
     */
    private static final Set<User> USER_SET = new HashSet<>();

    @Test
    void testCreateNewUser() {
        System.out.println("createNewUser");
        User user = TestUserFactory.createNewUser();
        USER_SET.add(user);
        assert user.getUserName() != null : "User name should not be null";
        assert user.getDisplayName() != null
                : "Display name should not be null";
    }

    @Test
    void testNewUsersAreDistinct() {
        int expected = RANDOM.nextInt(128) + 32;
        Set<User> users = new HashSet<>(expected);
        for (int i = 0; i < expected; i++) {
            User user = TestUserFactory.createNewUser();
            users.add(user);
            USER_SET.add(user);
        }
        int actual = users.size();
        String msg = "createNewUser() should have given " + expected
                + " distinct users";
        assertEquals(expected, actual, msg);
    }










}
