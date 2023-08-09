package com.sist.mapper;

import java.util.*;
import org.apache.ibatis.annotations.Select;
import com.sist.vo.*;

public interface FoodMapper {

	// 하나의 쿼리 문장으로 => 동적 쿼리 만들기
	@Select({"<script>"
			+"SELECT cno,title,subject,poster "
			+ "FROM food_category "
			+ "WHERE "
			+ "<if test='cno==1'>"
			+ "cno BETWEEN 1 AND 12"
			+ "</if>"
			+ "<if test='cno==2'>"
			+ "cno BETWEEN 13 AND 18"
			+ "</if>"
			+ "<if test='cno==3'>"
			+ "cno BETWEEN 19 AND 30"
			+ "</if>"
			+ " ORDER BY cno ASC"
			+ "</script>"
			})
	public List<CategoryVO> foodCategoryListData(Map map);
	
	
	@Select("SELECT fno,name,poster,type,phone,address "
			+ "FROM food_house "
			+ "WHERE cno=#{cno}")
	public List<FoodVO> foodListData(int cno);
}
