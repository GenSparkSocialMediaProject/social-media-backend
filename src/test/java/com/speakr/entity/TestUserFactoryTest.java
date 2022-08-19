package com.speakr.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
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

    @Test
    void testGiveExistingUser() {
        int capacity = RANDOM.nextInt(64) + 16;
        List<User> users = new ArrayList<>(capacity);
        while (users.size() < capacity) {
            User user = TestUserFactory.createNewUser();
            users.add(user);
            USER_SET.add(user);
        }
        User user = TestUserFactory.giveExistingUser();
        String msg = "giveExistingUser() gave user " + user.getUserName()
                + " who should have already been given by createNewUser()";
        assert USER_SET.contains(user) : msg;
    }

    @Test
    void testGiveUserOtherThan() {
        System.out.println("giveUserOtherThan");
        User user = TestUserFactory.createNewUser();
        User otherUser = TestUserFactory.giveUserOtherThan(user);
        USER_SET.add(user);
        USER_SET.add(otherUser);
        String msg = "giveUserOtherThan( ) should give user other than "
                + user.getUserName();
        assertNotEquals(user, otherUser, msg);
    }

    @AfterEach
    void reportUserSetSize() {
        System.out.println("User set has " + USER_SET.size() + " users");
    }

}
