package com.a0000006.apply.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.a0000006.apply.service.ApplyService;

@Controller
public class ApplyController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="applyService")
	private ApplyService applyService;
	
	
}
