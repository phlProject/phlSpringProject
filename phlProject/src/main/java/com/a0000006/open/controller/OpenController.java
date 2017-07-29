package com.a0000006.open.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000006.open.service.OpenService;
import com.phl.common.CommandMap;

@Controller
public class OpenController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="openService")
	private OpenService openService;
	
	
	@RequestMapping(value="/a0000006/open/scheduleList.do")
	public ModelAndView scheduleList(CommandMap commandMap) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/open/scheduleList");
		

		//현재 년도, 월, 일
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int toYear = cal.get( cal.YEAR );
		int toMonth = cal.get( cal.MONTH ) + 1;
		int toDay = cal.get( cal.DATE );
		mv.addObject("toYear", toYear);
		mv.addObject("toMonth", toMonth);
		mv.addObject("toDay", toDay);
		
		
		Map<String, Object> map = commandMap.getMap();
		map.put("toYear", toYear);
		map.put("toMonth", toMonth);
		map.put("toDay", toDay);
		

		// 대관 장소 목록
		List<CommandMap> placeList = openService.placeList(map);
		mv.addObject("placeList", placeList);
		
		
		// 스케줄 목록
		List<CommandMap> scheduleList = openService.scheduleList(map);
		mv.addObject("scheduleList", scheduleList);
		

		return mv;
		
	}
	
	

	@RequestMapping(value="/a0000006/open/ajaxScheduleList.do")
	public ModelAndView scheduleList(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		

		//현재 년도, 월, 일
		java.util.Calendar cal = java.util.Calendar.getInstance();
		int toYear = cal.get( cal.YEAR );
		int toMonth = cal.get( cal.MONTH ) + 1;
		int toDay = cal.get( cal.DATE );
		mv.addObject("toYear", toYear);
		mv.addObject("toMonth", toMonth);
		mv.addObject("toDay", toDay);
		
		
		Map<String, Object> map = commandMap.getMap();
		/*map.put("toYear", toYear);
		map.put("toMonth", toMonth);
		map.put("toDay", toDay);*/
		
		// 스케줄 목록
		List<CommandMap> scheduleList = openService.scheduleList(map);
		mv.addObject("scheduleList", scheduleList);
		
		return mv;
		
	}
	
	@RequestMapping(value="/a0000006/open/insertSchedule.do")
	public ModelAndView insertSchedule(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		map.put("sessionId", session.getAttribute("sessionId"));
		map.put("bsnsCode", session.getAttribute("bsnsCode"));
		
		// 신청 등록
		String result = openService.insertSchedule(map);
		mv.addObject("result", result);
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("bsnsCode", session.getAttribute("bsnsCode"));
		
		return mv;
		
	} 

	// 상세페이지
	@RequestMapping(value="/a0000006/open/viewSchedule.do")
	public ModelAndView viewSchedule(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		// 상세 페이지
		Map<String, Object> result = openService.viewSchedule(map);
		mv.addObject("result", result);
		
		return mv;
		
	}
	
	// 수정
	@RequestMapping(value="/a0000006/open/updateSchedule.do")
	public ModelAndView updateSchedule(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		// 상세 페이지
		String result = openService.updateSchedule(map);
		mv.addObject("result", result);
		
		return mv;
		
	}
	
	// 삭제
	@RequestMapping(value="/a0000006/open/deleteSchedule.do")
	public ModelAndView deleteSchedule(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		// 상세 페이지
		String result = openService.deleteSchedule(map);
		mv.addObject("result", result);
		
		return mv;
		
	}
	
	
}
