package com.speakr.entity;

public class TestUserFactory {

    public static User createNewUser() {
        return new User("James Public III", "jPublic3",
                "NFL in-house counsel");
    }

    // TODO: Write tests for this
    public static User giveExistingUser() {
        return new User();
    }

}
