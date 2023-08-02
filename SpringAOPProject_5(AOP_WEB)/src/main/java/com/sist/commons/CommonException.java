package com.sist.commons;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice		// 예외 처리를 한 번에 처리할 때 (컨트롤러 내에서 에러 났을 때)
public class CommonException {

	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException ex) {
		
		// 컨트롤러의 예외처리를 여기다가 모아둔다
		
		System.out.println("===== RuntimeException =====");
		ex.printStackTrace();
		System.out.println("============================");
	}
	
	
	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException ex) {
		
		// 컨트롤러의 예외처리를 여기다가 모아둔다
		
		System.out.println("===== SQLException =====");
		ex.printStackTrace();
		System.out.println("========================");
	}
	
	
	@ExceptionHandler(IOException.class)
	public void ioException(IOException ex) {
		
		// 컨트롤러의 예외처리를 여기다가 모아둔다
		
		System.out.println("===== IOException =====");
		ex.printStackTrace();
		System.out.println("=======================");
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public void Exception(Exception ex) {
		
		// 컨트롤러의 예외처리를 여기다가 모아둔다
		
		System.out.println("===== Exception =====");
		ex.printStackTrace();
		System.out.println("=====================");
	
	}
	
}
