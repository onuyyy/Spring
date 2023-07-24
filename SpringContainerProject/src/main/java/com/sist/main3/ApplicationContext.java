package com.sist.main3;

import java.util.*;

import org.apache.commons.collections.map.HashedMap;

public class ApplicationContext {

	private Map map=new HashedMap();	// class 관리엔 Map이 좋음
	public ApplicationContext() {
		map.put("a", new A());
		map.put("b", new B());
		map.put("c", new C());
		map.put("d", new D());
		
		// 클래스 여러 개를 묶어서 관리 => 컨테이너 / Factory Pattern
	}
	
	// 여러 개 묶어놓은 것 중 객체 찾기
	public Object getBean(String key) {
		return map.get(key);
	}
	
	
	/*
	 * Spring => 클래스 관리 (컨테이너) 
	 * 	
	 * 	1. 객체의 생명주기 관리 (생성 ~ 소멸)
	 * 	2. 객체 찾기 (getBean())
	 * 	3. DL / DI
	 * 	  ---------
	 * 		D Lookup => 객체 찾기
	 * 		D Injection => 주입
	 * 			DI - setter DI
	 * 				 constructor 
	 * 				 method
	 */
}
