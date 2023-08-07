package com.sist.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.sist.dao.*;
import com.sist.vo.MemberVO;
import oracle.jdbc.proxy.annotation.Post;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO dao;
	
	@GetMapping("member/join.do")
	public String member_join() {
		
		return "member/join"; 
	}
	
	@PostMapping("member/join_ok.do")
	public String member_join_ok(MemberVO vo) {
		
		dao.join(vo);
		
		return "redirect:/member/login.do";
	}
	
//	@GetMapping("member/login.do")
//	public String member_login() {
//		
//		return "../member/login.jsp";
//	}
	
	@GetMapping("member/login.do")
	public String member_login() {
		
		return "member/login"; 
	}
	
	
	@PostMapping("member/login_ok.do")
	public String login_ok(String id,String pwd,HttpServletRequest request) {
		
		MemberVO vo=dao.get_db_info(id, pwd);
		HttpSession session=request.getSession();
		
		if(vo.getMsg().equals("OK")) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			session.setAttribute("email", vo.getEmail());
			session.setAttribute("sex", vo.getSex());
			session.setAttribute("post", vo.getPost());
			session.setAttribute("addr1", vo.getAddr1());
			session.setAttribute("addr2", vo.getAddr2());
			session.setAttribute("phon", vo.getPhone());
			session.setAttribute("birth", vo.getBirth());
		}
		
	    return "redirect:/member/join.do";
	}
}

/*
	같은 경로에 있다면 /member/...
	다른 경로에 있다면 ../memebr/..
*/