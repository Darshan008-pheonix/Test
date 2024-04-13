package com.example.user.serviceimpln;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.user.service.AuthoService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class AuthoServiceImpln  implements AuthoService{

	@Override
	public String generateToken(String username) {
		Map<String,Object> claim=new HashMap<>();
		return createToken(claim,username);
	}

	private String createToken(Map<String, Object> claim, String username) {
		return Jwts.builder().setClaims(claim).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+18000)).signWith(generateKey(),SignatureAlgorithm.HS256).compact();
	}

	private Key generateKey() {
		byte[] deKey=Decoders.BASE64.decode("b7cb60c68f24f9912e01475e3d8853a03b63e0d4b7944a74757591ea243b7579");
		
		return Keys.hmacShaKeyFor(deKey);
	}

}
