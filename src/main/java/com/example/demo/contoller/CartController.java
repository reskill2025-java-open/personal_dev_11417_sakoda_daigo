package com.example.demo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
	
	@GetMapping ("/drink/confirm")
	public String confirm() {
		
		return "confirm";
	}

}
