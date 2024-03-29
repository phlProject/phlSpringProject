package com.a0000006.manage.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000006.manage.service.ManageService;
import com.phl.common.CommandMap;
import com.phl.util.CmmnUtilPaging;

@Controller
public class ManageController {
	
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="manageService")
	private ManageService manageService;
	
	/* 회원리스트 */
	@RequestMapping(value="/a0000006/manage/memList.do")
	public ModelAndView selectMemList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
       
		// 한글깨짐 방지
		request.setCharacterEncoding("utf-8"); 
		
		ModelAndView mv = new ModelAndView("/a0000006/manage/memList");
        
		/* 업체코드 - A0000006 (꿈두레) */
		if(commandMap.get("bsnsCode") == null){
			commandMap.put("bsnsCode", session.getAttribute("bsnsCode"));
		}
		
        // 관리자 페이지 > 전체 회원 수 
        int totalListCount = manageService.memListCnt(commandMap.getMap());
        
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

        // 회원 리스트
        List<Map<String,Object>> memList = manageService.memList(commandMap.getMap());

		mv.addObject("beginPageNum", 	pagingData[3]);	// 첫 페이지 번호
		mv.addObject("endPageNum", 		pagingData[4]);	// 끝 페이지 번호
		mv.addObject("totalPageCount",	pagingData[0]);	// 전체 페이지 번호
        mv.addObject("memList", memList);				// 멤버 리스트
        
        mv.addObject("searchSelect", 	commandMap.get("searchSelect"));	// 파라미터 검색조건
		mv.addObject("searchWord", 		commandMap.get("searchWord"));		// 파라미터 검색단어
		mv.addObject("searchAuthor", 	commandMap.get("searchAuthor"));	// 파라미터 검색권한
		mv.addObject("searchRemark", 	commandMap.get("searchRemark"));	// 파라미터 검색상태
		
        return mv;
    }
	
	
	/* 활성화/비활성화 수정 */
	@RequestMapping(value="/a0000006/manage/memActiveYn.do")
	public ModelAndView memActiveYn(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		String saveremark = "";
		if(commandMap.get("remark").equals("Y")){
			saveremark = "N";
		}else{
			saveremark = "Y";
		}
		
		commandMap.put("saveremark", saveremark);
		String result = manageService.memActiveYn(commandMap.getMap());
		
		mv.addObject("result", result); 
		
		return mv;
	}
	
	
	/* 권한 승인/해제 수정 */
	@RequestMapping(value="/a0000006/manage/memAuthorYn.do")
	public ModelAndView memAuthorYn(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		String saveremark = "";
		if(commandMap.get("remark").equals("Y")){
			saveremark = "S";
		}else{
			saveremark = "Y";
		}
		
		commandMap.put("saveremark", saveremark);
		String result = manageService.memAuthorYn(commandMap.getMap());
		
		mv.addObject("result", result); 
		
		return mv;
	}
}
