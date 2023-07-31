package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.DataBoardMapper;
import com.sist.vo.DataBoardVO;

@Repository
public class DataBoardDAO {

	@Autowired
	private DataBoardMapper mapper;
	
	/*
	 * 	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
				+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
				+ "FROM (SELECT /*+INDEX_DESC(springDataBoard sdb_no_pkno,subject,name,regdate,hit "
				+ "FROM springDataBoard)) "
				+ "WHERE num BETWEEN #{start} AND #{end}") */
		public List<DataBoardVO> databoardListData(Map map) {
			return mapper.databoardListData(map);
		}
	
//		@Select("SELECT CEIL(COuNT(*)/10.0) FROM springDataBoard")
		public int databardTotalPage() {
			return mapper.databardTotalPage();
		}
		
		// 시퀀스 만들기
//		@SelectKey(keyProperty = "no",resultType = int.class, before = true, 
//				statement = "SELECT NVL(MAX(no)+1,1) as no FROM apringDataBoard")
		
//		@Insert("INSERT INTO springDataBoard(no,name,subject,content,pwd,filename,filesize,filecount) "
//				+ "VALUES(#{no},#{name},#{subject},#{content},#{pwd},#{filename},#{filesize},#{filecount})")
		public void databoardInsert(DataBoardVO vo) {
			mapper.databoardInsert(vo);
		}
	
}
