package com.sist.mapper;

import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BoardMapper {

	// 목록 출력 => 페이징 기법
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT /*+ INDEX_DESC(springBoard sb_no_pk)*/no,subject,name,regdate,hit "
			+ "FROM springBoard)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	// 매개변수는 한 개만 설정해야 해서 Map으로 설정한다
	// => VO에 없는 것들은 map
	// map.get("start")   map.get("end") => key 이름이다
	
	// 총페이지 구하기
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springBoard")
	public int boarTotalPage();
	
	@Insert("INSERT INTO springBoard(no,name,subject,content,pwd) "
			+ "VALUES(sb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
	public void boardInsert(BoardVO vo);
	// #{ } = vo.getName  vo.getSubject ...
	
	// 상세보기 + 조회수 증가
	@Update("UPDATE springBoard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,hit,To_CHAR(regdate,'YYYY-MM-DD') as dbday "
			+ "FROM springBoard "
			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	
}
