package com.speakr.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestUserFactoryTest {

    private static final Random RANDOM = new Random();

    @Test
    void testCreateNewUser() {
        System.out.println("createNewUser");
        User user = TestUserFactory.createNewUser();
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
        }
        int actual = users.size();
        String msg = "createNewUser() should have given " + expected
                + " distinct users";
        assertEquals(expected, actual, msg);
    }

    @Test
    void testRecency() {
        System.out.println("recency");
        User firstUser = TestUserFactory.createNewUser();
        String msg = "Most recent new user should have recency 0";
        assert TestUserFactory.recency(firstUser) == 0 : msg;
        int leastRecency = RANDOM.nextInt(16) + 4;
        String msgPart = firstUser.getDisplayName()
                + " should now have recency ";
        for (int expected = 1; expected < leastRecency; expected++) {
            User latestNewUser = TestUserFactory.createNewUser();
            assert TestUserFactory.recency(latestNewUser) == 0 : msg;
            int actual = TestUserFactory.recency(firstUser);
            String recencyMsg = msgPart + expected;
            assertEquals(expected, actual, recencyMsg);
        }
    }

    @Test
    void testNegativeRecencyForNonFactoryCreatedUser() {
        String name = "Mxy";
        String displayName = "Mr. Mxyzptlk";
        String bio = "Superman's best friend, Supergirl's too";
        User nonFactoryCreatedUser = new User(name, displayName, bio);
        int actual = TestUserFactory.recency(nonFactoryCreatedUser);
        String msg = "Given that this test class made " + displayName
                + " rather than the factory, recency should be negative";
        assert actual < 0 : msg;
    }

    @Test
    void testGiveExistingUser() {
        System.out.println("giveExistingUser");
        int capacity = RANDOM.nextInt(64) + 16;
        List<User> users = new ArrayList<>(capacity);
        while (users.size() < capacity) {
            User user = TestUserFactory.createNewUser();
            users.add(user);
        }
        User user = TestUserFactory.giveExistingUser();
        String msg = "giveExistingUser() gave user " + user.getUserName()
                + " who should have already been given by createNewUser()";
        assert TestUserFactory.recency(user) > -1 : msg;
    }

    @Test
    void testGiveUserOtherThan() {
        System.out.println("giveUserOtherThan");
        User user = TestUserFactory.createNewUser();
        User otherUser = TestUserFactory.giveUserOtherThan(user);
        String msg = "giveUserOtherThan() should give user other than "
                + user.getUserName();
        assertNotEquals(user, otherUser, msg);
    }

}
