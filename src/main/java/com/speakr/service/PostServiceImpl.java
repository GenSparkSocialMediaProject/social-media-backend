package com.speakr.service;

import com.speakr.entity.Post;
import com.speakr.entity.User;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public Post getPostById(int id) {
        return null;
    }

    @Override
    public Post updatePost(Post post) {
        return null;
    }

    @Override
    public Post deletePostById(int id) {
        return null;
    }

    @Override
    public List<Post> getAllRecentPosts(Duration interval) {
        return null;
    }

    @Override
    public List<Post> getAllPostsFrom(User user) {
        return null;
    }

    @Override
    public List<Post> getAllRepliesTo(Post post) {
        return null;
    }

    @Override
    public Post editContent(Post post, String replacement) {
        return null;
    }
}
