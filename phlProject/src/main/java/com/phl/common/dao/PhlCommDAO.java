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
	
	/* 메뉴조회 (2dept) */
	@SuppressWarnings("unchecked")
    public List<CommandMap> menuListDept2(Map<String, Object> map) throws Exception{
        return (List<CommandMap>)selectList("phl/common.menuListDept2", map);
    }
}
