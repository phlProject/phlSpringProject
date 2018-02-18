package com.phl.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.common.CommandMap;
import com.phl.dao.AbstractDAO;

@Repository("phlCommDAO")
public class PhlCommDAO extends AbstractDAO {

	/* 공통코드 */
	@SuppressWarnings("unchecked")
    public List<CommandMap> selectCommCode(Map<String, Object> map) throws Exception{
        return (List<CommandMap>)selectList("phl/common.selectCommCode", map);
    }
	
	@SuppressWarnings("unchecked")
    public String selectCommCodeOne(Map<String, Object> map) throws Exception{
		return (String) selectOne("phl/common.selectCommCodeOne", map);
    }
	
	/* 메뉴조회 (2dept) */
	@SuppressWarnings("unchecked")
    public List<CommandMap> menuListDept2(Map<String, Object> map) throws Exception{
        return (List<CommandMap>)selectList("phl/common.menuListDept2", map);
    }
	
	/* 메뉴조회 (3dept) */
	@SuppressWarnings("unchecked")
    public List<CommandMap> menuListDept3(Map<String, Object> map) throws Exception{
        return (List<CommandMap>)selectList("phl/common.menuListDept3", map);
    }
	
	/* 게시판 이전 다음 페이지 번호 */
	public String selectBoardSn(Map<String, Object> map) throws Exception{
        return (String) selectOne("phl/common.selectBoardSn", map);
    }
	
	/* 게시판 조회수 증가 */
	public void boardHitCount(Map<String, Object> map) throws Exception{
        update("phl/common.boardHitCount", map);
    }
	
}