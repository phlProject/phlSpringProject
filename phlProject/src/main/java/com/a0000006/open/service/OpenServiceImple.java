package com.a0000006.open.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.open.dao.OpenDAO;
import com.phl.common.CommandMap;

@Service("openService")
public class OpenServiceImple implements OpenService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="openDAO")
	private OpenDAO openDAO;

	// 스케줄 목록
	@Override
	public List<CommandMap> scheduleList(Map<String, Object> map) throws Exception {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int toYear = Integer.parseInt(map.get("toYear").toString());
		int toMonth = Integer.parseInt(map.get("toMonth").toString());
		int toDay = Integer.parseInt(map.get("toDay").toString());
		
		if(toYear == 0){
			toYear = Integer.parseInt(sdf.format(d).substring(0, 4));
			toMonth = Integer.parseInt(sdf.format(d).substring(5, 7));
			toDay = Integer.parseInt(sdf.format(d).substring(8, 10));
		}
		
		map.put("toYear", toYear);
		map.put("toMonth", toMonth);
		map.put("toDay", toDay);
		
		return openDAO.scheduleList(map);
	}

	// 스케줄 등록
	@Override
	public String insertSchedule(Map<String, Object> map) throws Exception {
		try {
			openDAO.insertSchedule(map);
			return "0";
		} catch (Exception e) {
			return "-1";
		}
	}

	// 상세 스케줄
	@Override
	public Map<String, Object> viewSchedule(Map<String, Object> map) throws Exception {
		return openDAO.viewSchedule(map);
	}

	// 스케줄 수정
	@Override
	public String updateSchedule(Map<String, Object> map) throws Exception {
		try {
			openDAO.updateSchedule(map);
			return "0";
		} catch (Exception e) {
			return "-1";
		}
	}

	// 스케줄 삭제
	@Override
	public String deleteSchedule(Map<String, Object> map) throws Exception {
		try {
			openDAO.deleteSchedule(map);
			return "0";
		} catch (Exception e) {
			return "-1";
		}
	}

	// 대관 장소 목록
	@Override
	public List<CommandMap> placeList(Map<String, Object> map) {
		return openDAO.placeList(map);
	}
}
