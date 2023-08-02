package com.sist.aop;

/*
 * 	aspect : AOP는 OOP를 대체하는 프로그램이 아니다
 * 				=> OOP륿 보완한 프로그램 : OOP는 콜백함수(자동호출)가 없다
 * 				=> 1개,2개의 공통으로 사용되는 내용 => 메소드로 처리
 * 					getConnection(),disConnection()
 * 				=> 여러 개가 공통으로 사용되는 내용 => 클래스
 * 					CreateDataBase 
 * 					-------------- 공통 모듈
 * 				=> Spring에서선 반복적인 코딩을 모아서 관리 => 자동 호출 AOP
 * 
 * 	** 사용자 정의는 많이 사용하지 않는다
 * 
 * 	AOP
 * 	1. 어떤 메소드에 적용을 시킬 것인가 : PointCut
 * 		pointcut="execution(* com.sist.main.*.*(..))"
 * 											    ---
 * 											   매개변수
 * 											---
 * 										   클래스명	
 * 						   --- return형은 전체
 * 
 * 		pointcut="within("com.sist.main.*")"
 * 			=> 패키지 단위로 등록할 때
 * 
 * 	2. 호출되는 위치가 어디인가 : JoinPoint 
 * 
 * 		@Transactional
 * 		public String display() {
 * 				@Before : getConnection()
 * 			try {
 * 				------- @around	(setAutoCoomit())
 * 				핵심코딩	
 * 				------- @around (commit())
 * 			} catch {
 * 				@After-Throwing : 오류 처리 (rollBack())
 * 			} finally {
 * 				@after (disConnection(),getConnection())
 * 			}
 * 				return "" @After-REturning
 * 		};
 * 
 * 
 * 		JoinPoint + PointCut => Advice => Aspect
 * 			Weaving : 통합 => Proxy 패턴 (대리자)
 * 
 * 		public class A {
 * 			public class Proxy(A a) {
 * 			this.a=a;
 * 		}
 * 		public void dispay() {
 * 			@Before =>  설정된 메소드 호출
 * 			a.display();
 * 			@After => 설정된 메소드 호출
 * 		}
 * 
 * 
 */

import java.util.*;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sist.dao.*;

@Aspect
@Component	// 메모리 할당
public class EmpAspect {

	@Autowired
	private EmpDAO dao;
	
	@Before("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void getConnection() {
		System.out.println("오라클 연결");
		dao.getConnection();
	}
	
	@After("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void disConnection() {
		System.out.println("오라클 해제");
		dao.disConnection();
	}
	
	@AfterReturning(value="execution(* com.sist.dao.EmpDAO.emp*(..))",returning="obj")
																		// ------ 라톤 겂   
	public void print(Object obj) {
		List<EmpVO> list=(List<EmpVO>)obj;
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
							  +vo.getEname()+" "
							  +vo.getJob()+" "
							  +vo.getDbday()+" "
							  +vo.getSal());
		}
	}
	
	@AfterThrowing(value="execution(* com.sist.dao.EmpDAO.emp*(..))",throwing="ex")
	public void exception(Throwable ex) {
		System.out.println("에러발생");
		ex.printStackTrace();
	}
	
}




