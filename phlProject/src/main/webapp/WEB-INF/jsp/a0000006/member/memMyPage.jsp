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
		<form id="memMypage_Form" name="memMypage_Form">
		<table>
			<tr>
				<td>아이디 </td><td>
					${myPageInfo.MEM_ID}
					<input type="hidden" value="${sessionScope.bsns_code}" id="bsns_code" name="bsns_code" >
					<input type="hidden" value="${sessionScope.session_id}" id="session_id" name="session_id" >
					<input type="hidden" value="${myPageInfo.MEM_SN}" id="mem_sn" name="mem_sn">
					<input type="hidden" value="${myPageInfo.MEM_ID}" id="mem_id" name="mem_id">
				</td>
			</tr>
			<tr>
				<td>비밀번호 </td><td><input type="text" value="${myPageInfo.MEM_PW}" id="mem_pw" name="mem_pw" ></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td><td><input type="text" value="${myPageInfo.MEM_PW}" id="conf_mem_pw" name="conf_mem_pw" ></td>
			</tr>
			<tr>
				<td>이름</td><td><input type="text" value="${myPageInfo.MEM_NM}" id="mem_nm" name="mem_nm" ></td>
			</tr>
			<tr>
				<td>이메일 </td><td><input type="text" value="${myPageInfo.MEM_EMAIL}" id="mem_email" name="mem_email"></td>
			</tr>
			<tr>
				<td>별명</td><td><input type="text" value="${myPageInfo.MEM_NICKNM}" id="mem_nicknm" name="mem_nicknm"></td>
			</tr>
			<tr>
				<td>등급</td>
				<td>
					<select id="mem_grade" name="mem_grade">
						<c:forEach items="${commList}" var="rows">
							<option value="${rows.CMMN_CODE}" <c:if test="${rows.CMMN_CODE == myPageInfo.MEM_GRADE}">SELECTED</c:if> >${rows.DETAIL_CODE_NM}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>전화번호 </td><td><input type="text" value="${myPageInfo.MEM_PHONE}" id="mem_phone" name="mem_phone"></td>
			</tr>
		</table>
		
		<a href="javascript:fn_updateMemRegist();" id="updateMemRegist">수정</a>
		<a href="" id="mainIndex">메인</a>
		<a href="javascript:fn_deleteMemRegist();" id="deleteMember">회원탈퇴</a>
		</form>
	</div>

</body>
</html>