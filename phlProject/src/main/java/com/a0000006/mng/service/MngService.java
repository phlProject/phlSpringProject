package com.a0000006.mng.service;

import java.util.List;
import java.util.Map;

public interface MngService {

	/* 회원리스트 */
	List<Map<String, Object>> memList(Map<String, Object> map) throws Exception;
	
}
