package com.a0000006.mng.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000006.mng.service.MngService;
import com.phl.common.CommandMap;

@Controller
public class MngController {
	
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="mngService")
	private MngService mngService;
	
	/* 회원리스트 */
	@RequestMapping(value="/a0000006/mng/memList.do")
	public ModelAndView selectMemList(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/a0000006/mng/memList");
         
        List<Map<String,Object>> memList = mngService.memList(commandMap.getMap());
        mv.addObject("memList", memList);
        return mv;
    }
}
