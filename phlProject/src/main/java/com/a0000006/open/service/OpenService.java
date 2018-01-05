package com.a0000006.open.service;

import java.util.List;
import java.util.Map;

import com.phl.common.CommandMap;

public interface OpenService {
	
	
	/*********************************************************************/
	/****************************** 일   정  시작  ******************************/
	
	// 일정 - 리스트
	List<CommandMap> scheduleList(Map<String, Object> map) throws Exception;

	// 일정 - 등록
	String insertSchedule(Map<String, Object> map) throws Exception;

	// 일정 - 상세
	Map<String, Object> viewSchedule(Map<String, Object> map) throws Exception;

	// 일정 - 수정
	String updateSchedule(Map<String, Object> map) throws Exception;

	// 일정 - 삭제
	String deleteSchedule(Map<String, Object> map) throws Exception;

	// 일정 - 기간 별 일정 ( 오늘 / 이번 주 / 이번 달 )
	List<CommandMap> selectPeriodSchedule(Map<String, Object> map) throws Exception;
	
	
	/****************************** 일   정  종료  ******************************/
	/*********************************************************************/
	
	
	/*********************************************************************/
	/***************************** 자유게시판  시작  *****************************/
	
	/* 자유게시판 > 조회 > Count */
	int freeBoardListCnt(Map<String, Object> map) throws Exception;
	
	/* 자유게시판 > 조회 */
	List<Map<String, Object>> freeBoardList(Map<String, Object> map) throws Exception;
	
	/* 자유게시판 > 상세 폼 */
	List<Map<String, Object>> freeBoardView(Map<String, Object> map) throws Exception;
	
	/* 자유게시판 > 등록 */
	int insertFreeBoard(Map<String, Object> map) throws Exception;
	
	/* 자유게시판 > 수정 */
	String updateFreeBoard(Map<String, Object> map) throws Exception;
	
	/* 자유게시판 > 삭제 */
	String deleteFreeBoard(Map<String, Object> map) throws Exception;
	
	/***************************** 자유게시판  종료  *****************************/
	/*********************************************************************/

}
