package com.a0000006.network.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000006.network.service.NetworkService;
import com.phl.common.CommandMap;
import com.phl.common.service.PhlBoardService;
import com.phl.common.service.PhlCommService;
import com.phl.util.CmmnUtilPaging;

@Controller
public class NetworkController {

	Logger log = Logger.getLogger(this.getClass());
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	@Resource(name="phlBoardService")
	private PhlBoardService phlBoardService;
	
	@Resource(name="networkService")
	private NetworkService networkService;
	
	
	/* 헝겊 원숭이 연대 */
	@RequestMapping(value="/a0000006/network/patchMonkeyIntro.do")
	public ModelAndView patchMonkeyIntro(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/network/patchMonkeyIntro");
        
        return mv;
    }  
	
	/* 지역교육 네트워크 */
	@RequestMapping(value="/a0000006/network/areaEduIntro.do")
	public ModelAndView areaEduIntro(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/network/areaEduIntro");
        
        return mv;
    }  
	
	/* 청년 네트워크 */
	@RequestMapping(value="/a0000006/network/youthEduIntro.do")
	public ModelAndView youthEduIntro(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/network/youthEduIntro");
        
        return mv;
    }  
	
	/* 청소년 네트워크 */
	@RequestMapping(value="/a0000006/network/juvenileEduIntro.do")
	public ModelAndView juvenileEduIntro(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/network/juvenileEduIntro");
        
        return mv;
    }
	
	
	
	
	
	
	/* 네트워크 게시판 > 조회 */
	@RequestMapping(value="/a0000006/network/networkBoardList.do")
	public ModelAndView networkBoardList(CommandMap commandMap, HttpServletRequest request, HttpSession session) throws Exception{

		// 한글깨짐 방지
		request.setCharacterEncoding("utf-8"); 
		
		ModelAndView mv = new ModelAndView("/a0000006/network/networkBoardList");
		
		/* 업체코드 - A0000006 (꿈두레) */
		if(commandMap.get("bsnsCode") == null){
			commandMap.put("bsnsCode", session.getAttribute("bsnsCode"));
		}

		// 게시판 명 ( 네트워크활동 )
		commandMap.put("cmmnCode", commandMap.get("boardGbnCd"));
		commandMap.put("boardGbnCdNm", phlCommService.selectCommCodeOne(commandMap.getMap()));
		
		// 자유게시판 > 조회 > 카운트
		int totalListCount = networkService.networkBoardListCnt(commandMap.getMap());
		
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
		List<Map<String,Object>> networkBoardList = networkService.networkBoardList(commandMap.getMap());
		
		mv.addObject("beginPageNum", 	pagingData[3]);			// 첫 페이지 번호
		mv.addObject("endPageNum", 		pagingData[4]);			// 끝 페이지 번호
		mv.addObject("totalPageCount",	pagingData[0]);			// 전체 페이지 번호
		mv.addObject("networkBoardList", 	networkBoardList);	// 자유게시판 리스트
		
		// 게시글 번호 보여 줄 시 추가
		mv.addObject("totalListCount",  	totalListCount);	// 전체 레코드 수
		mv.addObject("countPerPage",    	countPerPage);		// 한 페이지당 보여지는 레코드 수
		mv.addObject("requestPageNumber", 	requestPageNumber); // 현재 페이지 번호
		
		mv.addObject("item", commandMap.getMap());
		
		
        return mv;
    } 
	
	
	/* 네트워크 게시판 > 상세 폼 */
	@RequestMapping(value="/a0000006/network/networkBoardView.do")
	public ModelAndView networkBoardView(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		// 2018.02.17 : 이전글, 다음글 로 인해 추가
		commandMap.put("moveBoardSn",request.getParameter("moveBoardSn"));
		
		ModelAndView mv = new ModelAndView("/a0000006/network/networkBoardView");
		
		// 공통 > 게시판 조회수 증가
		phlBoardService.boardHitCount(commandMap.getMap());
		
		// 책소개 > 상세
		List<Map<String,Object>> networkBoardView = networkService.networkBoardView(commandMap.getMap());
		
		mv.addObject("item", commandMap.getMap());
		mv.addObject("networkBoardView", networkBoardView.get(0));
		
		return mv;
	}
	
	/* 네트워크 게시판 > 신규등록 폼 */
	@RequestMapping(value="/a0000006/network/networkBoardFormI.do")
	public ModelAndView networkBoardForm(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/network/networkBoardForm");
		
		commandMap.put("newYn", "Y"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	/* 네트워크 게시판 > 등록 */
	@RequestMapping(value="/a0000006/network/insertNetworkBoard.do")
	public ModelAndView insertNetworkBoard(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		int boardSn = networkService.insertNetworkBoard(commandMap.getMap());
		commandMap.put("boardSn", boardSn);
		

		if(boardSn > 0){
			mv.addObject("result", "success");  	
		}else{
			mv.addObject("result", "fail");
		}
	
		mv.addObject("boardSn", boardSn);
		
		return mv;
	}
	
	/* 네트워크 게시판 > 수정 폼 */
	@RequestMapping(value="/a0000006/network/networkBoardFormU.do")
	public ModelAndView networkBoardFormU(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/network/networkBoardForm");
		
		List<Map<String,Object>> networkBoardView = networkService.networkBoardView(commandMap.getMap());
		
		commandMap.put("newYn", "N"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		mv.addObject("networkBoardView", networkBoardView.get(0));
		
		return mv;
	}
	
	/* 네트워크 게시판 > 수정 */
	@RequestMapping(value="/a0000006/network/updateNetworkBoard.do")
	public ModelAndView updateNetworkBoard(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = networkService.updateNetworkBoard(commandMap.getMap());
		
		mv.addObject("result", result);  	
		
		return mv;
	}
	
	/* 네트워크 게시판 > 삭제 */
	@RequestMapping(value="/a0000006/network/deleteNetworkBoard.do")
	public ModelAndView deleteNetworkBoard(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = networkService.deleteNetworkBoard(commandMap.getMap());
		
		mv.addObject("result", result);  	
		
		return mv;
	}
}
