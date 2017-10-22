package com.a0000006.network.service;

import java.util.List;
import java.util.Map;

public interface NetworkService {

	/* 네트워크게시판 > 조회 > Count */
	int networkBoardListCnt(Map<String, Object> map) throws Exception;
	
	/* 네트워크게시판 > 조회 */
	List<Map<String, Object>> networkBoardList(Map<String, Object> map) throws Exception;
	
	/* 네트워크게시판 > 상세 폼 */
	List<Map<String, Object>> networkBoardView(Map<String, Object> map) throws Exception;
	
	/* 네트워크게시판 > 등록 */
	int insertNetworkBoard(Map<String, Object> map) throws Exception;
	
	/* 네트워크게시판 > 수정 */
	String updateNetworkBoard(Map<String, Object> map) throws Exception;
	
	/* 네트워크게시판 > 삭제 */
	String deleteNetworkBoard(Map<String, Object> map) throws Exception;
	
}
