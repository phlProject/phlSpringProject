package com.a0000006.teacher.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.dao.AbstractDAO;

@Repository("teacherDAO")
public class TeacherDAO extends AbstractDAO {

	/* 참여게시판 > 조회 > Count */
	public int joinListCnt(Map<String, Object> map) throws Exception{
        return (Integer) selectOne("a0000006/teacher.joinListCnt", map);
    }

	/* 참여게시판 > 조회  */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> joinList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/teacher.joinList", map);
    }
	
	/* 참여게시판 > 상세 폼 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> joinView(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/teacher.joinView", map);
    }
	
	/* 일련번호 조회 */
	public int selectboardSn() throws Exception{
	    return (Integer) selectOne("a0000006/teacher.selectboardSn");
	}
	
	/* 참여게시판 > 등록 */
	public void insertJoin(Map<String, Object> map) throws Exception{
	    insert("a0000006/teacher.insertJoin", map);
	}
	
	/* 책소개 > 수정 */
	public void updateJoin(Map<String, Object> map) throws Exception{
	    update("a0000006/teacher.updateJoin", map);
	}
	
	/* 책소개 > 삭제 */
	public void deleteJoin(Map<String, Object> map) throws Exception{
	    update("a0000006/teacher.deleteJoin", map);
	}
}
