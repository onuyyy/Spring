package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.FoodDAO;
import java.util.*;
import com.sist.vo.*;

// javasciprt 값을 전송하는 것 restController , 페이지 이동은 controller

@RestController
public class FoodRestController {

	@Autowired
	private FoodDAO dao;
	
	@GetMapping(value="food/food_category_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_category(int cno) throws Exception {
		
		Map map=new HashedMap();
		map.put("cno", cno);
		
		List<CategoryVO> list=dao.foodCategoryListData(map);
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		
		return json;

	}
}
