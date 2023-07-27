package com.sist.dao;

/*
 *		client
 *		  ㅣ
 *		DispatcherServlet : 사용자의 모든 요청을 받는다 (Front Controller) 
 *							이미 스프링에서 라이브러리 제작
 *							=> 등록 (web.xml) => servlet은 구동 (톰캣)
 *					HandlerAdapter : Model을 찾는 역할
 *					HandlderMapping : 찾은 Model에서 @ReauestMapping()
 *					*** 자바로 환경 설정시에는 Handler~을 직접 설정
 *						==> web.xml 세팅과 동시에 구동
 *		  ㅣ
 *		해당 Model (controller) : 개발자 직접 제작 (DAO)
 *		  ㅣ		request에 요청, 처리값 담음/jsp 파일명을 전송
 *				jsp ==> jsp , Servlet ==> jsp
 *		DispatcherServlet
 *			1) jsp 찾기
 *			2) request를 전송
 *			-------------------- ViewResolver
 *		  ㅣ
 *		View (JSP)
 *		  ㅣ	request에 담긴 데이터 출력 (JSTL/EL)
 *		Client
 *		
 *
 *
 */

import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository		// 메모리 할당
public class FoodDAO {

	@Autowired
	private FoodMapper mapper;
	
//	@Select("SELECT cno,title,poster,subject "
//			+ "FROM food_category "
//			+ "ORDER BY cno ASC")
	public List<CategoryVO> foodCategoryListData() {
		return mapper.foodCategoryListData();
	}
	
//	@Select("SELECT fno,name,score,address,phone,type, poster "
//			+ "FROM food_house "
//			+ "WHERE cno=#{cno}")
	public List<FoodVO> foodListData(int cno) {
		return mapper.foodListData(cno);
	}

}
