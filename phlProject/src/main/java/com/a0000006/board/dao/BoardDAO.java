package com.a0000006.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.dao.AbstractDAO;

@Repository("BoardDAO")
public class BoardDAO extends AbstractDAO {

	/****************************** 책 소 개 시작  ******************************/
	
	/* 책소개 > 조회 > Count */
	public int bookListCnt(Map<String, Object> map) throws Exception{
        return (Integer) selectOne("a0000006/board.bookListCnt", map);
    }
	
	/* 책소개 > 조회  */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> bookList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/board.bookList", map);
    }
	
	/* 책소개 > 상세 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> bookView(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/board.bookView", map);
    }
	
	/* 책소개 > 등록 */
	public void insertBook(Map<String, Object> map) throws Exception{
	    insert("a0000006/board.insertBook", map);
	}
	
	/* 책소개 > 수정 */
	public void updateBook(Map<String, Object> map) throws Exception{
	    update("a0000006/board.updateBook", map);
	}
	
	/* 책소개 > 삭제 */
	public void deleteBook(Map<String, Object> map) throws Exception{
	    update("a0000006/board.deleteBook", map);
	}
	
	/* 게시판  > 파일 등록 */
	public void insertBoardFl(Map<String, Object> map) throws Exception{
	    insert("a0000006/board.insertBoardFl", map);
	}
	
	/* 게시판  > 파일 수정 */
	public void updateBoardFl(Map<String, Object> map) throws Exception{
	    update("a0000006/board.updateBoardFl", map);
	}

	/* 게시판 > 번호 채번 */
	public int seqSn() throws Exception{
	    return (Integer) selectOne("a0000006/board.seqSn");
	}
	
	/****************************** 책 소 개 종료  ******************************/
	
	/****************************** 간 행 물 시작  ******************************/
	
	/* 간행물 > 조회 > Count */
	public int publiListCnt(Map<String, Object> map) throws Exception{
        return (Integer) selectOne("a0000006/board.publiListCnt", map);
    }
	
	/* 간행물 > 조회  */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> publiList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/board.publiList", map);
    }
	
	/****************************** 간 행 물 종료  ******************************/
	
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> flList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/board.flList", map);
    }
}
