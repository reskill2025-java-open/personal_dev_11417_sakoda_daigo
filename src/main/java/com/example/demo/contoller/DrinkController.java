package com.example.demo.contoller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Drink;
import com.example.demo.repository.DrinkRepository;




@Controller
public class DrinkController {
	
	@Autowired
	DrinkRepository drinkRepository;
	
	@GetMapping ("/drink")
	public String drink(
		@RequestParam(name = "drinkId", defaultValue = "") Integer drinkId,
		Model model) {
//		List<Drink> drinkList = drinkRepository.findAll();
//		model.addAttribute("drinkList", drinkList);
//		
//		// 商品一覧情報の取得
			List<Drink> drinkList = null;
			if (drinkId == null) {
				drinkList = drinkRepository.findAll();
			} else {
				// itemsテーブルをカテゴリーIDを指定して一覧を取得
				drinkList = drinkRepository.findByDrinkId(drinkId);
			}
					model.addAttribute("drink", drinkList);
		return "/drink";
	}
	
	@GetMapping("/detail/{drinkId}")
	public String show(@PathVariable("drinkId") Integer drinkId, Model model) {
		
		Drink drink = drinkRepository.findById(drinkId).get();
		
		model.addAttribute("drink", drink);
		
		return "detail";
	}
}
