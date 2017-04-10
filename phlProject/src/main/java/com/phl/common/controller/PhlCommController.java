package com.phl.common.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phl.common.CommandMap;
import com.phl.common.service.PhlCommService;

@Controller
public class PhlCommController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	/* 공통코드 */
	@RequestMapping(value="/a0000006/mem/selectCommCode.do")
	public ModelAndView selectCommCode(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView();
         
        List<Map<String,Object>> commList = phlCommService.selectCommCode(commandMap.getMap());
        mv.addObject("commList", commList);
        return mv;
    }

}
