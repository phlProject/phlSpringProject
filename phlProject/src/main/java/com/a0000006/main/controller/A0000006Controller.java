package com.a0000006.main.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phl.common.CommandMap;
import com.phl.common.service.PhlCommService;

@Controller
public class A0000006Controller {

	Logger log = Logger.getLogger(this.getClass());
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	
	/* 메인화면 */
	@RequestMapping(value="/a0000006/mainIndex.do")
	public ModelAndView mainIndex(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/mainIndex");
        
        // 교육나눔꿈두레 사업코드 (A0000006)
        session.setAttribute("bsnsCode","A0000006");
        
        commandMap.put("bsnsCode", session.getAttribute("bsnsCode"));
        
        // 메뉴조회
        List<CommandMap> menuList = phlCommService.menuList_dept2(commandMap.getMap());
        
        session.setAttribute("menuList", menuList);
        
        return mv;
    }     
}
