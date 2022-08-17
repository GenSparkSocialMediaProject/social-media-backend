package com.speakr.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping
	public Map<String, String> getUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Map<String, String> userMap = new HashMap<>();
		userMap.put("users", authentication.getName());
		userMap.put("error", "false");
		return userMap;
	}
	
}