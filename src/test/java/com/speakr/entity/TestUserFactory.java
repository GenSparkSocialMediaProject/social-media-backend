package com.speakr.entity;

import java.util.ArrayList;
import java.util.List;

public class TestUserFactory {

    private static int userCount = 0;

    private static List<User> userList = new ArrayList<>();

    public static User createNewUser() {
        String name = "James Public " + userCount;
        String displayName = "jPublic" + userCount;
        String bio = "World's #" + userCount + " best dad";
        User user = new User(name, displayName, bio);
        userList.add(user);
        userCount++;
        return user;
    }

    // TODO: Write tests for this
    public static User giveExistingUser() {
        return new User();
    }

}
