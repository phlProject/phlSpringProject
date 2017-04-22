package com.a0000006.apply.service;

import java.util.List;
import java.util.Map;

import com.phl.common.CommandMap;


public interface ApplyService {

	// 스케줄 목록
	List<CommandMap> applyList(Map<String, Object> map) throws Exception;

}
