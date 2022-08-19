package com.speakr.entity;

/**
 * Provides fictional posts by fictional users for use in tests of the Post
 * class.
 * @author Alonso del Arte
 */
public class TestPostFactory {

    private static Post makeLunchBanalityPostFrom(User user) {
        return new Post();
    }

    private static Post makeWordleBanalityPostFrom(User user) {
        return new Post();
    }

    private static Post makeBanalPostFrom(User user) {
        return new Post();
    }

    private static Post makeSignificantPostFrom(User user) {
        return new Post();
    }

    // TODO: Write tests for this
    public static Post makeNewPostFrom(User user) {
        return new Post("Just enough to pass the first test", user);
    }

    // TODO: Write tests for this
    public static Post makeNewReply(Post post, User user) {
        return new Post();
    }

}
