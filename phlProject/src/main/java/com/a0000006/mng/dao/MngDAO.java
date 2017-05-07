package com.a0000006.mng.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.dao.AbstractDAO;

@Repository("mngDAO")
public class MngDAO extends AbstractDAO {

	/* 회원리스트 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> memList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/mng.memList", map);
    }
}
