package com.example.lap.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lap.entity.Laptop;
import com.example.lap.repo.LaptopRepo;

import jakarta.servlet.http.HttpSession;

@Controller
public class LaptopController {
	
	@Autowired
	LaptopRepo r;
	
	@RequestMapping("login")
	String login() {
		return "login.jsp";
	}
	@RequestMapping("validate")
	String validate(String user,String pswd,HttpSession h) {
		if(user.equals("abcd")&&pswd.equals("abc@123")) {
			return "main.jsp";
		}
		else {
			h.setAttribute("msg","InValid Credentails");
			return "login.jsp";
		}
	}
	
	@RequestMapping("addLap")
	String addLap(Laptop l,HttpSession h) {
		r.save(l);
		
		h.setAttribute("msg", "Data Saved SuccessFully...!!!");
		return "add.jsp";
	}
	@RequestMapping("findById")
	String lapByID(String lid,HttpSession h) {
		Optional<Laptop> l=r.findById(lid);
		if(l.isEmpty()) {
			h.setAttribute("value", "InValid Id");
		}
		else {
			
			h.setAttribute("value", l.get());
		}
		return "findId.jsp";
	}
	
	
	
	
	
	
	
}
