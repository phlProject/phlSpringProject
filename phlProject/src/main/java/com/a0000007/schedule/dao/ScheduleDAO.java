package com.a0000007.schedule.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.common.CommandMap;
import com.phl.dao.AbstractDAO;

@Repository("/a0000007/scheduleDAO")
public class ScheduleDAO extends AbstractDAO {

	/**
	 *  scheduleList ( 일정 조회 ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
	public List<CommandMap> scheduleList(Map<String, Object> map) throws Exception{
		return (List<CommandMap>)selectList("a0000007/schedule.scheduleList", map); 	
	}

	
	/**
	 *  scheduleView ( 일정 상세조회  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> scheduleView(Map<String, Object> map) throws Exception{
		return (Map<String, Object>) selectOne("a0000007/schedule.scheduleView", map);
	}
	
	
	/**
	 *  insertSchedule ( 일정 등록  ) 
	 *	2018.12.31 LJG  
	 */
	public void insertSchedule(Map<String, Object> map) throws Exception{
		insert("a0000007/schedule.insertSchedule", map);
	}
	
	/**
	 *  updateSchedule ( 일정 수정  ) 
	 *	2018.12.31 LJG  
	 */
	public void updateSchedule(Map<String, Object> map) throws Exception{
		update("a0000007/schedule.updateSchedule", map);
	}
	
	/**
	 *  deleteSchedule ( 일정 삭제  ) 
	 *	2018.12.31 LJG  
	 */
	public void deleteSchedule(Map<String, Object> map) throws Exception{
		update("a0000007/schedule.deleteSchedule", map);
		
	}
	
}
