package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Component;

@Component
public class Aop {

	private Connection conn;
	private PreparedStatement ps;
	private static Aop aop;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	
	   public Aop()
	   {
		   try
		   {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		   }catch(Exception ex) {}
	   }
	   
	   public void getConnection()
	   {
		   try
		   {
			   conn=DriverManager.getConnection(URL,"hr","happy");
		   }catch(Exception ex) {}
	   }
	   
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex) {}
	   }
	
	public static Aop newInstance () {
		
		if(aop==null) 
			aop=new Aop();
		
		return aop;
	}
	
	
	
}
