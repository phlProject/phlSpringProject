package com.a0000006.mng.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.mng.dao.MngDAO;

@Service("mngService")
public class MngServiceImpl implements MngService {

Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="mngDAO")
	private MngDAO mngDAO;

	/* 회원리스트 */
	@Override
    public List<Map<String, Object>> memList(Map<String, Object> map) throws Exception {
        return mngDAO.memList(map);
    }
}
