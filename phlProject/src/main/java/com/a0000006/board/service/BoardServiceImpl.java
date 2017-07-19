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
	
	
	
	/*********************************************************************/
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
	
	/* 책소개 > 등록(상세) */
	@Override
	public void insertBookDetail(Map<String, Object> map) throws Exception {
		try {
			boardDAO.insertBookDetail(map);
		} catch (Exception e) {
			e.printStackTrace();
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
	/*********************************************************************/
	
	
	/*********************************************************************/
	/********************** 자 료 공 통 시작 (교육, 정책, 기타 ) **********************/
	
	/* 자료공통 > 조회 > Count */
	public int dataListCnt(Map<String, Object> map) throws Exception {
        return boardDAO.dataListCnt(map);
    }
	
	/* 자료공통 > 조회  */
	@Override
    public List<Map<String, Object>> dataList(Map<String, Object> map) throws Exception {
        return boardDAO.dataList(map);
    }
	
	/* 자료공통 > 상세 폼 */
	@Override
    public List<Map<String, Object>> dataView(Map<String, Object> map) throws Exception {
        return boardDAO.dataView(map);
    }
	
	/* 자료공통 > 등록 */
	@Override
	public int insertData(Map<String, Object> map) throws Exception {
		try {
			boardDAO.insertData(map);

			// 게시판 공통 > 일련번호 조회
			int boardSn = boardDAO.selectboardSn();
			return boardSn;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/* 자료공통 > 수정 */
	@Override
	public String updateData(Map<String, Object> map) throws Exception {
		try {
			boardDAO.updateData(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 자료공통 > 삭제 */
	@Override
	public String deleteData(Map<String, Object> map) throws Exception {
		try {
			boardDAO.deleteData(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	
	/********************** 자 료 공 통 종료 (교육, 정책, 기타 ) **********************/
	/*********************************************************************/
	
	
	/*********************************************************************/
	/***************************** 게시판 공통 시작  *****************************/
	
	/* 게시판 공통 > 파일 등록 ( 'file' / 'image' )*/
	public String insertBoardAttach(Map<String, Object> map, String attach) throws Exception {
		try {
			if(attach.equals("file")){
				boardDAO.insertBoardFl(map);
			}else if(attach.equals("image")){
				boardDAO.insertBoardImg(map);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 게시판 공통 > 파일 수정 */
	public String updateBoardAttach(Map<String, Object> map, String attach) throws Exception {
		try {
			if(attach.equals("file")){
				boardDAO.updateBoardFl(map);
			}else if(attach.equals("image")){
				boardDAO.updateBoardImg(map);
			}
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
	
	/***************************** 게시판 공통 종료  *****************************/
	/*********************************************************************/
	

}
