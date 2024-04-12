package com.example.user.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	
	Employee findByEname(String ename);
}
