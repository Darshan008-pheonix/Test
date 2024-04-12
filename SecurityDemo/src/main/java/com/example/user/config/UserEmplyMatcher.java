package com.example.user.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.user.entity.Employee;

public class UserEmplyMatcher  implements UserDetails {

	String name;
	String pswd;
	List<GrantedAuthority> autho;
	
	public UserEmplyMatcher(Employee e) {
		name=e.getEname();
		pswd=e.getPswd();
		autho=Arrays.stream(e.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return autho;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return pswd;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
