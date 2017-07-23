<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교육나눔 꿈두레 - 책 소개</title>
</head>
<body>
	<!-- 목록이동_Form -->
	<form id="bookList_Form">
		<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}">		<!-- 검색구분 -->
		<input type="hidden" id="searchWord" 	name="searchWord" 		value="${item.searchWord}">			<!-- 검색어 -->
		<input type="hidden" id="bsnsCode"      name="bsnsCode"         value="${bookView.BSNS_CODE}">		<!-- 업체코드 -->
		<input type="hidden" id="boardSn" 		name="boardSn" 			value="${bookView.BOARD_SN}">		<!-- 게시판 번호 -->
		<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
		<input type="hidden" id="boardGbnCdNm" 	name="boardGbnCdNm"		value="${item.boardGbnCdNm}">		<!-- 게시판_구분_명 -->
		<input type="hidden" id="likeYn"		name="likeYn"			value="${bookView.LIKE_YN}">		<!-- 라이크 유무 -->
	</form>
	
	<div id="content">
		<h3 class="cont-title">${item.boardGbnCdNm}</h3>
		<p class="book-view">
			제목 : ${bookView.SUBJECT}
			<c:choose>
				<c:when test="${not empty sessionScope.sessionId}">
					<c:if test="${bookView.LIKE_YN eq 'Y'}">
						<a href="javascript:fn_bookLike();"><span id="likeImage">♥</span></a>
					</c:if>
					<c:if test="${bookView.LIKE_YN eq 'N' or empty bookView.LIKE_YN}">
						<a href="javascript:fn_bookLike();"><span id="likeImage">♡</span></a>
					</c:if>
				</c:when>
				<c:otherwise>
					♡ 
				</c:otherwise>
			</c:choose>
		</p>
		<div class="view">
			<img src="${bookView.FL_PATH}/${bookView.FL_NM}" width="100%" height="auto">
		</div>
			 지은이:${bookView.BOOK_WRITER} 출판사:${bookView.BOOK_PUBLISHER} 가격:${bookView.BOOK_PRICE}
			 <br><br>${bookView.CONTENT}
		<div class="bookView">	
			<div class="bookView-btn">
				<a href="javascript:fn_bookFormU();" 	id="bookFormU">수정</a>
				<a href="javascript:fn_deleteBook();" 	id="deleteBook">삭제</a>		
				<a href="javascript:fn_bookList();" 	id="bookList">목록</a>
			</div>
		</div>
	</div>
	
</body>
</html>