package com.example.user.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthoService {

	String generateToken(String username);
	
	String extractUsername(String token);
	
	boolean validate(String token,UserDetails user);
}
