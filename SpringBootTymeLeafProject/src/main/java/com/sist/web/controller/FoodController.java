package com.sist.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.web.service.FoodService;
import com.sist.web.vo.CategoryVO;

@Controller
public class FoodController {
	
	@Autowired
	private FoodService service;
	
	@RequestMapping("food/category")
	public String food_category(Model model) {
		
		List<CategoryVO> list=service.categoryListData();
		model.addAttribute("list", list);
		
		return "food/category";
		// 확장자 설정 .html 로 들어온다
	}

}
