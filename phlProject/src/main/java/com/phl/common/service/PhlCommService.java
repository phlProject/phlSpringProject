package com.phl.common.service;

import java.util.List;
import java.util.Map;

import com.phl.common.CommandMap;

public interface PhlCommService {
	
	/* 공통코드 */
	List<CommandMap> selectCommCode(Map<String, Object> map) throws Exception;
	
	String selectCommCodeOne(Map<String, Object> map) throws Exception;
	
	/* 메뉴조회 (2dept) */
	List<CommandMap> menuListDept2(Map<String, Object> map) throws Exception;
	
	/* 메뉴조회 (3dept) */
	List<CommandMap> menuListDept3(Map<String, Object> map) throws Exception;
	
	/* 게시판 조회수 증가 */
	void boardHitCount(Map<String, Object> map) throws Exception;
}
