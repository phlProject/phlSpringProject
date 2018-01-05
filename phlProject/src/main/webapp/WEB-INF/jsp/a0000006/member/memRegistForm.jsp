<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content" align="center">
	<h3 class="register-title">회원가입</h3>
	<div id="register">	
		<form id="memRegist_Form" name="memRegist_Form">
			<input type="hidden" id="bsnsCode" name="bsnsCode" value="${sessionScope.bsnsCode}"> <!-- 업체_코드 -->
			<input type="hidden" id="memIdUseYn" 		value="N"> <!-- ID 중복 검사 여부 -->
			<input type="hidden" id="memIdSuitYn" 		value="N"> <!-- ID 적합성 여부 -->
			<input type="hidden" id="memEmailUseYn" 	value="N"> <!-- Email 중복 검사 여부 -->
			<input type="hidden" id="memEmailSuitYn" 	value="N"> <!-- Email 적합성 여부 -->
			
				<table>
					<tr>
						<th>아이디 </th>
					    <td>
						     <input type="text" id="memId" name="memId" placeholder="아이디" onchange="javascript:memValidChk(this.name);"/>
							 <input type="button" value="아이디 중복검사" onclick="memDupChk('memId')">
							 <span id="memIdDupText" style="color:red; font-size:12px; padding:20px;"></span>
						</td>
					</tr>
				    <tr>
						<th>비밀번호</th>
						<td><input type="password" id="memPw" name="memPw" placeholder="비밀번호" onchange="javascript:confirmPw();"/></td>
					</tr>
					<tr>
					    <th>비밀번호 확인</th>
					    <td>
					    <input type="password" id="confMemPw" name="confMemPw" placeholder="비밀번호확인" onchange="javascript:confirmPw();"/>
					    <span id="confPwText" style="color:red; font-size:12px; padding:20px;"></span>
					    </td>
					</tr>
					<tr>	
						<th>이 름</th>
						<td><input type="text" id="memNm" name="memNm" placeholder="이 름" /></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>
							<input type="text" id="memEmail" name="memEmail" placeholder="이메일" onchange="javascript:memValidChk(this.name);"/>
							<input type="button" value="이메일 중복검사" onclick="memDupChk('memEmail')">
							<span id="memEmailDupText" style="color:red; font-size:12px; padding:20px;"></span>
						</td>
					</tr>
					<tr>
						<th>회원 구분</th>
						<td>
						<select id="memGbnCd" name="memGbnCd">
							<option value="">선택</option>	
							<c:forEach items="${memGbnList}" var="rows">
								<option value="${rows.CMMN_CODE}">${rows.DETAIL_CODE_NM}</option>
							</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<th>핸드폰</th>
						<td><input type="text" id="memPhone" name="memPhone" placeholder="핸드폰" /></td>
					</tr>
				</table>
		</form>
		<br/><br/>
		<a href="javascript:fn_insertMemRegist();" id="insertMemRegist">가입하기</a>
	</div>
</div>
