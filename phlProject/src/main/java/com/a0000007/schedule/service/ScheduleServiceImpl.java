package com.a0000007.schedule.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000007.schedule.dao.ScheduleDAO;
import com.phl.common.CommandMap;

@Service("/a0000007/scheduleService")
public class ScheduleServiceImpl implements ScheduleService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="/a0000007/scheduleDAO")
	private ScheduleDAO scheduleDAO;
	
	
	/**
	 *  scheduleList ( 일정 조회 ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public List<CommandMap> scheduleList(Map<String, Object> map) throws Exception {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int toYear = Integer.parseInt(map.get("toYear").toString());
		int toMonth = Integer.parseInt(map.get("toMonth").toString());
		int toDay = Integer.parseInt(map.get("toDay").toString());
		
		if(toYear == 0)
		{
			toYear = Integer.parseInt(sdf.format(d).substring(0, 4));
			toMonth = Integer.parseInt(sdf.format(d).substring(5, 7));
			toDay = Integer.parseInt(sdf.format(d).substring(8, 10));
		}
		
		map.put("toYear", 	toYear);
		map.put("toMonth",	toMonth);
		map.put("toDay", 	toDay);
		
		return scheduleDAO.scheduleList(map);
	}

	
	/**
	 *  scheduleView ( 일정 상세조회  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public Map<String, Object> scheduleView(Map<String, Object> map) throws Exception {
		return scheduleDAO.scheduleView(map);
	}
	
	
	/**
	 *  insertSchedule ( 일정 등록  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public String insertSchedule(Map<String, Object> map) throws Exception {
		try 
		{
			scheduleDAO.insertSchedule(map);
			return "0";
		} 
		catch (Exception e) 
		{
			return "-1";
		}
	}
	
	/**
	 *  updateSchedule ( 일정 수정  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public String updateSchedule(Map<String, Object> map) throws Exception {
		try 
		{
			scheduleDAO.updateSchedule(map);
			return "0";
		} 
		catch (Exception e) 
		{
			return "-1";
		}
	}
	
	
	/**
	 *  deleteSchedule ( 일정 삭제  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public String deleteSchedule(Map<String, Object> map) throws Exception {
		try 
		{
			scheduleDAO.deleteSchedule(map);
			return "0";
		} 
		catch (Exception e) 
		{
			return "-1";
		}
	}
	
}
