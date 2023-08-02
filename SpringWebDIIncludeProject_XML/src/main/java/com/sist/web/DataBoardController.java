package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import com.sist.vo.*;
import com.sist.dao.*;

@Controller
public class DataBoardController {

	@Autowired
	private DataBoardDAO dao;
	
	// 목록 출력
	@GetMapping("databoard/list.do")
	public String databoard_list(String page,Model model) {
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		List<DataBoardVO> list=dao.databoardListData(map);
		
		int totalpage=dao.databoardTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("curpage", curpage);
		
		model.addAttribute("main_jsp", "../databoard/list.jsp");
		return "main/main";
	}
	
	// 데이터 추가
	@GetMapping("databoard/insert.do")
	public String databoard_insert(Model model) {
		
		model.addAttribute("main_jsp", "../databoard/insert.jsp");
		return "main/main";
	}
	
	@PostMapping("databoard/insert_ok.do")
	public String databoard_insert_ok(DataBoardVO vo) {
		
		List<MultipartFile> list=vo.getFiles();
		if(list==null) {	// 파일이 없는 상태 (업로드가 안된 경우)
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		} else {			// 업로드가 된 상태
			String filenames="";
			String filesizes="";
			for(MultipartFile mf:list) {
				File file=new File("c:\\download\\"+mf.getOriginalFilename());
				try {
					mf.transferTo(file);	// 파일 업로드 
				} catch(Exception ex) {}
				
				filenames+=file.getName()+",";
				long len=file.length();		// 파일 크기 가져오기
				filesizes+=len+",";
			}
			filenames=filenames.substring(0,filenames.lastIndexOf(","));
			filesizes=filesizes.substring(0,filesizes.lastIndexOf(","));
			vo.setFilename(filenames);
			vo.setFilesize(filesizes);
			vo.setFilecount(list.size());
		}
		
		dao.databoardInsert(vo);
		return "redirect:../databoard/list.do";
	}
	
	
	/*
	 * 	요청 데이터가 없는 경우 (처음) => String으로 받아야 한다
	 * 	모든 데이터는 String으로 받을 수 있다
	 *	매개변수는 순서가 없고 여러 개를 받을 수 있다
	 *
	 *	1. Model (Controller) : 매개변수 설정
	 *		매개변수 => 사용자가 보내준 값 1) 일반 데이터 (int, String, ...)
	 *								2) 데이터를 모아서 처리 VO (커맨드 객체)
	 *								3) checkbox : String[]
	 *
	 *		내장객체
	 *			HttpServletRequest, HttpServletResponse
	 *			HttpSession, Model, RedirectAttributes,
	 *			PasswordEncoder
	 *
	 *		MVC의 핵심 => 매개변수 / 리턴형
	 *							-------  화면이동 (forward / sendRedirect)
	 *										1) forward : 화면 변경 => request 전송
	 *										2) sendRedirect : request 초기화, 기존에 설정된 위치로 변경
	 */
	
	// ../databoard/detail.do?no=${vo.no }
	@GetMapping("databoard/detail.do")
	public String databoard_detail(int no,Model model) {
		
		DataBoardVO vo=dao.databoardDetailData(no);
		
		if(vo.getFilecount()>0) {
			
			String filenames=vo.getFilename();
			StringTokenizer st=new StringTokenizer(filenames,",");
			List<String> nList=new ArrayList<String>();
			while(st.hasMoreTokens()) {
				nList.add(st.nextToken());
			}
			
			String filesizes=vo.getFilesize();
			st=new StringTokenizer(filesizes,",");
			List<String> sList=new ArrayList<String>();
			while(st.hasMoreTokens()) {
				sList.add(st.nextToken());
			}
			
			// 파일이 존재할 때만 전송한다
			model.addAttribute("nList", nList);
			model.addAttribute("sList", sList);
		}
		
		model.addAttribute("vo", vo);
		
		model.addAttribute("main_jsp", "../databoard/detail.jsp");
		return "main/main";
	}
	
	// "../databoard/download.do?fn=${fn }"
	@GetMapping("databoard/download.do")
	public void databoardDownload(String fn,HttpServletResponse response) {
		
		try {
			File file=new File("c:\\download\\"+fn);
			response.setHeader("Content-Disposition", "attachement;filename="
					+URLEncoder.encode(fn,"UTF-8"));
			// Download
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
			// 서버에서 파일 읽기
			BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
			
			// 사용자에게 전송
			// 읽은 byte 수 => i
			int i=0;
			byte[] buffer=new byte[1024];
			// TCP(1024), UDP(521)
			while((i=bis.read(buffer,0,1024))!=-1) {
				bos.write(buffer,0,i);
			}
			
			bis.close();
			bos.close();
			
		} catch(Exception ex) {}

	}
	
	@PostMapping("databoard/find.do")
	public String databoard_find(String fs,String ss,Model model) {
		
		// dao 연결
		Map map=new HashMap();
		map.put("fs", fs);
		map.put("ss", ss);
		List<DataBoardVO> list=dao.databoardFindData(map);
	
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		model.addAttribute("main_jsp", "../databoard/find.jsp");
		return "main/main";
	}
	
	// "../databoard/update.do?no=${vo.no }"
	@GetMapping("databoard/update.do")
	public String databoard_update(int no,Model model) {
		
		DataBoardVO vo=dao.databoardUpdateData(no);
		model.addAttribute("vo", vo);
		
		model.addAttribute("main_jsp", "../databoard/update.jsp"); 
		return "main/main";
	}
	
	@PostMapping("databoard/update_ok.do")
	@ResponseBody	// 승격 => (RestController)
	public String databoad_update(DataBoardVO vo) {
		
		String result ="";

		boolean bCheck=dao.databoardUpdate(vo);
		if(bCheck==true) {
			result="<script>"
					+ "location.href=\"../databoard/detail.do?no="+vo.getNo()+"\";"
					+ "</script>";
		} else {
			result="<script>"
					+ "alert(\"비밀번호가 틀립니다\");"
					+ "history.back();"
					+ "</script>";
		}
		
		return result;
	}
	

		// 삭제하기 @responsebody => restcontroller (메소드에서 클래스로 승격)
	  // databoard/delete.do?no=${vo.no }
	   @GetMapping("databoard/delete.do")
	   public String databoard_delete(int no,Model model)
	   {
		   model.addAttribute("no", no);
		   model.addAttribute("main_jsp", "../databoard/delete.jsp");
		   return "main/main";
	   }
	   // 실제 삭제 => @ResponseBody => @RestController
	   @PostMapping("databoard/delete_ok.do")
	   @ResponseBody
	   public String databoard_delete_ok(int no,String pwd)
	   {
		   String result="";
		   // DAO연동
		   boolean bCheck=dao.databoardDelete(no, pwd);
		   if(bCheck==true)
		   {
			   result="<script>"
					 +"location.href=\"../databoard/list.do\""
					 +"</script>";
		   }
		   else
		   {
			   result="<script>"
					 +"alert(\"비밀번호가 틀립니다!!\");"
					 +"history.back();"
					 +"</script>";
		   }
		   
		   return result;
	   }
	
	/*
	 * Manager : Open API
	 * restController : javascript로 json을 전송할 목적
	 * 					---------- 1. WEB : JavaScript (Ajax, VueJS, React)
	 * 							   2. Mobile : Kotlin
	 * Service : BI => DAO 여러 개를 통합, 다른 Service를 통합 
	 * 					=> 다른 언어와 연결을 시켜준다
	 */
	
}
