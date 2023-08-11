package com.sist.web;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	// 암호화,복호화
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("member/login.do")
	public String memberLogin() {
		return "member/login";
	}
	
	@GetMapping("member/join.do") 
	public String member_join() {
		return "member/join";
	}
	
	@GetMapping("member/logout.do")
	public String member_logout(HttpSession session) {
		session.invalidate();
		return "redirect:../member/login.do";
	}
}
