package com.a0000007.board.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.a0000007.board.service.BoardService;
import com.phl.common.service.PhlCommService;

@Controller
public class BoardController {

	Logger log = Logger.getLogger(this.getClass()); 
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	@Resource(name="BoardService")
	private BoardService boardService;
	
}
