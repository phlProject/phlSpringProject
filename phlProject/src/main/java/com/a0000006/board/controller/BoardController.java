package com.a0000006.board.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000006.board.service.BoardService;
import com.phl.common.CommandMap;
import com.phl.util.CmmnUtilFile;
import com.phl.util.CmmnUtilPaging;

@Controller
public class BoardController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="BoardService")
	private BoardService boardService;
	
	/****************************** 책 소 개 시작  ******************************/
	
	/* 책소개  > 조회 */
	@RequestMapping(value="/a0000006/board/bookList.do")
	public ModelAndView bookList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		// 한글깨짐 방지
		request.setCharacterEncoding("utf-8"); 
		
		ModelAndView mv = new ModelAndView("/a0000006/board/bookList");
		
		if(request.getParameter("bsns_code") == null){
			commandMap.put("bsns_code", session.getAttribute("bsns_code"));
		}
		/* 게시판 구분 - B01001 (책소개) */
		commandMap.put("board_gbn_cd", "B01001");
		
		// 책소개 > 조회 > 카운트
		int totalListCount = boardService.bookListCnt(commandMap.getMap());		
		
		// 요청 페이지 번호
		int requestPageNumber = 1;	
		
		// 요청 페이지 번호가 있을 시 해당 페이지 이동
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
		
		// 책소개 > 조회
		List<Map<String,Object>> bookList = boardService.bookList(commandMap.getMap());
		
		mv.addObject("beginPageNum", 	pagingData[3]);	// 첫 페이지 번호
		mv.addObject("endPageNum", 		pagingData[4]);	// 끝 페이지 번호
		mv.addObject("totalPageCount",	pagingData[0]);	// 전체 페이지 번호
		mv.addObject("bookList", 		bookList);		// 책소개 리스트
		
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	/* 책소개 > 상세 */
	@RequestMapping(value="/a0000006/board/bookView.do")
	public ModelAndView bookView(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/board/bookView");
		
		// 책소개 > 상세
		List<Map<String,Object>> bookView = boardService.bookView(commandMap.getMap());
		
		mv.addObject("item", commandMap.getMap());
		mv.addObject("bookView", bookView.get(0));
		
		return mv;
	}
	
	/* 책소개 > 등록 폼 이동 */
	@RequestMapping(value="/a0000006/board/bookForm.do")
	public ModelAndView bookForm(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/board/bookForm");
		
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	
	/* 책소개 > 등록  */
	@RequestMapping(value="/a0000006/board/insertBook.do")
	public ModelAndView insertBook(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		int board_Sn = boardService.insertBook(commandMap.getMap());
		
		String result_Fl_Yn = "success"; // 파일 등록 성공여부
		
		if(commandMap.get("uploadYn").equals("Y")){
			commandMap.put("board_Sn", board_Sn);
			// 게시판 > 파일 등록
			result_Fl_Yn = boardService.insertBoardFl(commandMap.getMap());
		}

		if(board_Sn > 0){
			mv.addObject("result", "success");  	
		}else{
			mv.addObject("result", "fail");
		}
		
		mv.addObject("result_Fl_Yn", result_Fl_Yn);  		
		mv.addObject("board_Sn", board_Sn);  		
		
		return mv;
	}
	
	/* 책소개 > 수정 폼 이동 */
	@RequestMapping(value="/a0000006/board/bookFormU.do")
	public ModelAndView bookFormU(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/board/bookFormU");
		
		List<Map<String,Object>> bookView = boardService.bookView(commandMap.getMap());
		
		mv.addObject("item", commandMap.getMap());
		mv.addObject("bookView", bookView.get(0));
		
		return mv;
	}
	
	/* 책소개 > 수정  */
	@RequestMapping(value="/a0000006/board/updateBook.do")
	public ModelAndView updateBook(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = boardService.updateBook(commandMap.getMap());
		
		String result_Fl_Yn = "success"; // 파일 등록 성공여부
		
		if(commandMap.get("uploadYn").equals("Y")){
			// 게시판 > 파일 등록
			result_Fl_Yn = boardService.updateBoardFl(commandMap.getMap());
		}
		
		mv.addObject("result_Fl_Yn", result_Fl_Yn);  
		mv.addObject("result", result);  	
		
		return mv;
	}
	
	/* 책소개 > 삭제  */
	@RequestMapping(value="/a0000006/board/deleteBook.do")
	public ModelAndView deleteBook(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = boardService.deleteBook(commandMap.getMap());
		
		mv.addObject("result", result);  	
		
		return mv;
	}
	
	/****************************** 책 소 개 종료  ******************************/
	
	/****************************** 간 행 물 시작  ******************************/
	
	/* 간행물  > 조회 */
	@RequestMapping(value="/a0000006/board/publiList.do")
	public ModelAndView publiList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		
		ModelAndView mv = new ModelAndView("/a0000006/board/publiList");
		
		/* 업체코드 - A0000006 (꿈두레) */
		if(commandMap.get("bsnsCode") == null){
			commandMap.put("bsnsCode", session.getAttribute("bsns_code"));
		}
		
		/* 게시판 구분 - B01002 (간행물) */
		if(commandMap.get("boardGbnCd") == null){
			commandMap.put("boardGbnCd", "B01002");
		}
		
		// 게시판 공통 > 조회 > Count
		int totalListCount = boardService.publiListCnt(commandMap.getMap());		
		
		// 요청 페이지 번호
		int requestPageNumber = 1;	
		
		// 요청 페이지 번호가 있을 시 해당 페이지 이동
		if(request.getParameter("requestPageNumber") != null){
			requestPageNumber = Integer.parseInt(request.getParameter("requestPageNumber"));
		}

		// 페이지당 리스트 갯수
		int countPerPage = 8;
		
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
		
		// 게시판 공통 > 조회 > List
		List<Map<String,Object>> publiList = boardService.publiList(commandMap.getMap());
		
		mv.addObject("beginPageNum", 	pagingData[3]);	// 첫 페이지 번호
		mv.addObject("endPageNum", 		pagingData[4]);	// 끝 페이지 번호
		mv.addObject("totalPageCount",	pagingData[0]);	// 전체 페이지 번호
		mv.addObject("publiList", 		publiList);		// 책소개 리스트
		
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	/* 간행물 > 상세 폼 */
	@RequestMapping(value="/a0000006/board/publiView.do")
	public ModelAndView publiView(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/board/publiView");
		
		// 간행물 > 상세 폼
		List<Map<String,Object>> publiView = boardService.publiView(commandMap.getMap());
		
		mv.addObject("item", commandMap.getMap());
		mv.addObject("publiView", publiView.get(0));
		
		return mv;
	}
	
	/* 간행물 > 신규등록 폼 */
	@RequestMapping(value="/a0000006/board/publiFormI.do")
	public ModelAndView publiFormI(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/board/publiForm");

		commandMap.put("newYn", "Y"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	/* 간행물 > 등록 */
	@RequestMapping(value="/a0000006/board/insertPubli.do")
	public ModelAndView insertPubli(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		int boardSn = boardService.insertPubli(commandMap.getMap());
		
		commandMap.put("boardSn", boardSn);
		
		// 게시판 공통 > 파일 등록
		String resultFlYn = boardService.insertBoardFl(commandMap.getMap());
		
		if(boardSn > 0){
			mv.addObject("result", "success");  	
		}else{
			mv.addObject("result", "fail");
		}
	
		mv.addObject("boardSn", boardSn);
		mv.addObject("resultFlYn", resultFlYn);
		
		return mv;
	}
	
	/* 간행물 > 수정 폼 */
	@RequestMapping(value="/a0000006/board/publiFormU.do")
	public ModelAndView publiFormU(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/board/publiForm");

		List<Map<String,Object>> publiView = boardService.publiView(commandMap.getMap());
		
		commandMap.put("newYn", "N"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		mv.addObject("publiView", publiView.get(0));
		
		return mv;
	}
	
	/* 간행물 > 수정 */
	@RequestMapping(value="/a0000006/board/updatePubli.do")
	public ModelAndView updatePubli(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = boardService.updatePubli(commandMap.getMap());
		
		String resultFlYn = "success"; // 파일 등록 성공여부
		
		if(commandMap.get("uploadYn").equals("Y")){
			// 게시판 > 파일 등록
			resultFlYn = boardService.updateBoardFl(commandMap.getMap());
		}
		
		mv.addObject("resultFlYn", resultFlYn);  
		mv.addObject("result", result);  	
		
		return mv;
	}
	
	/* 간행물 > 삭제 */
	@RequestMapping(value="/a0000006/board/deletePubli.do")
	public ModelAndView deletePubli(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = boardService.deletePubli(commandMap.getMap());
		
		mv.addObject("result", result);  	
		
		return mv;
	}
	
	/****************************** 간 행 물 종료  ******************************/
	
	
	/****************************** 게시판 공통 시작  ******************************/

	/* 게시판 공통 > 파일다운로드 > 조회 */
	@RequestMapping(value="/a0000006/board/downloadFile.do")
	public void fldownloadFile(CommandMap commandMap, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{

		commandMap.put("bsnsCode", request.getParameter("bsnsCode"));
		commandMap.put("boardSn", request.getParameter("boardSn"));
		commandMap.put("boardFlSn", request.getParameter("boardFlSn"));
		
		List<Map<String,Object>> boardFlList = boardService.boardFlList(commandMap.getMap());
		
		commandMap.put("originFlNm", boardFlList.get(0).get("ORIGIN_FL_NM"));
		commandMap.put("flNm", boardFlList.get(0).get("FL_NM"));
		commandMap.put("flPath", boardFlList.get(0).get("FL_PATH"));
		//request.setAttribute("fullSubPath", session.getAttribute("bsns_code")+"/board/book/");
		
		CmmnUtilFile.downloadFile(commandMap, request, response);
	}
	
	/****************************** 게시판 공통 종료 ******************************/
	
}