<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교육나눔 꿈두레</title>
</head>
<body>
	<!-- 목록이동_Form -->
	<form id="joinList_Form">
		<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}"> 		<!-- 검색구분 -->
		<input type="hidden" id="searchWord" 	name="searchWord"		value="${item.searchWord}">	  		<!-- 검색어 -->
		<input type="hidden" id="selectCategory"name="selectCategory"	value="${item.selectCategory}">	  	<!-- 검색카테고리  -->
		<input type="hidden" id="bsnsCode"      name="bsnsCode"         value="${joinView.BSNS_CODE}">		<!-- 업체코드 -->
		<input type="hidden" id="boardSn" 		name="boardSn" 			value="${joinView.BOARD_SN}">		<!-- 게시판 번호 -->
		<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
	</form>
	
		<div id="content">
			<h3 class="cont-title">상세</h3>
			<p class="book-view">제목 : ${joinView.SUBJECT}</p>
			<br>카테고리 :
				<select id="teacherGbnCd" name="teacherGbnCd">
					<option value="${joinView.BOARD_GBN_CD}">${joinView.BOARD_GBN_CD_NM}</option>
				</select>
				
			<br>${joinView.CONTENT}
			
			<div class="bookView">	
				<div class="bookView-btn">
					<a href="javascript:fn_joinFormU();" 	id="joinFormU">수정</a>
					<a href="javascript:fn_deleteJoin();" 	id="deleteJoin">삭제</a>		
					<a href="javascript:fn_joinList();" 	id="joinList">목록</a>
				</div>
			</div>
		</div>
		
		<div id="content">
			<h3>댓글</h3>
			
			<!-- 댓글 조회 -->
			<div>
				<table>
					<c:forEach items="${joinReList}" var="row">
						<tr>
							<td>${row.MEM_NM}</td>
							<td>${row.CONTENT}</td>
							
							<c:if test="${not empty sessionScope.loginInfo and sessionScope.loginInfo.MEM_ID ne row.MEM_ID}">
								<td><a href="javascript:fn_insertJoinReRe('${row.MEM_NM}','${row.ORDR}')" id="insertJoinReRe">답글</a></td>
							</c:if>
							
							<c:if test="${not empty sessionScope.loginInfo and sessionScope.loginInfo.MEM_ID eq row.MEM_ID}">
								<td><a href="javascript:fn_updateJoinRe('${row.BOARD_RE_SN}','${row.CONTENT}')" id="updateJoinRe">수정</a></td>
								<td><a href="javascript:fn_deleteJoinRe('${row.BOARD_RE_SN}')" id="deleteJoinRe">삭제</a></td>
							</c:if>
							
						</tr>
					</c:forEach>
				</table>
			</div>
			
			<!-- 댓글 등록 -->
			<c:if test="${not empty sessionScope.loginInfo}">
				<table>
					<tr>
						<td>${sessionScope.loginInfo.MEM_NM}</td>
						<td>
							<textarea rows="5" cols="70" id="contents" name="contents"></textarea>
							<input type="text" id="boardReSn" 	name="boardReSn" 	value="">
							<input type="text" id="boardReType"	name="boardReType" 	value="insert">
						</td>
						<td><a href="javascript:fn_saveJoinRe()" id="saveJoinRe"><span id="regNm">등록</span></a></td>
						<td><a href="javascript:fn_cancelJoinRe()" id="cancelJoinRe"><span id="canNm">취소</span></a></td>
					</tr>
				</table>
			</c:if>
		</div>
</body>

</html>