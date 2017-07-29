package com.a0000006.open.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.common.CommandMap;
import com.phl.dao.AbstractDAO;

@Repository("openDAO")
public class OpenDAO extends AbstractDAO{

	// 스케줄 목록
	@SuppressWarnings("unchecked")
	public List<CommandMap> scheduleList(Map<String, Object> map) throws Exception{
		return (List<CommandMap>)selectList("a0000006/open.scheduleList", map); 	
	}

	// 스케줄 등록
	public void insertSchedule(Map<String, Object> map) throws Exception{
		insert("a0000006/open.insertSchedule", map);
	}

	// 상세 스케줄
	@SuppressWarnings("unchecked")
	public Map<String, Object> viewSchedule(Map<String, Object> map) throws Exception{
		return (Map<String, Object>) selectOne("a0000006/open.viewSchedule", map);
	}

	// 스케줄 수정
	public void updateSchedule(Map<String, Object> map) throws Exception{
		update("a0000006/open.updateSchedule", map);
	}

	// 스케줄 삭제
	public void deleteSchedule(Map<String, Object> map) throws Exception{
		delete("a0000006/open.deleteSchedule", map);
		
	}
	
	// 대관 장소 목록
	@SuppressWarnings("unchecked")
	public List<CommandMap> placeList(Map<String, Object> map) {
		return (List<CommandMap>)selectList("a0000006/open.placeList", map);
	}
}
