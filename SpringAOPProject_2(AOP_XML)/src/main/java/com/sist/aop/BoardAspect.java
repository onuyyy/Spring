package com.sist.aop;


/*
 * 		언제 어디서 호출할지 여부 확인
 *		1. 시점 => pointcut
 *		2. 호출 => joinpoint
 *
 *			@Before : try 시작 전
 *			@After	: finally에서 호출
 *			@Around : 코드 위, 아래(두 군데) 호출 => 로그 파일, 트랜잭션 만들 때 자주 사용
 *			@After-Throwing  : catch에서 사용 => 오류 발생시
 *			@After-Returning : 정상 수행시 사용
 *			
 *
 *
 *			@Transactional => 트랜잭션 주면 전체 트랜잭션으로 바뀐다
 *		   public String display() {
 *				try {
 *				
 *				    @ => Before
 *					-------------------------------------- @Around => conn.setAutoCommit(false)
 *					--- 핵심코딩 (핵심 문장 수행 전에 before 호출)
 *					-------------------------------------- conn.commit()
 *
 *				} catch(Exception ex) {
 *
 *					@After-Throwing conn.rollback()
 *
 *				} finally {
 *
 *					@ => After conn.setAutoCommit(true)
 *
 *				}
 *
 *				return ""; => @After-Returning
 *			}
 *
 *
 *				-----	@Around => conn.setAutoCommit(false)
 *				핵심코딩	=> 위아래 두 군데 호출할 수 있음  
 *				------	conn.commit()
 *				
 *
 *
 *		-------------------- + advice
 *
 *		------------------------------ + aspect
 * 
 * 
 */

public class BoardAspect {

	public void before() {
		// 문장 수행 전
		System.out.println("오라클 연결");
	}
	
	public void after() {
		// 문장 수행 후 => finally
		System.out.println("오라클 해제");
	}
	
	
}







