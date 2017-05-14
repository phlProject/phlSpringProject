package com.a0000006.apply.service;

import java.util.List;
import java.util.Map;

import com.phl.common.CommandMap;


public interface ApplyService {

	// 스케줄 목록
	List<CommandMap> applyList(Map<String, Object> map) throws Exception;

	// 신청 등록
	String insertApply(Map<String, Object> map) throws Exception;

	// 상세 페이지
	Map<String, Object> viewApply(Map<String, Object> map) throws Exception;

	// 수정
	String updateApply(Map<String, Object> map) throws Exception;

	// 삭제
	String deleteApply(Map<String, Object> map) throws Exception;

}
