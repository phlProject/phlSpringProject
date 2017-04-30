package com.a0000006.board.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phl.common.CommandMap;

@Controller
public class boardController {

	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/a0000006/board/boardList.do")
	public ModelAndView applyList(CommandMap commandMap) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/board/boardList");
		
		return mv;
		
	}
}
