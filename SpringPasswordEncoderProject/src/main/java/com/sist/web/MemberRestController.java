package com.sist.web;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private MemberDAO dao;
	
	@PostMapping(value="member/join_ok.do",produces = "text/plain;charset=UTF-8")
	public String member_join(MemberVO vo) {
		
		// 값 들어왔는지 확인
		System.out.println("id :"+vo.getId());
		System.out.println("pwd :"+vo.getPwd());
		System.out.println("name :"+vo.getName());
		System.out.println("sex :"+vo.getSex());
		
		String result="";
		
		try {
			
			// pwd 암호화 시키기
			String en=encoder.encode(vo.getPwd());
			vo.setPwd(en);
			dao.memberInsert(vo);
			
			result="YES";
			
		} catch(Exception ex) {
			
			result="NO";
			ex.printStackTrace();
		}
		
		// YES => login / No => login 실패
		return result;
	}
	
	
	@PostMapping(value="member/login_ok.do",produces = "text/plain;charset=UTF-8")
	public String member_login_ok(String id,String pwd,HttpSession session) {
													
		/*
		 * session을 생성하는 게 아니라 매개변수로 받아오는 것
			매개변수로 session을 선언하면 dispatcherServlet에 의해 값을 주입
			필요한 객체 => 매개변수를 이용해서 받는다, 순서는 상관 없음
			사용자 전송 (요청) = request.getParameter
			받을 수 있는 클래스 : 내장 객체는 가능, Model(전송 객체) forward에서만 가능
			sendRedirect => RedirectAttributes
			@RestController => 다른 언어와 연결 할 때 (javascript,kotlin)
			json, <script>, 일반 문자열 ...=> @Responsebody
		 */
		
		String result="";
		
		int count=dao.memberIdCheck(id);
		
		if(count==0) {
			result="NOID";
		} else {
			
			MemberVO vo=dao.memberLogin(id);
			if(encoder.matches(pwd, vo.getPwd())) {
			// 암호화 된 것과 실제 데이터가 맞는지 확인
				result="OK";
				
				session.setAttribute("id", vo.getId());
				session.setAttribute("name", vo.getName());
				session.setAttribute("sex", vo.getSex());
					
			} else {
			// 비밀번호가 틀린 상테 => 같은 값인데 암호화는 다르다
				result="NOPWD";
				
			}
		}
		
		return result;
	}
}
