package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Drink;
import com.example.demo.repository.DrinkRepository;

@Controller
public class CartController {
	
	@Autowired
	Cart cart;
	
	@Autowired
	DrinkRepository drinkRepository;
	
	
	@GetMapping ("/drink/cart")
	public String index() {
		
		return "cart";
	}
	
	// 指定した商品をカートに追加する
	@PostMapping("/drink/cart/add")
	public String add(
			@RequestParam("drinkId") int drinkId) {
		
		// 商品IDをキーに商品情報を取得する
		Drink drink = drinkRepository.findById(drinkId).get();
		// 商品オブジェクトに個数をセット
		drink.setQuantity(1);
		// カートに追加
		cart.add(drink);
		// 「/cart」にリダイレクト
		return "redirect:/cart";
	}
	
	// 指定した商品をカートから削除
	@PostMapping("/drink/cart/delete")
	public String deleteCart(
		@RequestParam("drinkId") int drinkId) {
		
		// カート情報から削除
		cart.delete(drinkId);
		// 「/cart」にリダイレクト
		return "reirect:/cart";
	}
//
//		// 商品コードをキーに商品情報を取得する
//		Drink drink = drinkRepository.findById(drinkId).get();
//		// 商品オブジェクトに個数をセット
//		cart.setQuantity(1);
//		// カートに追加
//		cart.add(drink);
//		// 「/cart」にリダイレクト
//		return "redirect:/cart";
//	}
//	
//	@PostMapping("/cart/delete")
//	public String deleteCart(
//			@RequestParam("drinkId") int drinkId) {
//
//		// カート情報から削除
//		cart.delete(drinkId);
//		// 「/cart」にリダイレクト
//		return "redirect:/cart";
//	}
//	

}
