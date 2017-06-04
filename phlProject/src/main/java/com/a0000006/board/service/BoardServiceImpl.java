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
	
	/* 책소개 > 상세 폼 */
	@Override
    public List<Map<String, Object>> bookView(Map<String, Object> map) throws Exception {
        return boardDAO.bookView(map);
    }
	
	/* 책소개 > 등록 */
	@Override
	public int insertBook(Map<String, Object> map) throws Exception {
		try {
			boardDAO.insertBook(map);
			
			// 게시판 공통 > 일련번호 조회
			int boardSn = boardDAO.selectboardSn();
			
			return boardSn;
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
	
	/* 책소개 > 좋아요 Count */
	@Override
	public String bookLikeCount(Map<String, Object> map) throws Exception {
		try {
			boardDAO.bookLikeCount(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 책소개 > 좋아요 등록/수정 */
	@Override
	public String bookLikeHistory(Map<String, Object> map) throws Exception {
		try {
			boardDAO.bookLikeHistory(map);
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
	
	/* 간행물 > 상세 폼 */
	@Override
    public List<Map<String, Object>> publiView(Map<String, Object> map) throws Exception {
        return boardDAO.publiView(map);
    }
	
	/* 간행물 > 등록 */
	@Override
	public int insertPubli(Map<String, Object> map) throws Exception {
		try {
			boardDAO.insertPubli(map);
			
			// 게시판 공통 > 일련번호 조회
			int boardSn = boardDAO.selectboardSn();
			
			return boardSn;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/* 간행물 > 수정 */
	@Override
	public String updatePubli(Map<String, Object> map) throws Exception {
		try {
			boardDAO.updatePubli(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 간행물 > 삭제 */
	@Override
	public String deletePubli(Map<String, Object> map) throws Exception {
		try {
			boardDAO.deletePubli(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/****************************** 간 행 물 종료  ******************************/
	
	/****************************** 게시판 공통 시작  ******************************/
	
	/* 게시판 공통 > 파일 등록 */
	public String insertBoardFl(Map<String, Object> map) throws Exception {
		try {
			boardDAO.insertBoardFl(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 게시판 공통 > 파일 수정 */
	public String updateBoardFl(Map<String, Object> map) throws Exception {
		try {
			boardDAO.updateBoardFl(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 게시판 공통 > 파일다운로드 > 조회 */
	@Override
    public List<Map<String, Object>> boardFlList(Map<String, Object> map) throws Exception {
        return boardDAO.boardFlList(map);
	}
	
	/****************************** 게시판 공통 종료  ******************************/
	

}
