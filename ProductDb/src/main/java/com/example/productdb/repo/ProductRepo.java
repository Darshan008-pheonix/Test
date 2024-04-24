package com.example.productdb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productdb.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	List<Product> findByCompany(String company);

}
