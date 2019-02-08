package com.phl.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        List<CommandMap> commList = phlCommService.selectCommCode(commandMap.getMap());
        mv.addObject("commList", commList);
        return mv;
    }

	
	/**
	 *  uploadFile ( 공통 - 파일업로드 )
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/phl/comm/uploadFile.do")
	public ModelAndView uploadFile(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		List<Map<String,Object>> fl_upload = new ArrayList<Map<String,Object>>();
		
		// Sub Full Path 지정
		request.setAttribute("fullSubPath", session.getAttribute("bsnsCode") + request.getParameter("sPath"));
		
		fl_upload = CmmnUtilFile.uploadFile(request);

		if(fl_upload.get(0).size() > 0){
			mv.addObject("fl_upload", fl_upload.get(0));
			mv.addObject("result", "success");
		}else{
			mv.addObject("result", "fail");
		}
		return mv;
	}
	
	/**
	 *  downloadFile ( 공통 - 파일다운로드 )
	 *	2018.12.31 LJG  
	 */
	@RequestMapping(value="/phl/comm/downloadFile.do")
	public void downloadFile(CommandMap commandMap, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{

		commandMap.put("bsnsCode", 	request.getParameter("bsnsCode"));
		commandMap.put("flSn", 		request.getParameter("boardFlSn"));
		
		List<Map<String,Object>> downloadFile = phlCommService.downloadFile(commandMap.getMap());
		
		commandMap.put("originFlNm", 	downloadFile.get(0).get("ORIGIN_FL_NM"));
		commandMap.put("flNm", 			downloadFile.get(0).get("FL_NM"));
		commandMap.put("flPath", 		downloadFile.get(0).get("FL_PATH"));
		
		CmmnUtilFile.downloadFile(commandMap, request, response);
	}
}
