package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//import jakarta.persistence.Table;

//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Entity
//@Table(name = "cart")
public class Cart {
	
	@Id
	// 商品リスト
	private List<Drink> drinkList = new ArrayList<>(); 
	
	// 商品リストゲッター
	public List<Drink> getDrink() {
		return drinkList;
	}
	
	// 合計金額取得用ゲッター
	public int getTotalPrice() {
		// 合計金額
		int total = 0;
		for (Drink drink : drinkList) {
			total += drink.getPrice() * drink.getQuantity();
		}
		return total;
	}
	
		// カート追加
		public void add(Drink newDrink) {
			
			Drink existsDrink = null;
			// 現在のカートの商品から同一IDの商品を探す
			for (Drink drink :drinkList) {
				if (drink.getDrinkId() == newDrink.getDrinkId()) {
					existsDrink = drink;
					break;
				}
			}
			
			// カート内に商品が存在しなかった場合はカート追加
			// 存在した場合は、個数の更新を行う
			if (existsDrink == null) {
				drinkList.add(newDrink);
			} else {
				existsDrink.setQuantity(
						existsDrink.getQuantity() + newDrink.getQuantity());
			}
		}
		
		// カートから商品を削除
		public void delete(int drinkId) {
			
			// 現在のカートの商品から同一IDの商品を探す
			for (Drink drink : drinkList) {
				// 対象の商品IDが見つかった場合削除する
				if (drink.getDrinkId() == drinkId)  {
					drinkList.remove(drink);
					break;
				}
			}
		}
		
		// カートの中身をすべてクリア
		public void clear() {
			drinkList = new ArrayList<>();
		}
		
	}
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "cart_id")
//	private Integer cartId; // 注文ID
//	
//	private Integer id; // 顧客ID
//
//	private Integer quantity; // 数量
//	
//	@Column(name = "total_price")
//	private Integer totalPrice; // 合計金額
//
//	public Integer getCartId() {
//		return cartId;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	public Integer getTotalPrice() {
//		return totalPrice;
//	}
//
//	public void setCartId(Integer cartId) {
//		this.cartId = cartId;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//
//	public void setTotalPrice(Integer totalPrice) {
//		this.totalPrice = totalPrice;
//	}
//
