<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
	네트워크 게시판 상세화면
	수정/삭제 - 선생님 이상, 세션ID = 등록ID
 -->
<c:set var="authYn" value="N"/>
<c:if test="${loginInfo.MEM_GBN_CD ge 'G01030' && loginInfo.MEM_ID eq bookView.REG_ID}">
	<c:set var="authYn" value="Y"/>
</c:if>

<!-- 목록이동_Form -->
<form id="networkBoardList_Form">
	<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}">		<!-- 검색구분 -->
	<input type="hidden" id="searchWord" 	name="searchWord" 		value="${item.searchWord}">			<!-- 검색어 -->
	<input type="hidden" id="bsnsCode"      name="bsnsCode"         value="${networkBoardView.BSNS_CODE}">	<!-- 업체코드 -->
	<input type="hidden" id="boardSn" 		name="boardSn" 			value="${networkBoardView.BOARD_SN}">	<!-- 게시판 번호 -->
	<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
	<input type="hidden" id="boardGbnCdNm" 	name="boardGbnCdNm"		value="${item.boardGbnCdNm}">		<!-- 게시판_구분_명 -->
</form>

<div id="content">
	<h3 class="cont-title">${item.boardGbnCdNm}</h3>
	<p class="book-view">
		제목 : ${networkBoardView.SUBJECT}
	</p>
	
	 <hr color="#dddddd" size="0.2">
	 <br>${networkBoardView.CONTENT}
	 
	<div class="bookView">	
		<div class="bookView-btn">
			<c:if test="${authYn eq 'Y'}">
			<a href="javascript:fn_networkBoardFormU();" 	id="networkBoardFormU">수정</a>
			<a href="javascript:fn_deleteNetworkBoard();" 	id="deleteNetworkBoard">삭제</a>		
			</c:if>
			<a href="javascript:fn_networkBoardList();" 	id="networkBoardList">목록</a>
		</div>
	</div>
</div>
	
