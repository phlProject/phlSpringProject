package com.a0000007.program.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000007.program.service.ProgramService;
import com.phl.common.CommandMap;
import com.phl.common.service.PhlCommService;
import com.phl.util.CmmnUtilPaging;

@Controller(value="/a0000007/program")
public class ProgramController {

	Logger log = Logger.getLogger(this.getClass()); 
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	@Resource(name="/a0000007/programService")
	private ProgramService programService;
	
	/**
	 *  programList ( 프로그램 조회 - 첨부 게시판 조회 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/program/programList.do")
	public ModelAndView programList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{

		// 한글깨짐 방지
		request.setCharacterEncoding("utf-8"); 
				
		ModelAndView mv = new ModelAndView("/a0000007/program/programList");
		
		// 업체코드 체크
		if(commandMap.get("bsnsCode") == null)
		{
			commandMap.put("bsnsCode",  session.getAttribute("bsnsCode"));
		}
		
		// 게시판 구분 체크
		if(commandMap.get("boardGbnCd") == null)
		{
			commandMap.put("boardGbnCd", "B01001");
		}
		
		// 공통 - 기본 게시판 카운트
		int boardListCount = phlCommService.boardListCount(commandMap.getMap());
		
		// 요청 페이지 번호
		int requestPageNumber = 1;	
		
		// 요청 페이지 번호가 있을 시 해당 페이지 이동
		if(request.getParameter("requestPageNumber") != null)
		{
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
		int pagingData[] = CmmnUtilPaging.paginData(boardListCount, requestPageNumber, countPerPage);
		
		commandMap.put("limitFirst", 	pagingData[1]-1);
		commandMap.put("limitSecond",	pagingData[2]-pagingData[1]+1);
		
		// 추후 스크립트 처리 예정
		commandMap.put("atch", "image");
		
		// 공통 - 첨부 게시판 조회
		List<Map<String,Object>> boardList = phlCommService.atchBoardList(commandMap.getMap());
		
		mv.addObject("beginPageNum", 	pagingData[3]);	// 첫 페이지 번호
		mv.addObject("endPageNum", 		pagingData[4]);	// 끝 페이지 번호
		mv.addObject("totalPageCount",	pagingData[0]);	// 전체 페이지 번호
		mv.addObject("boardList", 		boardList);
		
		// 게시글 번호 보여 줄 시 추가
		mv.addObject("boardListCount",  	boardListCount);	// 전체 레코드 수
		mv.addObject("countPerPage",    	countPerPage);		// 한 페이지당 보여지는 레코드 수
		mv.addObject("requestPageNumber", 	requestPageNumber); // 현재 페이지 번호
		
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	/**
	 *  programFormI ( 프로그램 상세 - 첨부 게시판 신규 폼 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/program/programFormI.do")
	public ModelAndView programFormI(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000007/program/programForm");
		
		commandMap.put("newYn", "Y"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	/**
	 *  programFormU ( 프로그램 상세 - 첨부 게시판 수정 폼 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/program/programFormU.do")
	public ModelAndView programFormU(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000007/program/programForm");
		
		// 추후 스크립트 처리 예정
		commandMap.put("atch", "image");
		
		// 공통 - 첨부 게시판 상세 조회
		Map<String,Object> boardView = phlCommService.atchBoardView(commandMap.getMap());
		
		commandMap.put("newYn", "N"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		mv.addObject("boardView", 	boardView);
		
		return mv;
	}
	
	/**
	 *  programView ( 프로그램 상세 - 첨부 게시판 상세 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/program/programView.do")
	public ModelAndView programView(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{

		ModelAndView mv = new ModelAndView("/a0000007/program/programView");
		
		commandMap.put("moveBoardSn",request.getParameter("moveBoardSn"));	// 이전 글, 다음 글
		
		// 공통 - 게시판 조회수 증가
		phlCommService.boardHitCount(commandMap.getMap());
		
		// 추후 스크립트 처리 예정
		commandMap.put("atch", "image");
		
		// 공통 - 게시판 상세 조회
		Map<String,Object> boardView = phlCommService.atchBoardView(commandMap.getMap());
		
		mv.addObject("item", 		commandMap.getMap());
		mv.addObject("boardView", 	boardView);
		
		return mv;
	}
	
	/**
	 *  insertProgram ( 프로그램 상세 - 첨부 게시판 등록 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/program/insertProgram.do")
	public ModelAndView insertProgram(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		int boardSn = phlCommService.insertBoard(commandMap.getMap());
		commandMap.put("boardSn", boardSn);
		
		// 추후 스크립트 처리 예정
		commandMap.put("atch", "image");
		
		String resultFlYn = phlCommService.insertBoardAtch(commandMap.getMap());

		
		if(boardSn > 0)
		{
			mv.addObject("result", "success");  	
		}
		else
		{
			mv.addObject("result", "fail");
		}
	
		mv.addObject("boardSn", 	boardSn);
		mv.addObject("resultFlYn", 	resultFlYn);
		
		return mv;
	}
	
	/**
	 *  updateProgram ( 프로그램 상세 - 첨부 게시판 수정 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/program/updateProgram.do")
	public ModelAndView updateProgram(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = phlCommService.updateBoard(commandMap.getMap());
		
		String resultFlYn = "success"; // 파일 등록 성공여부
		
		// 추후 스크립트 처리 예정
		commandMap.put("atch", "image");
		
		if(commandMap.get("uploadYn").equals("Y")){
			resultFlYn = phlCommService.updateBoardAtch(commandMap.getMap());
		}
		
		mv.addObject("resultFlYn", 	resultFlYn);  
		mv.addObject("result", 		result);  	
		
		return mv;
	}
	
	/**
	 *  deleteProgram ( 프로그램 상세 - 첨부 게시판 삭제 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/program/deleteProgram.do")
	public ModelAndView deleteProgram(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		// 추후 스크립트 처리 예정
		commandMap.put("atch", "image");
		
		String result = phlCommService.deleteBoard(commandMap.getMap());
		
		mv.addObject("result", result);
		
		return mv;
	}
}
