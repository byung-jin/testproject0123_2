package com.hk.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter {
	
	//요청을 해서 컨트롤러가 실행되기전에 실행되는 메서드: preHandle()
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean isS=true;
//		String id=(String)request.getSession().getAttribute("id");
//		if(id==null) {
//			response.sendRedirect("error.jsp");
//			isS=false;
//			
//		}
		System.out.println("컨트롤러보다 먼저실행되죠??");
		return isS;
	}
	
	//컨트롤러가 실행되고 작업이 처리된후에    화면으로 이동하기전에 실행되는 메서드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("컨트롤러 작업이 끝난후에 실행되죠?");
		super.postHandle(request, response, handler, modelAndView);
	}
}






