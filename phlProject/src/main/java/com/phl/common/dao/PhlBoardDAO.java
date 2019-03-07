package com.phl.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.dao.AbstractDAO;

@Repository("phlBoardDAO")
public class PhlBoardDAO extends AbstractDAO {

	/**
	 *  moveBoardPage ( 공통 - 이전 다음 페이지 이동  ) 
	 *	2018.12.31 LJG  
	 */
	public String moveBoardPage(Map<String, Object> map) throws Exception{
        return (String) selectOne("phl/board.moveBoardPage", map);
    }
	
	/**
	 *  boardHitCount ( 공통 - 게시판 조회수 증가  ) 
	 *	2018.12.31 LJG  
	 */
	public void boardHitCount(Map<String, Object> map) throws Exception{
        update("phl/board.boardHitCount", map);
    }
	
	/**
	 *  boardListCount ( 공통 - 게시판 카운트  ) 
	 *	2018.12.31 LJG  
	 */
	public int boardListCount(Map<String, Object> map) throws Exception{
        return (Integer) selectOne("phl/board.boardListCount", map);
    }
	
	/**
	 *  boardList ( 공통 - 기본 게시판 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> boardList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/board.boardList", map);
    }
	
	/**
	 *  boardView ( 공통 - 기본 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> boardView(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/board.boardView", map);
    }
	
	/**
	 *  boardReplyList ( 공통 - 게시판 댓글 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> boardReplyList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/board.boardReplyList", map);
    }
	
	/**
	 *  selectBoardSn ( 공통 - 일련번호 조회  ) 
	 *	2018.12.31 LJG  
	 */
	public int selectBoardSn() throws Exception{
	    return (Integer) selectOne("phl/board.selectBoardSn");
	}
	
	/**
	 *  insertBoard ( 공통 - 기본 게시판 등록  ) 
	 *	2018.12.31 LJG  
	 */
	public void insertBoard(Map<String, Object> map) throws Exception{
	    insert("phl/board.insertBoard", map);
	}
	
	/**
	 *  updateBoard ( 공통 - 기본 게시판 수정  ) 
	 *	2018.12.31 LJG  
	 */
	public void updateBoard(Map<String, Object> map) throws Exception{
	    update("phl/board.updateBoard", map);
	}
	
	/**
	 *  deleteBoard ( 공통 - 기본 게시판 삭제  ) 
	 *	2018.12.31 LJG  
	 */
	public void deleteBoard(Map<String, Object> map) throws Exception{
	    update("phl/board.deleteBoard", map);
	}
	
	
	/**
	 *  boardNonMemList ( 공통 - 비회원 게시판 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> boardNonMemList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/board.boardNonMemList", map);
    }
	
	/**
	 *  boardPwdCheck ( 공통 - 비회원 게시판 비밀번호 확인  )
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> boardPwdCheck(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/board.boardPwdCheck", map);
    }
	
	/**
	 *  boardNonMemView ( 공통 - 비회원 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> boardNonMemView(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/board.boardNonMemView", map);
    }
	
	/**
	 *  insertBoardNonMemDetail ( 공통 - 비회원 게시판 상세정보 등록  ) 
	 *	2018.12.31 LJG  
	 */
	public void insertBoardNonMemDetail(Map<String, Object> map) throws Exception{
	    insert("phl/board.insertBoardNonMemDetail", map);
	}
	
	/**
	 *  updateBoardNonMemDetail ( 공통 - 비회원 게시판 상세정보 수정  ) 
	 *	2018.12.31 LJG  
	 */
	public void updateBoardNonMemDetail(Map<String, Object> map) throws Exception{
	    update("phl/board.updateBoardNonMemDetail", map);
	}
	
	
	/**
	 *  atchBoardList ( 공통 - 첨부 게시판 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> atchBoardList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/board.atchBoardList", map);
    }
	
	/**
	 *  boardView ( 공통 - 첨부 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> atchBoardView(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/board.atchBoardView", map);
    }
	
	/**
	 *  insertBoardAtch ( 공통 - 첨부 파일 등록  ) 
	 *	2018.12.31 LJG  
	 */
	public void insertBoardAtch(Map<String, Object> map) throws Exception{
	    insert("phl/board.insertBoardAtch", map);
	}
	
	/**
	 *  updateBoardAtch ( 공통 - 첨부 파일 수정  ) 
	 *	2018.12.31 LJG  
	 */
	public void updateBoardAtch(Map<String, Object> map) throws Exception{
	    insert("phl/board.updateBoardAtch", map);
	}
	
	/**
	 *  deleteBoardAtch ( 공통 - 첨부 파일 삭제  ) 
	 *	2018.12.31 LJG  
	 */
	
	
	
	/**
	 *  insertBoardReply ( 공통 - 게시판 댓글 등록 ) 
	 *	2018.12.31 LJG  
	 */
	public void insertBoardReply(Map<String, Object> map) throws Exception{
		update("phl/board.insertBoardReply", map);
	}
	
	/**
	 *  updateBoardReply ( 공통 - 게시판 댓글 수정 ) 
	 *	2018.12.31 LJG  
	 */
	public void updateBoardReply(Map<String, Object> map) throws Exception{
		update("phl/board.updateBoardReply", map);
	}
	
	/**
	 *  deleteBoardReply ( 공통 - 게시판 댓글 삭제 ) 
	 *	2018.12.31 LJG  
	 */
	public void deleteBoardReply(Map<String, Object> map) throws Exception{
		update("phl/board.deleteBoardReply", map);
	}
}
