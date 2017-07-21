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
		
		<h3 class="my-title">MYPAGE</h3>
		
		<table class="mytab">
			<tr>
				<th>아이디 </th>			
				<td>
					${myPageInfo.MEM_ID}
					<input type="hidden" value="${sessionScope.bsns_code}" id="bsns_code" name="bsns_code" >
					<input type="hidden" value="${sessionScope.session_id}" id="session_id" name="session_id" >
					<input type="hidden" value="${myPageInfo.MEM_SN}" id="mem_sn" name="mem_sn">
					<input type="hidden" value="${myPageInfo.MEM_ID}" id="mem_id" name="mem_id">
				</td>
			</tr>
			<tr>
				<th>비밀번호 </th>
				<td><input type="text" value="${myPageInfo.MEM_PW}" id="mem_pw" name="mem_pw" ></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="text" value="${myPageInfo.MEM_PW}" id="conf_mem_pw" name="conf_mem_pw" ></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" value="${myPageInfo.MEM_NM}" id="mem_nm" name="mem_nm" ></td>
			</tr>
			<tr>
				<th>이메일 </th>
				<td><input type="text" value="${myPageInfo.MEM_EMAIL}" id="mem_email" name="mem_email"></td>
			</tr>
			
			<tr>
				<th>등급</th>
				<td>
					<select id="mem_gbn_cd" name="mem_gbn_cd">
						<c:forEach items="${commList}" var="rows">
							<option value="${rows.CMMN_CODE}" <c:if test="${rows.CMMN_CODE == myPageInfo.MEM_GBN_CD}">SELECTED</c:if> >${rows.DETAIL_CODE_NM}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>전화번호 </th>
				<td><input type="text" value="${myPageInfo.MEM_PHONE}" id="mem_phone" name="mem_phone"></td>
			</tr>
		</table>
		<div class="bookView">
			<div class="bookView-btn">
				<a href="javascript:fn_deleteMemRegist();" id="deleteMember">회원탈퇴</a>
				<a href="" id="mainIndex">메인</a>
				<a href="javascript:fn_updateMemRegist();" id="updateMemRegist">수정</a>
			</div>
		</div>
		</form>
	</div>

</body>
</html>