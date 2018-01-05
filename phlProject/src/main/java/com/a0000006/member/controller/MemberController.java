package com.a0000006.member.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.a0000006.member.service.MemberService;
import com.phl.common.CommandMap;
import com.phl.common.service.PhlCommService;

@Controller
public class MemberController {

	Logger log = Logger.getLogger(this.getClass());
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	
	
	/* 로그인 폼 */
	@RequestMapping(value="/a0000006/member/memLoginForm.do")
	public ModelAndView memLoginForm(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/a0000006/member/memLoginForm");
	     
	    return mv;
	}
	
	/* 로그인 */
	@RequestMapping(value="/a0000006/member/loginAction.do")
	public ModelAndView loginAction(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView();
        
        String resultValue = "";
        
        /* 로그인(ID,PW CHECK) */
        List<Map<String,Object>> idPwChk = memberService.idPwCheck(commandMap.getMap());
        
        /* 해당하는 아이디 존재 시 */
        if(idPwChk.size() != 0){
        	String queryPw = (String) idPwChk.get(0).get("MEM_PW");
        	String queryUseYn = (String) idPwChk.get(0).get("USE_YN");
        	
        	/* 사용여부 'Y' */
        	if(queryUseYn.equals("Y")){
	        	/* 해당하는 아이디, 비밀번호 일치 시 */
		        if(queryPw != null && queryPw.equals(commandMap.get("memPw"))){

		        	/* 로그인 정보 */
		        	List<Map<String,Object>> loginInfo = memberService.loginInfo(commandMap.getMap());
		
		        	session.setAttribute("loginInfo", loginInfo.get(0));
		        	session.setAttribute("sessionId", loginInfo.get(0).get("MEM_ID"));
		        	
		        	mv.setViewName("redirect:/a0000006/mainIndex.do");
		        }else{
		        	/* 비밀번호 오류 */
		        	resultValue = "PW_ERROR";
		        	mv.setViewName("/a0000006/member/memLoginForm");
		        }
        	}else if(queryUseYn.equals("S")){
        		/* 권한부여 대기중 */
        		resultValue = "ID_STANDBY";
	        	mv.setViewName("/a0000006/member/memLoginForm");
        	}else if(queryUseYn.equals("N")){
        		/* 아이디 오류 */
            	resultValue = "ID_ERROR";
            	mv.setViewName("/a0000006/member/memLoginForm");
        	}
        }else{
        	/* 아이디 오류 */
        	resultValue = "ID_ERROR";
        	mv.setViewName("/a0000006/member/memLoginForm");
        }
        mv.addObject("resultValue",resultValue);  

        return mv;
    }
	
	/* 마이페이지 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/a0000006/member/memMyPage.do")
	public ModelAndView memMyPage(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/member/memMyPage");
	
		Map<String,Object> sessionInfo = (Map<String, Object>) session.getAttribute("loginInfo");
		
		// 공통코드 - G01 : 회원구분
	    commandMap.put("cl_code", "G01");
	    
	    // G01 - 998/999 : 홈페이지 관리자 , PHL 관리자 ( 조회 제외코드  )
	    if(!sessionInfo.get("MEM_GBN_CD").equals("G01998") && !sessionInfo.get("MEM_GBN_CD").equals("G01999")){
	    	commandMap.put("not_detail_code", "'998','999'");
	    }
	    
	    // 공통코드(회원권한)
	    List<CommandMap> memGbnList = phlCommService.selectCommCode(commandMap.getMap());
	    
		List<CommandMap> myPageInfo = memberService.memMyPage(commandMap.getMap());
		
		mv.addObject("memGbnList", memGbnList);
		mv.addObject("myPageInfo", myPageInfo.get(0)); 
		
		return mv;
	}
	
	/* 로그아웃 */
	@RequestMapping(value="/a0000006/member/logoutAction.do")
	public ModelAndView logoutAction(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("redirect:/a0000006/mainIndex.do");
        
        /* 로그인정보만 세션제거 */
        session.removeAttribute("loginInfo");
        session.removeAttribute("sessionId");
        
        return mv;
    }
	
	/* 회원가입 폼 */
	@RequestMapping(value="/a0000006/member/memRegistForm.do")
	public ModelAndView memRegistForm(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
	    ModelAndView mv = new ModelAndView("/a0000006/member/memRegistForm");
	    
	    // 공통코드 - G01 : 회원구분
	    commandMap.put("cl_code", "G01");
	    
	    // G01 - 998/999 : 홈페이지 관리자 , PHL 관리자 ( 조회 제외코드  )
	    commandMap.put("not_detail_code", "'998','999'");
	    
	    // 공통코드(회원권한)
	    List<CommandMap> memGbnList = phlCommService.selectCommCode(commandMap.getMap());
	    
	    mv.addObject("memGbnList", memGbnList);
	    
	    return mv;
	}

	/* 회원 등록 */
	@RequestMapping(value="/a0000006/member/insertMemRegist.do")
	public ModelAndView insertMemRegist(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");

		String result = memberService.insertMemRegist(commandMap.getMap());
		
		mv.addObject("result", result);  		
		
		return mv;
	}
	
	/* 마이페이지 수정 */
	@RequestMapping(value="/a0000006/member/updateMemRegist.do")
	public ModelAndView updateMemRegist(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");

		String result = memberService.updateMemRegist(commandMap.getMap());
		
		mv.addObject("result", result);  		
		
		return mv;
	}
	
	/* 회원탈퇴 */
	@RequestMapping(value="/a0000006/member/deleteMemRegist.do")
	public ModelAndView deleteMemRegist(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = memberService.deleteMemRegist(commandMap.getMap());
		
		mv.addObject("result", result);  
		
		/* 로그인정보만 세션제거 */
        session.removeAttribute("loginInfo");
        session.removeAttribute("sessionId");
		
        return mv;
	}
	
	/* 회원 중복체크 */
	@RequestMapping(value="/a0000006/member/memDupChk.do")
	public ModelAndView memDupChk(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");

		int dupCnt = memberService.memDupChk(commandMap.getMap());
		String result = "";
		
		if(dupCnt == 0)	result = "success";
		else result = "fail";
		
		
		mv.addObject("result", result);  		
		return mv;
	}
	
	/* 아이디/비밀번호 찾기 폼 */
	@RequestMapping(value="/a0000006/member/memSearchForm.do")
	public ModelAndView memSearchForm(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("/a0000006/member/memSearchForm");
		
		return mv;
		
	}
	
	/* 아이디/비밀번호 찾기 */
	@RequestMapping(value="/a0000006/member/memInfoSearch.do")
	public ModelAndView memInfoSearch(CommandMap commandMap, HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		String memInfo = memberService.memInfoSearch(commandMap.getMap());
		
		if(!memInfo.isEmpty()){
			mv.addObject("result", "success");
			mv.addObject("memInfo", memInfo);
		}
		  
		
        return mv;
	}
}
