package com.a0000006.board.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000006.board.service.BoardService;
import com.phl.common.CommandMap;
import com.phl.util.CmmnUtilPaging;

@Controller
public class BoardController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="BoardService")
	private BoardService boardService;
	
	/* 책소개 리스트 */
	@RequestMapping(value="/a0000006/board/bookList.do")
	public ModelAndView bookList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		request.setCharacterEncoding("utf-8"); // 한글깨짐 방지
		
		ModelAndView mv = new ModelAndView("/a0000006/board/bookList");
		
		commandMap.put("BSNS_CODE", session.getAttribute("BSNS_CODE"));
		commandMap.put("BOARD_GBN_CD", "B01001");
		
		// 책소개 리스트 Count
		int totalListCount = boardService.selectbookListCnt(commandMap.getMap());		
		
		// 요청 페이지 번호
		int requestPageNumber = 1;	
		if(request.getParameter("requestPageNumber") != null){
			requestPageNumber = Integer.parseInt(request.getParameter("requestPageNumber"));
		}

		// 페이지당 리스트 갯수
		 int countPerPage = 5;
		
		/* 
		 ** 페이징 계산 ** 
		 * 
		 * 파라미터 : 전체리스트 Count, 요청페이지번호, 페이지당리스트갯수
		 * pagingData[0] = 전체 페이지수
		 * pagingData[1] = FirstRow ( Limit 사용 용도 )
		 * pagingData[2] = EndRow	( Limit 사용 용도 )
		 * pagingData[3] = 첫 페이지 번호
		 * pagingData[4] = 끝 페이지 번호
		 * 
		 */
		int pagingData[] = CmmnUtilPaging.paginData(totalListCount, requestPageNumber, countPerPage);
		
		commandMap.put("limitFirst", 	pagingData[1]-1);
		commandMap.put("limitSecond",	pagingData[2]-pagingData[1]+1);
		
		// 책소개 리스트 
		List<Map<String,Object>> bookList = boardService.selectbookList(commandMap.getMap());
		
		mv.addObject("beginPageNum", 	pagingData[3]);	// 첫 페이지 번호
		mv.addObject("endPageNum", 		pagingData[4]);	// 끝 페이지 번호
		mv.addObject("totalPageCount",	pagingData[0]);	// 전체 페이지 번호
		mv.addObject("bookList", 		bookList);		// 책소개 리스트
		
		mv.addObject("searchSelect", 	commandMap.get("searchSelect"));	// 파라미터 검색조건
		mv.addObject("searchWord", 		commandMap.get("searchWord"));		// 파라미터 검색단어
		
		return mv;
	}
	
	/* 책소개 등록 폼 */
	@RequestMapping(value="/a0000006/board/bookForm.do")
	public ModelAndView bookForm(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/board/bookForm");
		
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
		
		if(commandMap.get("origin_fl_nm") != ""){
			boardService.insertBookFl(commandMap.getMap());
		}
		
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
	
	@RequestMapping(value="/a0000006/board/bookFormU.do")
	public ModelAndView bookFormU(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/board/bookForm");

		commandMap.put("BSNS_CODE", session.getAttribute("BSNS_CODE"));
		commandMap.put("BOARD_GBN_CD", "B01001");
		commandMap.put("BOARD_SN", request.getParameter("board_Sn"));
		
		List<Map<String,Object>> bookView = boardService.selectbookView(commandMap.getMap());
		
		mv.addObject("bookView", bookView.get(0));
		
		return mv;
	}
	
}