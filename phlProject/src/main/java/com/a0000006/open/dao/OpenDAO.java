package com.a0000006.open.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.common.CommandMap;
import com.phl.dao.AbstractDAO;

@Repository("openDAO")
public class OpenDAO extends AbstractDAO{
	
	/*********************************************************************/
	/****************************** 일   정  시작  ******************************/
	
	// 일정 - 리스트
	@SuppressWarnings("unchecked")
	public List<CommandMap> scheduleList(Map<String, Object> map) throws Exception{
		return (List<CommandMap>)selectList("a0000006/open.scheduleList", map); 	
	}

	// 일정 - 등록
	public void insertSchedule(Map<String, Object> map) throws Exception{
		insert("a0000006/open.insertSchedule", map);
	}

	// 일정 - 상세
	@SuppressWarnings("unchecked")
	public Map<String, Object> viewSchedule(Map<String, Object> map) throws Exception{
		return (Map<String, Object>) selectOne("a0000006/open.viewSchedule", map);
	}

	// 일정 - 수정
	public void updateSchedule(Map<String, Object> map) throws Exception{
		update("a0000006/open.updateSchedule", map);
	}

	// 일정 - 삭제
	public void deleteSchedule(Map<String, Object> map) throws Exception{
		delete("a0000006/open.deleteSchedule", map);
		
	}
	
	// 일정 - 대관 장소 목록 ( 삭제 예정 )
	@SuppressWarnings("unchecked")
	public List<CommandMap> placeList(Map<String, Object> map) {
		return (List<CommandMap>)selectList("a0000006/open.placeList", map);
	}
	
	
	/****************************** 일   정  종료  ******************************/
	/*********************************************************************/
	
	
	/*********************************************************************/
	/***************************** 자유게시판  시작  *****************************/
	
	/* 자유게시판 > 조회 > Count */
	public int freeBoardListCnt(Map<String, Object> map) throws Exception{
        return (Integer) selectOne("a0000006/open.freeBoardListCnt", map);
    }

	
	/* 자유게시판 > 조회 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> freeBoardList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/open.freeBoardList", map);
    }
	
	/* 자유게시판 > 상세 폼 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> freeBoardView(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/open.freeBoardView", map);
    }
	
	/* 자유게시판 > 등록 */
	public void insertFreeBoard(Map<String, Object> map) throws Exception{
	    insert("a0000006/open.insertFreeBoard", map);
	}
	
	/* 자유게시판 > 수정 */
	public void updateFreeBoard(Map<String, Object> map) throws Exception{
	    update("a0000006/open.updateFreeBoard", map);
	}

	/* 자유게시판 > 삭제 */
	public void deleteFreeBoard(Map<String, Object> map) throws Exception{
	    update("a0000006/open.deleteFreeBoard", map);
	}
	
	/* 자유게시판 > 일련번호 조회 */
	public int selectboardSn() throws Exception{
	    return (Integer) selectOne("a0000006/open.selectboardSn");
	}
	
	/***************************** 자유게시판  종료  *****************************/
	/*********************************************************************/
}
