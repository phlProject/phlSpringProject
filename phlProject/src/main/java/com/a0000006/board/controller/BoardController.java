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
import com.phl.common.service.PhlCommService;
import com.phl.util.CmmnUtilFile;
import com.phl.util.CmmnUtilPaging;

@Controller
public class BoardController {

	Logger log = Logger.getLogger(this.getClass()); 
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	@Resource(name="BoardService")
	private BoardService boardService;
	
	
	/*********************************************************************/
	/****************************** 책 소 개 시작  ******************************/
	
	/* 책소개  > 조회 */
	@RequestMapping(value="/a0000006/board/bookList.do")
	public ModelAndView bookList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		// 한글깨짐 방지
		request.setCharacterEncoding("utf-8"); 
		
		ModelAndView mv = new ModelAndView("/a0000006/board/bookList");
		
		/* 업체코드 - A0000006 (꿈두레) */
		if(commandMap.get("bsnsCode") == null){
			commandMap.put("bsnsCode", session.getAttribute("bsnsCode"));
		}
		
		/* 게시판 구분 - B01001 (책소개) */
		if(commandMap.get("boardGbnCd") == null){
			commandMap.put("boardGbnCd", "B01001");
			commandMap.put("boardGbnCdNm", "책소개");
		}
		
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
	
	/* 책소개 > 상세 폼 */
	@RequestMapping(value="/a0000006/board/bookView.do")
	public ModelAndView bookView(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/board/bookView");
		
		// 공통 > 게시판 조회수 증가
		phlCommService.boardHitCount(commandMap.getMap());
		
		// 책소개 > 상세
		List<Map<String,Object>> bookView = boardService.bookView(commandMap.getMap());
		
		mv.addObject("item", commandMap.getMap());
		mv.addObject("bookView", bookView.get(0));
		
		return mv;
	}
	
