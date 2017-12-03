<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">

	$(document).ready(function() {
		
		// 아이디 찾기 검색 클릭
		$('#btnIdSearch').click(function(){
			
			var postUrl = "/a0000006/member/memInfoSearch.do";
			
			$.post(postUrl, $("#idSearchForm").serialize(), function(data){
				if(data.result == "success" ){
					$("#memSearchId").text("회원님의 아이디는 ' " + data.memInfo + " ' 입니다.");
				} else{
					alert("수정에 실패하였습니다. 관리자에게 문의해주세요.");
					return;
				}
			});
			
		});
		
		
		// 비밀번호 찾기 검색 클릭
		$('#btnPwSearch').click(function(){
			
			var postUrl = "/a0000006/member/memInfoSearch.do";
			
			$.post(postUrl, $("#pwSearchForm").serialize(), function(data){
				if(data.result == "success" ){
					$("#memSearchPw").text("회원님의 비밀번호는 ' " + data.memInfo + " ' 입니다.");
					//ComSubmit('mem_Form','/a0000006/manage/memList.do');
				} else{
					alert("수정에 실패하였습니다. 관리자에게 문의해주세요.");
					return;
				}
			});
			
		});
		
	});
	
	// 정보 초기화
	function memInfoInit(){
		$("#memId").val("");
		$("#memNm").val("");
		$("#memPhone").val("");
		$("#memSearchId").text("");
		$("#memSearchPw").text("");
	}
</script>

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
								<input type="hidden" id="memSearchGb" name="memSearchGb" value="id">
								이름	: <input type="text" id="memNm" name="memNm"> <br/>
								휴대폰	: <input type="text" id="memPhone" name="memPhone"> <br/>
								<input type="button" id="btnIdSearch" name="btnIdSearch" value="찾기">
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
								<input type="hidden" id="memSearchGb" name="memSearchGb" value="pw">
								아이디	: <input type="text" id="memId" name="memId"> <br/>
								이름	: <input type="text" id="memNm" name="memNm"> <br/>
								휴대폰	: <input type="text" id="memPhone" name="memPhone"> <br/>
								<input type="button" id="btnPwSearch" name="btnPwSearch" value="찾기">
								<span id="memSearchPw" style="color:red; font-size:12px;"></span>
							</form>
						</div>
	                </li>
	            </ul>
	        </li>
	    </ul>
	</div>
</div>
