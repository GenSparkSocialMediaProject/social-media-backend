package com.speakr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.speakr.entity.Post;
import com.speakr.entity.User;
import com.speakr.service.PostService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostService postService;
    @PostMapping("/posts/add/{userId}/{post}")
    public Post addUser(@PathVariable int userId, @PathVariable String post){
        return this.postService.addPost("FOR TESTING PURPOSES", new User());
    }

    @PostMapping("/posts/add/{postId}/upvote")
    public Post addUser(@PathVariable int postId)
            throws JsonProcessingException {
        return new Post();// this.postService.addUpvote(postId, 14);
    }

    @GetMapping("/posts/upvoters/{postId}")
    public List<Integer> getUpvoters(@PathVariable int postId)
            throws JsonProcessingException {
        return new java.util.ArrayList<>();// this.postService.getUpvoters(postId);
    }

}
