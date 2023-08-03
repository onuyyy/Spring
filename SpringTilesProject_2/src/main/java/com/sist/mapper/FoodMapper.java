package com.sist.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;
import com.sist.vo.SeoulVO;

public interface FoodMapper {

	@Select("SELECT cno,title,poster FROM food_category ORDER BY cno ASC")
	public List<CategoryVO> foodCategoryData();
	
/*	@Select("SELECT fno, name, poster, rownum "
	        + "FROM (SELECT fno, name, poster "
	        + "FROM food_house ORDER BY fno ASC) "
	        + "WHERE rownum <= 7")
	public List<FoodVO> foodTop7();

	
	@Select("SELECT no, title, poster, rownum "
	        + "FROM (SELECT no, title, poster "
	        + "FROM seoul_location "
	        + "ORDER BY no ASC) "
	        + "WHERE rownum <= 7")
	public List<SeoulVO> seoulTop7(); */

	@Select("SELECT title,subject FROM food_category "
			+ "WHERE cno=#{cno}")
	public CategoryVO foodCategoryInfoDate(int cno);
	
	@Select("SELECT fno,cno,name,poster,phone,type,score,adress "
			+ "FROM food_house "
			+ "WHERE cno=#{cno}")
	public List<FoodVO> foodListData(int cno);
	

	
}
