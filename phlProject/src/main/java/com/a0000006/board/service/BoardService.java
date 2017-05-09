package com.a0000006.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

	/* 책소개 > 조회 > Count */
	int bookListCnt(Map<String, Object> map) throws Exception;
	
	/* 책소개 > 조회 */
	List<Map<String, Object>> bookList(Map<String, Object> map) throws Exception;
	
	/* 책소개 > 상세 */
	List<Map<String, Object>> bookView(Map<String, Object> map) throws Exception;
	
	/* 책소개  > 등록 */
	int insertBook(Map<String, Object> map) throws Exception;
	
	/* 게시판 > 파일 등록 */
	void insertBoardFl(Map<String, Object> map) throws Exception;
	
	
}
