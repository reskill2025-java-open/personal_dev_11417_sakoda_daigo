package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.Drink;



@Component
@SessionScope
public class Cart {
	
	@Autowired
	U u;

//	 商品リスト
		private List<Drink> drinkList = new ArrayList<>(); 
		
		// 商品リストゲッター
		public List<Drink> getDrink() {
			return drinkList;
		}
		
		// 合計個数取得用ゲッター
				public int getTotalQuantity() {
					// 合計金額
					int totalQuantity = 0;
					for (Drink drink : drinkList) {
						totalQuantity += drink.getQuantity();
					}
					return totalQuantity;
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
		
		// 割引価格ゲッター
		public int getDiscountPrice() {
			Integer status = u.getStatus(); 
		    int total = getTotalPrice();

		    if (status != null && status == 1) {
		        return (int)(total * 0.25); // プレミア会員：25%割引
		    } else {
		        return 0; // 通常会員または未設定：割引なし
		    }
		}
		
		// 割引後価格ゲッター
		public int getFinalPrice() {
			return  getTotalPrice() - getDiscountPrice();
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


