<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 공통 빼기 S -->
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<link rel="stylesheet" type="text/css" href="/css/default.css" />

<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/common.js"></script>

<script type="text/javascript">
function fn_loginVal(){
	
	if($("#memId").val() == ""){
		alert(" * 아이디를 입력해주세요. ");
		$("#memId").focus();
		return;
	}
	
	if($("#memPw").val() == ""){
		alert(" * 비밀번호를 입력해주세요. ");
		$("#memPw").focus();
		return;
	}
	
	ComSubmit('loginActionForm','/a0000007/adminLogin.do');
}
</script>
<!-- 공통 빼기 E -->

<div id="content">
	<h3 class="login-title">Login</h3>
	<div id="loginform">
	<form id="loginActionForm">
		<input type="hidden" id="bsnsCode" name="bsnsCode" value="${sessionScope.bsnsCode}">
		<img src="/img/id.jpg" alt="id" class="mr5"><input type="text" 		id="memId" name="memId" class="pl5" placeholder="아이디" 		onkeypress="if(event.keyCode == 13){fn_loginVal();}"  onkeydown="engNumber(this)" style="text-transform: lowercase;"/><br/>
		<img src="/img/pw.jpg" alt="pw" class="mr5"><input type="password" 	id="memPw" name="memPw" class="pl5" placeholder="비밀번호" 	onkeypress="if(event.keyCode == 13){fn_loginVal();}" />
	</form>
	<br/>
	
	<a href="javascript:fn_loginVal()" id="loginAction" >로그인</a> <br><br>

	<c:choose>
		<c:when test="${resultValue=='ID_ERROR'}">* 존재하지 않는 아이디입니다. </c:when>
		<c:when test="${resultValue=='PW_ERROR'}">* 비밀번호가 일치하지 않습니다. </c:when>
		<c:when test="${resultValue=='ID_STANDBY'}">* 권한 승인 대기중입니다. </c:when>
	</c:choose>
	
	</div>
</div>
