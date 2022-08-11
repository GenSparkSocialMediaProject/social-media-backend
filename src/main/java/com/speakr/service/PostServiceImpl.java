package com.speakr.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.speakr.dao.PostDAO;
import com.speakr.dao.UserDAO;
import com.speakr.entity.Post;
import com.speakr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostDAO postDAO;
    @Autowired
    private UserDAO userDAO;
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

    @Override
    public Post addPost(int userId, String text) {
        return postDAO.save(new Post(14,"Hello this is a post"));
    }

    @Override
    public Post addUpvote(int postId, int userId) throws JsonProcessingException {
        Post p = postDAO.getReferenceById(postId);
        p.addUpVoter(userId);
        return postDAO.save(p);
    }

    @Override
    public List<Integer> getUpvoters(int postId) throws JsonProcessingException {
        Post p = postDAO.getReferenceById(postId);

        return p.getUpVoters();
    }
}
