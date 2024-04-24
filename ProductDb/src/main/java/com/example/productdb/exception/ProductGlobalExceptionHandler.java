package com.example.productdb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductGlobalExceptionHandler {

	@ExceptionHandler(value=DataNotFoundException.class)
	ResponseEntity productNotFound(DataNotFoundException e) {
		return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
	}
}
