package com.sist.dao;

import java.util.*;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
	
//	@Select("SELECT no,name,subject,content "
//			+ "FROM springboard "
//			+ "WHERE no=#{no}")
	public BoardVO boardUpdateData(int no) {
		return mapper.boardUpdateData(no);
	}

//	@Select("SELECT pwd FROM springBoard "
//			+ "WHERE no=#{no}")
//	public String boardGetPassword(int no);
	
//	@Update("UPDATE springBoard SET "
//			+ "name=#{},subject=#{},content=#{} "
//			+ "WHERE no=#{no}")
	public boolean boardUpdate(BoardVO vo) {	// mapper와 동일하게 안 들어올 수도 있다
		boolean bCheck=false;
		
		String db_pwd=mapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd())) {
			bCheck=true;
			mapper.boardUpdate(vo);
		}
		return bCheck;
	}
	
//	@Delete("DELETE FROM springBoard "
//			+ "WHERE no=#{no}")
	public boolean boardDelete(int no,String pwd) {
		
		boolean bCheck=false;
		
		String db_pwd=mapper.boardGetPassword(no);
		if(db_pwd.equals(pwd)) {
			bCheck=true;
			mapper.boardDelete(no);
		}
		
		return bCheck;
		
	}
}
