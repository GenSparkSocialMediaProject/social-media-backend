package com.speakr.service;

import com.speakr.entity.Post;
import com.speakr.entity.User;

import java.time.Duration;
import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post getPostById(int id);

    Post updatePost(Post post);

    Post deletePostById(int id);

    List<Post> getAllRecentPosts(Duration interval);

    List<Post> getAllPostsFrom(User user);

    List<Post> getAllRepliesTo(Post post);

    Post editContent(Post post, String replacement);

}
