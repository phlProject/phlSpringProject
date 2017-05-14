package com.phl.util;

public class CmmnUtilPaging {

	/* 
	 ** 페이징 계산 ** 
	 * 
	 * 파라미터 : 전체리스트 Count, 요청페이지번호, 페이지당리스트갯수
	 * pagingData[0] = 전체 페이지수
	 * pagingData[1] = FirstRow ( Limit 사용 용도 )
	 * pagingData[2] = EndRow	( Limit 사용 용도 )
	 * pagingData[3] = 첫 페이지 번호
	 * pagingData[4] = 끝 페이지 번호
	 * 
	 */
	public static int[] paginData(int totalListCount, int requestPageNumber, int countPerPage){
		
		// 리스트 총 페이지 Count
		int totalPageCount = calculateTotalPageCount(totalListCount, countPerPage);
		
		// 페이지당 첫 로우 번호
		int firstRow = (requestPageNumber -1) * countPerPage + 1;

		// 페이지당 끝 로우 번호
		int endRow = firstRow + countPerPage - 1;
		if(endRow > totalListCount){
			endRow = totalListCount;
		}
		
		// 첫 페이지 번호
		int beginPageNum = (requestPageNumber - 1) / countPerPage * countPerPage + 1;
		
		// 끝 페이지 번호
		int endPageNum = beginPageNum + (countPerPage-1);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;
		}
		
		int paginData[] = {totalPageCount, firstRow, endRow, beginPageNum, endPageNum};
		
		return paginData;
	}
	
	/*
	 *	페이지 계산 
	 */
	public static int calculateTotalPageCount(int totalListCount, int countPerPage){
		if(totalListCount == 0){
			return 0;
		}
		
		int pageCount = totalListCount / countPerPage;
		if(totalListCount % countPerPage > 0){
			pageCount++;
		}
		
		return pageCount;
	}
}
