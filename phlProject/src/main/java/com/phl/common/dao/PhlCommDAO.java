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
	
	@SuppressWarnings("unchecked")
    public String selectCommCodeOne(Map<String, Object> map) throws Exception{
		return (String) selectOne("phl/common.selectCommCodeOne", map);
    }
	
	
	/**
	 *  menuListDept2 ( 공통 - 메뉴조회 (2dept)  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<CommandMap> menuListDept2(Map<String, Object> map) throws Exception{
        return (List<CommandMap>)selectList("phl/common.menuListDept2", map);
    }
	
	/**
	 *  menuListDept3 ( 공통 - 메뉴조회 (3dept)  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<CommandMap> menuListDept3(Map<String, Object> map) throws Exception{
        return (List<CommandMap>)selectList("phl/common.menuListDept3", map);
    }
	
	
	
	/**
	 *  downloadFile ( 공통 - 파일다운로드  )
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> downloadFile(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/common.downloadFile", map);
    }
	
	
	
	/**
	 *  adminCheck ( 공통 - 관리자 로그인  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> adminCheck(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/admin.adminCheck", map);
    }
	
	/**
	 *  adminInfo ( 공통 - 관리자 정보  ) 
	 *	2018.12.31 LJG  
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> adminInfo(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("phl/admin.adminInfo", map);
    }
}