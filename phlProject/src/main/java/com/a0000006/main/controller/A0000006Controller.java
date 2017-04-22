package com.a0000006.main.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class A0000006Controller {

	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="/a0000006/mainIndex.do")
	public ModelAndView memberList(Map<String,Object> commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/mainIndex");
        
        // 교육나눔꿈두레 사업코드 (A0000006)
        session.setAttribute("BSNS_CODE","A0000006");
        
        return mv;
    }     
}
