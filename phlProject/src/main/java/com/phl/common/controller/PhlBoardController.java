package com.phl.common.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phl.common.CommandMap;
import com.phl.common.service.PhlBoardService;

@Controller
public class PhlBoardController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="phlBoardService")
	private PhlBoardService phlBoardService;
	
	/* 게시판 이전 다음 페이지 번호 */
	@RequestMapping(value="/phl/board/pageMove.do")
	public ModelAndView pageMove(CommandMap commandMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = "N";
		
		commandMap.put("move", request.getParameter("move"));
		String boardSn = phlBoardService.moveBoardPage(commandMap.getMap());
		
		if(boardSn != null &&!boardSn.isEmpty()){
			result = boardSn;
		}
		mv.addObject("result", result);  	
		
		return mv;
	}
}
