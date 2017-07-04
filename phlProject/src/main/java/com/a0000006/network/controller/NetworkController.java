package com.a0000006.network.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phl.common.CommandMap;

@Controller
public class NetworkController {

	Logger log = Logger.getLogger(this.getClass());
	
	/* 헝겊 원숭이 연대 */
	@RequestMapping(value="/a0000006/network/patchMonkeyIntro.do")
	public ModelAndView patchMonkeyIntro(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/network/patchMonkeyIntro");
        
        return mv;
    }  
	
	/* 지역교육 네트워크 */
	@RequestMapping(value="/a0000006/network/areaEduIntro.do")
	public ModelAndView areaEduIntro(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/network/areaEduIntro");
        
        return mv;
    }  
	
	/* 청년 네트워크 */
	@RequestMapping(value="/a0000006/network/youthEduIntro.do")
	public ModelAndView youthEduIntro(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/network/youthEduIntro");
        
        return mv;
    }  
	
	/* 청소년 네트워크 */
	@RequestMapping(value="/a0000006/network/juvenileEduIntro.do")
	public ModelAndView juvenileEduIntro(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/network/juvenileEduIntro");
        
        return mv;
    }  
}
