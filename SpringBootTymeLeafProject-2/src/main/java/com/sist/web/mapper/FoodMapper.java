package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.*;
import com.sist.web.vo.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FoodMapper {

// 	<select id="foodFindData" resultType="FoodVO" parameterType="hashmap">
	public List<FoodVO> foodFindData(Map map);
	
// 	<select id="foodFindTotalPage" resultType="int" parameterType="string">
 	public int foodFindTotalPage(String address);
	
}
