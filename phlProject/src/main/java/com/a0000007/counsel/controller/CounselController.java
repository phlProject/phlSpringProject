package com.a0000007.counsel.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000007.counsel.service.CounselService;
import com.phl.common.CommandMap;
import com.phl.common.service.PhlCommService;
import com.phl.util.CmmnUtilPaging;

@Controller(value="/a0000007/counsel")
public class CounselController {

	Logger log = Logger.getLogger(this.getClass()); 
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	@Resource(name="/a0000007/counselService")
	private CounselService counselService;
	
	
	/**
	 *  counselList ( 상담신청 조회 - 비회원 게시판 조회 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/counsel/counselList.do")
	public ModelAndView counselList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{

		// 한글깨짐 방지
		request.setCharacterEncoding("utf-8"); 
				
		ModelAndView mv = new ModelAndView("/a0000007/counsel/counselList");
		
		// 업체코드 체크
		if(commandMap.get("bsnsCode") == null)
		{
			commandMap.put("bsnsCode",  session.getAttribute("bsnsCode"));
		}
		
		// 게시판 구분 체크 ( 상담신청 )
		if(commandMap.get("boardGbnCd") == null)
		{
			commandMap.put("boardGbnCd", "B01002");
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
		int countPerPage = 10;
		
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
		
		// 공통 - 기본 게시판 조회
		List<Map<String,Object>> boardList = phlCommService.boardNonMemList(commandMap.getMap());
		
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
	 *  counselFormI ( 상담신청 상세 - 비회원 게시판 신규 폼 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/counsel/counselFormI.do")
	public ModelAndView counselFormI(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000007/counsel/counselForm");
		
		commandMap.put("newYn", "Y"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	/**
	 *  counselFormU ( 상담신청 상세 - 비회원 게시판 수정 폼 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/counsel/counselFormU.do")
	public ModelAndView counselFormU(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000007/counsel/counselForm");
		
		// 공통 - 게시판 상세 조회
		List<Map<String, Object>> boardView = phlCommService.boardNonMemView(commandMap.getMap());
		
		commandMap.put("newYn", "N"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		mv.addObject("boardView", 	boardView.get(0));
		
		return mv;
	}
	
	/**
	 *  counselPwdCheck ( 상담신청 상세 - 비회원 게시판 비밀번호 확인 폼 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/counsel/counselPwdCheck.do")
	public ModelAndView counselPwdCheck(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000007/counsel/counselPwdCheck");
		
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	/**
	 *  counselPwdCheckAction ( 상담신청 상세 - 비회원 게시판 비밀번호 확인  ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/counsel/counselPwdCheckAction.do")
	public ModelAndView counselPwdCheckAction(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("item", commandMap.getMap());
		String resultValue = "";
		
		List<Map<String,Object>> boardPwdCheck = phlCommService.boardPwdCheck(commandMap.getMap());
		
		/* 해당하는 정보 존재시 */
        if(boardPwdCheck.size() != 0){
        	resultValue = "PW_OK";
        }else{
        	/* 비밀번호 오류 */
        	resultValue = "PW_ERROR";
        	
        }	
        mv.setViewName("/a0000007/counsel/counselPwdCheck");
        mv.addObject("resultValue",resultValue);  
		
		return mv;
	}
	
	
	/**
	 *  counselView ( 상담신청 상세 - 비회원 게시판 상세 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/counsel/counselView.do")
	public ModelAndView counselView(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{

		ModelAndView mv = new ModelAndView("/a0000007/counsel/counselView");
		
		// 공통 - 게시판 조회수 증가
		phlCommService.boardHitCount(commandMap.getMap());
		
		// 공통 - 게시판 상세 조회
		List<Map<String,Object>> boardView = phlCommService.boardNonMemView(commandMap.getMap());
		
		// 공통 - 게시판 댓글 조회
		List<Map<String,Object>> boardReplyList = phlCommService.boardReplyList(commandMap.getMap());
		
		mv.addObject("item", 			commandMap.getMap());
		mv.addObject("boardView", 		boardView.get(0));
		mv.addObject("boardReplyList", 	boardReplyList);
		
		return mv;
	}
	
	/**
	 *  insertCounsel ( 상담신청 상세 - 비회원 게시판 등록 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/counsel/insertCounsel.do")
	public ModelAndView insertCounsel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		int boardSn = phlCommService.insertBoardNonMem(commandMap.getMap());
		commandMap.put("boardSn", boardSn);

		phlCommService.insertBoardNonMemDetail(commandMap.getMap());

		if(boardSn > 0)
		{
			mv.addObject("result", "success");  	
		}
		else
		{
			mv.addObject("result", "fail");
		}
	
		mv.addObject("boardSn", boardSn);
		
		return mv;
	}
	
	/**
	 *  updateCounsel ( 상담신청 상세 - 비회원 게시판 수정 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/counsel/updateCounsel.do")
	public ModelAndView updateCounsel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = phlCommService.updateBoard(commandMap.getMap());
		
		mv.addObject("result", result);
		
		return mv;
	}
	
	/**
	 *  deleteCounsel ( 상담신청 상세 - 비회원 게시판 삭제 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/counsel/deleteCounsel.do")
	public ModelAndView deleteCounsel(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");

		String result = phlCommService.deleteBoard(commandMap.getMap());
		
		mv.addObject("result", result);
		
		return mv;
	}
	
	/**
	 *  saveCounselReply ( 상담신청 상세 - 비회원 게시판 댓글 등록/수정/삭제 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/counsel/saveCounselReply.do")
	public ModelAndView saveCounselReply(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		commandMap.put("sessionId",session.getAttribute("sessionId"));
		
		try{
			String result = phlCommService.saveBoardReply(commandMap.getMap());
			mv.addObject("result", result);  	
		}catch(Exception e){
		}
		return mv;
	}
}
