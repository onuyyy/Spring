package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.MemberVO;


@Repository
public class MemberDAO {

	@Autowired
	private MemberMapper mapper;
	
//	@Insert("INSERT INTO mymember VALUES(#{id},#{pwd},#{email},#{name},#{nickname},"
//			+ "#{sex},#{birth},#{phone},#{post},#{addr1},#{addr2})")
	public void join(MemberVO vo) {
		mapper.join(vo);
	}
	
//	@Select("SELECT COUNT(*) FROM mymember WHERE id=#{id}")
	public int id_count(String id) {
		return mapper.id_count(id);
	}
	
//	@Select("SELECT pwd,email,name,nickname,sex,birth,phone,post,addr1,addr2 FROM mymember "
//			+ "WHERE id=#{id}")
	public MemberVO login(String id) {
		return mapper.login(id);
	}
	
}
