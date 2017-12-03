<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form id="publiList_Form">
	<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}">		<!-- 검색구분 -->
	<input type="hidden" id="searchWord" 	name="searchWord" 		value="${item.searchWord}">			<!-- 검색어 -->
	<input type="hidden" id="bsnsCode"      name="bsnsCode"         value="${publiView.BSNS_CODE}">		<!-- 업체코드 -->
	<input type="hidden" id="boardSn" 		name="boardSn" 			value="${publiView.BOARD_SN}">		<!-- 게시판 번호 -->
	<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 		value="${item.boardGbnCd}">
</form>
  						  																
<div id="content">
	<h3 class="cont-title">간행물</h3>
	<p class="book-view">제목 : ${publiView.SUBJECT}</p>
		 ${publiView.CONTENT}
	<br>
	첨부파일 :  <a href="javascript:fn_boardFlDown('${publiView.BSNS_CODE}','${publiView.BOARD_SN}','${publiView.BOARD_FL_SN}');"><c:out value="${publiView.ORIGIN_FL_NM}"/></a>
	<div class="bookView">	
		<div class="bookView-btn">
			<a href="javascript:fn_publiFormU();" 	id="publiFormU">수정</a>
			<a href="javascript:fn_deletePubli();" 	id="deletePubli">삭제</a>		
			<a href="javascript:fn_publiList();" 	id="publiList">목록</a>
		</div>
	</div>
</div>
