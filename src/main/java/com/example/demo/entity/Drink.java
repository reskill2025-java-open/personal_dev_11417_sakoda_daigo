package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "drink")
public class Drink {

	
	@Id
	@Column(name = "drink_id")
	private Integer drinkId;	// 商品ID

	@Column(name = "drink_name")
	private String drinkName; // 商品名
	
		
	private Integer price; // 価格
	
	private Integer amount; // 内容量
	
	private String factory; // 製造メーカー
	
	@Column(name = "category_id")
	private Integer categoryId; // カテゴリーID
	
	@Transient
	private Integer quantity; // 数量
	
	@OneToOne
	@JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
	private Category category;

	public Integer getDrinkId() {
		return drinkId;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getFactory() {
		return factory;
	}

	public Integer getCategoryId() {
		return categoryId;
	}
	
	public String getCategoryName() {
		return category.getCategoryName();
	}
	
	public Integer getQuantity() {
		return quantity;
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

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
