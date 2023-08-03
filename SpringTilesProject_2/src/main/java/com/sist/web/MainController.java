package com.sist.web;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sist.vo.*;
import com.sist.dao.*;


@Controller
public class MainController {

	@Autowired
	private FoodDAO dao;
	
	@GetMapping("main/main.do")
	public String main_main(Model model) {
		
		List<CategoryVO> cList=dao.foodCategoryData();
		model.addAttribute("cList", cList);
		return "main";
	}
	
	
	
}
