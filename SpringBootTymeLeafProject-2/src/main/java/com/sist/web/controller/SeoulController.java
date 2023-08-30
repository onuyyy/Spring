package com.sist.web.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sist.web.dao.SeoulLocationDAO;
import com.sist.web.entity.SeoulLocationEntity;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal;

@Controller
public class SeoulController {

	@Autowired
	private SeoulLocationDAO dao;
	
	@RequestMapping("seoul/location")
	public String seoul_find(String page,String fd,Model model) {
		
		if(fd==null) 
			fd="서울";
		
		if(page==null)
			page="1";
					
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*curpage)-rowSize;
		
		map.put("start", start);
		map.put("address", fd);
		
		List<SeoulLocationEntity> list=dao.seoulLocationFindData(fd, start);
		
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		int totalpage=dao.seoulLocationFindTotalPage(fd);
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		model.addAttribute("fd", fd);
		
		return "seoul/location";
	}
	

	
}
