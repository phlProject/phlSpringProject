<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교육나눔 꿈두레</title>
</head>
<body>
	<div id="content">
		<h3 class="cont-title">간행물</h3>
		<form id="dataList_Form">
			<input type="hidden" id="bsnsCode"    	name="bsnsCode"       	value="${sessionScope.bsns_code}" >	<!-- 세션_업체코드 -->
			<input type="hidden" id="boardGbnCd" 	name="boardGbnCd"		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
			
			<!-- 검색조건 -->
			<div class="search">
				<select id="searchSelect" name="searchSelect">
					<option value="searchSubject" <c:if test="${item.searchSelect eq 'searchSubject'}">selected</c:if>>제목</option>
					<option value="searchContent" <c:if test="${item.searchSelect eq 'searchContent'}">selected</c:if>>줄거리</option>
					<option value="searchSubCon"  <c:if test="${item.searchSelect eq 'searchSubCon'}">selected</c:if>>제목+줄거리</option>
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
				<div class="bookForm">
					<a href="javascript:fn_dataFormI();" id="dataFormI">신규등록</a>
				</div>
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
</body>
</html>