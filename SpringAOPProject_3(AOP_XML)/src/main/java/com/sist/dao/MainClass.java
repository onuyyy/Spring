package com.sist.dao;

import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sist.dao.*;

public class MainClass {

	public static void main(String[] args) {
		
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		dao.empListData();
		
//		dao.empDetailData(7788);	=> return형이 list가 아니라 오류가 난다
		dao.empFindData("A");
		
	}
	
}
