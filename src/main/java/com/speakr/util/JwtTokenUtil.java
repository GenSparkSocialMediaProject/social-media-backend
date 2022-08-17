package com.speakr.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil
{
	public static final long JWT_TOKEN_VALIDITY = (60 * 60) * 12; // will be for 12 hours
	
	Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	public String getUserNameFromToken(String token)
	{
		return getUserFromToken(token, Claims::getSubject);
	}
	
	public Date getExpirationFromToken(String token)
	{
		return getUserFromToken(token, Claims::getExpiration);
	}
	
	public <T> T getUserFromToken(String token, Function<Claims, T> userResolver)
	{
		final Claims claims = getAllClaimsFromToken(token);
		return userResolver.apply(claims);
	}
	private Claims getAllClaimsFromToken(String token)
	{
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token)
	{
		final Date expiration = getExpirationFromToken(token);
		return expiration.before(new Date());
	}
	
	public String generateToken(UserDetails userDetails)
	{
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder().setClaims(claims)
			.setSubject(userDetails.getUsername())
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(
				System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
			.signWith(key)
			.compact();
	}
	
	public Boolean validateToken(String token, UserDetails userDetails)
	{
		final String username = getUserNameFromToken(token);
		return (
			username.equals(userDetails.getUsername())
			&& !isTokenExpired(token)
		);
	}
	
}
