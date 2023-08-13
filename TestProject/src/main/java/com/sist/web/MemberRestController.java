package com.sist.web;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

@RestController
public class MemberRestController {

	@Autowired
	private MemberDAO dao;
	
    @Autowired
	private BCryptPasswordEncoder encoder;
	
	@PostMapping(value="member/login_ok.do",produces = "text/plain;charset=UTF-8")
	public String login_ok(String id,String pwd,HttpSession session) {

		String result="";
		
		int count=dao.id_count(id);
		
		if(count==0) {
			result="NOID";
		} else {
			MemberVO vo=dao.login(id);
			if(encoder.matches(pwd, vo.getPwd())) {
				result="OK";
				
				session.setAttribute("id", vo.getId());
				session.setAttribute("name", vo.getName());
				session.setAttribute("nickname", vo.getNickname());
				session.setAttribute("email", vo.getEmail());
				session.setAttribute("phone", vo.getPhone());
				session.setAttribute("sex", vo.getSex());
				
			} else {
				result="NOPWD";
			}
		}
		
		return result;
	}
	
	
	@PostMapping(value = "member/join_ok.do",produces = "text/plain;charset=UTF-8")
	public String join(MemberVO vo) {
		
		String result="";
		
		try {
			String en=encoder.encode(vo.getPwd());
			vo.setPwd(en);
			dao.join(vo);
			result="YES";
		} catch(Exception ex) {
			ex.printStackTrace();
			result="NO";
		}
		
		return result;
	}
	
	@PostMapping(value="member/idCheck.do",produces = "text/plain;charset=UTF-8")
	public String idCheck(String id) {
		String result="";
		
		int count=dao.id_count(id);
		
		if(count==0) {
			result="OK";
		} else {
			result="NO";
		}
		
		return result;
	}
	
}
