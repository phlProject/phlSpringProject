<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content">
	<h3 class="login-title">Login</h3>
	<div id="loginform">
	<form id="loginActionForm">
		<input type="hidden" id="bsnsCode" name="bsnsCode" value="${sessionScope.bsnsCode}">
		<img src="/img/id.jpg" alt="id">&nbsp;&nbsp;<input type="text" id="memId" name="memId" placeholder="ID" onkeypress="if(event.keyCode == 13){fn_loginVal();}"  onkeydown="engNumber(this)" style="text-transform: lowercase;"/><br/>
		<img src="/img/pw.jpg" alt="pw">&nbsp;&nbsp;<input type="password" id="memPw" name="memPw" placeholder="PASSWORD" onkeypress="if(event.keyCode == 13){fn_loginVal();}" />
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
