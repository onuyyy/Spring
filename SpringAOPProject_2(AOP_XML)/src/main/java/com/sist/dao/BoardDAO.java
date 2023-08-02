package com.sist.dao;

public class BoardDAO {

	// 설정시 <aop:before method="before" pointcut="execution(* com.sist.dao.BoardDAO.aop*(..)"/>
	// aop로 시작되는 모든 메소드에 aop 호출하는 건데 find는 aop 제외
	public String find(String name) {
		System.out.println("FIND 수행");
		return name;
	}
	
	public void aopSelect(String name) {
		System.out.println(name+" SELECT 문장 수행");
	}
	
	public void aopUpdate() {
		System.out.println("UPDATE 문장 수행");
	}

	public void aopInsert() {
		System.out.println("INSERT 문장 수행");
	}
	
	public void aopDelete() {
		System.out.println("DELETE 문장 수행");
	}
	
}
