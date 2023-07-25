package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

public class FoodMainClass {

	public static void main(String[] args) {
		
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		FoodDAO fdao=(FoodDAO)app.getBean("fdao");	// bean의 id 값을 가져와야 한다
		
		List<FoodVO> list=fdao.foodCategoryData();
		
		for(FoodVO vo:list) {
			System.out.println(vo.getCno()+" "+vo.getSubject()+" "+vo.getTitle());
		}

	}

}
