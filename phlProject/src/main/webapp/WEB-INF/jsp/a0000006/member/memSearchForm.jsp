<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="content">
	        	<!-- <a href="#link" onclick="memInfoInit();"><img src="/img/tab-3-off.png" alt="메뉴01" /></a> -->
	<div class="content-2">
		<div class="idsearch">
		<h3>아이디 찾기</h3><br/>
		
		<form id="idSearchForm" name="idSearchForm" >
			이&nbsp;&nbsp;&nbsp;&nbsp;름 : 	<input type="text" id="memNm" 	 name="memNm"		class="pl5"	placeholder="이름" ><br/>
			이메일	: <input type="text" id="memEmail" name="memEmail" 	class="pl5"	placeholder="이메일" onkeydown="notHangeul(this)"><br/>
			<input type="button" id="btnIdSearch" name="btnIdSearch" value="찾기"><br/>
			<input type="hidden" id="memSearchGb" name="memSearchGb" value="id"><br/>
			<span id="memIdSearch" style="color:red; font-size:12px;"></span>
		</form>
		</div>
	
		<div class="pwsearch">
		<h3>비밀번호 찾기</h3>
		<form id="pwSearchForm" name="pwSearchForm" ><br/>
			아이디	: <input type="text" 	id="memId" 		name="memId" 	class="pl5"	placeholder="아이디" onkeydown="engNumber(this)"  style="text-transform: lowercase;"><br/>
			이&nbsp;&nbsp;&nbsp;&nbsp;름 : 	<input type="text" 	id="memNm" 		name="memNm" 	class="pl5"	placeholder="이름"> <br/>
			이메일	: <input type="text"	id="memEmail" 	name="memEmail" class="pl5"	placeholder="이메일" onkeydown="notHangeul(this)"><br/>
			<input type="button" id="btnPwSearch" name="btnPwSearch" value="찾기"><br/>
			<input type="hidden" id="memSearchGb" name="memSearchGb" value="pw"><br/>
			<span id="memPwSearch" style="color:red; font-size:12px;"></span>
		</form>
		</div>
	</div>
</div>
