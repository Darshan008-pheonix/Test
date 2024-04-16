package com.example.user.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.user.service.AuthoService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	@Autowired
	AuthoService ser;
	@Autowired
	AssignUserFromDatabase u;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkYXJzaGFuIiwiaWF0IjoxNzEzMTU5MDIyLCJleHAiOjE3MTMxNTkwNDB9.AsK5Cbc7DD6qP-J46CyTIROL8cGzH-bflD4FbtMcx8U
		String token=request.getHeader("Authorization");
		System.out.println("token:"+token);
		String username=null;
		if(token!=null && token.startsWith("Bearer ")) {
			token=token.substring(7);
			username=ser.extractUsername(token);
			System.out.println("username:"+username);
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails user=u.loadUserByUsername(username);
			System.out.println(ser.validate(token, user));
			if(ser.validate(token, user)) {
	UsernamePasswordAuthenticationToken authoToken = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
				System.out.println("authoToken:"+authoToken);
				SecurityContextHolder.getContext().setAuthentication(authoToken);
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
