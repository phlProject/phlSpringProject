package com.a0000007.schedule.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000007.schedule.service.ScheduleService;
import com.phl.common.CommandMap;
import com.phl.common.service.PhlCommService;

@Controller(value="/a0000007/schedule")
public class ScheduleController {

	Logger log = Logger.getLogger(this.getClass()); 
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	@Resource(name="/a0000007/scheduleService")
	private ScheduleService scheduleService;
	
	/**
	 *  scheduleList ( 일정 조회 ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/schedule/scheduleList.do")
	public ModelAndView scheduleList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000007/schedule/scheduleList");
		
		//현재 년도, 월, 일
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int toYear 	= cal.get( cal.YEAR );
		int toMonth = cal.get( cal.MONTH ) + 1;
		int toDay 	= cal.get( cal.DATE );
		mv.addObject("toYear", 	toYear);
		mv.addObject("toMonth", toMonth);
		mv.addObject("toDay", 	toDay);
		
		Map<String, Object> map = commandMap.getMap();
		map.put("toYear", 	toYear);
		map.put("toMonth", 	toMonth);
		map.put("toDay", 	toDay);

		List<CommandMap> scheduleList = scheduleService.scheduleList(map);
		mv.addObject("scheduleList", scheduleList);
		
		return mv;
	}
	
	
	/**
	 *  scheduleListAjax ( 일정 조회 - Ajax ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/schedule/scheduleListAjax.do")
	public ModelAndView scheduleListAjax(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		//현재 년도, 월, 일
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int toYear 	= cal.get( cal.YEAR );
		int toMonth = cal.get( cal.MONTH ) + 1;
		int toDay 	= cal.get( cal.DATE );
		mv.addObject("toYear", 	toYear);
		mv.addObject("toMonth", toMonth);
		mv.addObject("toDay", 	toDay);
		
		Map<String, Object> map = commandMap.getMap();

		List<CommandMap> scheduleList = scheduleService.scheduleList(map);
		mv.addObject("scheduleList", scheduleList);
		
		return mv;
	}
	
	/**
	 *  scheduleView ( 일정 상세조회  ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/schedule/scheduleView.do")
	public ModelAndView scheduleView(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		Map<String, Object> result = scheduleService.scheduleView(map);
		mv.addObject("result", result);
		
		return mv;
	}
	
	/**
	 *  insertSchedule ( 일정 등록  ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/schedule/insertSchedule.do")
	public ModelAndView insertSchedule(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		map.put("sessionId", 	session.getAttribute("sessionId"));
		map.put("bsnsCode", 	session.getAttribute("bsnsCode"));
		
		String result = scheduleService.insertSchedule(map);
		
		mv.addObject("result", 		result);
		mv.addObject("sessionId", 	session.getAttribute("sessionId"));
		mv.addObject("bsnsCode", 	session.getAttribute("bsnsCode"));
		
		return mv;
	} 
	
	
	/**
	 *  updateSchedule ( 일정 수정  ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/schedule/updateSchedule.do")
	public ModelAndView updateSchedule(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		String result = scheduleService.updateSchedule(map);
		mv.addObject("result", result);
		
		return mv;
	}
	
	
	/**
	 *  deleteSchedule ( 일정 삭제  ) 
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/a0000007/schedule/deleteSchedule.do")
	public ModelAndView deleteSchedule(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		String result = scheduleService.deleteSchedule(map);
		mv.addObject("result", result);
		
		return mv;
	}
	
	
}
