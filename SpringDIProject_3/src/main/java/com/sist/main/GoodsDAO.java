package com.sist.main;

/*
 *	객체 주입 => 자동 주입, XML 주입 
 */

import java.util.*;

import lombok.Setter;

import java.sql.*;

public class GoodsDAO {

	private Connection conn;
	private PreparedStatement ps;
	
	// Spring을 통해서 멤버변수 주입하는 것 => 생성자의 매개변수에 값을 채운다
	// setXxx()를 이용해서 값을 채운다
	
	// setter를 통해서 값 집어 넣는다
	@Setter
	private String url;
	@Setter
	private String username;
	@Setter
	private String password;
	
	
	// 생성자를 통해서 값 집어넣음
	public GoodsDAO(String driver) {
		try {
			Class.forName(driver);
		} catch(Exception ex) {}
	}
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(url,username,password);
		} catch(Exception ex) {}
	}
	
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch(Exception ex) {}
	}
	
	public List<String> goodsNameList() {
		List<String> list=new ArrayList<String>();
		
		try {
			getConnection();
			String sql="SELECT goods_name FROM goods_all "
					+ "ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			disConnection();
		}
		return list;
	}
	
}
