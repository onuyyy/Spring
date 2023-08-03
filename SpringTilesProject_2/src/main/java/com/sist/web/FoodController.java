package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;

@Controller
public class FoodController {

	@Autowired
	private FoodDAO dao;
		
	// "../food/food_list.do?no=${vo.cno }"
	@GetMapping("food/food_list.do")
	public String food_list(int cno,Model model) {
		
		List<FoodVO> list=dao.foodListData(cno);

		for(FoodVO vo:list) {
			String address=vo.getAddress();
			address=address.substring(0,address.lastIndexOf("지번"));
			vo.setAddress(address);
			
			String poster=vo.getPoster();
			poster=poster.substring(0,poster.indexOf("^"));
			poster=poster.replace("#", "&");
			vo.setPoster(poster);
		}

		model.addAttribute("list", list);
		
		CategoryVO vo=dao.foodCategoryInfoDate(cno);
		model.addAttribute("cvo", vo);
		
//		 	 			  폴더명/파일명 	extends : main 에 있는 걸 그대로 가져온다 
//		  <definition name="*/*" extends="main">
//			<put-attribute name="content" value="/WEB-INF/{1}/{2}.jsp"></put-attribute>
//		  </definition>
		return "food/food_list";
	}
	
	
	
}
