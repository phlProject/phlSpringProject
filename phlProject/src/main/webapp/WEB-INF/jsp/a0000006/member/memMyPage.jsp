<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content" align="center">
	<h3 class="myPage-title">나의 정보</h3>
	<div id="mypage">
		<form id="memMypage_Form" name="memMypage_Form">
			<input type="hidden" id="bsnsCode" 	name="bsnsCode" 	value="${sessionScope.bsnsCode}">	
			<input type="hidden" id="sessionId" name="sessionId" 	value="${sessionScope.sessionId}">
			<input type="hidden" id="memSn" 	name="memSn" 		value="${myPageInfo.MEM_SN}">
			
			<table>
				<tr>
					<th>아이디 </th>
					<td><input type="text" value="${myPageInfo.MEM_ID}" id="memId" name="memId" class="pl5" readonly="readonly" style="border: 0px;"></td>
				</tr>
				<tr>
					<th>비밀번호 </th>
					<td>
					<input type="password" value="${myPageInfo.MEM_PW}" id="memPw" name="memPw" class="pl5" onchange="javascript:confirmPw();" onkeydown="engNumber(this)">
					<span id="pwText" style="color:red; font-size:12px; padding:20px;"></span>
					</td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td>
						<input type="password" value="${myPageInfo.MEM_PW}" id="confMemPw" name="confMemPw" class="pl5" onchange="javascript:confirmPw(this);" onkeydown="engNumber(this)">
						<span id="confPwText" style="color:red; font-size:12px; padding:20px;"></span>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" value="${myPageInfo.MEM_NM}" id="memNm" name="memNm" class="pl5"></td>
				</tr>
				<tr>
					<th>이메일 </th>
					<td><input type="text" value="${myPageInfo.MEM_EMAIL}" id="memEmail" name="memEmail" readonly="readonly" style="border: 0px;"></td>
				</tr>
				
				<tr>
					<th>회원 구분</th>
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
					<td><input type="text" value="${myPageInfo.MEM_PHONE}" id="memPhone" name="memPhone" class="pl5" maxlength="11" onkeydown="onlyNumber(this)"></td>
				</tr>
			</table>
			<br><br>
			<a href="javascript:fn_updateMemValid();" 	id="updateMemValid">수정</a>
			<a href="javascript:fn_deleteMemRegist();" 	id="deleteMember">탈퇴</a>
		</form>
	</div>
</div>
