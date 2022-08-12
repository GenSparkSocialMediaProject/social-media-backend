package com.speakr.entity;

import java.util.Random;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the User class.
 * @author Alonso del Arte
 */
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

    @Test
    void testReferentialEquality() {
        User user = new User();
        assertEquals(user, user);
    }

    private User provideNull() {
        return null;
    }

    @Test
    void testNotEqualsNull() {
        User user = new User();
        String msg = user + " should not equal null";
        assert !user.equals(this.provideNull()) : msg;
    }

    private Object provideDiffClassObject() {
        return new Post();
    }

    @Test
    void testNotEqualsDiffClass() {
        User user = new User();
        Object obj = this.provideDiffClassObject();
        String msg = user + " should not equal " + obj;
        assert !user.equals(this.provideDiffClassObject()) : msg;
    }

    @Test
    void testNotEqualsDiffID() {
        User userA = new User();
        int idForUserA = RANDOM.nextInt();
        userA.setId(idForUserA);
        User userB = new User();
        int idForUserB = idForUserA + RANDOM.nextInt(8192) + 1;
        userB.setId(idForUserB);
        String msg = "Since userA has ID " + idForUserA + " and userB has ID "
                + idForUserB + ", they should not be considered equal";
        assertNotEquals(userA, userB, msg);
    }















}