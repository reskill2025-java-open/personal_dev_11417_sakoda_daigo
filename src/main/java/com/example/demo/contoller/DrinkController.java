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
import com.example.demo.entity.Users;
import com.example.demo.model.U;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.DrinkRepository;
import com.example.demo.repository.UsersRepository;




@Controller
public class DrinkController {
	
	@Autowired
	DrinkRepository drinkRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	U u;
	
	@GetMapping ("/drink")
	public String drink(
//		@RequestParam(name = "drinkId", defaultValue = "") Integer drinkId,
		@RequestParam(name = "keyword", defaultValue = "") String keyword,
		@RequestParam(name = "maxPrice", defaultValue = "") Integer maxPrice,
		@RequestParam(name = "categoryId", defaultValue = "") Integer categoryId,
		@RequestParam(name = "name", defaultValue = "") String name,
		@RequestParam(name = "email", defaultValue = "") String email,
		@RequestParam(name = "address", defaultValue = "") String address,
		Model model) {
	
		if (name.equals("")) {
		    Users users = usersRepository.findByName(u.getName());
		    if (users != null) {
		        u.setEmail(users.getEmail());
		        u.setAddress(users.getAddress());
		    } else {
		        // 対処例：空欄で初期化、またはログインページにリダイレクトしてもOK
		        u.setEmail("");
		        u.setAddress("");
		    }
		} else {
		    u.setName(name);
		    u.setEmail(email);
		    u.setAddress(address);
		}
			
		

		
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
