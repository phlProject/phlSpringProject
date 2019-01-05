package com.a0000007.schedule.service;

import java.util.List;
import java.util.Map;

import com.phl.common.CommandMap;

public interface ScheduleService {

	/**
	 *  scheduleList ( 일정 조회 ) 
	 *	2018.12.31 LJG  
	 */
	List<CommandMap> scheduleList(Map<String, Object> map) throws Exception;
	
	/**
	 *  scheduleView ( 일정 상세조회  ) 
	 *	2018.12.31 LJG  
	 */
	Map<String, Object> scheduleView(Map<String, Object> map) throws Exception;
	
	/**
	 *  insertSchedule ( 일정 등록  ) 
	 *	2018.12.31 LJG  
	 */
	String insertSchedule(Map<String, Object> map) throws Exception;
	
	/**
	 *  updateSchedule ( 일정 수정  ) 
	 *	2018.12.31 LJG  
	 */
	String updateSchedule(Map<String, Object> map) throws Exception;
	
	/**
	 *  deleteSchedule ( 일정 삭제  ) 
	 *	2018.12.31 LJG  
	 */
	String deleteSchedule(Map<String, Object> map) throws Exception;
}
