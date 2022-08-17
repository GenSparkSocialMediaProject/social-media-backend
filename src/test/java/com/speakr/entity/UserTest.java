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
//        fail("Test needs rewriting");
//        userA.setId(pseudorandomId);
//        userB.setId(pseudorandomId);
//        String msg = "Since both " + userA + " and " + userB + " have ID "
//                + pseudorandomId + ", sameIdAs() should return true";
//        assert userA.sameIdAs(userB) : msg;
    }

    @Test
    void testNotSameIdAs() {
        User userA = new User();
        User userB = new User();
        int pseudorandomIdA = RANDOM.nextInt(1024) + 16;
        int pseudorandomIdB = pseudorandomIdA + RANDOM.nextInt(1024) + 16;
//        fail("Test needs rewriting");
//        userA.setId(pseudorandomIdA);
//        userB.setId(pseudorandomIdB);
//        String msg = "Given that " + userA + " has ID " + pseudorandomIdA
//                + " and " + userB + " has ID " + pseudorandomIdB
//                + " sameIdAs() should return false";
//        assert !userA.sameIdAs(userB) : msg;
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
//        fail("Test needs rewriting");
//        userA.setId(idForUserA);
//        User userB = new User();
//        int idForUserB = idForUserA + RANDOM.nextInt(8192) + 1;
//        userB.setId(idForUserB);
//        String msg = "Since userA has ID " + idForUserA + " and userB has ID "
//                + idForUserB + ", they should not be considered equal";
//        assertNotEquals(userA, userB, msg);
    }

    @Test
    void testEquals() {
        System.out.println("equals");
        int id = RANDOM.nextInt();
        String userName = "MariaElena";
        User someUser = new User();
        User sameUser = new User();
//        fail("Test needs rewriting");
//        someUser.setId(id);
//        sameUser.setId(id);
//        someUser.setUserName(userName);
//        sameUser.setUserName(userName);
//        String msg = "As the two users both have ID " + id + " and user name "
//                + userName + ", they should be considered equal";
//        assertEquals(someUser, sameUser, msg);
    }

    @Test
    void testNotEqualsDiffUserName() {
        int id = RANDOM.nextInt();
        String userNameA = "Lando Calrissian Jones";
        String userNameB = "Lando Calrissian Williams";
        User userA = new User();
        User userB = new User();
//        fail("Test needs rewriting");
//        userA.setId(id);
//        userB.setId(id);
//        userA.setUserName(userNameA);
//        userB.setUserName(userNameB);
//        String msg = "Although both user " + userNameA + " and user "
//                + userNameB + " have ID " + id
//                + " they should not be considered equal";
//        assertNotEquals(userA, userB, msg);
    }

    /**
     * Test of the hashCode function, of the User class. The ID and hash code of
     * a User should match in order to keep things simple.
     */
    @Test
    void testHashCode() {
        System.out.println("hashCode");
        int start = RANDOM.nextInt();
        int stop = start + RANDOM.nextInt(128) + 32;
        User user = new User();
//        fail("Test needs rewriting");
//        for (int expected = start; expected < stop; expected++) {
//            user.setId(expected);
//            int actual = user.hashCode();
//            assertEquals(expected, actual);
//        }
    }

}
