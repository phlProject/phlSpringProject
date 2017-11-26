package com.a0000006.open.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000006.open.service.OpenService;
import com.phl.common.CommandMap;
import com.phl.common.service.PhlCommService;
import com.phl.util.CmmnUtilPaging;

@Controller
public class OpenController {

	Logger log = Logger.getLogger(this.getClass());
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	@Resource(name="openService")
	private OpenService openService;
	
	/*********************************************************************/
	/****************************** 일   정  시작  ******************************/
	
	// 일정 - 리스트
	@RequestMapping(value="/a0000006/open/scheduleList.do")
	public ModelAndView scheduleList(CommandMap commandMap) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/open/scheduleList");
		
		//현재 년도, 월, 일
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int toYear 	= cal.get( cal.YEAR );
		int toMonth = cal.get( cal.MONTH ) + 1;
		int toDay 	= cal.get( cal.DATE );
		mv.addObject("toYear", toYear);
		mv.addObject("toMonth", toMonth);
		mv.addObject("toDay", toDay);
		
		Map<String, Object> map = commandMap.getMap();
		map.put("toYear", toYear);
		map.put("toMonth", toMonth);
		map.put("toDay", toDay);

		// 스케줄 목록
		List<CommandMap> scheduleList = openService.scheduleList(map);
		mv.addObject("scheduleList", scheduleList);
		
