package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Cart;

@Controller
public class OrderController {

	
	@Autowired
	Cart cart;
	
	// 注文画面へ遷移
		@GetMapping("/order")
		public String order(){
			cart.clear();
			return "order";

		}
		
		
	
	
			
	
	
}
