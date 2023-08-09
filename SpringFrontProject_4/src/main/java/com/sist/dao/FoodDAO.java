package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.FoodMapper;
import com.sist.vo.CategoryVO;
import com.sist.vo.FoodVO;

@Repository
public class FoodDAO {

	@Autowired
	private FoodMapper mapper;
	
	public List<CategoryVO> foodCategoryListData(Map map) {
		return mapper.foodCategoryListData(map);
	}

	public List<FoodVO> foodListData(int cno) {
		return mapper.foodListData(cno);
	}
	
}
