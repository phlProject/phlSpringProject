<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교육나눔 꿈두레</title>
</head>
<body>

	<form id="dataList_Form">
		<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}">		<!-- 검색구분 -->
		<input type="hidden" id="searchWord" 	name="searchWord" 		value="${item.searchWord}">			<!-- 검색어 -->
		<input type="hidden" id="bsnsCode"      name="bsnsCode"         value="${dataView.BSNS_CODE}">		<!-- 업체코드 -->
		<input type="hidden" id="boardSn" 		name="boardSn" 			value="${dataView.BOARD_SN}">		<!-- 게시판 번호 -->
		<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 		value="${item.boardGbnCd}">
	</form>
	  						  																
	<div id="content">
		<h3 class="cont-title">간행물</h3>
		<p class="book-view">제목 : ${dataView.SUBJECT}</p>
			 ${dataView.CONTENT}
		<br>
		첨부파일 :  <a href="javascript:fn_boardFlDown('${dataView.BSNS_CODE}','${dataView.BOARD_SN}','${dataView.BOARD_FL_SN}');"><c:out value="${dataView.ORIGIN_FL_NM}"/></a>
		<div class="bookView">	
			<div class="bookView-btn">
				<a href="javascript:fn_dataFormU();" 	id="dataFormU">수정</a>
				<a href="javascript:fn_deleteData();" 	id="deletedata">삭제</a>		
				<a href="javascript:fn_dataList();" 	id="dataList">목록</a>
			</div>
		</div>
	</div>
</body>
</html>