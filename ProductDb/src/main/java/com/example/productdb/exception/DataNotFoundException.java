package com.example.productdb.exception;

import org.springframework.stereotype.Component;


public class DataNotFoundException extends RuntimeException{

	private String entity;
	private String attribute;
	private String value;
	
	private String msg="Data Not Found For Above Details";
	public DataNotFoundException(String entity, String attribute, String value) {
		super("Data Not Found For Above Details");
		this.value = value;
		this.attribute = attribute;
		this.entity = entity;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	


}
