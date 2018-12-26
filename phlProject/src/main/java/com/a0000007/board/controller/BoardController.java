package com.a0000007.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phl.common.CommandMap;
import com.phl.common.service.PhlCommService;

@Controller(value="/A0000007")
public class BoardController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	/* 공통 */ 
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	@RequestMapping(value="/board/programList.do")
	public ModelAndView programList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception
	{
		// 한글깨짐 방지
		request.setCharacterEncoding("utf-8"); 
				
		ModelAndView mv = new ModelAndView("/a0000007/board/programList");
		
		/* 업체코드 - A0000007 (두레꿈) */
		if(commandMap.get("bsnsCode") == null){
			commandMap.put("bsnsCode", session.getAttribute("bsnsCode"));
		}
				
		return mv;
	}
}
