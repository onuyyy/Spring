package com.sist.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutoInterceptor extends HandlerInterceptorAdapter {

	/*					  interceptor(preHandle)		interceptor(postHandle) 						
	 *  요청(.do) => Dispatcher 		=> 		HandlerMapping 		=>		 ViewResolver		=>		jsp
	 *  							@Controller, @RestController 찾아줌		 return값 받아서 화면 변경해준다
	 *  								=> @GetMapping, @PostMapping
	 *  
	 *  Spring
	 *  	= setting : AOP / DI => 클래스 등록
	 *  	= ORM(Mybatis)	=> JPA
	 *  		1) XML
	 *  		2) Annotation
	 *  		3) XML+Annotation
	 *  	= Transaction
	 *  	= WeblSocket
	 *  	= Task
	 *  	= MVC
	 */
	
	
	/*
	 * interceptor는 context에서 bean 태그로 메모리 할당 완료
	 * ----------- 자동 호출
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle");
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterHandle");
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	
	
}
