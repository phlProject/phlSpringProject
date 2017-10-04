package com.a0000006.network.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.network.dao.NetworkDAO;

@Service("networkService")
public class NetworkServiceImpl implements NetworkService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="networkDAO")
	private NetworkDAO networkDAO;
	
	/* 네트워크게시판 > 조회 > Count */
	public int networkBoardListCnt(Map<String, Object> map) throws Exception {
        return networkDAO.networkBoardListCnt(map);
    }
	
	/* 네트워크게시판 > 조회 */
	@Override
    public List<Map<String, Object>> networkBoardList(Map<String, Object> map) throws Exception {
        return networkDAO.networkBoardList(map);
    }
	
	/* 네트워크게시판 > 상세 폼 */
	@Override
    public List<Map<String, Object>> networkBoardView(Map<String, Object> map) throws Exception {
        return networkDAO.networkBoardView(map);
    }
	
	/* 네트워크게시판 > 등록 */
	@Override
	public int insertNetworkBoard(Map<String, Object> map) throws Exception {
		try {
			networkDAO.insertNetworkBoard(map);
			
			// 게시판 공통 > 일련번호 조회
			int boardSn = networkDAO.selectboardSn();
			
			return boardSn;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/* 네트워크게시판 > 수정 */
	@Override
	public String updateNetworkBoard(Map<String, Object> map) throws Exception {
		try {
			networkDAO.updateNetworkBoard(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	/* 네트워크게시판 > 삭제 */
	@Override
	public String deleteNetworkBoard(Map<String, Object> map) throws Exception {
		try {
			networkDAO.deleteNetworkBoard(map);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
}
