package com.sist.main;

import java.awt.List;
import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.vo.*;

public class MainClass {

	public static void main(String[] args) {
		
		

	}

//	@Test
//	public void location() {
//		
//			ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
//			LocationDAO dao=(LocationDAO)app.getBean("ldao");
//			
//			List<SeoulLocationVO> list=dao.locationListData();
//			for(SeoulLocationVO vo:list) {
//				System.out.println(vo.getTitle());
//			}
//	}
	
	@Test
	public void locationDetail() {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("명소 변호 : ");
		int no=scan.nextInt();
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		LocationDAO dao=(LocationDAO)app.getBean("ldao");
		SeoulLocationVO vo=dao.locationDetailData(no);
		System.out.println("Title : "+vo.getTitle());
		System.out.println("Adderss : "+vo.getAddress());
		System.out.println("Message : "+vo.getMsg());
	}
	
	
	
}
