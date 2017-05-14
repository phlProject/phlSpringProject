package com.phl.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.phl.common.CommandMap;


public class CmmnUtilFile {

	private static String filePathBase;		// 서버파일 full경로
	private static String filePathSub;		// 서버파일 Sub경로
	
	/**
	 * 	파일 업로드(폴더 생성 및 파일 업로드)
	 */
	public static List<Map<String,Object>> uploadFile(HttpServletRequest request) throws ServletException, IOException, Exception {

		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
	 	Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		
		          
		String charenc = "";		// 변환 파일명
		String fileName = "";		// 원본 파일명
		String filePath = "";		// 전체 파일 경로
		String filePathS = "";		// Sub 파일 경로
		String originalFileExtension = null;
		MultipartFile multipartFile = null;
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String, Object> listMap = null; 
		try {
			
			setFilePathBase();
			
			filePath = filePathBase;
			filePathS = filePathSub;
			charenc = getRandomString();
			
			final String[] badExt = { "jsp", "php", "asp", "aspx", "html", "htm", "js", "perl", "exe", "java", "class" };
			
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
	            	System.out.println(originalFileExtension);
	            	for(int j=0; j<badExt.length; j++){
	            		if(originalFileExtension.toLowerCase().equals("."+badExt[j])){
	            			System.out.println("불가");
	            			throw new Exception();
	            		}
	            	}
	            	charenc = getRandomString() + originalFileExtension;
	                 
	                fp = new File(filePath + charenc);
	                multipartFile.transferTo(fp);
	                listMap = new HashMap<String,Object>();
	                listMap.put("ORIGIN_FL_NM", fileName);
	                listMap.put("FL_NM", charenc);
	                listMap.put("FL_PATH", filePathS);
	                list.add(listMap);
	            }
	        }
			
		}catch (Exception e) {
			throw e;
		}
		
		
		return list;
		
	}
	
	/**
	 * 	파일 다운로드
	 * @throws
	 */
	public static void downloadFile(CommandMap commandMap, HttpServletRequest request, HttpServletResponse res) throws IOException{
		
		
		ServletContext context = request.getSession().getServletContext();
		
		setFilePathBase();
		String svrFlPth = filePathBase;
		
	    String svrFlNm = (String) commandMap.get("flNm");
	    String svrFlFullNm = svrFlPth + svrFlNm;
	    
	    System.out.println(svrFlFullNm);
	    
	    String locFlNm = (String) commandMap.get("originFlNm");

	    String charenc = "UTF-8";
		File file = new File(svrFlFullNm);
		
		if(!file.isFile()){
			// 동일한 파일이 있는지 다시 한번 확인함.
			try {
				throw new Exception("해당 파일이 존재하지 않습니다.") ;
			} catch (Exception e) {
				//e.printStackTrace();
			}
			
		}
		
		String mimeType = context.getMimeType(svrFlFullNm);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		
		res.setCharacterEncoding(charenc);		
		//res.setContentType("application/download");
		res.setContentType(mimeType);
		
		if(locFlNm != null){
			//res.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode( new String(locFileNm.getBytes("UTF-8"))) + ";");
			res.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(locFlNm, charenc) + ";");
		}
		res.setHeader("Content-Length", String.valueOf(file.length()));
		
		// 자바 I/O 를 이용하여 다운로드해 준다.
		byte[] buffer = new byte[1024];

		ServletOutputStream out = res.getOutputStream();
		BufferedInputStream in = null;
		
		try {
			in = new BufferedInputStream(new FileInputStream(file));
			int n = 0;
			while ((n = in.read(buffer, 0, 1024)) != -1) {
				out.write(buffer, 0, n);
			}// while
		} catch (Exception e) {
			
			
		} finally {
			out.flush();
			if (in != null)
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			if (out != null)
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}// finally
		
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
		
		SimpleDateFormat toFormat = new SimpleDateFormat("yyyyMMdd");
		String thisDate = toFormat.format(new Date());
		
		filePathBase = realPath;
		
		filePathSub = "/file/" + request.getAttribute("fullSubPath") + thisDate + "/";

		filePathBase = realPath + filePathSub;
	}		   
}
