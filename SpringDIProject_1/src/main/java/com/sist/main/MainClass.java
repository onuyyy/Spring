package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		Sawon s1=(Sawon)app.getBean("sa1");
		System.out.println("이름 : "+s1.getName());
		System.out.println("사번 : "+s1.getSabun());
		System.out.println("부서 : "+s1.getDept());
		System.out.println("직위 : "+s1.getJob());
		System.out.println("연봉 : "+s1.getPay());
		
		System.out.println("================================================================");
//		Sawon s2=(Sawon)app.getBean("sa2");
//		System.out.println("이름 : "+s2.getName());
//		System.out.println("사번 : "+s2.getSabun());
//		System.out.println("부서 : "+s2.getDept());
//		System.out.println("직위 : "+s2.getJob());
//		System.out.println("연봉 : "+s2.getPay());
		
		
//		System.out.println("================================================================");
//		Sawon s3=(Sawon)app.getBean("sa3");
//		System.out.println("이름 : "+s3.getName());
//		System.out.println("사번 : "+s3.getSabun());
//		System.out.println("부서 : "+s3.getDept());
//		System.out.println("직위 : "+s3.getJob());
//		System.out.println("연봉 : "+s3.getPay());
		
		System.out.println("================================================================");
		
		Sawon s2=app.getBean("sa1",Sawon.class);
								// ------------ 이렇게 형변환을 시킬 수도 있음
		s2.setSabun(2);
		s2.setName("심청이");
		s2.setDept("총무부");
		s2.setJob("과장");
		s2.setPay(5000);
		
		System.out.println("이름 : "+s1.getName());
		System.out.println("사번 : "+s1.getSabun());
		System.out.println("부서 : "+s1.getDept());
		System.out.println("직위 : "+s1.getJob());
		System.out.println("연봉 : "+s1.getPay());
		
		// s2번을 넣었는데 왜 s1 변경? s1과 s2는 같은 객체	=> 싱글턴이다 (같은 이름의 id를 가져오면 같은 객체)
		
		System.out.println("================================================================ ");
		System.out.println("객체 주소 확인");
		System.out.println("s1 객체 주소 : "+s1);
		System.out.println("s2 객체 주소 : "+s2);
		// 주소가 같다 => 같은 객체 (싱글턴!!) => id를 같은 걸 가져왔을 때
		
		// bean에서 scope=prototype을 주게 되면 다른 메모리게 객체를 저장하게 되어서 주소가 바뀜 => 현재 prototype을 줘서 주소가 바뀐 상태
		
		
		
		
		
		
		
		
	}

}
