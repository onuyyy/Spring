package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

public interface MemberMapper {
	
	@Select("SELECT COUNT(*) FROM mymember WHERE id=#{id}")
	public int id_count(String id);

	@Select("SELECT pwd,email,name,nickname,sex,birth,phone,post,addr1,addr2 FROM mymember "
			+ "WHERE id=#{id}")
	public MemberVO get_db_info(String id);
	
	@Insert("INSERT INTO mymember (id,pwd,email,name,nickname,sex,birth,phone,post,addr1,addr2) "
			+ "VALUES(#{id},#{pwd},#{email},#{name},#{nickname},"
			+ "#{sex},#{birth},#{phone},#{post},#{addr1},#{addr2})")
	public void join(MemberVO vo);
	
	@Select("SELECT COUNT(*) FROM mymember WHERE id=#{id}") 
	public int idCheck(String id);
	
	

}
