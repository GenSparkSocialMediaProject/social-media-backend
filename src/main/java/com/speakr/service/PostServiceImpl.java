package com.speakr.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.speakr.dao.PostDAO;
import com.speakr.dao.UserDAO;
import com.speakr.dao.VoteDAO;
import com.speakr.entity.Post;
import com.speakr.entity.User;
import com.speakr.entity.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService
{
    @Autowired
    private PostDAO postDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private VoteDAO voteDAO;

    @Override
    public List<Post> getAllPosts()
    {
        return postDAO.findAll();
    }

    @Override
    public Post getPostById(int id)
    {
        return postDAO.findAll().stream()
                .filter(post -> post.getPost_id() == id)
                .reduce((a, b) -> b).orElse(null);
    }

    @Override
    public Post updatePost(Post post)
    {
        return postDAO.save(post);
    }

    @Override
    public boolean deletePostById(int id)
    {
        postDAO.delete(this.getPostById(id));
        return true;
    }

    @Override
    public List<Post> getLatestPosts(int amount)
    {

        return postDAO.findAll().stream()
                .limit(amount)
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> getAllPostsFrom(User user)
    {
        return postDAO.findAll().stream()
                .filter(post -> post.getUser().equals(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> getAllRepliesTo(Post post)
    {
        return null;
    }

    @Override
    public Post editContent(Post post, String replacement)
    {
        post.setText(replacement);
        return postDAO.save(post);
    }

    @Override
    public Post addPost( String text, User user)
    {
        return postDAO.save(new Post(text, user));
    }

    @Override
    public Post addPost(Post post) { return postDAO.save(post); }

    @Override
    public Vote addUpvote(Post post, User user) throws JsonProcessingException
    {
        Vote upvote = new Vote(post, user, 1);
        return voteDAO.save(upvote);
    }

    @Override
    public int getUpvotes(Post post) throws JsonProcessingException
    {
        return voteDAO.findAll().stream()
                .filter(vote -> vote.getPost() == post)
                .map(Vote::getIncrement)
                .filter(inc -> inc == 1)
                .reduce(Integer::sum).orElse(0);
    }

}
