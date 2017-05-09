package com.phl.util;

import java.util.Calendar;

public class CmmnUtil {

	/**
	 * 
	 * 오늘날짜
	 * 
	 * @param 
	 * @return 
	 * @exception 
	 * @see
	 * 
	 *   
	 */
	
	public String getToday (){
		Calendar cal=Calendar.getInstance ( );
		StringBuffer sbDate=new StringBuffer ( );
		 
		int nYear = cal.get ( Calendar.YEAR );
		int nMonth = cal.get ( Calendar.MONTH ) + 1;
		int nDay = cal.get ( Calendar.DAY_OF_MONTH );
		 
		 
		sbDate.append ( nYear );
		sbDate.append ( "-" );
		if ( nMonth < 10 ) 
		sbDate.append ( "0" );
		sbDate.append ( nMonth );
		sbDate.append ( "-" );
		if ( nDay < 10 ) 
		sbDate.append ( "0" );
		sbDate.append ( nDay );
		 
		 
		return sbDate.toString ( );

	} 
	
	/**
	 * 
	 * iMth 만큼 달을 빼거나 더한 날짜를 반환.
	 * 
	 * @param 
	 * @return 
	 * @exception 
	 * @see
	 * 
	 *   
	 */
	
	public String getDateByMth ( int iMth ){
		
		Calendar cal = Calendar.getInstance ( );//오늘 날짜를 기준으루..
		StringBuffer sbDate=new StringBuffer ( );
		 

		cal.add ( cal.MONTH, iMth);  
		 
		 
		int nYear = cal.get ( Calendar.YEAR );
		int nMonth = cal.get ( Calendar.MONTH ) + 1;
		int nDay = cal.get ( Calendar.DAY_OF_MONTH );
		 
		 
		sbDate.append ( nYear );
		sbDate.append ( "-" );
		if ( nMonth < 10 ) 
		sbDate.append ( "0" );
		sbDate.append ( nMonth );
		sbDate.append ( "-" );
		if ( nDay < 10 ) 
		sbDate.append ( "0" );
		sbDate.append ( nDay );
		 
		 
		return sbDate.toString ( );

	} 

	
	
	/**
	 * 
	 * iDay 만큼 날수를 빼거나 더한 날짜를 반환.
	 * 
	 * @param 
	 * @return 
	 * @exception 
	 * @see
	 * 
	 *   
	 */
	
	public String getDateByDay ( int iDay ){
		Calendar cal=Calendar.getInstance ( );
		StringBuffer sbDate=new StringBuffer ( );
		 
		 
		cal.add ( Calendar.DAY_OF_MONTH, iDay );
		 
		 
		int nYear = cal.get ( Calendar.YEAR );
		int nMonth = cal.get ( Calendar.MONTH ) + 1;
		int nDay = cal.get ( Calendar.DAY_OF_MONTH );
		 
		 
		sbDate.append ( nYear );
		sbDate.append ( "-" );
		if ( nMonth < 10 ) 
		sbDate.append ( "0" );
		sbDate.append ( nMonth );
		sbDate.append ( "-" );
		if ( nDay < 10 ) 
		sbDate.append ( "0" );
		sbDate.append ( nDay );
		sbDate.append ( "-" );
		 
		 
		return sbDate.toString ( );

	} 
	
	/**
	 * 
	 * 8자리 문자열을 날짜 포맷터 추가 하여 반환.
	 * 
	 * @param 
	 * @return 
	 * @exception 
	 * @see
	 * 
	 *   
	 */
	
	public String getDateFormat (String strDate, String formatter ){
		String result = strDate;
		result = strDate.substring(0, 4) + formatter + strDate.substring(4, 6) + formatter + strDate.substring(6);
		
		return result;

	} 

	
	/**
	 * 
	 * 문자열 치환
	 * 
	 * @param 
	 * @return 
	 * @exception 
	 * @see
	 * 
	 *   
	 */
	
	public String replaceStr (String strOri, String strReplaceOri, String StrReplace ){
		String result = "";
		result = strOri.replaceAll(strReplaceOri, StrReplace);
		
		return result;
	}    
	   
	

	/**
	 * ,붙은 파리미터를 '',''로 변경해주는 함수
	 * @param String str
	 * @return String
	 * @throws Exception
	 */
	public static String getCommaParam(String str) throws Exception {
		String ret = "";
		String retAry[] = str.split(",");
		//if (str == null || "".equals(str)) {
		if ("".equals(str)) {
			return ret;
		}
		for(int i = 0; i < retAry.length; i++){
			//System.out.println(retAry[i]);
			//""의 경우 ''붙이는 처리 안함
			if ("".equals(retAry[i])) {
				continue;
			}
			if ("".equals(ret)) {
				ret += "'"+retAry[i].replaceAll(" ", "")+"'";
			} else {
				ret += ",'"+retAry[i].replaceAll(" ", "")+"'";
			}
		}
		return ret;
	}
}
