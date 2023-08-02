package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sist.service.FoodService;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
import com.sist.vo.SeoulVO;

@Controller
public class MainController {

	@Autowired
	private FoodService service;
	
	@GetMapping("main/main.do")
	public String main_main(Model model) {
		
		List<CategoryVO> cList=service.foodCategoryData();

		model.addAttribute("cList", cList);
		model.addAttribute("main_jsp", "home.jsp");
		return "main/main";
	}
	
}
