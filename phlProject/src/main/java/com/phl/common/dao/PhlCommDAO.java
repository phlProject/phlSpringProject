package com.phl.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.common.CommandMap;
import com.phl.dao.AbstractDAO;

@Repository("phlCommDAO")
public class PhlCommDAO extends AbstractDAO {

	/* 공통코드 */
	@SuppressWarnings("unchecked")
    public List<CommandMap> selectCommCode(Map<String, Object> map) throws Exception{
        return (List<CommandMap>)selectList("phl/common.selectCommCode", map);
    }
	
	@SuppressWarnings("unchecked")
    public String selectCommCodeOne(Map<String, Object> map) throws Exception{
		return (String) selectOne("phl/common.selectCommCodeOne", map);
    }
	
	/* 메뉴조회 (2dept) */
	@SuppressWarnings("unchecked")
    public List<CommandMap> menuListDept2(Map<String, Object> map) throws Exception{
        return (List<CommandMap>)selectList("phl/common.menuListDept2", map);
    }
	
	/* 메뉴조회 (3dept) */
	@SuppressWarnings("unchecked")
    public List<CommandMap> menuListDept3(Map<String, Object> map) throws Exception{
        return (List<CommandMap>)selectList("phl/common.menuListDept3", map);
    }
	
	/* 게시판 이전 다음 페이지 번호 */
	public String selectBoardSn(Map<String, Object> map) throws Exception{
        return (String) selectOne("phl/common.selectBoardSn", map);
    }
	
	
	/**
	 *  boardHitCount ( 공통 - 게시판 조회수 증가  ) 
	 *	2018.12.31 LJG  
	 */
	public void boardHitCount(Map<String, Object> map) throws Exception{
        update("phl/common.boardHitCount", map);
    }
	
	/**
	 *  boardListCount ( 공통 - 게시판 카운트  ) 
	 *	2018.12.31 LJG  
	 */
	public int boardListCount(Map<String, Object> map) throws Exception{
        return (Integer) selectOne("phl/common.boardListCount", map);
    }
	
	/**
	 *  boardList ( 공통 - 기본 게시판 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> boardList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/common.boardList", map);
    }
	
	/**
	 *  boardView ( 공통 - 기본 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public Map<String, Object> boardView(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectList("phl/common.boardView", map);
    }
	
	/**
	 *  selectBoardSn ( 공통 - 일련번호 조회  ) 
	 *	2018.12.31 LJG  
	 */
	public int selectBoardSn() throws Exception{
	    return (Integer) selectOne("phl/common.selectBoardSn");
	}
	
	/**
	 *  insertBoard ( 공통 - 기본 게시판 등록  ) 
	 *	2018.12.31 LJG  
	 */
	public void insertBoard(Map<String, Object> map) throws Exception{
	    insert("phl/common.insertBoard", map);
	}
	
	/**
	 *  updateBoard ( 공통 - 기본 게시판 수정  ) 
	 *	2018.12.31 LJG  
	 */
	public void updateBoard(Map<String, Object> map) throws Exception{
	    update("phl/common.updateBoard", map);
	}
	
	/**
	 *  deleteBoard ( 공통 - 기본 게시판 삭제  ) 
	 *	2018.12.31 LJG  
	 */
	public void deleteBoard(Map<String, Object> map) throws Exception{
	    update("phl/common.deleteBoard", map);
	}
	
	
	
	/**
	 *  atchBoardList ( 공통 - 첨부 게시판 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> atchBoardList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/common.atchBoardList", map);
    }
	
	/**
	 *  boardView ( 공통 - 첨부 게시판 상세 조회  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public Map<String, Object> atchBoardView(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectList("phl/common.atchBoardView", map);
    }
	
	/**
	 *  insertBoardAtch ( 공통 - 첨부 파일 등록  ) 
	 *	2018.12.31 LJG  
	 */
	public void insertBoardAtch(Map<String, Object> map) throws Exception{
	    insert("phl/common.insertBoardAtch", map);
	}
	
	/**
	 *  updateBoardAtch ( 공통 - 첨부 파일 수정  ) 
	 *	2018.12.31 LJG  
	 */
	public void updateBoardAtch(Map<String, Object> map) throws Exception{
	    insert("phl/common.updateBoardAtch", map);
	}
	
	/**
	 *  deleteBoardAtch ( 공통 - 첨부 파일 삭제  ) 
	 *	2018.12.31 LJG  
	 */
	
	
}