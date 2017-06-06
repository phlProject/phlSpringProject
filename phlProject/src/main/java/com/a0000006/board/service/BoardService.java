package com.a0000006.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

	/****************************** 책 소 개 시작  ******************************/
	
	/* 책소개 > 조회 > Count */
	int bookListCnt(Map<String, Object> map) throws Exception;
	
	/* 책소개 > 조회 */
	List<Map<String, Object>> bookList(Map<String, Object> map) throws Exception;
	
	/* 책소개 > 상세 폼 */
	List<Map<String, Object>> bookView(Map<String, Object> map) throws Exception;
	
	/* 책소개  > 등록 */
	int insertBook(Map<String, Object> map) throws Exception;
	
	/* 책소개  > 수정 */
	String updateBook(Map<String, Object> map) throws Exception;
	
	/* 책소개  > 삭제 */
	String deleteBook(Map<String, Object> map) throws Exception;
	
	/* 책소개  > 좋아요 COunt */
	String bookLikeCount(Map<String, Object> map) throws Exception;
	
	/* 책소개  > 좋아요 등록/수정  */
	String bookLikeHistory(Map<String, Object> map) throws Exception;
	
	/****************************** 책 소 개 종료  ******************************/
	
	/****************************** 간 행 물 시작  ******************************/
	
	/* 간행물 > 조회 > Count */
	int publiListCnt(Map<String, Object> map) throws Exception;
	
	/* 간행물 > 조회 */
	List<Map<String, Object>> publiList(Map<String, Object> map) throws Exception;
	
	/* 간행물 > 상세 폼 */
	List<Map<String, Object>> publiView(Map<String, Object> map) throws Exception;
	
	/* 간행물 > 등록 */
	int insertPubli(Map<String, Object> map) throws Exception;

	/* 간행물 > 수정 */
	String updatePubli(Map<String, Object> map) throws Exception;
	
	/* 간행물 > 삭제 */
	String deletePubli(Map<String, Object> map) throws Exception;
	
	/****************************** 간 행 물 종료  ******************************/
	
	/****************************** 게시판 공통 시작  ******************************/
	
	/* 게시판 공통 > 파일 등록 */
	String insertBoardFl(Map<String, Object> map) throws Exception;
	
	/* 게시판 공통 > 파일 수정 */
	String updateBoardFl(Map<String, Object> map) throws Exception;
	
	/* 게시판 공통 > 파일다운로드 > 조회 */
	List<Map<String, Object>> boardFlList(Map<String, Object> map) throws Exception;
	
	/****************************** 게시판 공통 종료  ******************************/
	

	/* 신청 > 기관탐방 > 탐방 조회  Count*/
	int visitListCnt(Map<String, Object> map) throws Exception;
	
	/* 신청 > 기관탐방 > 탐방 조회 */
	List<Map<String, Object>> visitList(Map<String, Object> map) throws Exception;
}
