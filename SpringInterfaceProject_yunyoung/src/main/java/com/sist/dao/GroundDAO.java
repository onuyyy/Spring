package com.sist.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.GroundMapper;
import com.sist.vo.GroundVO;

@Repository
public class GroundDAO {

	@Autowired
	private GroundMapper mapper;
	
//	@Select("SELECT gno,gprice,gname,gimage,num "
//			+ "FROM (SELECT gno,gprice,gname,gimage,rownum as num "
//			+ "FROM (SELECT gno,gprice,gname,gimage "
//			+ "FROM ground_detail ORDER BY gno)) "
//			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<GroundVO> groundListData(Map map) {
		return mapper.groundListData(map);
	}
	
//	@Select("SELECT CEIL(COUNT(*)/12.0) FROM ground_detail")
	public int groundTotalPage() {
		return mapper.groundTotalPage();
	}
	
}