	/* 책소개 > 신규등록 폼 */
	@RequestMapping(value="/a0000006/board/bookFormI.do")
	public ModelAndView bookForm(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/board/bookForm");
		
		commandMap.put("newYn", "Y"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	
	/* 책소개 > 등록  */
	@RequestMapping(value="/a0000006/board/insertBook.do")
	public ModelAndView insertBook(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		int boardSn = boardService.insertBook(commandMap.getMap());
		commandMap.put("boardSn", boardSn);
		
		// 책소개 > 등록(상세)
		boardService.insertBookDetail(commandMap.getMap());
		
		// 게시판 공통 > 파일 등록 ( 'file' / 'image' )
		String resultFlYn = boardService.insertBoardAttach(commandMap.getMap(), "image");

		if(boardSn > 0){
			mv.addObject("result", "success");  	
		}else{
			mv.addObject("result", "fail");
		}
	
		mv.addObject("boardSn", boardSn);
		mv.addObject("resultFlYn", resultFlYn);
		
		return mv;
	}
	
	/* 책소개 > 수정 폼 */
	@RequestMapping(value="/a0000006/board/bookFormU.do")
	public ModelAndView bookFormU(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/board/bookForm");
		
		List<Map<String,Object>> bookView = boardService.bookView(commandMap.getMap());
		
		commandMap.put("newYn", "N"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		mv.addObject("bookView", bookView.get(0));
		
		return mv;
	}
	
	/* 책소개 > 수정  */
	@RequestMapping(value="/a0000006/board/updateBook.do")
	public ModelAndView updateBook(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = boardService.updateBook(commandMap.getMap());
		
		String resultFlYn = "success"; // 파일 등록 성공여부
		
		if(commandMap.get("uploadYn").equals("Y")){
			// 게시판 > 파일 등록  ( 'file' / 'image' )
			resultFlYn = boardService.updateBoardAttach(commandMap.getMap(), "image");
		}
		
		mv.addObject("resultFlYn", resultFlYn);  
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
	
	/* 책소개 > 좋아요 */
	@RequestMapping(value="/a0000006/board/bookLike.do")
	public ModelAndView bookLike(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		commandMap.put("bsnsCode",request.getParameter("bsnsCode"));	
		commandMap.put("boardSn",request.getParameter("boardSn"));
		commandMap.put("saveLike",request.getParameter("saveLike"));	
		commandMap.put("sessionId",session.getAttribute("sessionId"));
		
		try{
			// 책소개 > 좋아요 Count
			String result = boardService.bookLikeCount(commandMap.getMap());
			if(result.equals("success")){
				// 책소개 > 좋아요 등록/수정
				result = boardService.bookLikeHistory(commandMap.getMap());
				
				mv.addObject("result", result);  	
			}
		}catch(Exception e){
		}
		return mv;
	}
	
	/****************************** 책 소 개 종료  ******************************/
	/*********************************************************************/
	
	
	
	/*********************************************************************/
	/********************** 자 료 공 통 시작 (교육, 정책, 기타 ) **********************/
	
	/* 교육자료  > 조회 */
	@RequestMapping(value="/a0000006/board/eduDataList.do")
	public ModelAndView eduDataList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		
		ModelAndView mv = new ModelAndView("/a0000006/board/dataBoardList");
		
		/* 업체코드 - A0000006 (꿈두레) */
		if(commandMap.get("bsnsCode") == null){
			commandMap.put("bsnsCode", session.getAttribute("bsnsCode"));
		}
		
		/* 게시판 구분 - B01002 (교육자료) */
		if(commandMap.get("boardGbnCd") == null){
			commandMap.put("boardGbnCd", "B01002");
			commandMap.put("boardGbnCdNm", "교육자료");
		}
		
		// 교육자료 > 조회 > Count
		int totalListCount = boardService.dataListCnt(commandMap.getMap());		
		
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
		
		// 간행물 > 조회
		List<Map<String,Object>> dataList = boardService.dataList(commandMap.getMap());
		
		mv.addObject("beginPageNum", 	pagingData[3]);	// 첫 페이지 번호
		mv.addObject("endPageNum", 		pagingData[4]);	// 끝 페이지 번호
		mv.addObject("totalPageCount",	pagingData[0]);	// 전체 페이지 번호
		mv.addObject("dataList", 		dataList);		// 자료 리스트
		
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	
	/* 정책자료  > 조회 */
	@RequestMapping(value="/a0000006/board/policyDataList.do")
	public ModelAndView policyDataList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		
		ModelAndView mv = new ModelAndView("/a0000006/board/dataBoardList");
		
		/* 업체코드 - A0000006 (꿈두레) */
		if(commandMap.get("bsnsCode") == null){
			commandMap.put("bsnsCode", session.getAttribute("bsnsCode"));
		}
		
		/* 게시판 구분 - B01003 (정책자료) */
		if(commandMap.get("boardGbnCd") == null){
			commandMap.put("boardGbnCd", "B01003");
			commandMap.put("boardGbnCdNm", "정책자료");
		}
		
		// 교육자료 > 조회 > Count
		int totalListCount = boardService.dataListCnt(commandMap.getMap());		
		
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
		
		// 간행물 > 조회
		List<Map<String,Object>> dataList = boardService.dataList(commandMap.getMap());
		
		mv.addObject("beginPageNum", 	pagingData[3]);	// 첫 페이지 번호
		mv.addObject("endPageNum", 		pagingData[4]);	// 끝 페이지 번호
		mv.addObject("totalPageCount",	pagingData[0]);	// 전체 페이지 번호
		mv.addObject("dataList", 		dataList);		// 자료 리스트
		
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	
	/* 기타자료  > 조회 */
	@RequestMapping(value="/a0000006/board/etcDataList.do")
	public ModelAndView etcDataList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		
		ModelAndView mv = new ModelAndView("/a0000006/board/dataBoardList");
		
		/* 업체코드 - A0000006 (꿈두레) */
		if(commandMap.get("bsnsCode") == null){
			commandMap.put("bsnsCode", session.getAttribute("bsnsCode"));
		}
		
		/* 게시판 구분 - B01004 (기타자료) */
		if(commandMap.get("boardGbnCd") == null){
			commandMap.put("boardGbnCd", "B01004");
			commandMap.put("boardGbnCdNm", "기타자료");
		}
		
		// 교육자료 > 조회 > Count
		int totalListCount = boardService.dataListCnt(commandMap.getMap());		
		
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
		
		// 간행물 > 조회
		List<Map<String,Object>> dataList = boardService.dataList(commandMap.getMap());
		
		mv.addObject("beginPageNum", 	pagingData[3]);	// 첫 페이지 번호
		mv.addObject("endPageNum", 		pagingData[4]);	// 끝 페이지 번호
		mv.addObject("totalPageCount",	pagingData[0]);	// 전체 페이지 번호
		mv.addObject("dataList", 		dataList);		// 자료 리스트
		
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	
	/* 자료공통  > 조회 */
	@RequestMapping(value="/a0000006/board/dataList.do")
	public ModelAndView dataList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		
		ModelAndView mv = new ModelAndView("/a0000006/board/dataBoardList");
		
		/* 업체코드 - A0000006 (꿈두레) */
		if(commandMap.get("bsnsCode") == null){
			commandMap.put("bsnsCode", session.getAttribute("bsnsCode"));
		}
		
		String boardGbnCdNm = "";
		if(commandMap.get("boardGbnCd").equals("B01002")) 		boardGbnCdNm = "교육자료";
		else if(commandMap.get("boardGbnCd").equals("B01003"))	boardGbnCdNm = "정책자료";
		else if(commandMap.get("boardGbnCd").equals("B01004"))	boardGbnCdNm = "기타자료";
		commandMap.put("boardGbnCdNm", boardGbnCdNm);
		
		// 자료공통 > 조회 > Count
		int totalListCount = boardService.dataListCnt(commandMap.getMap());		
		
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
		
		// 간행물 > 조회
		List<Map<String,Object>> dataList = boardService.dataList(commandMap.getMap());
		
		mv.addObject("beginPageNum", 	pagingData[3]);	// 첫 페이지 번호
		mv.addObject("endPageNum", 		pagingData[4]);	// 끝 페이지 번호
		mv.addObject("totalPageCount",	pagingData[0]);	// 전체 페이지 번호
		mv.addObject("dataList", 		dataList);		// 자료 리스트
		
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	
	/* 자료공통 > 상세 폼 */
	@RequestMapping(value="/a0000006/board/dataView.do")
	public ModelAndView eduDataView(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/board/dataBoardView");
		
		// 공통 > 게시판 조회수 증가
		phlCommService.boardHitCount(commandMap.getMap());
		
		List<Map<String,Object>> dataView = boardService.dataView(commandMap.getMap());
		
		mv.addObject("item", commandMap.getMap());
		mv.addObject("dataView", dataView.get(0));
		
		return mv;
	}
	
	
	/* 자료공통 > 신규등록 폼 */
	@RequestMapping(value="/a0000006/board/dataFormI.do")
	public ModelAndView eduDataFormI(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/board/dataBoardForm");

		commandMap.put("newYn", "Y"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		
		return mv;
	}
	
	
	/* 자료공통 > 등록 */
	@RequestMapping(value="/a0000006/board/insertData.do")
	public ModelAndView insertEduData(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		int boardSn = boardService.insertData(commandMap.getMap());
		
		commandMap.put("boardSn", boardSn);
		
		// 게시판 공통 > 파일 등록  ( 'file' / 'image' )
		String resultFlYn = boardService.insertBoardAttach(commandMap.getMap(), "file");
		
		if(boardSn > 0){
			mv.addObject("result", "success");  	
		}else{
			mv.addObject("result", "fail");
		}
	
		mv.addObject("boardSn", boardSn);
		mv.addObject("resultFlYn", resultFlYn);
		
		return mv;
	}
	
	
	/* 자료공통 > 수정 폼 */
	@RequestMapping(value="/a0000006/board/dataFormU.do")
	public ModelAndView eduDataFormU(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/board/dataBoardForm");

		List<Map<String,Object>> dataView = boardService.dataView(commandMap.getMap());
		
		commandMap.put("newYn", "N"); 		// 신규여부 ( Y : 신규등록 , N : 수정 )
		mv.addObject("item", commandMap.getMap());
		mv.addObject("dataView", dataView.get(0));
		
		return mv;
	}
	
	
	/* 자료공통 > 수정 */
	@RequestMapping(value="/a0000006/board/updateData.do")
	public ModelAndView updateEduData(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = boardService.updateData(commandMap.getMap());
		
		String resultFlYn = "success"; // 파일 등록 성공여부
		
		if(commandMap.get("uploadYn").equals("Y")){
			// 게시판 > 파일 등록  ( 'file' / 'image' )
			resultFlYn = boardService.updateBoardAttach(commandMap.getMap(), "image");
		}
		
		mv.addObject("resultFlYn", resultFlYn);  
		mv.addObject("result", result);  	
		
		return mv;
	}
	
	
	/* 자료공통 > 삭제 */
	@RequestMapping(value="/a0000006/board/deleteData.do")
	public ModelAndView deleteEduData(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = boardService.deleteData(commandMap.getMap());
		
		mv.addObject("result", result);  	
		
		return mv;
	}
	
	/********************** 자 료 공 통 종료 (교육, 정책, 기타 ) **********************/
	/*********************************************************************/
	
	
	/*********************************************************************/
	/***************************** 게시판 공통 시작  *****************************/

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
		//request.setAttribute("fullSubPath", session.getAttribute("bsnsCode")+"/board/book/");
		
		CmmnUtilFile.downloadFile(commandMap, request, response);
	}
	
	/***************************** 게시판 공통 종료 *****************************/	
	/*********************************************************************/
}