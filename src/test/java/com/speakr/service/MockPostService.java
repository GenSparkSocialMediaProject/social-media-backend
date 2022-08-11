package com.speakr.service;

import com.speakr.entity.Post;
import com.speakr.entity.User;
import com.speakr.entity.TestPostFactory;
import com.speakr.entity.TestUserFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

}
