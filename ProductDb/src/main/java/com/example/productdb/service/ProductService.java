package com.example.productdb.service;

import java.util.List;

import com.example.productdb.entity.Product;

public interface ProductService {

	Product saveProduct(Product p);
	
	Product productById(int pid);
	
	List<Product> productByCompany(String company);
	
	Product updateProduct(Product p);
}
