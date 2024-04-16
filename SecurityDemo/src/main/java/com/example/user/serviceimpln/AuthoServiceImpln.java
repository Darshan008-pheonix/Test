package com.example.user.serviceimpln;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.user.service.AuthoService;

import io.jsonwebtoken.Claims;
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
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*30)).signWith(generateKey(),SignatureAlgorithm.HS256).compact();
	}

	private Key generateKey() {
		byte[] deKey=Decoders.BASE64.decode("b7cb60c68f24f9912e01475e3d8853a03b63e0d4b7944a74757591ea243b7579");
		
		return Keys.hmacShaKeyFor(deKey);
	}

	@Override
	public String extractUsername(String token) {
		String username=extractClaim(token, Claims::getSubject);
		return username;
	}

	public Date extractExpDate(String token) {
		Date expDate=extractClaim(token, Claims::getExpiration);
		return expDate;
	}
	
	public boolean isExp(String token) {
		System.out.println(extractExpDate(token)+" "+new Date());
		for(int i=0;i<20;i++) {
			System.out.println("     ");
		}
		return (extractExpDate(token)).after(new Date());
	}
	
	@Override
	public boolean validate(String token, UserDetails user) {
		
		System.out.println(user.getUsername()+" "+extractUsername(token));
		System.out.println(isExp(token));
		return (user.getUsername().equals(extractUsername(token)))&&isExp(token);
		
	}
	
	
	<T> T extractClaim(String token,Function<Claims, T> claimData) {
		Claims c=extractAll(token);
		return claimData.apply(c);
	}
	
	Claims extractAll(String token) {
		return Jwts.parserBuilder().setSigningKey(generateKey()).build().parseClaimsJws(token).getBody();
	}

}









