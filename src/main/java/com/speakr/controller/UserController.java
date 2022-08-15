package com.speakr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.speakr.dao.PostDAO;
import com.speakr.dao.UserDAO;
import com.speakr.dao.VoteDAO;
import com.speakr.entity.Post;
import com.speakr.entity.User;
import com.speakr.entity.Vote;
import com.speakr.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class UserController
{
	@Autowired
	PostService postService;
	@Autowired
	UserDAO userDAO;
	@Autowired
	PostDAO postDAO;
	@Autowired
	VoteDAO voteDAO;
	
	@PostMapping("/posts/add")
	public Post addPost(@RequestBody Post post)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User user = userDAO.findUserByUserName(username);
		post.setUser(user);
		post.setPostTime(new Date());
		Post tmp = this.postService.addPost(post);
		tmp.setUser(null);
		return tmp;
	}
	
	@GetMapping("/posts")
	public List<Post> getPosts(@RequestBody(required = false) Integer amount)
	{
		if (amount != null) { return postService.getLatestPosts(amount); }
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return postService.getAllPosts();
	}
	
	@PostMapping("/posts/add/{postId}")
	public Vote upvote(@PathVariable int postId) throws JsonProcessingException
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User user = userDAO.findUserByUserName(username);
		var nVote = new Vote(postDAO.getReferenceById(postId), user, 1);
		if (voteDAO.findAll().stream()
			.filter(vote ->
				vote.getUser() == nVote.getUser() &&
					vote.getPost() == nVote.getPost())
			.collect(Collectors.toList()).size() > 0)
		{
			return nVote;
		}
		return this.postService.addUpvote(postDAO.getReferenceById(postId), user);
	}
	
	@GetMapping("/posts/upvotes/{postId}")
	public int getUpvotes(@PathVariable int postId) throws JsonProcessingException
	{
		return this.postService.getUpvotes(postDAO.getReferenceById(postId));
	}
	
	@GetMapping("/user/")
	public Map<String, String> getUserName()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Map<String, String> userMap = new HashMap<>();
		userMap.put("users", authentication.getName());
		userMap.put("error", "false");
		return userMap;
	}
	
}