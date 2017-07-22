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
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	/* 공통 */
	@Resource(name="phlCommService")
	private PhlCommService phlCommService;
	
	/* 로그인 폼 */
	@RequestMapping(value="/a0000006/mem/memLoginForm.do")
	public ModelAndView memLoginForm(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/a0000006/member/memLoginForm");
	     
	    return mv;
	}
	
	/* 로그인 */
	@RequestMapping(value="/a0000006/mem/loginAction.do")
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
		        if(queryPw != null && queryPw.equals(commandMap.get("mem_pw"))){
		        	resultValue = "SUCCESS";
		        	/* 로그인 정보 */
		        	List<Map<String,Object>> loginInfo = memberService.loginInfo(commandMap.getMap());
		
		        	session.setAttribute("loginInfo", loginInfo.get(0));
		        	session.setAttribute("session_id", loginInfo.get(0).get("MEM_ID"));
		        	
		        	mv.setViewName("/a0000006/mainIndex");
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
	@RequestMapping(value="/a0000006/mem/memMyPage.do")
	public ModelAndView memMyPage(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/a0000006/member/memMyPage");
	
		Map<String,Object> sessionInfo = (Map<String, Object>) session.getAttribute("loginInfo");
		
	    commandMap.put("cl_code", "G01");
	    
	    if(!sessionInfo.get("MEM_GBN_CD").equals("G01998") && !sessionInfo.get("MEM_GBN_CD").equals("G01999")){
	    	commandMap.put("not_detail_code", "'998','999'");
	    }
	    
	    // 공통코드(회원권한)
	    List<CommandMap> commList = phlCommService.selectCommCode(commandMap.getMap());
	    
		List<CommandMap> myPageInfo = memberService.memMyPage(commandMap.getMap());
		
		mv.addObject("commList", commList);
		mv.addObject("myPageInfo", myPageInfo.get(0)); 
		
		return mv;
	}
	
	/* 로그아웃 */
	@RequestMapping(value="/a0000006/mem/logoutAction.do")
	public ModelAndView logoutAction(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("/a0000006/mainIndex");
        
        /* 로그인정보만 세션제거 */
        session.removeAttribute("loginInfo");
        session.removeAttribute("session_id");
        
        return mv;
    }
	
	/* 회원가입 폼 */
	@RequestMapping(value="/a0000006/mem/memRegistForm.do")
	public ModelAndView memRegistForm(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
	    ModelAndView mv = new ModelAndView("/a0000006/member/memRegistForm");
	    
	    commandMap.put("cl_code", "G01");
	    commandMap.put("not_detail_code", "'998','999'");
	    
	    // 공통코드(회원권한)
	    List<CommandMap> commList = phlCommService.selectCommCode(commandMap.getMap());
	    
	    mv.addObject("commList", commList);
	    
	    return mv;
	}

	/* 회원 등록 */
	@RequestMapping(value="/a0000006/mem/insertMemRegist.do")
	public ModelAndView insertMemRegist(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");

		String result = memberService.insertMemRegist(commandMap.getMap());
		
		mv.addObject("result", result);  		
		
		return mv;
	}
	
	/* 마이페이지 수정 */
	@RequestMapping(value="/a0000006/mem/updateMemRegist.do")
	public ModelAndView updateMemRegist(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");

		String result = memberService.updateMemRegist(commandMap.getMap());
		
		mv.addObject("result", result);  		
		
		return mv;
	}
	
	/* 회원탈퇴 */
	@RequestMapping(value="/a0000006/mem/deleteMemRegist.do")
	public ModelAndView deleteMemRegist(CommandMap commandMap, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		String result = memberService.deleteMemRegist(commandMap.getMap());
		
		mv.addObject("result", result);  
		
		/* 로그인정보만 세션제거 */
        session.removeAttribute("loginInfo");
        session.removeAttribute("session_id");
		
        return mv;
	}
	
	/* 아이디 중복체크 */
	@RequestMapping(value="/a0000006/mem/idDupChk.do")
	public ModelAndView idDupChk(CommandMap commandMap, HttpSession session, HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		int id_Chk = memberService.idDupChk(commandMap.getMap());
		String result = "";
		
		if(id_Chk == 0){
			result = "success";
		}else{
			result = "fail";
		}
		
		mv.addObject("result", result);  		
		return mv;
	}
}
