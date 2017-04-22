package com.phl.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.dao.AbstractDAO;

@Repository("phlCommDAO")
public class PhlCommDAO extends AbstractDAO {

	/* 공통코드 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectCommCode(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/common.selectCommCode", map);
    }
}
