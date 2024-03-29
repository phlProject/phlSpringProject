package com.a0000006.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.common.CommandMap;
import com.phl.dao.AbstractDAO;

@Repository("memberDAO")
public class MemberDAO extends AbstractDAO {

	/* 로그인(ID,PW CHECK) */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> idPwCheck(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/member.idPwCheck", map);
    }
	
	/* 로그인 정보 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> loginInfo(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/member.loginInfo", map);
    }
	
	/* 마이페이지 */
	@SuppressWarnings("unchecked")
    public List<CommandMap> memMyPage(Map<String, Object> map) throws Exception{
        return (List<CommandMap>)selectList("a0000006/member.memMyPage", map);
    }
	
	/* 회원 등록 */
	public void insertMemRegist(Map<String, Object> map) throws Exception{
	    insert("a0000006/member.insertMemRegist", map);
	}
	
	/* 마이페이지 수정 */
	public void updateMemRegist(Map<String, Object> map) throws Exception{
	    update("a0000006/member.updateMemRegist", map);
	}
	
	/* 회원탈퇴 */
	public void deleteMemRegist(Map<String, Object> map) throws Exception{
	    update("a0000006/member.deleteMemRegist", map);
	}
	
	/* 회원 중복체크 */
    public int memDupChk(Map<String, Object> map) throws Exception{
        return (Integer) selectOne("a0000006/member.memDupChk", map);
    }
 
    /* 아이디/비밀번호 찾기 */
	public String memInfoSearch(Map<String, Object> map) throws Exception{
		return (String) selectOne("a0000006/member.memInfoSearch", map);
	}
}
