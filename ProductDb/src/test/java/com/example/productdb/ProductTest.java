package com.example.productdb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.productdb.entity.Product;
import com.example.productdb.repo.ProductRepo;
import com.example.productdb.service.ProductService;
import com.example.productdb.serviceimpln.ProductServiceImpln;


@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
public class ProductTest {

	@Autowired
	ProductRepo repo;
	
	
	ProductService ser;	
	Product p;
	
	@BeforeEach
	void setup(){
		p=new Product(12345, "Laptop", 45000, "Dell", 8);
		repo.save(p);
		ser=new ProductServiceImpln(repo);
	}
	
	@AfterEach
	void tearDown() {
		repo.deleteAll();
		p=null;
	}
	
	@Test
	void test() {
		Product obj=ser.productById(12345);
		assertThat(obj.getName()).isEqualTo("Laptop");
	}
}
