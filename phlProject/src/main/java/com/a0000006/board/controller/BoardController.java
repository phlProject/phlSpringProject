package com.a0000006.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.a0000006.board.service.BoardService;
import com.phl.common.CommandMap;
import com.phl.util.CmmnUtilFile;

@Controller
public class BoardController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="BoardService")
	private BoardService boardService;
	
	/* 책소개 리스트 */
	@RequestMapping(value="/a0000006/board/bookList.do")
	public ModelAndView bookList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/board/bookList");
		
		commandMap.put("BSNS_CODE", session.getAttribute("BSNS_CODE"));
		commandMap.put("BOARD_GBN_CD", "B01001"); /* 책소개 */
		
		List<Map<String,Object>> bookList = boardService.selectbookList(commandMap.getMap());
		
		mv.addObject("bookList", bookList);
		
		return mv;
	}
	
	/* 책소개 등록 폼 */
	@RequestMapping(value="/a0000006/board/bookForm.do")
	public ModelAndView bookForm(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/board/bookForm");
		
		return mv;
	}
	
	/* 파일 업로드 */
	@RequestMapping(value="/a0000006/board/uploadFile.do")
	public ModelAndView fileUpload(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		List<Map<String,Object>> savedFiles = new ArrayList<Map<String,Object>>();
		
		savedFiles = CmmnUtilFile.uploadFile(request);
		System.out.println(savedFiles);
		mv.addObject("savedFiles", savedFiles.get(0));
		mv.addObject("result", "success");
		
		return mv;
		
	}
	
	/* 책소개 등록  */
	@RequestMapping(value="/a0000006/board/insertBook.do")
	public ModelAndView insertBook(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		commandMap.put("SESSION_ID", session.getAttribute("session_id"));
		commandMap.put("BSNS_CODE", session.getAttribute("BSNS_CODE"));
		commandMap.put("BOARD_GBN_CD", "B01001");
		
		String result = boardService.insertBook(commandMap.getMap());
		
		mv.addObject("result", result);  		
		
		return mv;
	}
	
	/* 책소개 상세 폼 */
	@RequestMapping(value="/a0000006/board/bookView.do")
	public ModelAndView bookView(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/board/bookView");

		commandMap.put("BSNS_CODE", session.getAttribute("BSNS_CODE"));
		commandMap.put("BOARD_GBN_CD", "B01001");
		commandMap.put("BOARD_SN", request.getParameter("board_Sn"));
		
		List<Map<String,Object>> bookView = boardService.selectbookView(commandMap.getMap());
		
		mv.addObject("bookView", bookView.get(0));
		
		return mv;
	}
}