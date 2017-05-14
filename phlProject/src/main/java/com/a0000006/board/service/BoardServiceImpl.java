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
	
	
	/****************************** 책 소 개 시작  ******************************/
	
	/* 책소개 > 조회 > Count */
	public int bookListCnt(Map<String, Object> map) throws Exception {
        return boardDAO.bookListCnt(map);
    }
	
	/* 책소개 > 조회  */
	@Override
    public List<Map<String, Object>> bookList(Map<String, Object> map) throws Exception {
        return boardDAO.bookList(map);
    }
	
	/* 책소개 > 상세 */
	@Override
    public List<Map<String, Object>> bookView(Map<String, Object> map) throws Exception {
        return boardDAO.bookView(map);
    }
	
	/* 책소개 > 등록 */
	@Override
	public int insertBook(Map<String, Object> map) throws Exception {
		try {
			boardDAO.insertBook(map);
			
			// 전 등록된 Seq 가져오기
			int board_sn = boardDAO.seqSn();
			
			return board_sn;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/* 책소개 > 수정 */
	@Override
	public String updateBook(Map<String, Object> map) throws Exception {
		try {
			boardDAO.updateBook(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 책소개 > 삭제 */
	@Override
	public String deleteBook(Map<String, Object> map) throws Exception {
		try {
			boardDAO.deleteBook(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 게시판 > 파일 등록 */
	public String insertBoardFl(Map<String, Object> map) throws Exception {
		try {
			boardDAO.insertBoardFl(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 게시판 > 파일 수정 */
	public String updateBoardFl(Map<String, Object> map) throws Exception {
		try {
			boardDAO.updateBoardFl(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/****************************** 책 소 개 종료  ******************************/
	
	/****************************** 간 행 물 시작  ******************************/
	
	/* 간행물 > 조회 > Count */
	public int publiListCnt(Map<String, Object> map) throws Exception {
        return boardDAO.publiListCnt(map);
    }
	
	/* 간행물 > 조회  */
	@Override
    public List<Map<String, Object>> publiList(Map<String, Object> map) throws Exception {
        return boardDAO.publiList(map);
    }
	
	/****************************** 간 행 물 종료  ******************************/
	
	@Override
    public List<Map<String, Object>> flList(Map<String, Object> map) throws Exception {
        return boardDAO.flList(map);
	}
}
