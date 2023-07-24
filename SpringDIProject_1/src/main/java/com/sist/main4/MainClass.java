package com.sist.main4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	private Sawon sa;
	public Sawon getSa() {
		return sa;
	}

	
	public void setSa(Sawon sa) {
		this.sa=sa;
	}
	
	public static void main(String[] args) {
		
//		ApplicationContext app=new ClassPathXmlApplicationContext("app4.xml");
		
		GenericApplicationContext app=new GenericXmlApplicationContext("app4.xml");
		Sawon sa=(Sawon)app.getBean("sa1");
//		
//		// sa.init() 먼저 호출된 상태
//		sa.print();
//		// sa.destory()
//		app.close();
	

		
	}

	
}
