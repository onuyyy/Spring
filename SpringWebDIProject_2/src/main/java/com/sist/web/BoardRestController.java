package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

/*
 * 	@Controller
 * 		=> 요청 처리 : 요청 결과 값 전송한다 => 페이지 지정(파일)
 * 			jsp (forward) => request를 전송 / .do (sendRedirect) => request 전송 x, 기존의 파일로 이동 (ex: insert_ok.do)
 * 
 * 		detail.do => detail.jsp (forward)	//	insert_ok.do => list.do (sendRedirect)
 * 
 * 	@RestController
 * 		=> 요청 처리 : 요청한 결과 값을 전송 (결과 값만 전송)
 * 		=> 결과 값 : 1. JavaScript 2. 일반 문자
 * 					JSON
 */

@RestController
@RequestMapping("board/")
public class BoardRestController {

	@Autowired
	private BoardDAO dao;
	
	@PostMapping(value = "update_ok.do",produces = "text/html;charset=UTF-8")
	// ModelAttribute : VO를 받는다 
	/*
	 *  Spring 
	 *  	Model(Controller) 메소드
	 *  		= 리턴형 : String / void
	 *  		= 매개변수 : 단일 변수(int, String, ...) , VO 객체 , List , 배열
	 *  					Model, RedirectAttribute, HttpSession
	 *  						   ------------------ 전송객체(sendRedirect)
	 *  					---- 전송객체(forward) 
	 *  => request를 사용하지 않는다
	 *  	1) request.getParameter() : 매개변수 (DispatcherServlet에서 매개변수로 넣어준다)
	 *  	2) request 대신에 model을 이용해서 값을 전송한다
	 *  
	 *  크롬에서만 가능 => 자바스크립트에 데이터를 전송할 경우에 사용
	 *  	ajax, vue, react => JSON
	 *  
	 */
	public String board_update_ok(BoardVO vo) {
		String result="";
		
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true) {
			result="<script>location.href=\"detail.do?no="+vo.getNo()+"\"</script>"; 
		} else {
			result="<script>"
					+ "alert(\"비밀번호가 틀립니다\");"
					+ "history.back();"
					+ "</script>";
		}
		return result;
	}
	
	
}
