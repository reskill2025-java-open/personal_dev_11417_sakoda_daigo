package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Integer>{
	
	List<Drink> findByDrinkNameContainingAndPriceLessThanEqualAndCategoryId(String keyword, Integer maxPrice, Integer categoryId);

	List<Drink> findByDrinkNameContainingAndPriceLessThanEqual(String keyword, Integer maxPrice);

	List<Drink> findByDrinkNameContainingAndCategoryId(String keyword, Integer categoryId);

	List<Drink> findByDrinkNameContaining(String keyword);

	List<Drink> findByPriceLessThanEqualAndCategoryId(Integer maxPrice, Integer categoryId);

	List<Drink> findByPriceLessThanEqual(Integer maxPrice);
	
	List<Drink> findByCategoryId(Integer categoryId);
}
