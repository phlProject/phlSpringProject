package com.phl.error;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/phl/error")
public class CmmnErrorController {
	
	Logger logger = Logger.getLogger(CmmnErrorController.class);
	
	@RequestMapping(value="/throwalbe.do")
	public ModelAndView throwalbe(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("common/error");
		
		logger.info("throwalbe");
		pageErrorLog(request);
		mv.addObject("msg", "예외가 발생하였습니다.");
		
		return mv;
	}
	
	@RequestMapping(value="/exception.do")
	public ModelAndView exception(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("common/error");
		
		logger.info("exception");
		pageErrorLog(request);
		mv.addObject("msg", "예외가 발생하였습니다.");
		
		return mv;
	}
	
	@RequestMapping(value="/400.do")
	public ModelAndView pageError400(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("common/error");
		
		logger.info("page error code 400");
		pageErrorLog(request);
		mv.addObject("msg", "잘못된 요청입니다.");
		
		return mv;
	}
	
	@RequestMapping(value="/403.do")
	public ModelAndView pageError403(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("common/error");
		
		logger.info("page error code 403");
		pageErrorLog(request);
		mv.addObject("msg", "접근이 금지되었습니다.");
		
		return mv;
	}
	
	@RequestMapping(value="/404.do")
	public ModelAndView pageError404(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("common/error");
		
		logger.info("page error code 404");
		pageErrorLog(request);
		mv.addObject("msg", "요청하신 페이지는 존재하지 않습니다.");
		
		return mv;
	}
	
	@RequestMapping(value="/405.do")
	public ModelAndView pageError405(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("common/error");
		
		logger.info("page error code 405");
		pageErrorLog(request);
		mv.addObject("msg", "요청된 메소드가 허용되지 않습니다.");
		
		return mv;
	}
	
	@RequestMapping(value="/500.do")
	public ModelAndView pageError500(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("common/error");
		
		logger.info("page error code 500");
		pageErrorLog(request);
		mv.addObject("msg", "서버에 오류가 발생하였습니다.");
		
		return mv;
	}
	
	@RequestMapping(value="/503.do")
	public ModelAndView pageError503(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("common/error");
		
		logger.info("page error code 503");
		pageErrorLog(request);
		mv.addObject("msg", "서비스를 사용할 수 없습니다.");
		
		return mv;
	}
	
	public void pageErrorLog(HttpServletRequest request){
		logger.info("status_code" + request.getAttribute("javax.servlet.error.status_code"));
		logger.info("exception_type" + request.getAttribute("javax.servlet.error.exception_type"));
		logger.info("message" + request.getAttribute("javax.servlet.error.message"));
		logger.info("request_uri" + request.getAttribute("javax.servlet.error.request_uri"));
		logger.info("exception" + request.getAttribute("javax.servlet.error.exception"));
		logger.info("servlet_name" + request.getAttribute("javax.servlet.error.servlet_name"));
	}
}
