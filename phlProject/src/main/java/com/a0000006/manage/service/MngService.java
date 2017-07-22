package com.a0000006.manage.service;

import java.util.List;
import java.util.Map;

public interface MngService {

	/* 회원리스트 Count */
	int memListCnt(Map<String, Object> map) throws Exception;
	
	/* 회원리스트 */
	List<Map<String, Object>> memList(Map<String, Object> map) throws Exception;
	
	/* 회원 활성화 비활성화 수정 */
	String memUpdateActive(Map<String, Object> map) throws Exception;
	
}
