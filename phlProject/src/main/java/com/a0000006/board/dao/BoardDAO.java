package com.a0000006.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.phl.dao.AbstractDAO;

@Repository("BoardDAO")
public class BoardDAO extends AbstractDAO {

	/*********************************************************************/
	/****************************** 책 소 개 시작  ******************************/
	
	/* 책소개 > 조회 > Count */
	public int bookListCnt(Map<String, Object> map) throws Exception{
        return (Integer) selectOne("a0000006/board.bookListCnt", map);
    }
	
	/* 책소개 > 조회  */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> bookList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/board.bookList", map);
    }
	
	/* 책소개 > 상세 폼 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> bookView(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/board.bookView", map);
    }
	
	/* 책소개 > 등록 */
	public void insertBook(Map<String, Object> map) throws Exception{
	    insert("a0000006/board.insertBook", map);
	}
	
	/* 책소개 > 등록(상세) */
	public void insertBookDetail(Map<String, Object> map) throws Exception{
	    insert("a0000006/board.insertBookDetail", map);
	}
	
	/* 책소개 > 수정 */
	public void updateBook(Map<String, Object> map) throws Exception{
	    update("a0000006/board.updateBook", map);
	}
	
	/* 책소개 > 삭제 */
	public void deleteBook(Map<String, Object> map) throws Exception{
	    update("a0000006/board.deleteBook", map);
	}
	
	/* 책소개 > 좋아요 Count */
	public void bookLikeCount(Map<String, Object> map) throws Exception{
		update("a0000006/board.bookLikeCount", map);
	}
	
	/* 책소개 > 좋아요 등록/수정 */
	public void bookLikeHistory(Map<String, Object> map) throws Exception{
	    insert("a0000006/board.bookLikeHistory", map);
	}
	
	/****************************** 책 소 개 종료  ******************************/
	/*********************************************************************/
	
	
	/*********************************************************************/
	/********************** 자 료 공 통 시작 (교육, 정책, 기타 ) **********************/
	
	/* 간행물 > 조회 > Count */
	public int dataListCnt(Map<String, Object> map) throws Exception{
        return (Integer) selectOne("a0000006/board.dataListCnt", map);
    }
	
	/* 간행물 > 조회  */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> dataList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/board.dataList", map);
    }
	
	/* 간행물 > 상세 폼 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> dataView(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/board.dataView", map);
    }
	
	/* 간행물 > 등록 */
	public void insertData(Map<String, Object> map) throws Exception{
	    insert("a0000006/board.insertData", map);
	}
	
	/* 간행물 > 수정 */
	public void updateData(Map<String, Object> map) throws Exception{
	    update("a0000006/board.updateData", map);
	}
	
	/* 간행물 > 삭제 */
	public void deleteData(Map<String, Object> map) throws Exception{
	    update("a0000006/board.deleteData", map);
	}
	
	
	/********************** 자 료 공 통 종료 (교육, 정책, 기타 ) **********************/
	/*********************************************************************/
	
	/****************************** 간 행 물 시작  ******************************/
	
	/* 간행물 > 조회 > Count */
	public int publiListCnt(Map<String, Object> map) throws Exception{
        return (Integer) selectOne("a0000006/board.publiListCnt", map);
    }
	
	/* 간행물 > 조회  */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> publiList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/board.publiList", map);
    }
	
	/* 간행물 > 상세 폼 */
	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> publiView(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/board.publiView", map);
    }
	
	/* 간행물 > 등록 */
	public void insertPubli(Map<String, Object> map) throws Exception{
	    insert("a0000006/board.insertPubli", map);
	}
	
	/* 간행물 > 수정 */
	public void updatePubli(Map<String, Object> map) throws Exception{
	    update("a0000006/board.updatePubli", map);
	}
	
	/* 간행물 > 삭제 */
	public void deletePubli(Map<String, Object> map) throws Exception{
	    update("a0000006/board.deletePubli", map);
	}
	
	/****************************** 간 행 물 종료  ******************************/
	
	
	/*********************************************************************/
	/***************************** 게시판 공통 시작  *****************************/
	
	/* 게시판 공통 > 일련번호 조회 */
	public int selectboardSn() throws Exception{
	    return (Integer) selectOne("a0000006/board.selectboardSn");
	}
	
	/* 게시판 공통 > 파일 등록 (파일) */
	public void insertBoardFl(Map<String, Object> map) throws Exception{
	    insert("a0000006/board.insertBoardFl", map);
	}
	
	/* 게시판 공통 > 파일 등록 (이미지) */
	public void insertBoardImg(Map<String, Object> map) throws Exception{
	    insert("a0000006/board.insertBoardImg", map);
	}
	
	/* 게시판 공통 > 파일 수정 */
	public void updateBoardFl(Map<String, Object> map) throws Exception{
	    update("a0000006/board.updateBoardFl", map);
	}
	
	/* 게시판 공통 > 파일 수정 */
	public void updateBoardImg(Map<String, Object> map) throws Exception{
	    update("a0000006/board.updateBoardImg", map);
	}
	
	/* 게시판 공통 > 파일다운로드 > 조회 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> boardFlList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList("a0000006/board.boardFlList", map);
    }
	
	/***************************** 게시판 공통 종료  *****************************/
	/*********************************************************************/
	
	

}
