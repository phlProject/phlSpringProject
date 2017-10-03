package com.a0000006.manage.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.manage.dao.ManageDAO;

@Service("manageService")
public class ManageServiceImpl implements ManageService {

Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="manageDAO")
	private ManageDAO manageDAO;

	/* 회원리스트 Count */
	public int memListCnt(Map<String, Object> map) throws Exception {
        return manageDAO.memListCnt(map);
    }
	
	/* 회원리스트 */
	@Override
    public List<Map<String, Object>> memList(Map<String, Object> map) throws Exception {
        return manageDAO.memList(map);
    }

	/* 활성화/비활성화 수정 */
	@Override
	public String memActiveYn(Map<String, Object> map) throws Exception {
		try {
			manageDAO.memActiveYn(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 권한 승인/해제 수정 */
	@Override
	public String memAuthorYn(Map<String, Object> map) throws Exception {
		try {
			manageDAO.memAuthorYn(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
}
