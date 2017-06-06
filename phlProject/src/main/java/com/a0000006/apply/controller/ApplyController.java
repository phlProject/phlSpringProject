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
		

		// 대관 장소 목록
		List<CommandMap> placeList = applyService.placeList(map);
		mv.addObject("placeList", placeList);
		
		
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
		/*map.put("toYear", toYear);
		map.put("toMonth", toMonth);
		map.put("toDay", toDay);*/
		
		// 스케줄 목록
		List<CommandMap> applyList = applyService.applyList(map);
		mv.addObject("applyList", applyList);
		
		return mv;
		
	}
	
	@RequestMapping(value="/a0000006/apply/insertApply.do")
	public ModelAndView insertApply(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		map.put("session_id", session.getAttribute("session_id"));
		map.put("bsns_code", session.getAttribute("bsns_code"));
		
		// 신청 등록
		String result = applyService.insertApply(map);
		mv.addObject("result", result);
		mv.addObject("session_id", session.getAttribute("session_id"));
		mv.addObject("bsns_code", session.getAttribute("bsns_code"));
		
		return mv;
		
	} 

	// 상세페이지
	@RequestMapping(value="/a0000006/apply/viewApply.do")
	public ModelAndView viewApply(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		// 상세 페이지
		Map<String, Object> result = applyService.viewApply(map);
		mv.addObject("result", result);
		
		return mv;
		
	}
	
	// 수정
	@RequestMapping(value="/a0000006/apply/updateApply.do")
	public ModelAndView updateApply(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		// 상세 페이지
		String result = applyService.updateApply(map);
		mv.addObject("result", result);
		
		return mv;
		
	}
	
	// 삭제
	@RequestMapping(value="/a0000006/apply/deleteApply.do")
	public ModelAndView deleteApply(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		Map<String, Object> map = commandMap.getMap();
		
		// 상세 페이지
		String result = applyService.deleteApply(map);
		mv.addObject("result", result);
		
		return mv;
		
	}
	
	
}
