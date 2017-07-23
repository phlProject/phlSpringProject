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
					<input type="hidden" id="bsnsCode" 	name="bsnsCode" 	value="${sessionScope.bsns_code}">
					<input type="hidden" id="sessionId" name="sessionId" 	value="${sessionScope.session_id}">
					<input type="hidden" id="memSn" 	name="memSn" 		value="${myPageInfo.MEM_SN}">
					<input type="hidden" id="memId" 	name="memId"		value="${myPageInfo.MEM_ID}">
				</td>
			</tr>
			<tr>
				<th>비밀번호 </th>
				<td><input type="text" value="${myPageInfo.MEM_PW}" id="memPw" name="memPw" ></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="text" value="${myPageInfo.MEM_PW}" id="confMemPw" name="confMemPw" ></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" value="${myPageInfo.MEM_NM}" id="memNm" name="memNm" ></td>
			</tr>
			<tr>
				<th>이메일 </th>
				<td><input type="text" value="${myPageInfo.MEM_EMAIL}" id="memEmail" name="memEmail"></td>
			</tr>
			
			<tr>
				<th>등급</th>
				<td>
					<select id="memGbnCd" name="memGbnCd">
						<c:forEach items="${memGbnList}" var="rows">
							<option value="${rows.CMMN_CODE}" <c:if test="${rows.CMMN_CODE == myPageInfo.MEM_GBN_CD}">SELECTED</c:if> >${rows.DETAIL_CODE_NM}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>전화번호 </th>
				<td><input type="text" value="${myPageInfo.MEM_PHONE}" id="memPhone" name="memPhone"></td>
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