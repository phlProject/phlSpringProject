package com.phl.common.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.phl.common.CommandMap;
import com.phl.common.dao.PhlCommDAO;

@Service("phlCommService")
public class PhlCommServiceImpl implements PhlCommService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="phlCommDAO")
	private PhlCommDAO phlCommDAO;
	
	/* 공통코드 */
	@Override
    public List<CommandMap> selectCommCode(Map<String, Object> map) throws Exception {
        return phlCommDAO.selectCommCode(map);
    }
	
	@Override
    public String selectCommCodeOne(Map<String, Object> map) throws Exception {
        return phlCommDAO.selectCommCodeOne(map);
    }
	
	/* 메뉴조회 (2dept) */
	@Override
    public List<CommandMap> menuListDept2(Map<String, Object> map) throws Exception {
        return phlCommDAO.menuListDept2(map);
    }
	
	/* 메뉴조회 (3dept) */
	@Override
    public List<CommandMap> menuListDept3(Map<String, Object> map) throws Exception {
        return phlCommDAO.menuListDept3(map);
    }
	
	/* 게시판 이전 다음 페이지 번호 */
	@Override
	public String selectBoardSn(Map<String, Object> map) throws Exception {
		return phlCommDAO.selectBoardSn(map);
	}
	
	/* 게시판 조회수 증가 */
	@Override
	public void boardHitCount(Map<String, Object> map) throws Exception {
		phlCommDAO.boardHitCount(map);
	}
	
}
