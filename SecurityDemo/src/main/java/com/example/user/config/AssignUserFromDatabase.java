package com.example.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.user.entity.Employee;
import com.example.user.repo.EmployeeRepo;

public class AssignUserFromDatabase implements UserDetailsService {

	@Autowired
	EmployeeRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee e = repo.findByEname(username);
		if(e==null) {
			throw new UsernameNotFoundException("User not found..!!");
		}
		
		return new UserEmplyMatcher(e);
	}

}
