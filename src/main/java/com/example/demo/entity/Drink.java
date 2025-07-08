package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "drink")
public class Drink {

	@Id
	@Column(name = "drink_id")
	private Integer drinkId;	

	@Column(name = "drink_name")
	private String drinkName;
		
	private Integer price;
	
	private String category;

	public Integer getDrinkId() {
		return drinkId;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public Integer getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public void setDrinkId(Integer drinkId) {
		this.drinkId = drinkId;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
