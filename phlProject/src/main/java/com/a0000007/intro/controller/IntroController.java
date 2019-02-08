package com.a0000007.intro.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phl.common.CommandMap;
import com.phl.common.service.PhlCommService;

@Controller(value="/a0000007/intro")
public class IntroController {

	Logger log = Logger.getLogger(this.getClass());
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	/* 소개 */
	@RequestMapping(value="/a0000007/intro/introduce.do")
	public ModelAndView greeting(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000007/intro/introduce");
        
		commandMap.put("bsnsCode", 	session.getAttribute("bsnsCode").toString());
		List<Map<String,Object>> fileList = phlCommService.downloadFile(commandMap.getMap());
		
		mv.addObject("fileList", fileList);
		
        return mv;
    }  
}
