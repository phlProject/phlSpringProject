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
		<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 		value="${item.boardGbnCd}">
	</form>
	
	<div id="content">
		<h3 class="cont-title">책 소개</h3>
		<p class="book-view">제목 : ${bookView.SUBJECT}</p>
		<div class="view">
			<img src="${bookView.FL_PATH}/${bookView.FL_NM}" width="100%" height="auto">
		</div>
			 ${bookView.CONTENTS}
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