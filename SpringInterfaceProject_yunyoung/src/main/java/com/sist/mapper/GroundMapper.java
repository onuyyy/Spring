package com.sist.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import com.sist.vo.GroundVO;

public interface GroundMapper {

	/*
	 * 	private int gno,gprice;
		private String gname,gaddr,gimage,gnotice;
	 */
//	@Select("SELECT gno,gprice,gname,gimage,num "
//			+ "FROM (SELECT gno,gprice,gname,gimage,rownum as num "
//			+ "FROM (SELECT gno,gprice,gname,gimage "
//			+ "FROM ground_detail ORDER BY gno)) "
//			+ "WHERE num BETWEEN #{start} AND #{end}")
//	public List<GroundVO> groundListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM ground_detail")
	public int groundTotalPage();

	
	@Select("SELECT gno, goods_name, goods_image, TO_CHAR(cprice, '999,999') as dbcprice, TO_CHAR(price, '999,999') as dbprice, num "
	         + "FROM (SELECT gno, goods_name, goods_image, cprice, price, rownum AS num "
	         + "FROM (SELECT gno, goods_name, goods_image, cprice, price " 
	         + "FROM goods ORDER BY gno ASC)) WHERE num BETWEEN #{start} AND #{end}")
	public List<GroundVO> groundListData(Map map);
}
