package com.a0000006.apply.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000006.apply.service.ApplyService;
import com.phl.common.CommandMap;

@Controller
public class ApplyController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="applyService")
	private ApplyService applyService;
	
	
	@RequestMapping(value="/a0000006/apply/applyList.do")
	public ModelAndView applyList(CommandMap commandMap) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/apply/applyList");
		

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
		
		// 스케줄 목록
		List<CommandMap> applyList = applyService.applyList(map);
		mv.addObject("applyList", applyList);
		
		return mv;
		
	}
	
	

	@RequestMapping(value="/a0000006/apply/scheduleList.do")
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
		map.put("toYear", toYear);
		map.put("toMonth", toMonth);
		map.put("toDay", toDay);
		
		// 스케줄 목록
		List<CommandMap> applyList = applyService.applyList(map);
		mv.addObject("applyList", applyList);
		
		return mv;
		
	}
	
	
	
}
