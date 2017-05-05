package com.phl.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public class CmmnUtilFile {

	private static String fullName;			// 서버파일 full경로
	private static String path;				// 서버파일경로
	private static String rename;			// 서버파일명	
	
	private static String filePathBase;		// 기본파일경로 
	
	public CmmnUtilFile(){
		fullName 	= "";
		path 		= "";
		rename 		= "";
	}
	
	/**
	 * 	파일 업로드(폴더 생성 및 파일 업로드)
	 */
	public static List<Map<String,Object>> uploadFile(HttpServletRequest request) throws ServletException, IOException, Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
	 	Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		
		
		String charenc = "";		// 변환 파일명
		String fileName = "";		// 원본 파일명
		String filePath = "";		// 전체 파일 경로
		String originalFileExtension = null;
		MultipartFile multipartFile = null;
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String, Object> listMap = null; 
		try {
			setFilePathBase();
			
			filePath = filePathBase;
			charenc = getRandomString();
		
			// 폴더 생성
			File fp = new File(filePath);
			if (!fp.exists()){
				fp.mkdirs();
			}
			
			while(iterator.hasNext()){
	            multipartFile = multipartHttpServletRequest.getFile(iterator.next());
	            if(multipartFile.isEmpty() == false){
	            	fileName = multipartFile.getOriginalFilename();
	                originalFileExtension = fileName.substring(fileName.lastIndexOf("."));
	                charenc = getRandomString() + originalFileExtension;
	                 
	                fp = new File(filePath + charenc);
	                multipartFile.transferTo(fp);
	                
	                listMap = new HashMap<String,Object>();
	                listMap.put("ORIGIN_FL_NM", fileName);
	                listMap.put("FL_NM", charenc);
	                listMap.put("FL_PATH", filePath);
	                list.add(listMap);
	            }
	        }
			
		}catch (Exception e) {
			throw e;
		}
		
		
		return list;
		
	}
	
	/**
	 * 변환 이름지정
	 */
	public static String getRandomString(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


	
	/**
	 * 경로 지정 
	 */
	public static void setFilePathBase(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		ServletContext context = request.getSession().getServletContext();
		   
		// 파일 기본 경로  2017.02.01 
		String realPath = context.getRealPath("/");
		realPath = realPath.substring(0, realPath.length()-1);
		   		
		filePathBase = realPath;
		  
		// 변경 해야됨
		boolean pCt = realPath.contains("/app/online/");
		if(pCt){
			// not local
			filePathBase = realPath + "/file/a0000006/board/";
		}else{
			// local
			filePathBase = realPath + "\\file\\a0000006\\board\\";
		}
	}		   
}
