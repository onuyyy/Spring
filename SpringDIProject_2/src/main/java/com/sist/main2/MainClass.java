package com.sist.main2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		String[] xml= {"member.xml","sawon.xml","student.xml"};
		ApplicationContext app=new ClassPathXmlApplicationContext("app-*.xml");
		// xml이 분산되었을 떈 이렇게 코딩
		
		Sawon s=(Sawon)app.getBean("sa");
		s.init();
		s.print();
		
		Member m=(Member)app.getBean("mem");
		m.init();
		m.print();
		
		Student std=app.getBean("std",Student.class);
										//   ------- 형변환 안 하는 방법
		std.init();
		std.print();
		
		// s.init() => Spring에서 처리하는 게 나음 (init-method)

	}

}

/*
 *		String[] xml= {"member.xml","sawon.xml","student.xml"};
		ApplicationContext app=new ClassPathXmlApplicationContext(xml);
		// xml이 분산되었을 떈 이렇게 코딩
		
		Sawon s=(Sawon)app.getBean("sa");
		Member m=(Member)app.getBean("mem");
		Student std=app.getBean("std",Student.class);
										//   ------- 형변환 안 하는 방법
		
		// s.init() => Spring에서 처리하는 게 나음 (init-method)
		s.print();
		System.out.println("=======================");
		m.print();
		System.out.println("=======================");
		std.print();
		
		 => 출력
		 	======== 회원 정보
			======== 사원 정보
			======== 학생 정보
			사번 : 1
			이름 : sce
			부서 : ㄱㅂㅂ
			=======================
			아이디 : h
			이름 : hkd
			성별 : m
			=======================
			학번 : 2
			이름 : yyy
			성별 : W
		 
		 ** init이 먼저 호출된다
		 위처럼 여러 개일 땐 직접 호출한다 s.init()

 */
