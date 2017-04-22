package com.a0000006.apply.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.apply.dao.ApplyDAO;


@Service("applyService")
public class ApplyServiceImpl implements ApplyService{

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="applyDAO")
	private ApplyDAO applyDAO;
	
	
}
