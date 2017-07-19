package com.a0000006.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	
	
	/*********************************************************************/
	/****************************** 책 소 개 시작  ******************************/
	
	/* 책소개 > 조회 > Count */
	int bookListCnt(Map<String, Object> map) throws Exception;
	
	/* 책소개 > 조회 */
	List<Map<String, Object>> bookList(Map<String, Object> map) throws Exception;
	
	/* 책소개 > 상세 폼 */
	List<Map<String, Object>> bookView(Map<String, Object> map) throws Exception;
	
	/* 책소개  > 등록 */
	int insertBook(Map<String, Object> map) throws Exception;
	
	/* 책소개 > 등록(상세) */
	void insertBookDetail(Map<String, Object> map) throws Exception;
	
	/* 책소개  > 수정 */
	String updateBook(Map<String, Object> map) throws Exception;
	
	/* 책소개  > 삭제 */
	String deleteBook(Map<String, Object> map) throws Exception;
	
	/* 책소개  > 좋아요 COunt */
	String bookLikeCount(Map<String, Object> map) throws Exception;
	
	/* 책소개  > 좋아요 등록/수정  */
	String bookLikeHistory(Map<String, Object> map) throws Exception;
	
	/****************************** 책 소 개 종료  ******************************/
	/*********************************************************************/
	
	
	/*********************************************************************/
	/********************** 자 료 공 통 시작 (교육, 정책, 기타 ) **********************/
	
	/* 자료공통 > 조회 > Count */
	int dataListCnt(Map<String, Object> map) throws Exception;
	
	/* 자료공통 > 조회 */
	List<Map<String, Object>> dataList(Map<String, Object> map) throws Exception;
	
	/* 자료공통 > 상세 폼 */
	List<Map<String, Object>> dataView(Map<String, Object> map) throws Exception;
	
	/* 자료공통 > 등록 */
	int insertData(Map<String, Object> map) throws Exception;

	/* 자료공통 > 수정 */
	String updateData(Map<String, Object> map) throws Exception;
	
	/* 자료공통 > 삭제 */
	String deleteData(Map<String, Object> map) throws Exception;
	
	/********************** 자 료 공 통 종료 (교육, 정책, 기타 ) **********************/
	/*********************************************************************/
	
	
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
	
	
	/*********************************************************************/
	/****************************** 게시판 공통 시작  ******************************/
	
	/* 게시판 공통 > 파일 등록 ( 'file' / 'image' ) */
	String insertBoardAttach(Map<String, Object> map, String attach) throws Exception;
	
	/* 게시판 공통 > 파일 수정 ( 'file' / 'image' ) */
	String updateBoardAttach(Map<String, Object> map, String attach) throws Exception;
	
	/* 게시판 공통 > 파일다운로드 > 조회 */
	List<Map<String, Object>> boardFlList(Map<String, Object> map) throws Exception;
	
	/****************************** 게시판 공통 종료  ******************************/
	/*********************************************************************/
	
	
}
