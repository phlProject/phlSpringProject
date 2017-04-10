package com.phl.common.service;

import java.util.List;
import java.util.Map;

public interface PhlCommService {
	
	/* 공통코드 */
	List<Map<String, Object>> selectCommCode(Map<String, Object> map) throws Exception;
	
}
