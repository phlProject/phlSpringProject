package com.a0000006.mem.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.mem.dao.MemberDAO;
import com.phl.common.CommandMap;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="memberDAO")
	private MemberDAO memberDAO;

	/* 로그인(ID,PW CHECK) */
	@Override
    public List<Map<String, Object>> idPwCheck(Map<String, Object> map) throws Exception {
        return memberDAO.idPwCheck(map);
    }
	
	/* 로그인 정보 */
	@Override
    public List<Map<String, Object>> loginInfo(Map<String, Object> map) throws Exception {
        return memberDAO.loginInfo(map);
    }
	
	/* 마이페이지  */
	@Override
    public List<CommandMap> memMyPage(Map<String, Object> map) throws Exception {
        return memberDAO.memMyPage(map);
    }
	
	/* 회원 등록 */
	@Override
	public String insertMemRegist(Map<String, Object> map) throws Exception {
		try {
			memberDAO.insertMemRegist(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 마이페이지 수정 */
	@Override
	public String updateMemRegist(Map<String, Object> map) throws Exception {
		try {
			memberDAO.updateMemRegist(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 회원탈퇴 */
	@Override
	public String deleteMemRegist(Map<String, Object> map) throws Exception {
		try {
			memberDAO.deleteMemRegist(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 아이디 중복체크 */
	@Override
    public int idDupChk(Map<String, Object> map) throws Exception {
        return memberDAO.idDupChk(map);
    }
	
	/* 회원리스트 */
	@Override
    public List<Map<String, Object>> selectMemList(Map<String, Object> map) throws Exception {
        return memberDAO.selectMemList(map);
    }
}
