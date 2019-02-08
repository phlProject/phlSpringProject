package com.phl.common.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.phl.common.dao.PhlBoardDAO;

@Service("phlBoardService")
public class PhlBoardServiceImpl implements PhlBoardService {

Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="phlBoardDAO")
	private PhlBoardDAO phlBoardDAO;
	
	/**
	 *  moveBoardPage ( 공통 - 이전 다음 페이지 이동  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public String moveBoardPage(Map<String, Object> map) throws Exception {
		return phlBoardDAO.moveBoardPage(map);
	}
	
	/**
	 *  boardHitCount ( 공통 - 게시판 조회수 증가  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public void boardHitCount(Map<String, Object> map) throws Exception {
		phlBoardDAO.boardHitCount(map);
	}
	
	/**
	 *  boardListCount ( 공통 - 게시판 카운트  ) 
	 *	2018.12.31 LJG  
	 */
	public int boardListCount(Map<String, Object> map) throws Exception {
        return phlBoardDAO.boardListCount(map);
    }
	
	/**
	 *  boardList ( 공통 - 기본 게시판 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> boardList(Map<String, Object> map) throws Exception {
        return phlBoardDAO.boardList(map);
    }
	
	/**
	 *  boardView ( 공통 - 기본 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> boardView(Map<String, Object> map) throws Exception {
        return phlBoardDAO.boardView(map);
    }
	
	/**
	 *  boardReplyList ( 공통 - 게시판 댓글 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> boardReplyList(Map<String, Object> map) throws Exception {
        return phlBoardDAO.boardReplyList(map);
    }
	
	/**
	 *  insertBoard ( 공통 - 기본 게시판 등록  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public int insertBoard(Map<String, Object> map) throws Exception {
		try 
		{
			phlBoardDAO.insertBoard(map);
			
			// 게시판 공통 > 일련번호 조회
			int boardSn = phlBoardDAO.selectBoardSn();
			
			return boardSn;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 *  updateBoard ( 공통 - 기본 게시판 수정  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public String updateBoard(Map<String, Object> map) throws Exception {
		try 
		{
			phlBoardDAO.updateBoard(map);
			return "success";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "fail";
		}
	}
	
	/**
	 *  deleteBoard ( 공통 - 기본 게시판 삭제  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public String deleteBoard(Map<String, Object> map) throws Exception {
		try 
		{
			phlBoardDAO.deleteBoard(map);
			return "success";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "fail";
		}
	}
	
	
	/**
	 *  boardNonMemList ( 공통 - 비회원 게시판 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> boardNonMemList(Map<String, Object> map) throws Exception {
        return phlBoardDAO.boardNonMemList(map);
    }
	
	/**
	 *  boardNonMemView ( 공통 - 비회원 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> boardNonMemView(Map<String, Object> map) throws Exception {
        return phlBoardDAO.boardNonMemView(map);
    }
	
	/**
	 *  boardPwdCheck ( 공통 - 비회원 게시판 비밀번호 확인  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> boardPwdCheck(Map<String, Object> map) throws Exception {
        return phlBoardDAO.boardPwdCheck(map);
    }
	
	/**
	 *  insertBoardNonMem ( 공통 - 비회원 게시판 등록  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public int insertBoardNonMem(Map<String, Object> map) throws Exception {
		try 
		{
			phlBoardDAO.insertBoard(map);
			
			// 게시판 공통 > 일련번호 조회
			int boardSn = phlBoardDAO.selectBoardSn();
			
			return boardSn;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 *  insertBoardNonMemDetail ( 공통 - 비회원 게시판 상세정보 등록  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public void insertBoardNonMemDetail(Map<String, Object> map) throws Exception {
		try {
			phlBoardDAO.insertBoardNonMemDetail(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  updateBoardNonMem ( 공통 - 비회원 게시판 수정  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public String updateBoardNonMem(Map<String, Object> map) throws Exception {
		try 
		{
			phlBoardDAO.updateBoard(map);
			return "success";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "fail";
		}
	}
	
	/**
	 *  deleteBoardNonMem ( 공통 - 비회원 게시판 삭제  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public String deleteBoardNonMem(Map<String, Object> map) throws Exception {
		try 
		{
			phlBoardDAO.deleteBoard(map);
			return "success";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "fail";
		}
	}
	
	
	
	
	/**
	 *  atchBoardList ( 공통 - 첨부 게시판 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> atchBoardList(Map<String, Object> map) throws Exception {
		
		List<Map<String, Object>> atchBoardList = phlBoardDAO.atchBoardList(map);
		
        return atchBoardList;
    }
	
	/**
	 *  atchBoardView ( 공통 - 첨부 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> atchBoardView(Map<String, Object> map) throws Exception {
        return phlBoardDAO.atchBoardView(map);
    }
	
	/**
	 *  insertBoardAtch ( 공통 - 첨부 파일 등록  ) 
	 *	2018.12.31 LJG  
	 */
	public String insertBoardAtch(Map<String, Object> map) throws Exception {
		try 
		{
			phlBoardDAO.insertBoardAtch(map);
			return "success";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "fail";
		}
	}
	
	/**
	 *  updateBoardAtch ( 공통 - 첨부 파일 수정  ) 
	 *	2018.12.31 LJG  
	 */
	public String updateBoardAtch(Map<String, Object> map) throws Exception {
		try 
		{
			phlBoardDAO.updateBoardAtch(map);
			return "success";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "fail";
		}
	}
	
	/**
	 *  deleteBoardAtch ( 공통 - 첨부 파일 삭제  ) 
	 *	2018.12.31 LJG  
	 */
	
	
	/**
	 *  saveBoardReply ( 공통 - 게시판 댓글 등록/수정/삭제 ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public String saveBoardReply(Map<String, Object> map) throws Exception {
		try {
				if(map.get("boardReType").equals("insert"))
				{
					phlBoardDAO.insertBoardReply(map);
				}
				else if(map.get("boardReType").equals("update"))
				{
					phlBoardDAO.updateBoardReply(map);
				}
				else if(map.get("boardReType").equals("delete"))
				{
					phlBoardDAO.deleteBoardReply(map);
				}
				
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
}
