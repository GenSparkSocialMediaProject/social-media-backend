package com.speakr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.speakr.util.JwtRequestFilter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders
		.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication
		.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration
		.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration
		.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration
		.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration
		.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication
		.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
// TODO: Figure out what to do about deprecated WebSecurityConfigurerAdapter
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsService jwtUserDetailService;

	private final JwtRequestFilter jwtRequestFilter;
	
	public WebSecurityConfig(UserDetailsService jwtUserDetailService,
							 JwtRequestFilter jwtRequestFilter) {
		this.jwtUserDetailService = jwtUserDetailService;
		this.jwtRequestFilter = jwtRequestFilter;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(jwtUserDetailService)
				.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf()
			.disable()
			.authorizeHttpRequests()
			.antMatchers("/auth/*")
			.permitAll()
			.anyRequest().authenticated()
			.and().exceptionHandling().authenticationEntryPoint((req, res, authException) -> {
				Map<String, Object> responseMap = new HashMap<>();
				ObjectMapper mapper = new ObjectMapper();
				res.setStatus(401);
				responseMap.put("error", true);
				responseMap.put("message", "Unauthorized access.");
				res.setHeader("content-type", "application/json");
				String response = mapper.writeValueAsString(responseMap);
				res.getWriter().write(response);
			})
			.and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().addFilterBefore((Filter) jwtRequestFilter,
						UsernamePasswordAuthenticationFilter.class);
	}
	
}
