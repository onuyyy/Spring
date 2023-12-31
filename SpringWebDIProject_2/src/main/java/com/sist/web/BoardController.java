package com.sist.web;

import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.dao.*;
import com.sist.vo.BoardVO;

/*
 * Spring MVC
 * 		1) DispatcherServlet 등록 => web.xml
 * 			=> class를 등록한 파일 셋팅 (클래스 관리)
 * 			=> 한글 변환
 * 		2) 클래스 제작
 * 			=> VO
 * 			=> Mapper
 * 			=> DAO
 * 			=> Model	
 */

@Controller
@RequestMapping("board/")
public class BoardController {

	@Autowired
	private BoardDAO dao;
	
	//get post 동시처리 => requestMapping
	// 목록
	@GetMapping("list.do")	// list.do?page= 와 같아야 함 / 처음은 String으로 받는 이유? => 첫페이지는 null값이기 떄문에 // 상세볼 때는 int로 넘어오기 때문에 int로 받는다
	public String board_list(String page,Model model) {
		// 받아야 할 변수 page => request.parameter 쓰지 않고 매개변수로 받는다
		// Model model => 전송객체 (request 대신 사용한다)
		
		if(page==null) 
			page="1";
		int curpage=Integer.parseInt(page);
		
		// map 에 값 넣기
		Map map=new HashedMap();
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list=dao.boardListData(map);
				
		int totalpage=dao.boarTotalPage();
		
		model.addAttribute("curpage",curpage);	// request.setAttribute 와 같다
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list",list);
		
		// board/list.jsp 로 값 보냄
		return "board/list";
	}
	
	// 추가
	@GetMapping("insert.do")
	public String board_insert() {
		
		return "board/insert";
	}
	
	//form 태그 이용하면 post
	@PostMapping("insert_ok.do")
	public String board_insert_ok(BoardVO vo) {
		dao.boardInsert(vo);
		return "redirect:list.do";
	}
	
	// 데이터 수정
	@GetMapping("update.do")
	public String board_update(int no,Model model) {
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo",vo);
		
		return "board/update";
	}
	
	
	// 데이터 삭제
	// delete.do?no=${vo.no }
	@GetMapping("delete.do")	// form 태그 외에는 get방식 (ajax는 좀 다름)
	public String board_delete(int no,Model model) {
		model.addAttribute("no",no);
		
		return "board/delete";
	}
	
	@PostMapping("delete_ok.do")
	public String board_delete_ok(int no,String pwd,Model model) {
		
		boolean bCheck=dao.boardDelete(no, pwd);
		model.addAttribute("bCheck",bCheck);
		
		return "board/delete_ok";
	}
	// jsp를 만들어서 처리할 건지, 값만 보내서 처리할 건지
	
	
	// 데이터 상세보기
	
	
	// 상세보기
	@GetMapping("detail.do")
	public String board_detail(int no,Model model) {
							//------------------- request.getparameter() => dispatcherServelt 통해서 값이 들어온다
							// String no=request.getParameter("no")
		// list.jsp에서 보낸 no값과 매개변수 no값이 반드시 일치해야 한다
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo",vo);
		
		return "board/detail";
	}
	/*
	 *  class Model {
	 *  	HttpServletRequest request;
	 *  public void addAttribute(String key, Object obj) {
	 *  	request.setAttribute(key,obj)
	 *  }
	 *  }
	 */
	
	
	
	// 검색
	
}
