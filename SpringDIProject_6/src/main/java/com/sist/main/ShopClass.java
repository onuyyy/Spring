package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.ShopDAO;
import com.sist.vo.SeoulShopVO;

public class ShopClass {

	public static void main(String[] args) {


	}
	
	public void shopLocationListData() {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		ShopDAO sdao=(ShopDAO)app.getBean("sdao");
		
		List<SeoulShopVO> list=sdao.shopLocationListData();
		for(SeoulShopVO vo:list) {
			System.out.println(vo.getNo()+" "+vo.getTitle());
		}
		
	}

}
