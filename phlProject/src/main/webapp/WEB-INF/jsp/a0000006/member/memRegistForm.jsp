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
		<div id="register">
			<p>회원가입</p>	
			<form id="memRegist_Form" name="memRegist_Form">
				<input type="hidden" id="bsns_code" name="bsns_code" value="${sessionScope.bsns_code}">
				<input type="hidden" id="usableId_yn" value="N">
					<table>
						<tr>
							<th>아이디 </th>
						    <td>
							     <input type="text" id="mem_id" name="mem_id" placeholder="아이디" onchange="javascript:changedId();"/>
								 <input type="button" value="중복검사" onclick="idDupChk()"><br/>
								 <span id="idDupText" style="color:red; font-size:12px;"></span>
							</td>
						</tr>
					    <tr>
							<th>비밀번호</th>
							<td><input type="password" id="mem_pw" name="mem_pw" placeholder="비밀번호" onchange="javascript:confirmPw();"/></td>
						</tr>
						<tr>
						    <th>비밀번호 확인</th>
						    <td>
						    <input type="password" id="conf_mem_pw" name="conf_mem_pw" placeholder="비밀번호확인" onchange="javascript:confirmPw();"/>
						    <span id="confPwText" style="color:red; font-size:12px;"></span>
						    </td>
						</tr>
						<tr>	
							<th>이 름</th>
							<td><input type="text" id="mem_nm" name="mem_nm" placeholder="이 름" /></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" id="mem_email" name="mem_email" placeholder="이메일" /></td>
						</tr>
						<tr>
							<th>회원 구분</th>
							<td>
							<select id="mem_gbn_cd" name="mem_gbn_cd">
								<option value="">선택</option>	
								<c:forEach items="${commList}" var="rows">
									<option value="${rows.CMMN_CODE}">${rows.DETAIL_CODE_NM}</option>
								</c:forEach>
							</select>
							</td>
						</tr>
						<tr>
							<th>핸드폰</th>
							<td><input type="text" id="mem_phone" name="mem_phone" placeholder="핸드폰" /></td>
						</tr>
					</table>
			</form>
			<a href="javascript:fn_insertMemRegist();" id="insertMemRegist">가입하기</a>
		</div>
	</div>
</body>
</html>
