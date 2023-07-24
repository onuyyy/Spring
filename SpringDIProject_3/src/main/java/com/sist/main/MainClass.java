package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.Setter;

public class MainClass {

	@Setter
	private GoodsDAO dao;
	// 생성된 dao를 내놔라 => setter가 채워줌 (객체 주입)
	
	public static void main(String[] args) {
		
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		MainClass mc=(MainClass)app.getBean("mc");
		List<String> list=mc.dao.goodsNameList();
		for(String name:list) {
			System.out.println(name);
			
			// new를 쓰면 안 된다 => Spring에 있는 값을 못 가져온다
		}
		
	}

}
