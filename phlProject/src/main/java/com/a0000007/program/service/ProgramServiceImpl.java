package com.a0000007.program.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000007.program.dao.ProgramDAO;

@Service("/a0000007/programService")
public class ProgramServiceImpl implements ProgramService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="/a0000007/programDAO")
	private ProgramDAO programDAO;
}
