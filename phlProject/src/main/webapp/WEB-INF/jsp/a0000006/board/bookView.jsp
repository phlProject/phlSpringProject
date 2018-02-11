<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
	자료 게시판 상세화면
	수정/삭제 - 선생님 이상, 세션ID = 등록ID
 -->
<c:set var="authYn" value="N"/>
<c:if test="${loginInfo.MEM_GBN_CD ge 'G01030' && loginInfo.MEM_ID eq bookView.REG_ID}">
	<c:set var="authYn" value="Y"/>
</c:if>


<!-- 목록이동_Form -->
<form id="bookList_Form">
	<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}">		<!-- 검색구분 -->
	<input type="hidden" id="searchWord" 	name="searchWord" 		value="${item.searchWord}">			<!-- 검색어 -->
	<input type="hidden" id="bsnsCode"      name="bsnsCode"         value="${bookView.BSNS_CODE}">		<!-- 업체코드 -->
	<input type="hidden" id="boardSn" 		name="boardSn" 			value="${bookView.BOARD_SN}">		<!-- 게시판 번호 -->
	<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
	<input type="hidden" id="boardGbnCdNm" 	name="boardGbnCdNm"		value="${item.boardGbnCdNm}">		<!-- 게시판_구분_명 -->
	<input type="hidden" id="likeYn"		name="likeYn"			value="${bookView.LIKE_YN}">		<!-- 라이크 유무 -->
	<input type="hidden" id="sessionId" 	name="sessionId"		value="${sessionScope.sessionId}">	<!-- 세션_아이디(등록자/수정자) -->
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
		<div class="imgBox">
			<img src="${bookView.FL_PATH}/${bookView.FL_NM}">
		</div>
	</div>
		 <p class="detail">지은이&nbsp;:&nbsp;${bookView.BOOK_WRITER}&nbsp;&nbsp;|&nbsp;&nbsp;출판사&nbsp;:&nbsp;${bookView.BOOK_PUBLISHER}&nbsp;&nbsp;|&nbsp;&nbsp;가격&nbsp;:&nbsp;${bookView.BOOK_PRICE} </p>
		 <hr color="#dddddd" size="0.2">
		 <br>${bookView.CONTENT}
	<div class="bookView">	
		<div class="bookView-btn">
			<c:if test="${authYn eq 'Y'}">
			<a href="javascript:fn_bookFormU();" 	id="bookFormU">수정</a>
			<a href="javascript:fn_deleteBook();" 	id="deleteBook">삭제</a>		
			</c:if>
			<a href="javascript:fn_bookList();" 	id="bookList">목록</a>
		</div>
	</div>
</div>
	
