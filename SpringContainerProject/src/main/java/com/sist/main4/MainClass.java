package com.sist.main4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 	컨테이너 (스프링이 주로 하는 역할)
 * 		=> 개발자가 만드는 클래스 (한 개의 기능 수행 : 컴포넌트)
 * 		   컴포넌트 여러 개를 관리하는 역할 (컨테이너)
 * 		   JButton, JTextField... (컴포넌트)
 * 		  --------------------------------- JFrame(컨테이너)
 * 	컨테이너의 역할
 * 		1) 객체(컴포넌트) 생성 => new를 거의 사용 안 함(사용할 경우 : VO 호출할 때 사용 => VO는 클래스 등록 안 함, 사용자정의 데이터이기 때문에)
 * 		2) 객체의 변수 초기화 => DI
 * 		3) 사용하지 않는 객체 소멸시킨다
 * 		------------------------- 객체의 생명주기 관리
 * 			=> 핵심 기능에만 집중해서 개발해라
 * 
 * 		스프링에서 지원하는 컨테이너
 * 		BeanFactory => core (DI) 지원
 * 			ㅣ
 * 		ApplicationContext (Application) => core(DI), AOP 지원 
 * 			ㅣ - AnnotationConfigApplicationConText
 * 			    ------------------------------------ Spring 5 version의 핵심 (XML 사용하지 않고 순수하게 자바로만 사용)
 * 		WebApplicationContext (MVC) => core(DI), AOP, MVC 지원
 */

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");

		/* 
		 * ClassPathXmlApplicationContext() : XML을 파싱한다 (xml에 등록된 클래스를 읽어간다)
		 * ClassPath : src/main/java		=> 자동인식 해준다 (여기다 만들면 파일명만 쓰면 된다)
		 */
		
		A a=(A)app.getBean("a");
		a.display();
		
	}

}
