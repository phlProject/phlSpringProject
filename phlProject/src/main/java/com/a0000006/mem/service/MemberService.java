package com.a0000006.mem.service;

import java.util.List;
import java.util.Map;

import com.phl.common.CommandMap;

public interface MemberService {

	/* 로그인(ID,PW CHECK) */
	List<Map<String, Object>> idPwCheck(Map<String, Object> map) throws Exception;
	
	/* 로그인 정보 */
	List<Map<String, Object>> loginInfo(Map<String, Object> map) throws Exception;
	
	/* 마이페이지 */
	List<CommandMap> memMyPage(Map<String, Object> map) throws Exception;
	
	/* 회원 등록 */
	String insertMemRegist(Map<String, Object> map) throws Exception;

	/* 마이페이지 수정 */
	String updateMemRegist(Map<String, Object> map) throws Exception;
	
	/* 회원탈퇴 */
	String deleteMemRegist(Map<String, Object> map) throws Exception;
	
	/* 아이디 중복체크 */
	public int idDupChk(Map<String, Object> map) throws Exception;
	
}