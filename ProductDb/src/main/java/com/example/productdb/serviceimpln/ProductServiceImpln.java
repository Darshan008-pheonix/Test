package com.example.productdb.serviceimpln;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productdb.entity.Product;
import com.example.productdb.exception.DataNotFoundException;
import com.example.productdb.repo.ProductRepo;
import com.example.productdb.service.ProductService;

@Service
public class ProductServiceImpln implements ProductService{
	
	@Autowired
	ProductRepo r;
	
	public ProductServiceImpln() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ProductServiceImpln(ProductRepo r) {
		super();
		this.r = r;
	}


	@Override
	public Product saveProduct(Product p) {
		return r.save(p);
	}

	@Override
	public Product productById(int pid) {
		Optional<Product> p=r.findById(pid);
//		if(p.isPresent()) {
//			return p.get();		
//			}
//		else {
//			throw new  DataNotFoundException("Product", "Id",pid+"");
//		}
	return r.findById(pid).orElseThrow(()->new DataNotFoundException("Product", "Id",pid+""));
	}

	@Override
	public List<Product> productByCompany(String company) {
		
		List<Product> l=r.findByCompany(company);
		if(l.size()>0) {
			return l;
		}
		else {
			throw new DataNotFoundException("Product", "company", company);
		}
	}

	@Override
	public Product updateProduct(Product p) {
		// TODO Auto-generated method stub
		Optional<Product> z=r.findById(p.getPid());
		if(z.isPresent()) {
//			Product p1=z.get();
//			p1.setCompany(p.getCompany());
//			p1.setDate(p.getDate());
//			p1.setName(p.getName());
//			p1.setPrice(p.getPrice());
			return r.save(p);
		}
		else {
			throw new DataNotFoundException("Product","Id",""+p.getPid());
		}
	}

}
