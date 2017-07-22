package com.a0000006.oepn.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.a0000006.oepn.service.OpenService;

@Controller
public class OpenController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="openService")
	private OpenService openService;
}
