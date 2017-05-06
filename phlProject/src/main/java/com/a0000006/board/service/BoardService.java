package com.a0000006.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

	/* 책소개 리스트 */
	List<Map<String, Object>> selectbookList(Map<String, Object> map) throws Exception;
	
	int selectbookListCnt(Map<String, Object> map) throws Exception;
	
	/* 책소개  등록 */
	String insertBook(Map<String, Object> map) throws Exception;
	
	void insertBookFl(Map<String, Object> map) throws Exception;
	
	/* 책소개 상세 */
	List<Map<String, Object>> selectbookView(Map<String, Object> map) throws Exception;
}
