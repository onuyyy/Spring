package com.sist.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/*
 *	메모리 할당 받을 수 있는 어노테이션이 존재
 *		=> 다른 언어와 연결할 때 쓰임
 *
 *	@RestController
 *	자바스크립트에 맞게 데이터 전송
 *	foodVO => {}	List<foodVO> => [{},{},{}]	=> JSON으로 변경 후 전송			
 *	 
 */

@CrossOrigin("http://localhost:3000")	// 포트번호 허용하는 어노테이션 (viewJS,Javascript는 포트번호 3000)
@RestController
public class FoodRestController {

}
