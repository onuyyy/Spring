package com.sist.dao;

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
	public int idCheck(String id) {
		return mapper.idCheck(id);
	}
	
	
//	@Select("SELECT COUNT(*) FROM mymember WHERE id=#{id}")
//	public int id_count(String id);
//
//	@Select("SELECT pwd,email,name,nickname,sex,birth,phone,post,addr1,addr2 FROM mymember "
//			+ "WHERE id=#{id}")
	public MemberVO get_db_info(String id, String pwd) {
		int count=mapper.id_count(id);
		
		MemberVO vo=new MemberVO();
		
		 if(count==0) {
			 vo.setMsg("NOID");
		 } else {
			vo=mapper.get_db_info(id);
			
			String db_pwd=vo.getPwd();
			String email=vo.getName();
			String name=vo.getName();
			String nickname=vo.getNickname();
			String sex=vo.getSex();
			String birth=vo.getBirth();
			String phone=vo.getPhone();
			String post=vo.getPost();
			String addr1=vo.getAddr1();
			String addr2=vo.getAddr2();
			
			if(db_pwd.equals(pwd)) {
				vo.setId(id);
				vo.setName(name);
				vo.setEmail(email);
				vo.setNickname(nickname);
				vo.setSex(sex);
				vo.setBirth(birth);
				vo.setPhone(phone);
				vo.setPost(post);
				vo.setAddr1(addr1);
				vo.setAddr2(addr2);
				vo.setMsg("OK");
			} else {
				vo.setMsg("NOPWD");
			}
		 }
		 
		return vo;
	}
}
