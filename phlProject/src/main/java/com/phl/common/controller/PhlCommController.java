package com.phl.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phl.common.CommandMap;
import com.phl.common.service.PhlCommService;
import com.phl.util.CmmnUtilFile;

@Controller
public class PhlCommController {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	/* 공통코드 */
	@RequestMapping(value="/a0000006/mem/selectCommCode.do")
	public ModelAndView selectCommCode(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView();
        System.out.println("test");
        List<CommandMap> commList = phlCommService.selectCommCode(commandMap.getMap());
        mv.addObject("commList", commList);
        return mv;
    }

	
	/* 파일 업로드 */
	@RequestMapping(value="/phl/uploadFile.do")
	public ModelAndView fileUpload(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		List<Map<String,Object>> fl_upload = new ArrayList<Map<String,Object>>();
		
		fl_upload = CmmnUtilFile.uploadFile(request);

		if(fl_upload.get(0).size() > 0){
			mv.addObject("fl_upload", fl_upload.get(0));
			mv.addObject("result", "success");
		}else{
			mv.addObject("result", "fail");
		}
		return mv;
		
	}
}
