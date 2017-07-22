package com.a0000006.manage.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.manage.dao.MngDAO;

@Service("mngService")
public class MngServiceImpl implements MngService {

Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="mngDAO")
	private MngDAO mngDAO;

	/* 회원리스트 Count */
	public int memListCnt(Map<String, Object> map) throws Exception {
        return mngDAO.memListCnt(map);
    }
	
	/* 회원리스트 */
	@Override
    public List<Map<String, Object>> memList(Map<String, Object> map) throws Exception {
        return mngDAO.memList(map);
    }

	/* 회원 활성화 비활성화 수정 */
	@Override
	public String memUpdateActive(Map<String, Object> map) throws Exception {
		try {
			mngDAO.memUpdateActive(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
}
