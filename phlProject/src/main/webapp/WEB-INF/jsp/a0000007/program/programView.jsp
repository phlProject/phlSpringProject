<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="/js/a0000007/program.js"></script>

<!-- 
	활동 프로그램 게시판
	수정/삭제 - 관리자 ( G01999 )
 -->
<c:set var="authYn" value="N"/>
<c:if test="${loginInfo.MEM_GBN_CD ge 'G01999' && !empty sessionScope.sessionId}">
	<c:set var="authYn" value="Y"/>
</c:if>


<!-- 목록이동_Form -->
<form id="boardList_Form">
	<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}"> 		<!-- 검색구분 -->
	<input type="hidden" id="searchWord" 	name="searchWord"		value="${item.searchWord}">	  		<!-- 검색어 -->
	<input type="hidden" id="bsnsCode"      name="bsnsCode"         value="${boardView.BSNS_CODE}">		<!-- 업체코드 -->
	<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 		value="${boardView.BOARD_GBN_CD}">	<!-- 게시판_구분 -->
	<input type="hidden" id="boardSn" 		name="boardSn" 			value="${boardView.BOARD_SN}">		<!-- 게시판 번호 -->
	<input type="hidden" id="sessionId" 	name="sessionId"		value="${sessionScope.sessionId}">	<!-- 세션_아이디(등록자/수정자) -->
</form>

<div id="content">
<div id="default_detail_Form">
	<div style="height:40px;">
		<div class="default_detail_Form_div1">
			<span class="default_detail_subject">
				${boardView.SUBJECT}
			</span> 
			<span class="default_detail_boardGbn"> |</span>
		</div>
		<div class="default_detail_Form_div2">
			<span class="default_detail_regDt">${boardView.REG_DT}</span>
		</div>
	</div>
	
	<hr style="border: 1px dotted  #e9e6e4;">
	
	<div class="default_image_viewDiv">
		<div class="default_image_imgBox">
			<img src="${boardView.FL_PATH}/${boardView.FL_NM}">
		</div>
	</div>
	
	<p class="default_image5_detail">	</p>
	<hr color="#dddddd" size="0.2">
	
	<div class="default_detail_Form_div3">
		${boardView.CONTENT}
	</div>
</div>

<div class="default_btnDiv">
	<div class="default_btn default_floatL">
		<a href="javascript:fn_pageMoveProgram('pre');" 	id="preDetail">이전 글</a>
		<a href="javascript:fn_pageMoveProgram('after');" 	id="aftDetail">다음 글</a>
	</div>	
	<div class="default_btn default_floatR">
		<c:if test="${authYn eq 'Y'}">
		<a href="javascript:fn_programFormU();" 	id="programFormU">수정</a>
		<a href="javascript:fn_deleteProgram();" 	id="deleteProgram">삭제</a>		
		</c:if>
		<a href="javascript:fn_programList();" 	id="programList">목록</a>
	</div>
</div>
</div>