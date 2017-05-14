package com.a0000006.apply.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.a0000006.apply.dao.ApplyDAO;
import com.phl.common.CommandMap;


@Service("applyService")
public class ApplyServiceImpl implements ApplyService{

	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="applyDAO")
	private ApplyDAO applyDAO;

	
	// 스케줄 목록
	@Override
	public List<CommandMap> applyList(Map<String, Object> map) throws Exception {
		
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
		
		return applyDAO.applyList(map);
	}


	// 신청 등록
	@Override
	public String insertApply(Map<String, Object> map) throws Exception {
		try {
			applyDAO.insertApply(map);
			return "0";
		} catch (Exception e) {
			return "-1";
		}
		
	}


	// 상세 페이지
	@Override
	public Map<String, Object> viewApply(Map<String, Object> map) throws Exception {
		return applyDAO.viewApply(map);
	}


	// 수정 페이지
	@Override
	public String updateApply(Map<String, Object> map) throws Exception {
		try {
			applyDAO.updateApply(map);
			return "0";
		} catch (Exception e) {
			return "-1";
		}
	}
	
	// 삭제 페이지
	@Override
	public String deleteApply(Map<String, Object> map) throws Exception {
		try {
			applyDAO.deleteApply(map);
			return "0";
		} catch (Exception e) {
			return "-1";
		}
	}
	
	
}
