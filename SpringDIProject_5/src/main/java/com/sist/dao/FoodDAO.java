package com.sist.dao;

import java.util.List;
import java.util.Map;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class FoodDAO extends SqlSessionDaoSupport{

	public List<FoodVO> foodCategoryData() {
		
		return getSqlSession().selectList("foodCategoryData");
	}
	
}
