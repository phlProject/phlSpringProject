package com.phl.common.service;

import java.util.List;
import java.util.Map;

import com.phl.common.CommandMap;

public interface PhlCommService {
	
	/* 공통코드 */
	List<CommandMap> selectCommCode(Map<String, Object> map) throws Exception;
	
	String selectCommCodeOne(Map<String, Object> map) throws Exception;
	
	/* 메뉴조회 (2dept) */
	List<CommandMap> menuListDept2(Map<String, Object> map) throws Exception;
	
	/* 메뉴조회 (3dept) */
	List<CommandMap> menuListDept3(Map<String, Object> map) throws Exception;
	
	
	
	
	
	/* 게시판 이전 다음 페이지 번호 */
	String selectBoardSn(Map<String, Object> map) throws Exception;
	
	
	/**
	 *  boardHitCount ( 공통 - 게시판 조회수 증가  ) 
	 *	2018.12.31 LJG  
	 */
	void boardHitCount(Map<String, Object> map) throws Exception;
	
	/**
	 *  boardListCount ( 공통 - 게시판 카운트  ) 
	 *	2018.12.31 LJG  
	 */
	int boardListCount(Map<String, Object> map) throws Exception;
	
	/**
	 *  boardList ( 공통 - 기본 게시판 조회  ) 
	 *	2018.12.31 LJG  
	 */
	List<Map<String, Object>> boardList(Map<String, Object> map) throws Exception;
	
	/**
	 *  boardView ( 공통 - 기본 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	Map<String, Object> boardView(Map<String, Object> map) throws Exception;
	
	/**
	 *  insertBoard ( 공통 - 기본 게시판 등록  ) 
	 *	2018.12.31 LJG  
	 */
	int insertBoard(Map<String, Object> map) throws Exception;
	
	/**
	 *  updateBoard ( 공통 - 기본 게시판 수정  ) 
	 *	2018.12.31 LJG  
	 */
	String updateBoard(Map<String, Object> map) throws Exception;
	
	/**
	 *  deleteBoard ( 공통 - 기본 게시판 삭제  ) 
	 *	2018.12.31 LJG  
	 */
	String deleteBoard(Map<String, Object> map) throws Exception;
	
	
	
	/**
	 *  atchBoardList ( 공통 - 첨부 게시판 조회  ) 
	 *	2018.12.31 LJG  
	 */
	List<Map<String, Object>> atchBoardList(Map<String, Object> map) throws Exception;
	
	/**
	 *  atchBoardView ( 공통 - 첨부 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	Map<String, Object> atchBoardView(Map<String, Object> map) throws Exception;
	
	/**
	 *  insertBoardAtch ( 공통 - 첨부 파일 등록  ) 
	 *	2018.12.31 LJG  
	 */
	String insertBoardAtch(Map<String, Object> map) throws Exception;
	
	/**
	 *  updateBoardAtch ( 공통 - 첨부 파일 수정  ) 
	 *	2018.12.31 LJG  
	 */
	String updateBoardAtch(Map<String, Object> map) throws Exception;
	
	/**
	 *  deleteBoardAtch ( 공통 - 첨부 파일 삭제  ) 
	 *	2018.12.31 LJG  
	 */
}
