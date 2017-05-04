package com.a0000006.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.dao.AbstractDAO;

@Repository("BoardDAO")
public class BoardDAO extends AbstractDAO {

	/* 책소개 리스트 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectbookList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/board.selectbookList", map);
    }
	
	/* 책소개 등록 */
	public void insertBook(Map<String, Object> map) throws Exception{
	    insert("a0000006/board.insertBook", map);
	}
	
	/* 책소개 상세 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectbookView(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/board.selectbookView", map);
    }
}
