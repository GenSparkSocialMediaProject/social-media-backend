package com.speakr.service;

import com.speakr.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsImp implements UserDetailsService
{
	final com.speakr.dao.UserDAO UserDAO;
	public JwtUserDetailsImp(com.speakr.dao.UserDAO userDAO) { this.UserDAO = userDAO; }
	
	
	@Override
	public UserDetails loadUserByUsername(String username)	 throws UsernameNotFoundException, NullPointerException
	{
		User user = UserDAO.findUserByUserName(username);
		List<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("USER_ROLE"));
		System.out.println(UserDAO.findAll());
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Username: \"%s\" does not exist.", username));
		}
		return new org.springframework.security.core.userdetails.User
			(user.getUser_name(), user.getPassword(), authorityList);
	}
	
	
	public UserDetails createUserDetails(String username, String password)
	{
		List<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("USER_ROLE"));
		return new org.springframework.security.core.userdetails.User
			(username, password, authorityList);
	}
}
