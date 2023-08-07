package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
import java.util.*;
import com.sist.vo.*;

@RestController
public class GroundRestController {

	@Autowired
	private GroundDAO dao;
	
	@GetMapping(value="ground/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String food_list_vue(String page) {
		
		String result="";
		
		try {
			if(page==null)
				page="1";
			
			int curpage=Integer.parseInt(page);
			
			Map map=new HashMap();
			map.put("start", (curpage*12)-11);
			map.put("end", curpage*12);
			
			List<GroundVO> list=dao.groundListData(map);
			int totalpage=dao.groundTotalPage();

			JSONArray arr=new JSONArray();
			int i=0;
			for(GroundVO vo:list) {
				
				JSONObject obj=new JSONObject();

				obj.put("gno", vo.getGno());
				obj.put("goods_name", vo.getGoods_name());
				String goods_image=vo.getGoods_image();
				
				obj.put("goods_image", goods_image);
				

				if(i==0) {
					obj.put("curpage", curpage);
					obj.put("totalpage", totalpage);
				}
				
				arr.add(obj);
				i++;
			}
			result=arr.toJSONString();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	
}
