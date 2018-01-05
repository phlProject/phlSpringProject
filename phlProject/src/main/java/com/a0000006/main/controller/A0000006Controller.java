package com.a0000006.main.controller;

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
import com.phl.common.service.PhlCommService;

@Controller
public class A0000006Controller {

	Logger log = Logger.getLogger(this.getClass());
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	/* 자료실 */
	@Resource(name="BoardService")
	private BoardService boardService;
	
	
	
	/* 메인화면 */
	@RequestMapping(value="/a0000006/mainIndex.do")
	public ModelAndView mainIndex(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/mainIndex");
        
        // 교육나눔꿈두레 사업코드 (A0000006)
        session.setAttribute("bsnsCode","A0000006");
        
        commandMap.put("bsnsCode", session.getAttribute("bsnsCode"));

        if(session.getAttribute("menuList") == null){
        	// 메뉴조회
	        List<CommandMap> menuList = phlCommService.menuListDept3(commandMap.getMap());
	        
	        session.setAttribute("menuList", menuList);  
        }
        
        // 자료실 조회
        commandMap.put("boardGbnCd", "B01001");	// 게시판_코드 : 책소개 
        commandMap.put("selectWhere", "main");
        List<Map<String,Object>> bookList = boardService.bookList(commandMap.getMap());
        
        mv.addObject("bookList", bookList);
        
        return mv;
    }     
}
