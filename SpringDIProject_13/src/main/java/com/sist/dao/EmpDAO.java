package com.sist.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sist.vo.EmpVO;

/*
 * service (interface) => serviceImpl => repository
 * 										 ----------- 
 * 											 dao
 * 
 * service : 1.dao 여러 개 묶기, 1.controller 일을 처리
 */

public class EmpDAO extends SqlSessionDaoSupport {
/*
 * <sql id="select-emp">
	SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday, sal, dname, loc
	FROM emp,dept
	WHERE emp.deptno=dept,deptno
</sql>

<select id="empdeptListData" resultMap="empMap">
	<include refid="select-emp"></include>
	ORDER BY sal DESC
</select>
<select id="empdeptDetailData" resultMap="empMap" parameterType="int">
	<include refid="select-emp"></include>
	AND empno=#{empno}
</select>
 */
	
	public List<EmpVO> empdeptListData() {
		return getSqlSession().selectList("empdeptListData");
	}
	
	public EmpVO empdeptDetailData(int empno) {
		return getSqlSession().selectOne("empdeptDetailData", empno);
	}
}
