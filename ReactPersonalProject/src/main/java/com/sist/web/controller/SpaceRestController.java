package com.sist.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.dao.SpaceDAO;
import com.sist.web.entity.PageVO;
import com.sist.web.entity.SpaceEntity;

@RestController
@RequestMapping("space/")
@CrossOrigin("http://localhost:3000")
public class SpaceRestController {

	@Autowired
	private SpaceDAO dao;
	
	@GetMapping("space_list")
	public List<SpaceEntity> space_list() {
		
		List<SpaceEntity> list=dao.spaceList();
		
		return list;
		
	}
	
	@GetMapping("space_detail")
	public SpaceEntity space_detail(int spaceId) {
		
		SpaceEntity vo=dao.findBySpaceId(spaceId);
		
		return vo;
		
	}
	
	@GetMapping("space_category")
	public List<String> space_category_name() {
		
		List<String> list=dao.spaceCateName();
		
		return list;
	}
	
	@GetMapping("space_cateCount")
	public int category_count(String category) {
		int count=dao.categoryCount(category);
		return count;
	}
	
	@GetMapping("category_detail_list")
	public List<SpaceEntity> category_list(String category) {
		List<SpaceEntity> list=dao.findByCategory(category);
		
		return list;
	}
	
	@RequestMapping("space_find_react")
	public List<SpaceEntity> food_find(String fd,String page) {
		
		if(fd==null)
			fd="서울";
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		
		int rowSize=10;
		int start=(rowSize*curpage)-rowSize;
		
		List<SpaceEntity> list=dao.spaceFindData(fd, start);
		
		return list;
		
	}
	
	
	@RequestMapping("space_page_react")
	public PageVO food_page(String fd,int page) {
		
		int totalpage=dao.spaceFindTotalPage(fd);
		final int BLOCK=5;
		
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;	
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		PageVO vo=new PageVO();
		
		vo.setCurpage(page);
		vo.setEndPage(endPage);
		vo.setStartPage(startPage);
		vo.setTotalpage(totalpage);
		
		return vo;
	}
	
	
	@GetMapping("space_cateFind")
	public List<SpaceEntity> cate_click_list(String category) {
		System.out.println(category);
		List<SpaceEntity> list=dao.findByCategory(category);
		return list;
	}
	
}
