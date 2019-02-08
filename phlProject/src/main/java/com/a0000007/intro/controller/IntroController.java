package com.a0000007.intro.controller;

import javax.annotation.Resource;

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
	public ModelAndView greeting(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000007/intro/introduce");
        
        return mv;
    }  
}
