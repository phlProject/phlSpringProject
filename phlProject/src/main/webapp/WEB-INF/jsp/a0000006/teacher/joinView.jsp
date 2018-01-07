<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
	참여 게시판 상세화면
	게시글 수정/삭제 		- 선생님 이상, 세션ID = 등록ID
	
	댓글    등록/수정/삭제 	- 손님 이상
 -->
<c:set var="authYn" value="N"/>
<c:if test="${loginInfo.MEM_GBN_CD ge 'G01030' && loginInfo.MEM_ID eq joinView.REG_ID}">
	<c:set var="authYn" value="Y"/>
</c:if>

<c:set var="commentAuthYn" value="N"/>
<c:if test="${loginInfo.MEM_GBN_CD ge 'G01010'}">
	<c:set var="commentAuthYn" value="Y"/>
</c:if>


<!-- 목록이동_Form -->
<form id="joinList_Form">
	<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}"> 		<!-- 검색구분 -->
	<input type="hidden" id="searchWord" 	name="searchWord"		value="${item.searchWord}">	  		<!-- 검색어 -->
	<input type="hidden" id="selectCategory"name="selectCategory"	value="${item.selectCategory}">	  	<!-- 검색카테고리  -->
	<input type="hidden" id="bsnsCode"      name="bsnsCode"         value="${joinView.BSNS_CODE}">		<!-- 업체코드 -->
	<input type="hidden" id="boardSn" 		name="boardSn" 			value="${joinView.BOARD_SN}">		<!-- 게시판 번호 -->
	<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
	<input type="hidden" id="sessionId" 	name="sessionId"		value="${sessionScope.sessionId}">	<!-- 세션_아이디(등록자/수정자) -->
</form>
	
	
<div id="content">

	<div id="default_view_form">
		<h3 id="default_view_title">${joinView.SUBJECT}</h3>
	</div>
	
	
	<div id="default_view">
		카테고리 :
		<select id="default_Select" name="default_Select">
			<option value="${joinView.BOARD_GBN_CD}">${joinView.BOARD_GBN_CD_NM}</option>
		</select>	
	</div>
	
	${joinView.CONTENT}			
</div>


<hr style="border:0.5px solid #ddd; width:94%;">


<div id="content">
	<div class="detail01">
		<h3 class="reply">댓&nbsp;&nbsp;&nbsp;글</h3>
		<hr style="border:1px solid #e5dfda; width:97%; float:left; margin-left:10px;">
		<!-- 댓글 조회 -->
		<div class="reply-tb">
			<table align="center">
				<c:forEach items="${joinReList}" var="row">
					<tr>
						<td width="70%">${row.CONTENT}</td>
						<td width="10%">${row.MEM_NM}</td>
						
						<c:if test="${commentAuthYn eq 'Y'}">
							<!-- 세션 ID != 등록 ID -->
							<c:if test="${loginInfo.MEM_ID ne row.MEM_ID}">
								<td colspan="2"><a href="javascript:fn_insertJoinReRe('${row.MEM_NM}','${row.ORDR}')" id="insertJoinReRe">답글</a></td>
							</c:if>
							<!-- 세션 ID == 등록 ID -->
							<c:if test="${loginInfo.MEM_ID eq row.MEM_ID}">
								<td><a href="javascript:fn_updateJoinRe('${row.BOARD_RE_SN}','${row.CONTENT}')" id="updateJoinRe">수정</a></td>
								<td><a href="javascript:fn_deleteJoinRe('${row.BOARD_RE_SN}')" id="deleteJoinRe">삭제</a></td>
							</c:if>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
	
		<br/><br/>
		<!-- 댓글 등록 -->
		<c:if test="${commentAuthYn eq 'Y'}">
			<div class="reply-tb02">
				<table align="center">
					<tr>
						<td>
							<span class="reply-name">작성자&nbsp; |&nbsp;&nbsp; </span>
						 	<span class="reply-value">${sessionScope.loginInfo.MEM_NM}</span>
						 </td>
					</tr>
					<tr>
						<td>
							<textarea rows="7" cols="97" id="contents" name="contents" style="border:0.5px solid #ddd;"></textarea>
							<input type="hidden" id="boardReSn" 	name="boardReSn" 	value="">
							<input type="hidden" id="boardReType"	name="boardReType" 	value="insert">
						</td>
					</tr>
				</table>
				<br/>
				<center>
				<a href="javascript:fn_saveJoinRe()" id="saveJoinRe"><span id="regNm">등&nbsp;&nbsp;록</span></a>
				<a href="javascript:fn_cancelJoinRe()" id="cancelJoinRe"><span id="canNm">취&nbsp;&nbsp;소</span></a>
				</center>
			</div>
		</c:if>
	</div>
</div>
<div class="bookView">	
	<div class="bookView-btn">
		<c:if test="${authYn eq 'Y'}">
			<a href="javascript:fn_joinFormU();" 	id="joinFormU">수정</a>
			<a href="javascript:fn_deleteJoin();" 	id="deleteJoin">삭제</a>
		</c:if>		
		<a href="javascript:fn_joinList();" 	id="joinList">목록</a>
	</div>
</div>