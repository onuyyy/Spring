package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
	/*	ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=new EmpDAO("oracle.jdbc.driver.OracleDriver");
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob());
		}
	*/	
		// new를 쓰지 말고 Spring이 가지고 있는 객체르 가져와서 써야 오류가 안 난다
		
			ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob());
		}
		
	}

}
