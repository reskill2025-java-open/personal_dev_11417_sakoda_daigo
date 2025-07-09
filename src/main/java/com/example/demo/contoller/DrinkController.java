package com.example.demo.contoller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Category;
import com.example.demo.entity.Drink;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.DrinkRepository;




@Controller
public class DrinkController {
	
	@Autowired
	DrinkRepository drinkRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping ("/drink")
	public String drink(
//		@RequestParam(name = "drinkId", defaultValue = "") Integer drinkId,
		@RequestParam(name = "keyword", defaultValue = "") String keyword,
		@RequestParam(name = "maxPrice", defaultValue = "") Integer maxPrice,
		@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
		Model model) {
	
		List<Category> categoryList = categoryRepository.findAll();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("keyword", keyword);
		model.addAttribute("maxPrice", maxPrice);
		model.addAttribute("selectedCategoryId", categoryId);
		
		
		
		// 商品一覧情報の取得
			List<Drink> drinkList = null;
			if (keyword.length() > 0) {
				// キーワードあり
				if (maxPrice != null) {
					// 最大価格あり
					if (categoryId != null) {
						// カテゴリー指定あり
						drinkList = drinkRepository.findByDrinkNameContainingAndPriceLessThanEqualAndCategoryId(keyword,maxPrice,categoryId);
					} else {
						// カテゴリー指定なし
						drinkList = drinkRepository.findByDrinkNameContainingAndPriceLessThanEqual(keyword,maxPrice);
					}
				}else {
					// 最大価格なし
					if  (categoryId != null) {
						drinkList = drinkRepository.findByDrinkNameContainingAndCategoryId(keyword,categoryId);
					} else {
						// カテゴリー指定なし
						drinkList = drinkRepository.findByDrinkNameContaining(keyword);
					}
				}
			} else {
				// キーワードなし
				if (maxPrice != null) {
					// 最大価格あり
					if (categoryId != null) {
						// カテゴリー指定あり
						drinkList = drinkRepository.findByPriceLessThanEqualAndCategoryId(maxPrice,categoryId);
					} else {
						// カテゴリー指定なし
						drinkList = drinkRepository.findByPriceLessThanEqual(maxPrice);
					}			
				} else {
					// 最大価格なし
					if (categoryId != null) {
						// カテゴリー指定あり
						drinkList = drinkRepository.findByCategoryId(categoryId);
					} else {
						// カテゴリー指定なし
						drinkList = drinkRepository.findAll();
					}	
					}	
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
