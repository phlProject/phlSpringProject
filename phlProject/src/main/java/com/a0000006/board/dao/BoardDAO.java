package com.a0000006.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.dao.AbstractDAO;

@Repository("BoardDAO")
public class BoardDAO extends AbstractDAO {

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
	
	/* 책소개 등록 */
	public void insertBook(Map<String, Object> map) throws Exception{
	    insert("a0000006/board.insertBook", map);
	}
	
	/* 책소개 메인이미지 등록 */
	public void insertBookFl(Map<String, Object> map) throws Exception{
	    insert("a0000006/board.insertBookFl", map);
	}

	

}
