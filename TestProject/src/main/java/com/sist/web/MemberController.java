package com.sist.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
import com.sist.vo.MemberVO;
import oracle.jdbc.proxy.annotation.Post;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("member/join.do")
	public String member_join(Model model) {
		
		model.addAttribute("main_jsp", "../member/join.jsp");
		return "member/main"; 
	}
	
	
	@RequestMapping("member/login.do")
	public String login(Model model) {
		model.addAttribute("main_jsp", "../member/login.jsp");
		return "member/main";
	}
	
	@GetMapping("member/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../member/main.do";
	}
	
	@GetMapping("member/main.do")
	public String main() {
		return "member/main";
	}

}