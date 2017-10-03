package com.a0000006.manage.service;

import java.util.List;
import java.util.Map;

public interface ManageService {

	/* 회원리스트 Count */
	int memListCnt(Map<String, Object> map) throws Exception;
	
	/* 회원리스트 */
	List<Map<String, Object>> memList(Map<String, Object> map) throws Exception;
	
	/* 활성화/비활성화 수정 */
	String memActiveYn(Map<String, Object> map) throws Exception;
	
	/* 권한 승인/해제 수정 */
	String memAuthorYn(Map<String, Object> map) throws Exception;
}
