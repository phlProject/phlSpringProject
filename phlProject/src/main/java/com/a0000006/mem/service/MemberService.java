package com.a0000006.mem.service;

import java.util.List;
import java.util.Map;

public interface MemberService {

	/* 로그인(ID,PW CHECK) */
	List<Map<String, Object>> idPwCheck(Map<String, Object> map) throws Exception;
	
	/* 로그인 정보 */
	List<Map<String, Object>> loginInfo(Map<String, Object> map) throws Exception;
	
	/* 마이페이지 */
	List<Map<String, Object>> memMyPage(Map<String, Object> map) throws Exception;
	
	/* 회원 등록 */
	void insertMemRegist(Map<String, Object> map) throws Exception;

	/* 아이디 중복체크 */
	public int idDupChk(Map<String, Object> map) throws Exception;
	
	/* 회원리스트 */
	List<Map<String, Object>> selectMemList(Map<String, Object> map) throws Exception;
	
}