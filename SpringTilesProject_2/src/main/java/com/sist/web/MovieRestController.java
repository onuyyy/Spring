package com.sist.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRestController {

	private String[] urls= { "", "https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do", 
			"https://www.kobis.or.kr/kobis/business/main/searchMainRealTicket.do", 
			"https://www.kobis.or.kr/kobis/business/main/searchMainDailySeatTicket.do" };
	
/*
		1. HTML : text/html
		2. XML : text/xml
		3. JSON : text/plain
		
		vo → {} → JSONObject
		List → [{}, {}, {}...] → JSONArray
 */
	@GetMapping(value = "movie/movie_rank_vue.do", produces = "text/plain;charset=UTF-8")
	public String movie_rank(int no)
	{
		return "";
	}
	
}
