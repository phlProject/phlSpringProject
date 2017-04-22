package com.phl.common.service;

import java.util.List;
import java.util.Map;

import com.phl.common.CommandMap;

public interface PhlCommService {
	
	/* 공통코드 */
	List<CommandMap> selectCommCode(Map<String, Object> map) throws Exception;
	
}
