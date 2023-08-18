package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sist.dao.Aop;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

	@Autowired
	private Aop aop;
	
	@Before("execution(* com.sist.*(..))")
	public void getConnection() {
		aop.getConnection();
	}
	
	@After("execution(* com.sist.*(..))")
	public void disConnection() {
		aop.disConnection();
	}
	
	
	
}
