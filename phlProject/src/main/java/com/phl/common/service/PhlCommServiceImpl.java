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
}
