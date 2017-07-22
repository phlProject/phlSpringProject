package com.a0000006.teacher.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phl.common.CommandMap;

@Controller
public class TeacherController {

Logger log = Logger.getLogger(this.getClass());
	
	/* 아하 과정 */
	@RequestMapping(value="/a0000006/teacher/ahaProcess.do")
	public ModelAndView ahaProcess(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/teacher/ahaProcess");
        
        return mv;
    }
	
	/* 배움과 결 */
	@RequestMapping(value="/a0000006/teacher/learnAndGrain.do")
	public ModelAndView learnAndGrain(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/teacher/learnAndGrain");
        
        return mv;
    } 
	
	/* 생명의 시쓰기 */
	@RequestMapping(value="/a0000006/teacher/lifeOfPoem.do")
	public ModelAndView lifeOfPoem(CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/teacher/lifeOfPoem");
        
        return mv;
    } 
}
