<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
	자료 게시판 리스트
	등록 - 선생님 이상 ( G01030 )
	읽기 - 모두 
 -->
<c:set var="authYn" value="N"/>
<c:if test="${loginInfo.MEM_GBN_CD ge 'G01030'}">
	<c:set var="authYn" value="Y"/>
</c:if>

<div id="content">
	<h3 class="cont-title">${item.boardGbnCdNm}</h3>
	<form id="dataList_Form">
		<input type="hidden" id="bsnsCode"    	name="bsnsCode"       	value="${sessionScope.bsnsCode}" >	<!-- 세션_업체코드 -->
		<input type="hidden" id="boardGbnCd" 	name="boardGbnCd"		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
		<input type="hidden" id="boardGbnCdNm" 	name="boardGbnCdNm"		value="${item.boardGbnCdNm}">		<!-- 게시판_구분_명 -->
		
		<!-- 검색조건 -->
		<div class="search">
			<select id="searchSelect" name="searchSelect">
				<option value="searchSubject" <c:if test="${item.searchSelect eq 'searchSubject'}">selected</c:if>>제목</option>
				<option value="searchContent" <c:if test="${item.searchSelect eq 'searchContent'}">selected</c:if>>내용</option>
				<option value="searchSubCon"  <c:if test="${item.searchSelect eq 'searchSubCon'}">selected</c:if>>제목+내용</option>
			</select>
			<input type="text" id="searchWord" name="searchWord" value="${item.searchWord}">
			<input type="button" value="검색" onclick="fn_dataList();" class="button">
		</div>
		<br/>
		<div class="book-tab">
			<c:if test="${empty dataList}">
				<div class="bookList">
					<center><h4>조회 된 내용이 없습니다.</h4></center>
				</div>
			</c:if>
			<c:if test="${not empty dataList}">
			<div class="public">
				
				<c:forEach items="${dataList}" var="row" varStatus="status">
					<div class="public-list">
						<div class="public-img">
							<a href="javascript:fn_dataView('${row.BOARD_SN}')">
							 Image
							</a>
						</div>
						
						<div class="public-title">
							${row.SUBJECT}
						</div>
						<div class="public-down">
							<a href="javascript:fn_boardFlDown('${row.BSNS_CODE}','${row.BOARD_SN}','${row.BOARD_FL_SN}');">
							 Download
							</a>
						</div>
						<div class="public-view">
							<a href="javascript:fn_dataView('${row.BOARD_SN}')">
							  View
							</a>
						</div>
					</div>
					<c:if test="${status.count%4 != 0}">
						<div style="position:relative; float:left; background-color: ; width: 10px; height: 220px;">
						 &nbsp;
						</div>
					</c:if>
				</c:forEach>	
			</div>
			<br/><br/><br/>
			</c:if>		
			
			<!-- 권한 Y 일 경우 신규등록 -->
			<c:if test="${authYn eq 'Y'}">			
				<div class="bookForm">
					<a href="javascript:fn_dataFormI();" id="dataFormI">신규등록</a>
				</div>
			</c:if>
			
			<div class="book_paging">
				<c:if test="${beginPageNum > 5}">
					<a href="<c:out value="/a0000006/board/dataList.do?requestPageNumber=${beginPageNum-1}"/>">◀</a>
				</c:if>
							
				<c:forEach var="requestPageNumber" begin="${beginPageNum}" end="${endPageNum}">
					<a href="<c:out value="/a0000006/board/dataList.do?requestPageNumber=${requestPageNumber}"/>">${requestPageNumber}</a>
				</c:forEach>
							
				<c:if test="${endPageNum < totalPageCount}">
					<a href="<c:out value="/a0000006/board/dataList.do?requestPageNumber=${endPageNum+1}"/>">▶</a>
				</c:if>	
			</div>
		</div>
	</form>		
</div>
