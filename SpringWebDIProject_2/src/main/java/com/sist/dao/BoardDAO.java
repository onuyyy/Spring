package com.sist.dao;

import java.util.*;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.BoardMapper;
import com.sist.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	private BoardMapper mapper;
	
//	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'),hit,num "
//			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
//			+ "FROM (SELECT /*+ INDEX_DESC(springBoard sb_no_pk)*/no,subject,name,regdate,hit "
//			+ "FROM springBoard)) "
//			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map) {
		return mapper.boardListData(map);
	}
	
//	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springBoard")
	public int boarTotalPage() {
		return mapper.boarTotalPage();
	}

//	@Insert("INSERT INTO springBoard(no,name,subject,content,pwd) "
//			+ "VALUES(sb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}
	// void는 return 필요 X
	
//	@Select("SELECT * FROM springBoard "
//			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
	}
	
}
