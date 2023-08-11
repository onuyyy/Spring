package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.ReplyVO;

import lombok.Delegate;

public interface ReplyMapper {

	// 복잡한 코딩은 xml, 간단한 것은 어노테이션
	
// 	<select id="replyListData" resultType="ReplyVO" parameterType="int">
//		SELECT no,fno,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS) as dbday
//		FROM springTestREply
//		WHERE fno=#{fno}
//		ORDER BY no DESC
//	</select>
	public List<ReplyVO> replyListData(int fno);
	
//	<insert id="replyInsert" parameterType="ReplyVO">
//		INSERT INTO springTestReply VALUES(
//		str_no_seq.nextval,#{fno},#{id},#{name},#{msg),SYSDATE
//		)
//	</insert>

	public void replyInsert(ReplyVO vo);
	
	@Delete("DELETE FROM springTestReply WHERE no=#{no}")
	public void replyDelete(int no);
	
	@Update("UPDATE springTestReply SET msg=#{msg} "
			+ "WHERE no=#{no}")
	public void replyUpdate(ReplyVO vo);
}
