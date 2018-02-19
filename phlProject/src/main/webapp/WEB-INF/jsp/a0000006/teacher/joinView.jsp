<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
<c:if test="${loginInfo.MEM_GBN_CD ge 'G01010' && !empty sessionScope.sessionId}">
	<c:set var="commentAuthYn" value="Y"/>
</c:if>


<!-- 목록이동_Form -->
<form id="joinList_Form">
	<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}"> 		<!-- 검색구분 -->
	<input type="hidden" id="searchWord" 	name="searchWord"		value="${item.searchWord}">	  		<!-- 검색어 -->
	<input type="hidden" id="selectCategory"name="selectCategory"	value="${item.selectCategory}">	  	<!-- 검색카테고리  -->
	<input type="hidden" id="bsnsCode"      name="bsnsCode"         value="${joinView.BSNS_CODE}">		<!-- 업체코드 -->
	<input type="hidden" id="boardSn" 		name="boardSn" 			value="${joinView.BOARD_SN}">		<!-- 게시판 번호 -->
	<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 		value="${fn:substring(joinView.BOARD_GBN_CD,0,3)}">	<!-- 게시판_구분 -->
	<input type="hidden" id="sessionId" 	name="sessionId"		value="${sessionScope.sessionId}">	<!-- 세션_아이디(등록자/수정자) -->
</form>
	

<div id="default_detail_Form">

	<div style="height:73px;">
		<div class="default_detail_Form_div1">
			<span class="default_detail_subject">${joinView.SUBJECT}</span> 
			<span class="default_detail_boardGbn"> | ${joinView.BOARD_GBN_CD_NM}</span>
		</div>
		<div class="default_detail_Form_div2">
			<span class="default_detail_regDt">${joinView.REG_DT}</span>
		</div>
	</div>
	
	<hr style="border: 1px dotted  #e9e6e4;">
	
	<div class="default_detail_Form_div3" style="min-height: 55%;">
		${joinView.CONTENT}
	</div>
	
	<hr style="border:0.5px solid #ddd; width: 100%;">
	
	<div class="default_reply_Form">
		<c:if test="${!empty joinReList}">
			<br/>
			<table>
				<c:forEach items="${joinReList}" var="row">
					<tr>
						<td width="80%">
							<c:if test="${row.RE_LEVEL ne 1}">&nbsp;&nbsp;&nbsp; ⤷</c:if> 
							${row.MEM_NM} | ${row.REG_DT}
						</td>
						<td width="20%">
							<c:if test="${commentAuthYn eq 'Y'}">
								<!-- 세션 ID != 등록 ID -->
								<c:if test="${loginInfo.MEM_ID ne row.MEM_ID}">
									<a href="javascript:fn_insertJoinReRe('${row.MEM_NM}','${row.ORDR}')" id="insertJoinReRe">답글</a>
								</c:if>
								<!-- 세션 ID == 등록 ID -->
								<c:if test="${loginInfo.MEM_ID eq row.MEM_ID}">
									<a href="javascript:fn_updateJoinRe('${row.BOARD_RE_SN}','${row.CONTENT}')" id="updateJoinRe">수정</a>
									<a href="javascript:fn_deleteJoinRe('${row.BOARD_RE_SN}')" id="deleteJoinRe">삭제</a>
								</c:if>
							</c:if>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<c:if test="${row.RE_LEVEL ne 1}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:if> 
							${row.CONTENT}
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
		<!-- 댓글 입력 -->
		<c:if test="${commentAuthYn eq 'Y'}">
		<div class="default_reply_regist">
			<table>
				<tr>
					<td>
						<span class="default_reply_name">작성자 | </span><span class="default_reply_value">${sessionScope.loginInfo.MEM_NM}</span>
					</td>
				</tr>
				<tr>
					<td>
						<textarea rows="7" cols="93.5" id="contents" name="contents" style="border:1px solid #ddd;"></textarea>
						<input type="hidden" id="boardReSn" 	name="boardReSn" 	value="">
						<input type="hidden" id="boardReType"	name="boardReType" 	value="insert">
					</td>
				</tr>
				<tr>	
					<td>
						<br/>
						<center>
						<a href="javascript:fn_saveJoinRe()" 	id="saveJoinRe"><span id="regNm">등 록</span></a>
						<a href="javascript:fn_cancelJoinRe()" 	id="cancelJoinRe"><span id="canNm">취 소</span></a>
						</center>
					</td>
				</tr>
			</table>
			<br/>
		</div>
		</c:if>
	</div>
</div>

<div class="default_btnDiv">	
	<div class="default_btn default_floatL">
		<a href="javascript:fn_pageMoveJoin('pre');" 	id="preDetail">이전 글</a>
		<a href="javascript:fn_pageMoveJoin('after');" 	id="aftDetail">다음 글</a>
	</div>
	<div class="default_btn default_floatR">
		<c:if test="${authYn eq 'Y'}">
			<a href="javascript:fn_joinFormU();" 	id="joinFormU">수정</a>
			<a href="javascript:fn_deleteJoin();" 	id="deleteJoin">삭제</a>
		</c:if>		
		<a href="javascript:fn_joinList();" 	id="joinList">목록</a>
	</div>
</div>

<%-- 
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
				<a href="javascript:fn_saveJoinRe()" id="saveJoinRe"><span id="regNm">등&nbsp;&nbsp;록</span></a>
				<a href="javascript:fn_cancelJoinRe()" id="cancelJoinRe"><span id="canNm">취&nbsp;&nbsp;소</span></a>
			</div>
		</c:if>
	</div>
</div> --%>


