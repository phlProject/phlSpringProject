<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 공통 빼기 S -->
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<link rel="stylesheet" type="text/css" href="/css/default.css" />

<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/phl/phl_common.js"></script>
<script src="/js/common.js"></script>
<script src="/js/a0000007/counsel.js"></script>
<!-- 공통 빼기 E -->


<!-- 
	상담신청 게시판 상세화면
	댓글    등록/수정/삭제 	- 관리자
 -->
<c:set var="commentAuthYn" value="N"/>
<c:if test="${loginInfo.MEM_GBN_CD ge 'G01999' && !empty sessionScope.sessionId}">
	<c:set var="commentAuthYn" value="Y"/>
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


<div id="default_detail_Form">
	<div style="height:73px;">
		<div class="default_detail_Form_div1">
			<span class="default_detail_subject">${boardView.SUBJECT}</span> 
		</div>
		<div class="default_detail_Form_div2">
			<span class="default_detail_regDt">${boardView.REG_DT}</span>
		</div>
	</div>

	<hr style="border: 1px dotted  #e9e6e4;">
	
	<div class="default_detail_Form_div3" style="min-height: 55%;">
		${boardView.CONTENT}
	</div>
	
	<hr style="border:0.5px solid #ddd; width: 100%;">
	
	
	<div class="default_reply_Form">
		<c:if test="${!empty boardReplyList}">
			<br/>
			<table>
				<c:forEach items="${boardReplyList}" var="row">
					<tr>
						<td width="80%">
							<c:if test="${row.RE_LEVEL ne 1}">&nbsp;&nbsp;&nbsp; ⤷</c:if> 
							${row.MEM_NM} | ${row.REG_DT}
						</td>
						<td width="20%">
							<c:if test="${commentAuthYn eq 'Y'}">
								<!-- 세션 ID != 등록 ID -->
								<c:if test="${loginInfo.MEM_ID ne row.MEM_ID}">
									<a href="javascript:fn_insertBoardReReply('${row.MEM_NM}','${row.ORDR}');" id="insertBoardReReply">답글</a>
								</c:if>
								<!-- 세션 ID == 등록 ID -->
								<c:if test="${loginInfo.MEM_ID eq row.MEM_ID}">
									<a href="javascript:fn_updateBoardReply('${row.BOARD_RE_SN}','${row.CONTENT}');" id="updateBoardReply">수정</a>
									<a href="javascript:fn_deleteBoardReply('${row.BOARD_RE_SN}');" id="deleteBoardReply">삭제</a>
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
						<a href="javascript:fn_saveBoardReply()" 	id="saveBoardReply"><span id="regNm">등 록</span></a>
						<a href="javascript:fn_cancelBoardReply()" 	id="cancelBoardReply"><span id="canNm">취 소</span></a>
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
	<div class="default_btn default_floatR">
		<a href="javascript:fn_counselFormU();" 	id="counselFormU">수정</a>
		<a href="javascript:fn_deleteCounsel();" 	id="deleteCounsel">삭제</a>
		<a href="javascript:fn_counselList();" 		id="counselList">목록</a>
	</div>
</div>