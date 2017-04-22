package com.a0000006.apply.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.common.CommandMap;
import com.phl.dao.AbstractDAO;

@Repository("applyDAO")
public class ApplyDAO extends AbstractDAO{

	// 스케줄 목록
	@SuppressWarnings("unchecked")
	public List<CommandMap> applyList(Map<String, Object> map) throws Exception{
		return (List<CommandMap>)selectList("a0000006/apply.applyList", map); 	
	}

}
