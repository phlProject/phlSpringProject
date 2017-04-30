package com.a0000006.board.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000006.board.service.BoardService;
import com.phl.common.CommandMap;

@Controller
public class BoardController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="BoardService")
	private BoardService boardService;
	
	/* 책소개 리스트 */
	@RequestMapping(value="/a0000006/board/bookList.do")
	public ModelAndView applyList(CommandMap commandMap) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/board/bookList");
		
		return mv;
	}
}
