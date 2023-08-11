package com.sist.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.ReplyMapper;
import com.sist.vo.ReplyVO;

/*
 * 데이터 저장 => mounted => render() => html 데이터 출력시 사용
 * 			   -------
 * 				  ㅣ
 * 			 데이터가 변경 : updated() => render()
 * 							 ㅣ
 * 						data:{} => 안에 있는 변수 값이 변경시에 호출
 */

@Repository
public class ReplyDAO {

	@Autowired
	private ReplyMapper mapper;
	
	public List<ReplyVO> replyListData(int fno) {
		return mapper.replyListData(fno);
	}

	public void replyInsert(ReplyVO vo) {
		mapper.replyInsert(vo);
	}
	
	public void replyDelete(int no) {
		mapper.replyDelete(no);
	}
	
	public void replyUpdate(ReplyVO vo) {
		mapper.replyUpdate(vo);
	}
	
}
