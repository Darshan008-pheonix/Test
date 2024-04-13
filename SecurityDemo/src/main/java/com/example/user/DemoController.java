package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.entity.AuthoInfo;
import com.example.user.entity.Employee;
import com.example.user.repo.EmployeeRepo;
import com.example.user.service.AuthoService;
import com.example.user.service.EmployeeService;
import com.example.user.serviceimpln.EmployeeServiceImpln;

@RestController
public class DemoController {
	@Autowired
	EmployeeService s;
	
	@Autowired
	AuthoService as;
	
	@RequestMapping("index")
	String api1() {
		return "<h1>Hello Index Page</h1>";
	}
	
	
	@RequestMapping("home")
	String api2() {
		return "<h1>Hello Home Page</h1>";
	}
	
	
	@RequestMapping("page")
	String api3() {
		return "<h1>Hello Page1 Method Level Security</h1>";
	}
	
	@PostMapping("add")
	Employee addEmp(@RequestBody Employee e) {
		return s.addEmp(e);
		
	}
	
	
	@PostMapping("autho")
	String authoToken(@RequestBody AuthoInfo a) {
	return as.generateToken(a.getUserName());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
