package com.example.demo.contoller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Drink;
import com.example.demo.entity.Users;
import com.example.demo.model.Cart;
import com.example.demo.model.U;
import com.example.demo.repository.DrinkRepository;
import com.example.demo.repository.UsersRepository;

@Controller
public class CartController {
	
	@Autowired
	Cart cart;
	
	@Autowired
	DrinkRepository drinkRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	U u;
	
	@Autowired
	HttpSession httpsession;
	
	
	
	@GetMapping ("/cart")
	public String index(Model model) { 
		Users users =  usersRepository.findByName(u.getName());
		if (users == null) {
		    // 例えばログイン画面にリダイレクトするなど
		    return "redirect:/login";
		}
		u.setAddress(users.getAddress());
		u.setEmail(users.getEmail());
		
	// new Users(); // 空のUsersオブジェクトを作成
		
		model.addAttribute("isPremium", u.getStatus() == 1);
	    model.addAttribute("users", users); // モデルに追加
	    		return "cart";
	}
	
	// 指定した商品をカートに追加する
	@PostMapping("/cart/add")
	public String addCart(
			@RequestParam("drinkId") int drinkId, Model model) {
		model.addAttribute("isPremium", u.getStatus() == 1);

		// 商品IDをキーに商品情報を取得する
		Drink drink = drinkRepository.findById(drinkId).get();
		if (u.getAge() == null) {
		    model.addAttribute("errorMessage", "年齢情報が未登録のため、購入できません");
		    return "drink";
		}
		 // お酒カテゴリのときだけ、未成年チェックを適用
	    if (drink.getCategoryId() == 5 && u.getAge() < 20) {
	        model.addAttribute("errorMessage", "未成年はお酒を購入できません");
	        return "under20";
	    }
		
		
		// 商品オブジェクトに個数をセット
		drink.setQuantity(1);
		// カートに追加
		cart.add(drink);
		// 「/cart」にリダイレクト
		return "redirect:/cart";
	}
	
//	 指定した商品をカートから削除
	@PostMapping("/cart/delete")
	public String deleteCart(
		@RequestParam("drinkId") int drinkId) {
		
		// カート情報から削除
		cart.delete(drinkId);
		// 「/cart」にリダイレクト
		return "redirect:/cart";
	}
	
	@PostMapping("/cart")
	public String cart(
			@RequestParam("users") String name,
			Model model) {
		Cart cart = new Cart();
		int a = cart.getDiscountPrice();
		model.addAttribute("cart",a);
		return "cart";
	}
}