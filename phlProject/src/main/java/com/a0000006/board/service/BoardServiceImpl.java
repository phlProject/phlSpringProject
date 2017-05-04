package com.a0000006.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.board.dao.BoardDAO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="BoardDAO")
	private BoardDAO boardDAO;
	
	/* 책소개 리스트 */
	@Override
    public List<Map<String, Object>> selectbookList(Map<String, Object> map) throws Exception {
        return boardDAO.selectbookList(map);
    }
	
	/* 책소개 등록 */
	@Override
	public String insertBook(Map<String, Object> map) throws Exception {
		try {
			boardDAO.insertBook(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 책소개 상세 */
	@Override
    public List<Map<String, Object>> selectbookView(Map<String, Object> map) throws Exception {
        return boardDAO.selectbookView(map);
    }
}
