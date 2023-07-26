package com.sist.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 	1. 프레임워크 : 언제든지 변경해서 사용이 가능하다
 * 	   라이브러리 : 완제품이라 변경해서 사용 불가
 * 
 * 	   프레임워크 
 * 		= 개발에서 기본이 되는 틀을 제공
 * 		= 클래스와 클래스간의 느슨한 결합, 낮은 결합도 유지
 * 								  -------------- 다른 클래스에 영향이 
 * 		POJO 독립적인 클래스 제작
 * 		메소드마다 반복해서 사용하는 소스코드 => 공통 모듈로 분리
 * 	==> 클래스를 모아서 관리 container
 * 		생성에 필요한 데이터나 객체 주소가 필요할 때도 있다 : DI  
 * 
 * 	1. 컨테이너의 종류
 * 		BeanFActory : 가장 단순한 컨테이너 => 사용자가 만든 클래스만 관리 DI
 * 		ApplicationAntext : AOP,메시지 지원 => 구현된 클래스
 * 							ClassPathApplicationContext
 * 							FileSystemXmlApplicationContext
 * 		WEbApplicationContext : MVC		
 * 		** 컨테이처 역할
 * 			1) DL : 클래스를 찾아주는 역할 getBean()
 * 			2) DI : 필요한 데이터를 받아서 초기화 (변수)
 * 					setter DI / contreyvor
 * 	2. DI (값을 스프링에 전송하는 방식)	
 * 	
 * 
 * ** spring 지원 라이브러리
 * 		spring Core : DI => container
 * 		spring : 자동 호출
 * 
 * ** xml 사용법
 * 		- 스프링에서 객체를 생성하기 위해선 클래스명을 전송 (메모리 할당)
 * 		- xml
 * 		- annotation
 * 		- 자바코드
 * ** xml 이용법
 * 		- 클래스 한 개를 설정
 * 			<bean id="" class=""> key / 값
 * 		- 패키지 단위 설정
 * 			<context:component-scan base-package="com.sist.*>
 * 
 * ** annotation
 * 		메모리 할당
 * 	클래스의 ㅈ ㅗㅇ류별 그분'\
 * @component
 * @repository
 * @servic
 * @controll
 * 
 * 
 * 	3. AOP
 * 	4. MVC 구조
 * 	5. 보안
 * => db 연결 (orm : mybatis,jpa)
 * 	
 * 
 * 
 */
public class MainClass {

	public static void main(String[] args) {

		String path="C:\\springDev\\springStudy\\SpringDIProject_8\\src\\main\\java\\app.xml";
		ApplicationContext app=new ClassPathMapApplicationContext("app.xml");
		
		Sawon sa=(Sawon)app.getBean("sa");
		System.out.println(sa.getSabun());
		System.out.println(sa.getDept());
		System.out.println(sa.getJob());
		System.out.println(sa.getName());
		

	}

}
