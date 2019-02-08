package com.phl.common.service;

import java.util.List;
import java.util.Map;

import com.phl.common.CommandMap;

public interface PhlCommService {
	
	/* 공통코드 */
	List<CommandMap> selectCommCode(Map<String, Object> map) throws Exception;
	
	String selectCommCodeOne(Map<String, Object> map) throws Exception;
	
	/**
	 *  menuListDept2 ( 공통 - 메뉴조회 (2dept)  ) 
	 *	2018.12.31 LJG  
	 */
	List<CommandMap> menuListDept2(Map<String, Object> map) throws Exception;
	
	/**
	 *  menuListDept3 ( 공통 - 메뉴조회 (3dept)  ) 
	 *	2018.12.31 LJG  
	 */
	List<CommandMap> menuListDept3(Map<String, Object> map) throws Exception;
	
	
	
	/**
	 *  downloadFile ( 공통 - 파일다운로드  ) 
	 *	2018.12.31 LJG  
	 */
	List<Map<String, Object>> downloadFile(Map<String, Object> map) throws Exception;
	
	
	
	/**
	 *  adminCheck ( 공통 - 관리자 로그인  ) 
	 *	2018.12.31 LJG  
	 */
	List<Map<String, Object>> adminCheck(Map<String, Object> map) throws Exception;
	
	/**
	 *  adminInfo ( 공통 - 관리자 정보  ) 
	 *	2018.12.31 LJG  
	 */
	List<Map<String, Object>> adminInfo(Map<String, Object> map) throws Exception;
}
