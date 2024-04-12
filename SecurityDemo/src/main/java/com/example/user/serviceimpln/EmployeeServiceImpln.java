package com.example.user.serviceimpln;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.user.entity.Employee;
import com.example.user.repo.EmployeeRepo;
import com.example.user.service.EmployeeService;

@Component
public class EmployeeServiceImpln implements EmployeeService {
	@Autowired
	EmployeeRepo repo;
	
	BCryptPasswordEncoder b=new BCryptPasswordEncoder();

	@Override
	public Employee addEmp(Employee e) {
		e.setPswd(b.encode(e.getPswd()));
		return repo.save(e);
	}

}
