<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="content">
	<div class="tabmenu">
	    <ul>
	        <li class="tab1">
	        	<a href="#link" onclick="memInfoInit();"><img src="/img/tab-3-off.png" alt="메뉴01" /></a>
	            <ul class="tabcontent">
	                <li><a href="#"></a>
	                <div class="tab-cont3">
		                <div class="tab-cont1">
							<h3 class="cont1-1">아이디 찾기</h3><br/>
							<form id="idSearchForm" name="idSearchForm">
								이름	: <input type="text" id="memNm" 	name="memNm"> <br/>
								이메일	: <input type="text" id="memEmail" 	name="memEmail" placeholder="이메일" onkeydown="notHangeul(this)"> <br/>
								<input type="button" id="btnIdSearch" name="btnIdSearch" value="찾기">
								<input type="hidden" id="memSearchGb" name="memSearchGb" value="id">
								<span id="memSearchId" style="color:red; font-size:12px;"></span>
							</form>
						</div>
					</div>
	                </li>
	            </ul>
	        </li>
	        <li class="tab2">
	        	<a href="#link" onclick="memInfoInit();"><img src="/img/tab-4-off.png" alt="메뉴02" /></a>
	            <ul class="tabcontent">
	                <li><a href="#"></a>
	               		 <div class="tab-cont3">
							<h3 class="cont1-1">비밀번호 찾기</h3><br/>
							<form id="pwSearchForm" name="pwSearchForm">
								아이디	: <input type="text" 	id="memId" 		name="memId" onkeydown="engNumber(this)" style="text-transform: lowercase;"> <br/>
								이름	: <input type="text" 	id="memNm" 		name="memNm"> <br/>
								이메일	: <input type="text"	id="memEmail" 	name="memEmail" placeholder="이메일" onkeydown="notHangeul(this)"> <br/>
								<input type="button" id="btnPwSearch" name="btnPwSearch" value="찾기">
								<input type="hidden" id="memSearchGb" name="memSearchGb" value="pw">
								<span id="memSearchPw" style="color:red; font-size:12px;"></span>
							</form>
						</div>
	                </li>
	            </ul>
	        </li>
	    </ul>
	</div>
</div>
