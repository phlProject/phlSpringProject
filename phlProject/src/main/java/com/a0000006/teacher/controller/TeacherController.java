package com.a0000006.teacher.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000006.teacher.service.TeacherService;
import com.phl.common.CommandMap;
import com.phl.common.service.PhlCommService;
import com.phl.util.CmmnUtilPaging;

@Controller
public class TeacherController {

	Logger log = Logger.getLogger(this.getClass());

	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	@Resource(name="teacherService")
	private TeacherService teacherService;

	
	/* 아하 과정 */
	@RequestMapping(value="/a0000006/teacher/ahaProcess.do")
	public ModelAndView ahaProcess(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/teacher/ahaProcess");
        
        return mv;
    }
	
	/* 배움과 결 */
	@RequestMapping(value="/a0000006/teacher/learnAndGrain.do")
	public ModelAndView learnAndGrain(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/teacher/learnAndGrain");
        
        return mv;
    } 
	
	/* 생명의 시쓰기 */
	@RequestMapping(value="/a0000006/teacher/lifeOfPoem.do")
	public ModelAndView lifeOfPoem(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/teacher/lifeOfPoem");
        
        return mv;
    } 
	
	
	
	/* 참여게시판 > 조회 */
	@RequestMapping(value="/a0000006/teacher/joinList.do")
	public ModelAndView joinList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		// 한글깨짐 방지
		request.setCharacterEncoding("utf-8"); 
		
		ModelAndView mv = new ModelAndView("/a0000006/teacher/joinList");
		
		// 공통코드 - T01 : 교사학교과정
	    commandMap.put("cl_code", "T01");
	    
	    // 공통코드(교사학교과정)
	    List<CommandMap> teacherGbnList = phlCommService.selectCommCode(commandMap.getMap());
		
		/* 업체코드 - A0000006 (꿈두레) */
		if(commandMap.get("bsnsCode") == null){
			commandMap.put("bsnsCode", session.getAttribute("bsnsCode"));
		}
		
		/* 게시판 구분 - T01 (교사학교과정) */
		if(commandMap.get("boardClGbnCd") == null){
			commandMap.put("boardClGbnCd", "T01");
		}
		
		// 참여게시판 > 조회 > 카운트
		int totalListCount = teacherService.joinListCnt(commandMap.getMap());
		
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
		
		// 참여게시판 > 조회
		List<Map<String,Object>> joinList = teacherService.joinList(commandMap.getMap());
		
		mv.addObject("beginPageNum", 	pagingData[3]);	// 첫 페이지 번호
		mv.addObject("endPageNum", 		pagingData[4]);	// 끝 페이지 번호
		mv.addObject("totalPageCount",	pagingData[0]);	// 전체 페이지 번호
		mv.addObject("joinList", 		joinList);		// 책소개 리스트
		mv.addObject("teacherGbnList",  teacherGbnList);// 공통코드(교사학교카테고리)
		
		// 게시글 번호 보여 줄 시 추가
		mv.addObject("totalListCount",  	totalListCount);	// 전체 레코드 수
		mv.addObject("countPerPage",    	countPerPage);		// 한 페이지당 보여지는 레코드 수
		mv.addObject("requestPageNumber", 	requestPageNumber); // 현재 페이지 번호
		
		mv.addObject("item", commandMap.getMap());
		
		System.out.println(commandMap.getMap());
		
		return mv;
	}
	
	/* 참여게시판 > 상세 폼 */
	@RequestMapping(value="/a0000006/teacher/joinView.do")
	public ModelAndView joinView(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/teacher/joinView");
		
		// 공통 > 게시판 조회수 증가
		phlCommService.boardHitCount(commandMap.getMap());
		
		
		// 참여게시판 > 상세
		List<Map<String,Object>> joinView = teacherService.joinView(commandMap.getMap());
		
		// 참여게시판 > 댓글 상세
		List<Map<String,Object>> joinReList = teacherService.joinReList(commandMap.getMap());
		
		mv.addObject("item", commandMap.getMap());
		mv.addObject("joinView", joinView.get(0));
		mv.addObject("joinReList", joinReList);
		
		return mv;
	}
	
	/* 참여게시판 > 신규등록 폼 */
	@RequestMapping(value="/a0000006/teacher/joinFormI.do")
	public ModelAndView joinForm(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/teacher/joinForm");

		// 공통코드 - T01 : 교사학교과정
	    commandMap.put("cl_code", "T01");
	    
	    // 공통코드(교사학교과정)
	    List<CommandMap> teacherGbnList = phlCommService.selectCommCode(commandMap.getMap());
	    
		commandMap.put("newYn", "Y"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		
		mv.addObject("item", commandMap.getMap());
		mv.addObject("teacherGbnList", teacherGbnList);
		
		return mv;
	}
	
	
	/* 참여게시판 > 등록  */
	@RequestMapping(value="/a0000006/teacher/insertJoin.do")
	public ModelAndView insertJoin(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		int boardSn = teacherService.insertJoin(commandMap.getMap());
		
		if(boardSn > 0){
			mv.addObject("result", "success");  	
		}else{
			mv.addObject("result", "fail");
		}
		
		mv.addObject("boardSn", boardSn);
		
		return mv;
	}
	
	/* 참여게시판 > 수정 폼 */
	@RequestMapping(value="/a0000006/teacher/joinFormU.do")
	public ModelAndView joinFormU(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/teacher/joinForm");
		
		// 공통코드 - T01 : 교사학교과정
	    commandMap.put("cl_code", "T01");
	    
	    // 공통코드(교사학교과정)
	    List<CommandMap> teacherGbnList = phlCommService.selectCommCode(commandMap.getMap());
		
		List<Map<String,Object>> joinView = teacherService.joinView(commandMap.getMap());
		
		commandMap.put("newYn", "N"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		mv.addObject("joinView", joinView.get(0));
		mv.addObject("teacherGbnList", teacherGbnList);
		
		return mv;
	}
	
	/* 참여게시판 > 수정  */
	@RequestMapping(value="/a0000006/teacher/updateJoin.do")
	public ModelAndView updateJoin(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = teacherService.updateJoin(commandMap.getMap());
		
		mv.addObject("result", result);  	
		
		return mv;
	}
	
	/* 참여게시판 > 삭제  */
	@RequestMapping(value="/a0000006/teacher/deleteJoin.do")
	public ModelAndView deleteJoin(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = teacherService.deleteJoin(commandMap.getMap());
		
		mv.addObject("result", result);  	
		
		return mv;
	}
	
	/* 참여게시판 > 댓글 등록/수정/삭제 */
	@RequestMapping(value="/a0000006/teacher/saveJoinRe.do")
	public ModelAndView saveJoinRe(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		commandMap.put("sessionId",session.getAttribute("sessionId"));
		
		try{
			String result = teacherService.saveJoinRe(commandMap.getMap());
			mv.addObject("result", result);  	
		}catch(Exception e){
		}
		return mv;
	}
}
