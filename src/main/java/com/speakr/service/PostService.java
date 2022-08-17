package com.speakr.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.speakr.entity.Post;
import com.speakr.entity.User;
import com.speakr.entity.Vote;

import java.time.Duration;
import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post getPostById(int id);

    Post updatePost(Post post);

    boolean deletePostById(int id);

    List<Post> getLatestPosts(int amount);

    List<Post> getAllPostsFrom(User user);

    List<Post> getAllRepliesTo(Post post);

    Post editContent(Post post, String replacement);

    Post addPost(String text, User user);
<<<<<<< HEAD

    Vote addUpvote(Post post, User user) throws JsonProcessingException;
    int getUpvotes(Post post) throws JsonProcessingException;

    Post addPost(Post post);
=======
>>>>>>> 6e1ceb4b86e938fba730f32a878253ba68fdae79

    Vote addUpvote(Post post, User user) throws JsonProcessingException;
    int getUpvotes(Post post) throws JsonProcessingException;
    
    Post addPost(Post post);
}
