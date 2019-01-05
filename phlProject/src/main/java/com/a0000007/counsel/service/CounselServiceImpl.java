package com.a0000007.counsel.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000007.counsel.dao.CounselDAO;

@Service("/a0000007/counselService")
public class CounselServiceImpl implements CounselService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="/a0000007/counselDAO")
	private CounselDAO counselDAO;
}
