package com.sist.main2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		// xml 파싱하기
		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");
		
		Member m1=(Member)app.getBean("mem1");
		m1.print();
		
		Member m2=(Member)app.getBean("mem2");
		m1.print();
		
		Member m3=(Member)app.getBean("mem3");
		m1.print();
		
		Member m4=(Member)app.getBean("mem4");
		m1.print();
		

	}

}
