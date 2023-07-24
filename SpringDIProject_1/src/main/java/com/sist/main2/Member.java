package com.sist.main2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor		// 매개변수 3개를 다 포함한 생성자를 만듦 Member(String,String,String,String,String)
public class Member {

	private String id,name,address,phone,sex;
	
	// 개발자가 호출하는 함수
	public void print() {
		System.out.println("ID : "+id);
		/* System.out.println("Name : "+name); */
		System.out.println("Address : "+address);
		System.out.println("Phone : "+phone);
		System.out.println("Sex : "+sex);
	}
	
}
