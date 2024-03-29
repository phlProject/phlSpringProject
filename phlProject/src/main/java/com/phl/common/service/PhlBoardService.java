package com.phl.common.service;

import java.util.List;
import java.util.Map;

public interface PhlBoardService {

	/**
	 *  moveBoardPage ( 공통 - 이전 다음 페이지 이동  ) 
	 *	2018.12.31 LJG  
	 */
	String moveBoardPage(Map<String, Object> map) throws Exception;
	
	
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
	List<Map<String, Object>> boardView(Map<String, Object> map) throws Exception;
	
	/**
	 *  boardReplyList ( 공통 - 게시판 댓글 조회  ) 
	 *	2018.12.31 LJG  
	 */
	List<Map<String, Object>> boardReplyList(Map<String, Object> map) throws Exception;
	
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
	 *  boardNonMemList ( 공통 - 비회원 게시판 조회  ) 
	 *	2018.12.31 LJG  
	 */
	List<Map<String, Object>> boardNonMemList(Map<String, Object> map) throws Exception;
	
	/**
	 *  boardNonMemView ( 공통 - 비회원 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	List<Map<String, Object>> boardNonMemView(Map<String, Object> map) throws Exception;
	
	/**
	 *  boardPwdCheck ( 공통 - 비회원 게시판 비밀번호 확인  ) 
	 *	2018.12.31 LJG  
	 */
	List<Map<String, Object>> boardPwdCheck(Map<String, Object> map) throws Exception;
	
	
	
	/**
	 *  insertBoardNonMem ( 공통 - 비회원 게시판 등록  ) 
	 *	2018.12.31 LJG  
	 */
	int insertBoardNonMem(Map<String, Object> map) throws Exception;
	
	
	/**
	 *  insertBoardNonMemDetail ( 공통 - 비회원 게시판 상세정보 등록  ) 
	 *	2018.12.31 LJG  
	 */
	void insertBoardNonMemDetail(Map<String, Object> map) throws Exception;
	
	/**
	 *  updateBoardNonMem ( 공통 - 비회원 게시판 수정  ) 
	 *	2018.12.31 LJG  
	 */
	String updateBoardNonMem(Map<String, Object> map) throws Exception;
	
	/**
	 *  deleteBoardNonMem ( 공통 - 비회원 게시판 삭제  ) 
	 *	2018.12.31 LJG  
	 */
	String deleteBoardNonMem(Map<String, Object> map) throws Exception;
	
	
	
	
	/**
	 *  atchBoardList ( 공통 - 첨부 게시판 조회  ) 
	 *	2018.12.31 LJG  
	 */
	List<Map<String, Object>> atchBoardList(Map<String, Object> map) throws Exception;
	
	/**
	 *  atchBoardView ( 공통 - 첨부 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	List<Map<String, Object>> atchBoardView(Map<String, Object> map) throws Exception;
	
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
	
	/**
	 *  saveBoardReply ( 공통 - 게시판 댓글 등록/수정/삭제 ) 
	 *	2018.12.31 LJG  
	 */
	String saveBoardReply(Map<String, Object> map) throws Exception;
	
}
