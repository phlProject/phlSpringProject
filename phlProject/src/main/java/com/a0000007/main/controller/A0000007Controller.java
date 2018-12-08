package com.a0000007.main.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phl.common.CommandMap;
import com.phl.common.service.PhlCommService;

@Controller
public class A0000007Controller {

	Logger log = Logger.getLogger(this.getClass());
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	/* 두레꿈학교 - 메인화면 */
	@RequestMapping(value="/a0000007/mainIndex.do")
	public ModelAndView mainIndex(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000007/mainIndex");
		
		// 두레꿈학교 - A0000007
        session.setAttribute("bsnsCode", "A0000007");
        
		return mv;
    }     
}
