package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;

@Component("mc")
public class MainCLass {

	@Autowired	// getBean 대신 자동으로 객체 주소 값을 찾아서 주입한다, 객체를 받을 때마다 따로따로 받아야 한다 
	@Qualifier("bdao")	// 맞는 것을 선택해서 가져온다
	private Board board;
	public static void main(String[] args) {
		
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
	}
}