		return mv;
		
	}
	
	
	// 일정 - 리스트 ( Ajax )
	@RequestMapping(value="/a0000006/open/ajaxScheduleList.do")
	public ModelAndView scheduleList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		

		//현재 년도, 월, 일
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int toYear 	= cal.get( cal.YEAR );
		int toMonth = cal.get( cal.MONTH ) + 1;
		int toDay 	= cal.get( cal.DATE );
		mv.addObject("toYear", toYear);
		mv.addObject("toMonth", toMonth);
		mv.addObject("toDay", toDay);
		
		
		Map<String, Object> map = commandMap.getMap();
		/*map.put("toYear", toYear);
		map.put("toMonth", toMonth);
		map.put("toDay", toDay);*/
		
		// 스케줄 목록
		List<CommandMap> scheduleList = openService.scheduleList(map);
		mv.addObject("scheduleList", scheduleList);
		
		return mv;
		
	}
	
	// 일정 - 등록
	@RequestMapping(value="/a0000006/open/insertSchedule.do")
	public ModelAndView insertSchedule(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		map.put("sessionId", session.getAttribute("sessionId"));
		map.put("bsnsCode", session.getAttribute("bsnsCode"));
		
		// 신청 등록
		String result = openService.insertSchedule(map);
		mv.addObject("result", result);
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("bsnsCode", session.getAttribute("bsnsCode"));
		
		return mv;
		
	} 

	// 일정 - 상세
	@RequestMapping(value="/a0000006/open/viewSchedule.do")
	public ModelAndView viewSchedule(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		// 상세 페이지
		Map<String, Object> result = openService.viewSchedule(map);
		mv.addObject("result", result);
		
		return mv;
		
	}
	
	// 일정 - 수정
	@RequestMapping(value="/a0000006/open/updateSchedule.do")
	public ModelAndView updateSchedule(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		// 상세 페이지
		String result = openService.updateSchedule(map);
		mv.addObject("result", result);
		
		return mv;
		
	}
	
	// 일정 - 삭제
	@RequestMapping(value="/a0000006/open/deleteSchedule.do")
	public ModelAndView deleteSchedule(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		// 상세 페이지
		String result = openService.deleteSchedule(map);
		mv.addObject("result", result);
		
		return mv;
		
	}
	
	/****************************** 일   정  종료  ******************************/
	/*********************************************************************/
	
	
	/*********************************************************************/
	/***************************** 자유게시판  시작  *****************************/
	
	/* 자유게시판 > 조회 */
	@RequestMapping(value="/a0000006/open/freeBoardList.do")
	public ModelAndView freeBoardList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		// 한글깨짐 방지
		request.setCharacterEncoding("utf-8"); 
		
		ModelAndView mv = new ModelAndView("/a0000006/open/freeBoardList");
		
		/* 업체코드 - A0000006 (꿈두레) */
		if(commandMap.get("bsnsCode") == null){
			commandMap.put("bsnsCode", session.getAttribute("bsnsCode"));
		}
		
		/* 게시판 구분 - B01005 (자유게시판) */
		if(commandMap.get("boardGbnCd") == null){
			commandMap.put("boardGbnCd", "B01005");
			commandMap.put("boardGbnCdNm", "자유게시판");
		}
		
		// 자유게시판 > 조회 > 카운트
		int totalListCount = openService.freeBoardListCnt(commandMap.getMap());
		
		// 요청 페이지 번호
		int requestPageNumber = 1;	
		
		// 요청 페이지 번호가 있을 시 해당 페이지 이동
		if(request.getParameter("requestPageNumber") != null){
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
		int pagingData[] = CmmnUtilPaging.paginData(totalListCount, requestPageNumber, countPerPage);
		
		commandMap.put("limitFirst", 	pagingData[1]-1);
		commandMap.put("limitSecond",	pagingData[2]-pagingData[1]+1);
		
		// 책소개 > 조회
		List<Map<String,Object>> freeBoardList = openService.freeBoardList(commandMap.getMap());
		
		mv.addObject("beginPageNum", 	pagingData[3]);	// 첫 페이지 번호
		mv.addObject("endPageNum", 		pagingData[4]);	// 끝 페이지 번호
		mv.addObject("totalPageCount",	pagingData[0]);	// 전체 페이지 번호
		mv.addObject("freeBoardList", 	freeBoardList);	// 자유게시판 리스트
		
		// 게시글 번호 보여 줄 시 추가
		mv.addObject("totalListCount",  	totalListCount);	// 전체 레코드 수
		mv.addObject("countPerPage",    	countPerPage);		// 한 페이지당 보여지는 레코드 수
		mv.addObject("requestPageNumber", 	requestPageNumber); // 현재 페이지 번호
		
		mv.addObject("item", commandMap.getMap());
		
		return mv; 
	}
	
	/* 자유게시판 > 상세 폼 */
	@RequestMapping(value="/a0000006/open/freeBoardView.do")
	public ModelAndView freeBoardView(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/open/freeBoardView");
		
		// 공통 > 게시판 조회수 증가
		phlCommService.boardHitCount(commandMap.getMap());
		
		// 책소개 > 상세
		List<Map<String,Object>> freeBoardView = openService.freeBoardView(commandMap.getMap());
		
		mv.addObject("item", commandMap.getMap());
		mv.addObject("freeBoardView", freeBoardView.get(0));
		
		return mv;
	}
	
	/* 자유게시판 > 신규등록 폼 */
	@RequestMapping(value="/a0000006/open/freeBoardFormI.do")
	public ModelAndView freeBoardForm(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/open/freeBoardForm");
		
		commandMap.put("newYn", "Y"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	/* 자유게시판 > 등록 */
	@RequestMapping(value="/a0000006/open/insertFreeBoard.do")
	public ModelAndView insertFreeBoard(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		int boardSn = openService.insertFreeBoard(commandMap.getMap());
		commandMap.put("boardSn", boardSn);
		

		if(boardSn > 0){
			mv.addObject("result", "success");  	
		}else{
			mv.addObject("result", "fail");
		}
	
		mv.addObject("boardSn", boardSn);
		
		return mv;
	}
	
	/* 자유게시판 > 수정 폼 */
	@RequestMapping(value="/a0000006/open/freeBoardFormU.do")
	public ModelAndView freeBoardFormU(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/open/freeBoardForm");
		
		List<Map<String,Object>> freeBoardView = openService.freeBoardView(commandMap.getMap());
		
		commandMap.put("newYn", "N"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		mv.addObject("freeBoardView", freeBoardView.get(0));
		
		return mv;
	}
	
	/* 자유게시판 > 수정 */
	@RequestMapping(value="/a0000006/open/updateFreeBoard.do")
	public ModelAndView updateFreeBoard(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = openService.updateFreeBoard(commandMap.getMap());
		
		mv.addObject("result", result);  	
		
		return mv;
	}
	
	/* 자유게시판 > 삭제 */
	@RequestMapping(value="/a0000006/open/deleteFreeBoard.do")
	public ModelAndView deleteFreeBoard(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = openService.deleteFreeBoard(commandMap.getMap());
		
		mv.addObject("result", result);  	
		
		return mv;
	}
	
	/***************************** 자유게시판  종료  *****************************/
	/*********************************************************************/
	
	
}
