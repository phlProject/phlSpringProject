package com.a0000006.teacher.service;

import java.util.List;
import java.util.Map;

public interface TeacherService {

	/* 참여게시판 > 조회 > Count */
	int joinListCnt(Map<String, Object> map) throws Exception;
	
	/* 참여게시판 > 조회 */
	List<Map<String, Object>> joinList(Map<String, Object> map) throws Exception;
	
	/* 참여게시판 > 상세 폼 */
	List<Map<String, Object>> joinView(Map<String, Object> map) throws Exception;
	
	/* 참여게시판 > 등록 */
	int insertJoin(Map<String, Object> map) throws Exception;
	
	/* 참여게시판 > 수정 */
	String updateJoin(Map<String, Object> map) throws Exception;
	
	/* 참여게시판 > 삭제 */
	String deleteJoin(Map<String, Object> map) throws Exception;
	
	/* 참여게시판 > 댓글 조회 */
	List<Map<String, Object>> joinReList(Map<String, Object> map) throws Exception;
	
	/* 참여게시판  > 댓글 등록/수정/삭제 */
	String saveJoinRe(Map<String, Object> map) throws Exception;
}
