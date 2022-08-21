package com.speakr.entity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of the Post class.
 * @author Alonso del Arte
 */
class PostTest {

    public static final Random RANDOM = new Random();

    /**
     * Test of the getReplies function of the Post class. This test adds a
     * single reply to a post and then checks that the reply can be retrieved.
     */
    @Test
    void testGetReplies() {
        System.out.println("getReplies");
        User originalPoster = TestUserFactory.createNewUser();
        Post post = TestPostFactory.makeNewPostFrom(originalPoster);
        User respondent = TestUserFactory.giveUserOtherThan(originalPoster);
        String replyText = "Couldn't agree more!";
        Post reply = new Post(replyText, respondent);
        post.addReply(reply);
        Set<Post> replies = post.getReplies();
        String msg = "Reply to \"" + post.getText() + "\" from "
                + post.getUser().getDisplayName() + " should include reply \""
                + replyText + "\" from " + respondent.getDisplayName();
        assert replies.contains(reply) : msg;
    }

    // TODO: Write test requiring getReplies() not to leak private field
    //  reference. Though with the mockery that Spring makes of access
    //  modifiers, this might be moot...

}