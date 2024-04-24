package com.example.productdb.entity;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Product {
  
	@Id
	private int pid;  //findById()
	private String name; //findByName()
	private double price; //findByPrice
	private String company; //findByCompany
	private int qt; //findByQt
	@JsonFormat(pattern = "hh:mm:ss a" ,shape = JsonFormat.Shape.STRING)
	private LocalTime time;
	@JsonFormat(pattern ="yyyy-MM-dd")
	private LocalDate date;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getQt() {
		return qt;
	}
	public void setQt(int qt) {
		this.qt = qt;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Product(int pid, String name, double price, String company, int qt) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.company = company;
		this.qt = qt;
	}
	
	
	
}
