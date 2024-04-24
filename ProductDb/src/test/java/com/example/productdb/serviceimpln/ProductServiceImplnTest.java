package com.example.productdb.serviceimpln;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.productdb.entity.Product;
import com.example.productdb.repo.ProductRepo;
import com.example.productdb.service.ProductService;

class ProductServiceImplnTest {
	@Mock
	ProductRepo repo;
	ProductService ser;
	AutoCloseable autoCloseable;
	Product p;
	
	@BeforeEach
	void setUp() throws Exception {
		autoCloseable=MockitoAnnotations.openMocks(this);
		ser=new ProductServiceImpln(repo);
		p=new Product(12345, "Laptop", 45000, "Dell", 8);
		repo.save(p);
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}
	
	@Test
	void testSaveProduct() {
		mock(Product.class);
		mock(ProductRepo.class);
		when(ser.saveProduct(p)).thenReturn(p);
		assertThat(ser.saveProduct(p).getPid()).isEqualTo(p.getPid());
	}

	@Test
	void test1ProductByID() {
		mock(Product.class);
		mock(ProductRepo.class);
		when(repo.findById(p.getPid())).thenReturn(Optional.ofNullable(p));
		assertThat(ser.productById(12345)).isEqualTo(p);
	}
	//check for exception
	@Test
	void test2ProductByID() {
		mock(Product.class);
		mock(ProductRepo.class);
		when(repo.findById(p.getPid())).thenReturn(Optional.ofNullable(p));
		RuntimeException e=Assertions.assertThrows(RuntimeException.class,()->ser.productById(5555));
		assertThat(e.getMessage()).isEqualTo("Data Not Found For Above Details");
		
	}


}











