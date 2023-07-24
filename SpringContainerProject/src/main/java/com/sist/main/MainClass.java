package com.sist.main;
/*
 * MainClass는 Hello 클래스에 의존을 한다 => 클래스명 바뀌면 Main에서 오류 뜸 => 유지 보수 어려움
 * 									=> 결합성(의존성)이 강한 프로그램
 * 									=> 장점 : 연결하기 쉽다 / 단점 : 변경시에 다른 클래스에 영향을 끼친다
 * 									=> 스프링에서는 방지 (의존성이 낮은 프로그램을 구현)
 * 									   ----- 클래스 수정 => 다른 클래스에 영향이 없게 한다
 * 									=> 스프링에서는 가급적이면 new를 사용하지 않는다 (new => 직접적 연결이기 때문에 영향을 많이 끼친다)
 * 									=> ㅁ   ---  ㅇ  ---  ㅁ
 * 									  class interface class => interface 이용한다
 */
public class MainClass {

	// 유지보수 => 리팩토링 (가시성 => 변수명, 메소드명을 변경)
	public static void main(String[] args) {
		
		Hello hello=new Hello();
		/*
		 * String msg=hello.sayHello("홍길동"); System.out.println(msg);
		 */

	}

}
