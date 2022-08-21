package com.speakr.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Provides fictional users for use in tests of the User class. Most of them are
 * named James Public followed by a number, with username "jPublic" with the
 * same number appended.
 * @author Alonso del Arte
 */
public class TestUserFactory {

    private static int userCount = 0;

    private static final List<User> USER_LIST = new ArrayList<>();

    public static User createNewUser() {
        String name = "jPublic" + userCount;
        String displayName = "James Public " + userCount;
        String bio = "World's #" + userCount + " best dad";
        User user = new User(name, displayName, bio);
        USER_LIST.add(user);
        userCount++;
        return user;
    }

    // TODO: Write tests for this
    public int recency(User user) {
        return Integer.MIN_VALUE;
    }

    public static User giveExistingUser() {
        if (userCount == 0) {
            String excMsg = "No existing users to give";
            throw new NoSuchElementException(excMsg);
        }
        int choice = (int) Math.floor(Math.random() * userCount);
        return USER_LIST.get(choice);
    }

    public static User giveUserOtherThan(User user) {
        User otherUser = giveExistingUser();
        if (otherUser.equals(user)) {
            return createNewUser();
        } else {
            return otherUser;
        }
    }

}
