package com.speakr.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.speakr.entity.Post;
import com.speakr.entity.User;
import com.speakr.entity.TestPostFactory;
import com.speakr.entity.TestUserFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MockPostService implements PostService {

    // TODO: Write tests for this
    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>();
    }

    // TODO: Write tests for this
    @Override
    public Post getPostById(int id) {
        return new Post();
    }

    // TODO: Write tests for this
    @Override
    public Post updatePost(Post post) {
        return new Post();
    }

    // TODO: Write tests for this
    @Override
    public Post deletePostById(int id) {
        return new Post();
    }

    // TODO: Write tests for this
    @Override
    public List<Post> getAllRecentPosts(Duration interval) {
        return new ArrayList<>();
    }

    // TODO: Write tests for this
    @Override
    public List<Post> getAllPostsFrom(User user) {
        return new ArrayList<>();
    }

    // TODO: Write tests for this
    @Override
    public List<Post> getAllRepliesTo(Post post) {
        return new ArrayList<>();
    }

    // TODO: Write tests for this
    @Override
    public Post editContent(Post post, String replacement) {
        return new Post();
    }

    // TODO: Write tests for this
    @Override
    public Post addPost(int userId, String text) {
        return null;
    }

    // TODO: Write tests for this
    @Override
    public Post addUpvote(int postId, int userId) throws JsonProcessingException {
        return null;
    }

    // TODO: Write tests for this
    @Override
    public List<Integer> getUpvoters(int postId) throws JsonProcessingException {
        return null;
    }

}
