package com.a0000006.network.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.dao.AbstractDAO;

@Repository("networkDAO")
public class NetworkDAO extends AbstractDAO {

	/* 네트워크게시판 > 조회 > Count */
	public int networkBoardListCnt(Map<String, Object> map) throws Exception{
        return (Integer) selectOne("a0000006/network.networkBoardListCnt", map);
    }
	
	/* 네트워크게시판 > 조회 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> networkBoardList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/network.networkBoardList", map);
    }
	
	/* 네트워크게시판 > 상세 폼 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> networkBoardView(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/network.networkBoardView", map);
    }
	
	/* 네트워크게시판 > 등록 */
	public void insertNetworkBoard(Map<String, Object> map) throws Exception{
	    insert("a0000006/network.insertNetworkBoard", map);
	}
	
	/* 네트워크게시판 > 수정 */
	public void updateNetworkBoard(Map<String, Object> map) throws Exception{
	    update("a0000006/network.updateNetworkBoard", map);
	}

	/* 네트워크게시판 > 삭제 */
	public void deleteNetworkBoard(Map<String, Object> map) throws Exception{
	    update("a0000006/network.deleteNetworkBoard", map);
	}
	
	/* 네트워크게시판 > 일련번호 조회 */
	public int selectboardSn() throws Exception{
	    return (Integer) selectOne("a0000006/network.selectboardSn");
	}
}
