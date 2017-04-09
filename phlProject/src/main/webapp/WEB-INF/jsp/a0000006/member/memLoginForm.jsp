<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="content" align="center">
		<form id="loginActionForm">
			아이디 :  <input type="text" id="mem_id" name="mem_id" /> <br/>
			비밀번호 : <input type="password" id="mem_pw" name="mem_pw" />
		</form>
		
		<a href="javascript:fn_loginVal()" id="loginAction123	">로그인</a>
		<a href="/a0000006/mainIndex.do" id="mainIndex">메인</a> <br/>
		
		<c:choose>
			<c:when test="${resultValue=='ID_ERROR'}">* 존재하지 않는 아이디입니다. </c:when>
			<c:when test="${resultValue=='PW_ERROR'}">* 비밀번호가 일치하지 않습니다. </c:when>
		</c:choose>
	</div>

</body>
</html>