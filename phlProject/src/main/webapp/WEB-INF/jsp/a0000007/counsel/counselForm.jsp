<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="/js/a0000007/counsel.js"></script>

<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" charset="utf-8" src="/resources/editor/js/HuskyEZCreator.js"></script>


<!-- 
	상담 신청
	등록 - 모두
	수정 - 글쓴이(비밀번호)
 -->
<c:set var="authYn" value="Y"/>

<!-- 목록이동_Form -->
<form id="boardList_Form">
	<input type="hidden" id="searchSelect" 	name="searchSelect" value="${item.searchSelect}"> 		<!-- 검색구분 		-->
	<input type="hidden" id="searchWord" 	name="searchWord"	value="${item.searchWord}">	  		<!-- 검색어 		-->
	<input type="hidden" id="bsnsCode" 		name="bsnsCode" 	value="${sessionScope.bsnsCode}">	<!-- 세션_업체코드 	-->
	<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 	value="${item.boardGbnCd}">			<!-- 게시판_구분	-->
	<input type="hidden" id="boardSn" 		name="boardSn" 		value="${boardView.BOARD_SN}">		<!-- 게시판_번호 	-->
</form>


<div id="content">

	<input type="hidden" id="newYn" name="newYn" value="${item.newYn}"><!-- 신규등록여부 ( 신규 : Y / 수정 : N ) -->
	
	<div id="default_view_form">
		<h3 id="default_view_title">상담 등록</h3>
	</div>
	
	<!-- Editor_Form -->
	<form id="default_editor_Form" name="default_editor_Form">
		<input type="hidden" id="bsnsCode" 		name="bsnsCode" 	value="${sessionScope.bsnsCode}"> 	<!-- 세션_업체코드 			-->
		<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 	value="${item.boardGbnCd}">			<!-- 게시판_구분 			-->
		<input type="hidden" id="sessionId" 	name="sessionId"	value="${sessionScope.sessionId}">	<!-- 세션_아이디(등록자/수정자) 	-->
		<input type="hidden" id="boardSn" 		name="boardSn"		value="${boardView.BOARD_SN}">		<!-- 게시판_번호 			-->
		
		<h3>작성자</h3>
		<input type="text" 		id="regNm" 		name="regNm" 		size="86" value="${boardView.REG_NM}"><br/>
		<h3>비밀번호</h3>
		<input type="password" 	id="password" 	name="password" 	size="86" value="${boardView.PASSWORD}" onkeydown="engNumber(this)" maxlength="8"><br/>
		<h3>연락처</h3>
		<input type="text" 		id="phone" 		name="phone" 		size="86" value="${boardView.PHONE}" 	onkeydown="onlyNumber(this)" maxlength="12"><br/>
		<h3>이메일</h3>
		<input type="text" 		id="email" 		name="email" 		size="86" value="${boardView.EMAIL}" 	onkeydown="notHangeul(this)"><br/>
		<h3>제목</h3>
		<input type="text" 		id="subject" 	name="subject" 		size="86" value="${boardView.SUBJECT}">
		<textarea id="editor" name="editor" style="HEIGHT: 300px; WIDTH: 90%" rows="10" cols="30">${boardView.CONTENT}</textarea>
	</form>
	
	<!-- 버튼  -->
	<div class="default_btnDiv">
		<div class="default_btn">
			<a href="#" id="fn_saveCounsel">등록</a> 
			<a href="javascript:fn_counselList();" id="counselList">취소</a>
		</div>
	</div>
	
</div>


<script type="text/javascript">

	$(function() {
		
		// Smart Editor 사용 Script
		var editor_object = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : editor_object,
			elPlaceHolder : "editor",
			sSkinURI : "/resources/editor/SmartEditor2Skin.html",
			htParams : {
				bUseToolbar : true,			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,		// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			}
		});

		//저장버튼 클릭이벤트
		$("#fn_saveCounsel").click(function() {
			
			// 유효성 체크
			if(!fn_valid()){
				return;
			}

			// Smart Editor 사용 Script ( textarea id = 'editor' ) / 유효성 체크
			editor_object.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
			var editor = $.trim($("#editor").val());

			if( editor == ""  || editor == null || editor == '&nbsp;' || editor == '<p>&nbsp;</p>')  {
	             alert("내용을 입력 해주세요.");
	             editor_object.getById["editor"].exec("FOCUS"); //포커싱
	             return;
	        }
			
			var msg = "";
			var postUrl = "";

			if ($("#newYn").val() == "Y") {
				msg = "등록하시겠습니까?";
				postUrl = "/a0000007/counsel/insertCounsel.do";
			} else if ($("#newYn").val() == "N") {
				msg = "수정하시겠습니까?";
				postUrl = "/a0000007/counsel/updateCounsel.do";
			}

			if (!confirm(msg)) {
				return;
			}

			$.post(postUrl, $("#default_editor_Form").serialize(), function(data) {
				if (data.result == "success") {
					alert("등록되었습니다.");
					if ($("#newYn").val() == "Y")
						$("#boardSn").val(data.boardSn);
					ComSubmit('boardList_Form', '/a0000007/counsel/counselView.do');
				} else {
					alert("실패하였습니다. 관리자에게 문의해주세요.");
					ComSubmit('boardList_Form', '/a0000007/counsel/counselList.do');
					return;
				}
			});
		});
	});
	
	// 유효성 검사
	function fn_valid(){
		
		var authYn 	= '<c:out value="${authYn}" escapeXml="false"/>'; 	// 등록 권한
		
		var regNm    	= $("#regNm").val();	// 작성자
		var password 	= $("#password").val();	// 비밀번호
		var phone    	= $("#phone").val();	// 연락처
		var email    	= $("#email").val();	// 이메일
		var subject 	= $("#subject").val();	// 제목
		
		
		if(authYn == "N"){
			alert("등록/수정 할 권한이 없습니다.");
			return false;
		}
		
		if(!this.gfnIsNull(regNm)){
			alert("작성자를 입력 해주세요.");
			$("#regNm").focus();
			return false;
		}
		
		if(!this.gfnIsNull(password)){
			alert("비밀번호를 입력 해주세요.");
			$("#password").focus();
			return false;
		}
		
		if(!this.gfnIsNull(phone)){
			alert("연락처를 입력 해주세요.");
			$("#phone").focus();
			return false;
		}
		
		if(!this.gfnIsNull(email)){
			alert("이메일을 입력 해주세요.");
			$("#email").focus();
			return false;
		}
		
		if(!this.gfnIsNull(subject)){
			alert("제목을 입력 해주세요.");
			$("#subject").focus();
			return false;
		}

		return true;
	}
</script>