package com.sist.main;

import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;
import com.sist.config.*;

@Component("mc")
public class MainClass {
	
	@Autowired
	private EmpDAO dao;
	public static void main(String[] args) {
		
		// 생성이 application이 아니라 annotation이다
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(EmpConfig.class);
		MainClass mc=(MainClass)app.getBean("mc");
		
		List<EmpVO> list=mc.dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}
		
//		Scanner scan=new Scanner(System.in);
//		System.out.println("번호 입력 :");
//		int empno=scan.nextInt();
//		EmpVO vo=mc.dao.empDetailData(empno);
//		
//		System.out.println(vo.getEname()+" "+vo.getJob()+" "+vo.getSal()+" "+vo.getComm());

		
		
		/*
		 * 	@Select("SELECT empno,ename,job,hiredate,sal,deptno,comm FROM emp WHERE=#{empno}")
			public EmpVO empDetailData(int empno);
		 */
	}

}
