package com.example.productdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.productdb.entity.Product;
import com.example.productdb.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService s;
	
	@PostMapping("addPro")
	ResponseEntity<Product> saveProduct(@RequestBody Product p) {
		return new ResponseEntity<Product>(s.saveProduct(p),HttpStatus.CREATED);
	}

	@GetMapping("byId")
	ResponseEntity<Product> findProductById(@RequestHeader int pid) {
		return new ResponseEntity<Product>(s.productById(pid),HttpStatus.FOUND);
	}
	
	@GetMapping("byCompany")
	ResponseEntity<List<Product>> findProductCompany(@RequestHeader String company) {
		return new ResponseEntity<List<Product>>(s.productByCompany(company),HttpStatus.FOUND);
	}
	
	@PutMapping("updatePro")
	ResponseEntity<Product> upProduct(@RequestBody Product p) {
		return new ResponseEntity<Product>(s.updateProduct(p),HttpStatus.CREATED);
	}
}
