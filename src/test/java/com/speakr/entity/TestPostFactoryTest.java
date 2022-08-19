package com.speakr.entity;

import java.util.Date;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the TestPostFactory class.
 * @author Alonso del Arte
 */
class TestPostFactoryTest {

    @Test
    void testMakeNewPostFrom() {
        System.out.println("makeNewPostFrom");
        User expected = TestUserFactory.createNewUser();
        Post post = TestPostFactory.makeNewPostFrom(expected);
        User actual = post.getUser();
        String msg = "Expecting new post to be from " + expected.getUserName();
        assertEquals(expected, actual, msg);
        assert post.getText() != null : "Post text must not be null";
        assert post.getPostTime() != null : "Post timestamp must not be null";
        assert post.getReplies().size() == 0
                : "New post should not have replies already";
    }

    // TODO: Write test requiring new posts to be distinct

}
