<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div id="content" align="center">123444
		<form id="memRegistForm" name="memRegistForm">
			<input type="hidden" id="usableId_yn" value="N">
			<table>
				<tr>
					<td>
						아이디 : <input type="text" id="mem_id" name="mem_id" onchange="javascript:changedId();" /> 
						<input type="button" value="중복검사" onclick="idDupChk()"><br/>
						<span id="idDupText" style="color: red;"></span>
					</td>
				</tr>
				<tr>
					<td>
						비밀번호 : <input type="password" id="mem_pw" name="mem_pw" onchange="javascript:confirmPw();"/>
					</td>	
				</tr>
				<tr>
					<td>
						비밀번호 확인 : <input type="password" id="conf_mem_pw" name="conf_mem_pw" onchange="javascript:confirmPw();"/><br/>
						<span id="confPwText" style="color: red;"></span> 
					</td>	
				</tr>
				<tr>
					<td>
						이름 : <input type="text" id="mem_nm" name="mem_nm"/>
					</td>
				</tr>
				<tr>
					<td>
						이메일 : <input type="text" id="mem_email" name="mem_email"/>
					</td>
				</tr>
				<tr>
					<td>
						닉네임 : <input type="text" id="mem_nicknm" name="mem_nicknm"/>
					</td>
				</tr>
				<tr>
					<td>
						회원 구분 : 
						<select id="mem_grade" name="mem_grade">
							<option value="">선택</option>	
							<c:forEach items="${commList}" var="rows">
								<option value="${rows.CMMN_CODE}">${rows.DETAIL_CODE_NM}</option>
							</c:forEach>
						</select>
						
					</td>
				</tr>
				<tr>
					<td>
						핸드폰 : <input type="text" id="mem_phone" name="mem_phone"/>
					</td>
					
				</tr>
			</table>
			
		</form>
		<a href="javascript:fn_insertMemRegist();" id="insertMemRegist">작성</a>
		<a href="/a0000006/mainIndex.do" id="mainIndex">메인</a>
	</div>
</body>
</html>