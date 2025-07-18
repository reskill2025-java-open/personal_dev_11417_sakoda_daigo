package com.example.demo.contoller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Cart;
import com.example.demo.model.U;

@Controller
public class OrderController {

	
	
	
	@Autowired
	Cart cart;
	
	@Autowired
	U u;
	
	// 注文画面へ遷移
		@GetMapping("/order")
		public String order(Model model){
			cart.clear();
			
			// 今日の日付 + 3日
			LocalDate deliveryDate = LocalDate.now().plusDays(4);
			
			// 表示形式を整える（例: 7/18）
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d");
		    String formattedDate = deliveryDate.format(formatter);
		    
		    model.addAttribute("deliveryDate", formattedDate);
		    model.addAttribute("isPremium", u.getStatus() == 1);
		    model.addAttribute("address", u.getAddress()); 
		    model.addAttribute("drinkList", cart.getDrink());
		    return "order";

		}
		
		
	
	
			
	
	
}
