package com.speakr.entity;

import java.util.Random;

import org.junit.jupiter.api.Test;

class UserTest {

    private static final Random RANDOM = new Random();

    @Test
    void testSameIdAs() {
        User userA = new User();
        User userB = new User();
        int pseudorandomId = RANDOM.nextInt(1024) + 16;
        userA.setId(pseudorandomId);
        userB.setId(pseudorandomId);
        String msg = "Since both " + userA + " and " + userB + " have ID "
                + pseudorandomId + ", sameIdAs() should return true";
        assert userA.sameIdAs(userB) : msg;
    }

}