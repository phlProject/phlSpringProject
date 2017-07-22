package com.a0000006.manage.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.dao.AbstractDAO;

@Repository("manageDAO")
public class ManageDAO extends AbstractDAO {

	/* 회원리스트 Count */
	@SuppressWarnings("unchecked")
	public int memListCnt(Map<String, Object> map) throws Exception{
        return (Integer) selectOne("a0000006/manage.memListCnt", map);
    }
	
	/* 회원리스트 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> memList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/manage.memList", map);
    }
	
	/* 회원 활성화 비활성화 수정 */
	public void memUpdateActive(Map<String, Object> map) throws Exception{
	    update("a0000006/manage.memUpdateActive", map);
	}
}
