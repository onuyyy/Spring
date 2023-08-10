package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.sist.dao.FoodDAO;

@Controller
public class FoodController {

	@GetMapping("food/food_category.do")
	public String food_category() {
		
		
		
		return "food/food_category";
	}
	
}
