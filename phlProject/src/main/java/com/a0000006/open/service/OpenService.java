package com.a0000006.open.service;

import java.util.List;
import java.util.Map;

import com.phl.common.CommandMap;

public interface OpenService {
	// 스케줄 목록
	List<CommandMap> scheduleList(Map<String, Object> map) throws Exception;

	// 스케줄 등록
	String insertSchedule(Map<String, Object> map) throws Exception;

	// 상세 스케줄
	Map<String, Object> viewSchedule(Map<String, Object> map) throws Exception;

	// 스케줄 수정
	String updateSchedule(Map<String, Object> map) throws Exception;

	// 스케줄 삭제
	String deleteSchedule(Map<String, Object> map) throws Exception;

	// 대관 장소 목록
	List<CommandMap> placeList(Map<String, Object> map);

}
