<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<script src="/js/a0000007/counsel.js"></script>


<script type="text/javascript">

function fn_baordPwdCheck(){
	
	
	if($("#password").val() == ""){
		alert(" * 비밀번호를 입력해주세요. ");
		$("#password").focus();
		return;
	}
	
	$.ajax({
		url		: "/a0000007/counsel/counselPwdCheckAction.do",
		type 	: "post",
		data : {
					bsnsCode 	: $("#bsnsCode").val(),		// 사업코드
					boardSn		: $("#boardSn").val(),		// 게시판 번호
					boardGbnCd	: $("#boardGbnCd").val(),	// 게시판 구분
					password	: $("#password").val()		// 게시판 비밀번호
				},
		dataType : "json",
		success : function(data){
			if(data.result == "PW_OK"){
				ComSubmit('boardPwdCheckForm','/a0000007/counsel/counselView.do');
			}else if(data.result == "PW_ERROR"){
				alert("비밀번호가 일치하지 않습니다.");
			}else{
				alert("실패하였습니다. 관리자에게 문의해주세요.");
				return;
			}
		}
	});
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
	</div>
</div>