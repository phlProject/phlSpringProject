package com.phl.common.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.phl.common.CommandMap;
import com.phl.common.dao.PhlCommDAO;

@Service("phlCommService")
public class PhlCommServiceImpl implements PhlCommService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="phlCommDAO")
	private PhlCommDAO phlCommDAO;
	
	/* 공통코드 */
	@Override
    public List<CommandMap> selectCommCode(Map<String, Object> map) throws Exception {
        return phlCommDAO.selectCommCode(map);
    }
	
	@Override
    public String selectCommCodeOne(Map<String, Object> map) throws Exception {
        return phlCommDAO.selectCommCodeOne(map);
    }
	
	/**
	 *  menuListDept2 ( 공통 - 메뉴조회 (2dept)  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<CommandMap> menuListDept2(Map<String, Object> map) throws Exception {
        return phlCommDAO.menuListDept2(map);
    }
	
	/**
	 *  menuListDept3 ( 공통 - 메뉴조회 (3dept)  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<CommandMap> menuListDept3(Map<String, Object> map) throws Exception {
        return phlCommDAO.menuListDept3(map);
    }
	
	
	
	/**
	 *  downloadFile ( 공통 - 파일다운로드  )
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> downloadFile(Map<String, Object> map) throws Exception {
        return phlCommDAO.downloadFile(map);
    }
	
	
	
	/**
	 *  adminCheck ( 공통 - 관리자 로그인  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> adminCheck(Map<String, Object> map) throws Exception {
        return phlCommDAO.adminCheck(map);
    }
	
	/**
	 *  adminInfo ( 공통 - 관리자 정보  ) 
	 *	2018.12.31 LJG  
	 */
	@Override
    public List<Map<String, Object>> adminInfo(Map<String, Object> map) throws Exception {
        return phlCommDAO.adminInfo(map);
    }
}	
