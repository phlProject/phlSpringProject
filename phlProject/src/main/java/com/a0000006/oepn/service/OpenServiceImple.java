package com.a0000006.oepn.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.oepn.dao.OpenDAO;

@Service("openService")
public class OpenServiceImple implements OpenService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="openDAO")
	private OpenDAO openDAO;
}
