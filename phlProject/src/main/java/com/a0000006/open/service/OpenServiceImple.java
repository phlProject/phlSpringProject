package com.a0000006.open.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.open.dao.OpenDAO;
import com.phl.common.CommandMap;

@Service("openService")
public class OpenServiceImple implements OpenService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="openDAO")
	private OpenDAO openDAO;
	
	/*********************************************************************/
	/****************************** 일   정  시작  ******************************/
	
	// 일정 - 리스트
	@Override
	public List<CommandMap> scheduleList(Map<String, Object> map) throws Exception {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int toYear = Integer.parseInt(map.get("toYear").toString());
		int toMonth = Integer.parseInt(map.get("toMonth").toString());
		int toDay = Integer.parseInt(map.get("toDay").toString());
		
		if(toYear == 0){
			toYear = Integer.parseInt(sdf.format(d).substring(0, 4));
			toMonth = Integer.parseInt(sdf.format(d).substring(5, 7));
			toDay = Integer.parseInt(sdf.format(d).substring(8, 10));
		}
		
		map.put("toYear", toYear);
		map.put("toMonth", toMonth);
		map.put("toDay", toDay);
		
		return openDAO.scheduleList(map);
	}

	// 일정 - 등록
	@Override
	public String insertSchedule(Map<String, Object> map) throws Exception {
		try {
			openDAO.insertSchedule(map);
			return "0";
		} catch (Exception e) {
			return "-1";
		}
	}

	// 일정 - 상세
	@Override
	public Map<String, Object> viewSchedule(Map<String, Object> map) throws Exception {
		return openDAO.viewSchedule(map);
	}

	// 일정 - 수정
	@Override
	public String updateSchedule(Map<String, Object> map) throws Exception {
		try {
			openDAO.updateSchedule(map);
			return "0";
		} catch (Exception e) {
			return "-1";
		}
	}

	// 일정 - 삭제
	@Override
	public String deleteSchedule(Map<String, Object> map) throws Exception {
		try {
			openDAO.deleteSchedule(map);
			return "0";
		} catch (Exception e) {
			return "-1";
		}
	}

	// 일정 - 대관 장소 목록 ( 삭제 예정 )
	@Override
	public List<CommandMap> placeList(Map<String, Object> map) {
		return openDAO.placeList(map);
	}
	
	
	/****************************** 일   정  종료  ******************************/
	/*********************************************************************/
	
	
	/*********************************************************************/
	/***************************** 자유게시판  시작  *****************************/
	
	/* 자유게시판 > 조회 > Count */
	public int freeBoardListCnt(Map<String, Object> map) throws Exception {
        return openDAO.freeBoardListCnt(map);
    }
	
	/* 자유게시판 > 조회 */
	@Override
    public List<Map<String, Object>> freeBoardList(Map<String, Object> map) throws Exception {
        return openDAO.freeBoardList(map);
    }
	
	/* 자유게시판 > 상세 폼 */
	@Override
    public List<Map<String, Object>> freeBoardView(Map<String, Object> map) throws Exception {
        return openDAO.freeBoardView(map);
    }
	
	/* 자유게시판 > 등록 */
	@Override
	public int insertFreeBoard(Map<String, Object> map) throws Exception {
		try {
			openDAO.insertFreeBoard(map);
			
			// 게시판 공통 > 일련번호 조회
			int boardSn = openDAO.selectboardSn();
			
			return boardSn;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/* 자유게시판 > 수정 */
	@Override
	public String updateFreeBoard(Map<String, Object> map) throws Exception {
		try {
			openDAO.updateFreeBoard(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 자유게시판 > 삭제 */
	@Override
	public String deleteFreeBoard(Map<String, Object> map) throws Exception {
		try {
			openDAO.deleteFreeBoard(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/***************************** 자유게시판  종료  *****************************/
	/*********************************************************************/
}
