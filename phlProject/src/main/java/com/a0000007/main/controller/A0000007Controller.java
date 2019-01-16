package com.a0000007.main.controller;

import java.util.List;
import java.util.Map;

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
public class A0000007Controller {

	Logger log = Logger.getLogger(this.getClass());
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	/* 두레꿈학교 - 메인화면 */
	@RequestMapping(value="/a0000007/mainIndex.do")
	public ModelAndView mainIndex(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000007/mainIndex");
		
		// 두레꿈학교 - A0000007
        session.setAttribute("bsnsCode", "A0000007");
        
		return mv;
    }     
	
	@RequestMapping(value="/a0000007/admin.do")
	public ModelAndView admin(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000007/admin");
		 
		// 두레꿈학교 - A0000007
        session.setAttribute("bsnsCode", "A0000007");
        
		return mv;
    }    
	
	
	@RequestMapping(value="/a0000007/adminLogin.do")
	public ModelAndView adminLogin(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
        
		ModelAndView mv = new ModelAndView();
        
        String resultValue = "";
        
        /* 관리자 체크 */
        List<Map<String,Object>> adminCheck = phlCommService.adminCheck(commandMap.getMap());
        
        /* 해당하는 정보 존재시 */
        if(adminCheck.size() != 0){
        	String queryPw 		= (String) adminCheck.get(0).get("MEM_PW");
        	
        	if(queryPw != null && queryPw.equals(commandMap.get("memPw"))){

        		List<Map<String,Object>> loginInfo = phlCommService.adminInfo(commandMap.getMap());
	
	        	session.setAttribute("loginInfo", loginInfo.get(0));
	        	session.setAttribute("sessionId", loginInfo.get(0).get("MEM_ID"));
	        	
	        	mv.setViewName("redirect:/a0000007/mainIndex.do");
	        }else{
	        	/* 비밀번호 오류 */
	        	resultValue = "PW_ERROR";
	        	mv.setViewName("/a0000007/admin");
	        }
        }else{
        	/* 아이디 오류 */
        	resultValue = "ID_ERROR";
        	mv.setViewName("/a0000007/admin");
        }
        mv.addObject("resultValue",resultValue);  

        return mv;
    }
}
