package com.a0000006.teacher.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.teacher.dao.TeacherDAO;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="teacherDAO")
	private TeacherDAO teacherDAO;
	
	/* 참여게시판 > 조회 > Count */
	public int joinListCnt(Map<String, Object> map) throws Exception {
        return teacherDAO.joinListCnt(map);
    }
	
	/* 참여게시판 > 조회  */
	@Override
    public List<Map<String, Object>> joinList(Map<String, Object> map) throws Exception {
        return teacherDAO.joinList(map);
    }

	/* 참여게시판 > 상세 폼 */
	@Override
    public List<Map<String, Object>> joinView(Map<String, Object> map) throws Exception {
        return teacherDAO.joinView(map);
    }
	
	/* 참여게시판 > 등록 */
	@Override
	public int insertJoin(Map<String, Object> map) throws Exception {
		try {
			teacherDAO.insertJoin(map);
			
			int boardSn = teacherDAO.selectboardSn();
			
			return boardSn;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/* 참여게시판 > 수정 */
	@Override
	public String updateJoin(Map<String, Object> map) throws Exception {
		try {
			teacherDAO.updateJoin(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 참여게시판 > 삭제 */
	@Override
	public String deleteJoin(Map<String, Object> map) throws Exception {
		try {
			teacherDAO.deleteJoin(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
}
