package com.msgexm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;  
@RestController  
@RequestMapping("/hello/")
public class HelloWorldMsg{

	//@ReMapping(value = "/msgs/", method = RequestMethod.GET)//default GET type

    @GetMapping("msgs")  
	public String hello()   
	{  
	return "Congratulations......for your First API......!!!!!";  
	}  
	}  