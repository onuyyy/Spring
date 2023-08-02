package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class FoodController {

	@Autowired
	private FoodDAO dao;
	
	@GetMapping("food/food_list.do")
	public String food_list(int cno,Model model) {
		
		CategoryVO vo=dao.foodCategoryInfoData(cno);
		List<FoodVO> list=dao.foodListData(cno);
		
		model.addAttribute("cvo",vo);
		model.addAttribute("list", list);
		
		// 데이터베이스에서 데이터 읽기 => food_list.jsp로 전송 => 화면 출력
		model.addAttribute("main_jsp", "../food/food_list.jsp");
		return "main/main";
	}
	
	// food/food_detail.do?fno${vo.fno}
	@GetMapping("food/food_detail.do")
	public String food_detail(int fno,Model model) {
		
		// 상세보기에 필요한 데이터를 오라클에서 읽어 온다
		// 전송
		FoodVO vo=dao.foodDetailData(fno);
		model.addAttribute("vo",vo);
		
		model.addAttribute("main_jsp","../food/food_detail.jsp");
		return "main/main";
	}
	
	// food/food_before_detail.do
	@GetMapping("food/food_before_detail.do")
	public String food_before_detail(int fno,RedirectAttributes ra,HttpServletResponse response) {
		
		Cookie cookie=new Cookie("food_"+fno, String.valueOf(fno));
		// cookie는 String만 저장 가능
		
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		
		// 브라우저로 전송
		response.addCookie(cookie);
		
		/*
		 * 	Model : forward일 때 값을 전송
		 *  RedirectAttribute : sendRedirect일 때 값을 전송
		 *  					=> ? 안 달고 이렇게 값을 전송하면 된다 
		 */
		ra.addAttribute("fno",fno);
		return "redirect:../food/food_detail.do";
		// 	return "redirect:../food/food_detail.do?fno="+fno;
		
	}
	
}
 