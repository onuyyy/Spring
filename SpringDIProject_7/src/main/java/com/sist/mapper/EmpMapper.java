package com.sist.mapper;

import java.util.*;
import org.apache.ibatis.annotations.Select;
import com.sist.vo.*;

public interface EmpMapper {

	/*
	 * <select id="empListData" resultType="EmpVO" parameterType="int">
	 * 		SELECT ~~ 
	 * </select>
	 * 
	 * 		==> annotation으로 바뀜
	 * 
	 * id = method명
	 * resultType = 리턴형
	 * parameterType = 매개변수
	 * 
	 *  -- DAO
	 * 	public List<EmpVO> empListData(int empno) {
	 * 		
	 * 	}
	 */
	
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,"
			+"sal,deptno,comm "
			+"FROM emp")
	public List<EmpVO> empListData();
	
	// 변수명과 컬럼명이 일치해야 한다
	@Select("SELECT empno,ename,job,mgr,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,"
			+"TO_CHAR(sal,'$99,999') as dbsal,NVL(comm,0) as comm,deptno "
			+"FROM emp "
			+"WHERE empno=#{empno}")
	public EmpVO empDetailData(int empno);
	
	
	// 이름으로 검색하기
	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday, "
			+ "sal,deptno,comm "
			+ "FROM emp "
			+ "WHERE ename LIKE '%'||#{ename}||'%'")
	public List<EmpVO> enameFindData(String ename);
	
	
}





