package com.sist.dao;

import java.util.*;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpDAO {

	// @autowired 대신 mapper를 setter 해야 한다
	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}

	private EmpMapper mapper;
	
	/*
	 * 	@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal "
			+ "FROM emp") */
		public List<EmpVO> empListData() {
			return mapper.empListData();
		}
		
		/*@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal "
				+ "FROM emp "
				+ "WHERE empno=#{empno}") */
		public EmpVO empDetailData(int empno) {
			return mapper.empDetailData(empno);
		}
		
		/*(@Select("SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday,sal "
				+ "FROM emp "
				+ "WHERE ename LIKE '%'||#{ename}||'%'")*/
		public List<EmpVO> empFindData(String ename) {
			return mapper.empFindData(ename);
		}
		
}
