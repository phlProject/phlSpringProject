<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교육나눔 꿈두레 - 책 소개</title>
</head>
<body>
	<div id="content">
		<h3 class="cont-title">책 소개</h3>
		<form id="bookList_Form">
			<input type="hidden" id="bsnsCode"    	name="bsnsCode"       	value="${sessionScope.bsns_code}" >	<!-- 세션_업체코드 -->
			<input type="hidden" id="sessionId"    	name="sessionId"       	value="${sessionScope.session_id}" >	<!-- 세션_업체코드 -->
			<input type="hidden" id="boardGbnCd" 	name="boardGbnCd"		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
			
			<!-- 검색조건 -->
			<div class="search">
				<select id="searchSelect" name="searchSelect">
					<option value="searchSubject" <c:if test="${item.searchSelect eq 'searchSubject'}">selected</c:if>> 제목</option>
					<option value="searchContent" <c:if test="${item.searchSelect eq 'searchContent'}">selected</c:if>>줄거리</option>
					<option value="searchSubCon"  <c:if test="${item.searchSelect eq 'searchSubCon'}">selected</c:if>>제목+줄거리</option>
				</select>
				<input type="text" id="searchWord" name="searchWord" value="${item.searchWord}">
				<input type="button" value="검색" onclick="fn_bookList();" class="button">
			</div>
			<br/>
			<div class="book-tab">
				<c:if test="${empty bookList}">
					<div class="bookList">
						<center><h4>조회 된 내용이 없습니다.</h4></center>
					</div>
				</c:if>
				<c:if test="${not empty bookList}">
					<c:forEach items="${bookList}" var="row">
						<div class="bookList">
							<div class="book-left">
								<img src="${row.FL_PATH}/${row.FL_NM}" width="200" height="160">
							</div>
							<div class="book-right">
								<a href="javascript:fn_bookView('${row.BOARD_SN}')">${row.SUBJECT} ♥${row.LIKE_COUNT}</a>
								<hr color="#e2d318" size="0.3">						
								<p>${row.CONTENT}</p>
							</div>
						</div>
					</c:forEach>
				</c:if>				
					<div class="bookForm">
						<a href="javascript:fn_bookFormI();" id="bookFormI">신규등록</a>
					</div>
				<div class="book_paging">
					<c:if test="${beginPageNum > 5}">
						<a href="<c:out value="/a0000006/board/bookList.do?requestPageNumber=${beginPageNum-1}"/>">◀</a>
					</c:if>
								
					<c:forEach var="requestPageNumber" begin="${beginPageNum}" end="${endPageNum}">
						<a href="<c:out value="/a0000006/board/bookList.do?requestPageNumber=${requestPageNumber}"/>">${requestPageNumber}</a>
					</c:forEach>
								
					<c:if test="${endPageNum < totalPageCount}">
						<a href="<c:out value="/a0000006/board/bookList.do?requestPageNumber=${endPageNum+1}"/>">▶</a>
					</c:if>	
				</div>			
			</div>
		</form>
	</div>
</body>
</html>