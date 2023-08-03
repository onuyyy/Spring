package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sist.mapper.BoardMapper;
import com.sist.vo.BoardVO;
 
@Repository
public class BoardDAO {

	@Autowired
	private BoardMapper mapper;
	
	// 목록 출력
//	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
//			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
//			+ "FROM (SELECT no,subject,name,regdate,hit "
//			+ "FROM springReplyBoard ORDER BY group_id DESC,group_step ASC)) "
//			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map) {
		return mapper.boardListData(map);
	}

	// 총페이지
//	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springReplyBoard")
	public int boardTotalPage() {
		return mapper.boardTotalPage();
	}
	
	// 추가
//	@Insert("INSERT INTO springReplyBoard(no,name,subject,content,pwd,group_id) "
//			+ "VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},"
//			+ "(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard))")
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}
	
	// 상세보기
//	@Update("UPDATE springReplyBoard SET "
//			+ "hit=hit+1 "
//			+ "WHERE no=#{no}")
//	public void hitIncrement(int no);
//	
//	@Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday, hit "
//			+ "FROM springReplyBoard "
//			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
		
	}
	
	// 답변 (트랜잭션) => 스프링 AOP
//	@Select("SELECT group_id,group_step,groupe_tab "
//			+ "FROM springReplyBoard "
//			+ "WHERE no=#{no}")
//	public BoardVO boardParentInfoData(int no);
//	
//	// 수정
//	@Update("UPDATE springReplyBoard SET "
//			+ "group_step=group_step+1 "
//			+ "WHERE group_id=#{group_id} AND group_step>#{group_ste}")
//	public void baordGroupStepIncrement(BoardVO vo);
//	
//	@Insert("INSERT INTO springReplyBoard(no,name,subject,content,pwd,group_id,group_step,group_tab,root) "
//			+ "VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},"
//			+ "#{group_id},#{group_step},#{group_tab},#{root}")
//	public void boardReplyInsert(BoardVO vo);
//	
//	@Update("UPDATE springReplyBoard SET "
//			+ "dept=dept+1 "
//			+ "WHERE no=#{no}")
//	public void boardDepthIncrement(int no);
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public void boardReplyInsert(int root,BoardVO vo) {
		BoardVO pvo=mapper.boardParentInfoData(root);
		mapper.baordGroupStepIncrement(pvo);
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		vo.setRoot(root);
		mapper.boardReplyInsert(vo);
		mapper.boardDepthIncrement(root);
		
	}
	
	public BoardVO boardUpdateData(int no) {
		return mapper.boardDetailData(no);
	}

//	@Select("SELECT pwd FROM springReplyBoard "
//			+ "WHERE no=#{no}")
//	public String boardGetPassword(int no);
//	
//	@Update("UPDATE springReplyBoard SET "
//			+ "name=#{name},subject=#{subject},content=#{content} "
//			+ "WHERE no=#{no}")
	public boolean boardUpdate(BoardVO vo) {
		
		boolean bCheck=false;
		String db_pwd=mapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd())) {
			bCheck=true;
			mapper.boardUpdate(vo);
		}
		return bCheck;
	}

//	@Select("SELECT root,depth FROM springReplyBoard "
//			+ "WHERE no=#{no}")
//	public BoardVO boardInfoData(int no);
//	
//	@Update("UPDATE springReplyBoard SET "
//			+ "subject='관리자가 삭제한 게시물입니다.',content='관리자가 삭제한 게시물입니다.' "
//			+ "WHERE no=#{no}")
//	public void boardSubjectUpdate(int no);
//	
//	@Delete("DELETE FROM springReplyBoard "
//			+ "WHERE no=#{no}")
//	public void boardDelete(int no);
//	
//	@Update("UPDATE springReplyBoard SET "
//			+ "depth=depth-1 "
//			+ "WHERE no=#{no}")
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	public boolean boardDelete(int no,String pwd) {
		boolean bCheck=false;
		
		// pwd 읽기
		String db_pwd=mapper.boardGetPassword(no);
		if(db_pwd.equals(pwd)) {
			bCheck=true;
			// 삭제할 수 있는 게시물인지 확인=depth
			BoardVO vo=mapper.boardInfoData(no);
			if(vo.getDepth()==0) {
				mapper.boardDelete(no);
			} else {
				mapper.boardSubjectUpdate(no);
			}
			mapper.boardDepthDecrement(no);
		} else {
			
		}
		
		return bCheck;
	}
	
	// 다중 쿼리 find
	public List<BoardVO> boardFindDate(Map map) {
		return mapper.boardFindDate(map);
	}
	
}


