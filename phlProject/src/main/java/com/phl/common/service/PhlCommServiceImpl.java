package com.phl.common.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.phl.common.CommandMap;
import com.phl.common.dao.PhlCommDAO;

@Service("phlCommService")
public class PhlCommServiceImpl implements PhlCommService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="phlCommDAO")
	private PhlCommDAO phlCommDAO;
	
	/* 공통코드 */
	@Override
    public List<CommandMap> selectCommCode(Map<String, Object> map) throws Exception {
        return phlCommDAO.selectCommCode(map);
    }
	
	@Override
    public String selectCommCodeOne(Map<String, Object> map) throws Exception {
        return phlCommDAO.selectCommCodeOne(map);
    }
	
	/* 메뉴조회 (2dept) */
	@Override
    public List<CommandMap> menuListDept2(Map<String, Object> map) throws Exception {
        return phlCommDAO.menuListDept2(map);
    }
	
	/* 메뉴조회 (3dept) */
	@Override
    public List<CommandMap> menuListDept3(Map<String, Object> map) throws Exception {
        return phlCommDAO.menuListDept3(map);
    }
	
	
	/**
	 *  adminCheck ( 공통 - 관리자 로그인  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> adminCheck(Map<String, Object> map) throws Exception {
        return phlCommDAO.adminCheck(map);
    }
	
	/**
	 *  adminInfo ( 공통 - 관리자 정보  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> adminInfo(Map<String, Object> map) throws Exception {
        return phlCommDAO.adminInfo(map);
    }
	
	/**
	 *  moveBoardPage ( 공통 - 이전 다음 페이지 이동  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public String moveBoardPage(Map<String, Object> map) throws Exception {
		return phlCommDAO.moveBoardPage(map);
	}
	
	/**
	 *  boardHitCount ( 공통 - 게시판 조회수 증가  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public void boardHitCount(Map<String, Object> map) throws Exception {
		phlCommDAO.boardHitCount(map);
	}
	
	/**
	 *  boardListCount ( 공통 - 게시판 카운트  ) 
	 *	2018.12.31 LJG  
	 */
	public int boardListCount(Map<String, Object> map) throws Exception {
        return phlCommDAO.boardListCount(map);
    }
	
	/**
	 *  boardList ( 공통 - 기본 게시판 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> boardList(Map<String, Object> map) throws Exception {
        return phlCommDAO.boardList(map);
    }
	
	/**
	 *  boardView ( 공통 - 기본 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> boardView(Map<String, Object> map) throws Exception {
        return phlCommDAO.boardView(map);
    }
	
	/**
	 *  boardReplyList ( 공통 - 게시판 댓글 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> boardReplyList(Map<String, Object> map) throws Exception {
        return phlCommDAO.boardReplyList(map);
    }
	
	/**
	 *  insertBoard ( 공통 - 기본 게시판 등록  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public int insertBoard(Map<String, Object> map) throws Exception {
		try 
		{
			phlCommDAO.insertBoard(map);
			
			// 게시판 공통 > 일련번호 조회
			int boardSn = phlCommDAO.selectBoardSn();
			
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
			phlCommDAO.updateBoard(map);
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
			phlCommDAO.deleteBoard(map);
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
        return phlCommDAO.boardNonMemList(map);
    }
	
	/**
	 *  boardNonMemView ( 공통 - 비회원 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> boardNonMemView(Map<String, Object> map) throws Exception {
        return phlCommDAO.boardNonMemView(map);
    }
	
	/**
	 *  boardPwdCheck ( 공통 - 비회원 게시판 비밀번호 확인  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> boardPwdCheck(Map<String, Object> map) throws Exception {
        return phlCommDAO.boardPwdCheck(map);
    }
	
	/**
	 *  insertBoardNonMem ( 공통 - 비회원 게시판 등록  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
	public int insertBoardNonMem(Map<String, Object> map) throws Exception {
		try 
		{
			phlCommDAO.insertBoard(map);
			
			// 게시판 공통 > 일련번호 조회
			int boardSn = phlCommDAO.selectBoardSn();
			
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
			phlCommDAO.insertBoardNonMemDetail(map);
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
			phlCommDAO.updateBoard(map);
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
			phlCommDAO.deleteBoard(map);
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
		
		List<Map<String, Object>> atchBoardList = phlCommDAO.atchBoardList(map);
		
        return atchBoardList;
    }
	
	/**
	 *  atchBoardView ( 공통 - 첨부 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> atchBoardView(Map<String, Object> map) throws Exception {
        return phlCommDAO.atchBoardView(map);
    }
	
	/**
	 *  insertBoardAtch ( 공통 - 첨부 파일 등록  ) 
	 *	2018.12.31 LJG  
	 */
	public String insertBoardAtch(Map<String, Object> map) throws Exception {
		try 
		{
			phlCommDAO.insertBoardAtch(map);
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
			phlCommDAO.updateBoardAtch(map);
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
					phlCommDAO.insertBoardReply(map);
				}
				else if(map.get("boardReType").equals("update"))
				{
					phlCommDAO.updateBoardReply(map);
				}
				else if(map.get("boardReType").equals("delete"))
				{
					phlCommDAO.deleteBoardReply(map);
				}
				
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	
}	
