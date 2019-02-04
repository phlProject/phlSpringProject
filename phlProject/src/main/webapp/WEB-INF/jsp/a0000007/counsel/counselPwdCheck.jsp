<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="/js/a0000007/counsel.js"></script>


<script type="text/javascript">
var resultValue = "";

$( document ).ready(function() {
	var resultValue = '<c:out value="${resultValue}"  escapeXml="false"/>';
	var boardSn 	= '<c:out value="${item.boardSn}" escapeXml="false"/>';
	
	if(resultValue == "PW_OK")
	{
		fn_counselView(boardSn);
	}
});


function fn_baordPwdCheck(){
	
	
	if($("#password").val() == ""){
		alert(" * 비밀번호를 입력해주세요. ");
		$("#password").focus();
		return;
	}
	
	ComSubmit('boardPwdCheckForm','/a0000007/counsel/counselPwdCheckAction.do');
}
</script>


<!-- 목록이동_Form -->
<form id="boardList_Form">
	<input type="hidden" id="searchSelect" 	name="searchSelect" value="${item.searchSelect}"> 		<!-- 검색구분 		-->
	<input type="hidden" id="searchWord" 	name="searchWord"	value="${item.searchWord}">	  		<!-- 검색어 		-->
	<input type="hidden" id="bsnsCode" 		name="bsnsCode" 	value="${sessionScope.bsnsCode}">	<!-- 세션_업체코드 	-->
	<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 	value="${item.boardGbnCd}">			<!-- 게시판_구분	-->
</form>

<div id="content">
	<h3 class="login-title">비밀번호</h3>
	<div id="loginform">
		<form id="boardPwdCheckForm">
			<input type="hidden" id="bsnsCode" 	name="bsnsCode" 	value="${sessionScope.bsnsCode}">
			<input type="hidden" id="boardSn"  	name="boardSn" 		value="${item.boardSn}">
			<input type="hidden" id="boardGbnCd"  name="boardGbnCd" 	value="${item.boardGbnCd}">
			
			<img src="/img/pw.jpg" alt="pw" class="mr5"><input type="password" 	id="password" name="password" class="pl5" placeholder="비밀번호" 	onkeypress="if(event.keyCode == 13){fn_baordPwdCheck();}" />
		</form>
		<br/>
		
		<a href="javascript:fn_baordPwdCheck()" id="baordPwdCheck" >확인</a> <br><br>
		<a href="javascript:fn_counselList();" 	id="counselList">목록</a>
	
		<c:choose>
			<c:when test="${resultValue=='PW_ERROR'}">* 비밀번호가 일치하지 않습니다. </c:when>
		</c:choose>
	
	</div>
</div>