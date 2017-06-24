package com.a0000006.intro.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phl.common.CommandMap;

@Controller
public class IntroController {

	Logger log = Logger.getLogger(this.getClass());
	
	/* 이사장 인사말 */
	@RequestMapping(value="/a0000006/intro/greeting.do")
	public ModelAndView greeting(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/intro/greeting");
        
        return mv;
    }  
	
	/* 교육나눔 꿈두레 소개 */
	@RequestMapping(value="/a0000006/intro/introduce.do")
	public ModelAndView introduce(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/intro/introduce");
        
        return mv;
    }
	
	/* 참여와 후원 */
	@RequestMapping(value="/a0000006/intro/sponsor.do")
	public ModelAndView sponsor(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/intro/sponsor");
        
        return mv;
    }
	
	/* 오시는 길 */
	@RequestMapping(value="/a0000006/intro/directions.do")
	public ModelAndView directions(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/intro/directions");
        
        return mv;
    }
}
