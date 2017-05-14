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

	// 등록
	public void insertApply(Map<String, Object> map) throws Exception{
		insert("a0000006/apply.insertApply", map);
	}

	// 상세 페이지
	public Map<String, Object> viewApply(Map<String, Object> map) throws Exception{
		return (Map<String, Object>) selectOne("a0000006/apply.viewApply", map);
	}

	// 수정
	public void updateApply(Map<String, Object> map) throws Exception{
		update("a0000006/apply.updateApply", map);
	}

	// 삭제
	public void deleteApply(Map<String, Object> map) throws Exception{
		delete("a0000006/apply.deleteApply", map);
		
	}

}
