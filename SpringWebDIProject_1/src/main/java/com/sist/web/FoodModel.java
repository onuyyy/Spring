package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// model (요청 >> 응답)
@Controller
@RequestMapping("food/")	// 같은 경로면 여기다 매핑해도 된다
public class FoodModel {

	@Autowired
	private FoodDAO dao;
	
	@RequestMapping("category.do")
	public String food_category(HttpServletRequest requset,HttpServletResponse response) {
		
		List<CategoryVO> list=dao.foodCategoryListData();
		requset.setAttribute("list", list);
		return "food/category";
	}
	
	@RequestMapping("food_list.do")
	public String food_list(HttpServletRequest requset,HttpServletResponse response) {
		
		String cno=requset.getParameter("cno");
		List<FoodVO> list=dao.foodListData(Integer.parseInt(cno));
		
		return "food/list";
	}
	
}
