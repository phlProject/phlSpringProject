<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="content">
	        	<!-- <a href="#link" onclick="memInfoInit();"><img src="/img/tab-3-off.png" alt="메뉴01" /></a> -->
	<br>
	<h3 class="">아이디 찾기</h3><br/>
	<form id="idSearchForm" name="idSearchForm">
		이름	: <input type="text" id="memNm" 	name="memNm"> <br/>
		이메일	: <input type="text" id="memEmail" 	name="memEmail" placeholder="이메일" onkeydown="notHangeul(this)"> <br/>
		<input type="button" id="btnIdSearch" name="btnIdSearch" value="찾기">
		<input type="hidden" id="memSearchGb" name="memSearchGb" value="id">
		<span id="memIdSearch" style="color:red; font-size:12px;"></span>
	</form>
	<br>
	<h3 class="">비밀번호 찾기</h3><br/>
	<form id="pwSearchForm" name="pwSearchForm">
		아이디	: <input type="text" 	id="memId" 		name="memId" onkeydown="engNumber(this)" style="text-transform: lowercase;"> <br/>
		이름	: <input type="text" 	id="memNm" 		name="memNm"> <br/>
		이메일	: <input type="text"	id="memEmail" 	name="memEmail" placeholder="이메일" onkeydown="notHangeul(this)"> <br/>
		<input type="button" id="btnPwSearch" name="btnPwSearch" value="찾기">
		<input type="hidden" id="memSearchGb" name="memSearchGb" value="pw">
		<span id="memPwSearch" style="color:red; font-size:12px;"></span>
	</form>
</div>
