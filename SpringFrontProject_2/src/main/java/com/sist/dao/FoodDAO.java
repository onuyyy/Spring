package com.sist.dao;

import java.util.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.FoodLocationVO;
import com.sist.mapper.*;

@Repository
public class FoodDAO {

	@Autowired
	private FoodMapper mapper;
	
//	@Select("SELECT fno,name,poster,score,num "
//			+ "FROM (SELECT fno,name,poster,score,rownum as num "
//			+ "FROM (SELECT fno,name,poster,score "
//			+ "FROM food_location ORDER BY fno ASC)) "
//			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodLocationVO> foodListData(Map map) {
		
		return mapper.foodListData(map);
	};
	
	
//	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_location")
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
	
	// 상세보기 한 페이지 안에서 출력
//	@Select("SELECT fno,name,poster,score,parking,time,type,address,pbone,"
//			+ "price,menu "
//			+ "FROM food_location "
//			+ "WHERE fno=#{fno}")
	public FoodLocationVO foodDetailData(int fno) {
		return mapper.foodDetailData(fno);
	} 
	
	// 검색
//	@Select("SELECT fno,name,poster,score,num "
//			+ "FROM (SELECT fno,name,poster,score,rownum as num "
//			+ "FROM (SELECT fno,name,poster,score "
//			+ "FROM food_location ORDER BY fno ASC WHERE LIKE '%'||#{address}||'%')) "
//			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodLocationVO> foodFindData(Map map) {
		return mapper.foodFindData(map);
	}
	
	
	
}
