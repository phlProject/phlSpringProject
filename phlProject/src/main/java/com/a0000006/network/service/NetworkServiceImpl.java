package com.a0000006.network.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.network.dao.NetworkDAO;

@Service("networkService")
public class NetworkServiceImpl implements NetworkService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="networkDAO")
	private NetworkDAO networkDAO;
	
}
