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
		
		int toYear = (Integer) map.get("toYear");
		int toDay = (Integer) map.get("toDay");
		
		if(toYear == 0){
			toYear = Integer.parseInt(sdf.format(d).substring(0, 4));
			toDay = Integer.parseInt(sdf.format(d).substring(5, 7));
		}
		
		map.put("toYear", toYear);
		map.put("toDay", toDay);
		
		return applyDAO.applyList(map);
	}
	
	
}
