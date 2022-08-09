package com.speakr.entity;

import java.util.Random;

import org.junit.jupiter.api.Test;

class UserTest {

    private static final Random RANDOM = new Random();

    @Test
    void testSameIdAs() {
        System.out.println("sameIdAs");
        User userA = new User();
        User userB = new User();
        int pseudorandomId = RANDOM.nextInt(1024) + 16;
        userA.setId(pseudorandomId);
        userB.setId(pseudorandomId);
        String msg = "Since both " + userA + " and " + userB + " have ID "
                + pseudorandomId + ", sameIdAs() should return true";
        assert userA.sameIdAs(userB) : msg;
    }

    @Test
    void testNotSameIdAs() {
        User userA = new User();
        User userB = new User();
        int pseudorandomIdA = RANDOM.nextInt(1024) + 16;
        int pseudorandomIdB = pseudorandomIdA + RANDOM.nextInt(1024) + 16;
        userA.setId(pseudorandomIdA);
        userB.setId(pseudorandomIdB);
        String msg = "Given that " + userA + " has ID " + pseudorandomIdA
                + " and " + userB + " has ID " + pseudorandomIdB
                + " sameIdAs() should return false";
        assert !userA.sameIdAs(userB) : msg;
    }

}