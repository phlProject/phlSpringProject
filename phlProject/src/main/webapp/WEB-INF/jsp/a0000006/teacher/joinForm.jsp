<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교육나눔 꿈두레</title>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" charset="utf-8" src="/resources/editor/js/HuskyEZCreator.js"></script>

<script>
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
		$("#fn_saveJoin").click(function() {

			var msg = "";
			var postUrl = "";

			if ($("#newYn").val() == "Y") {
				msg = "저장하시겠습니까?";
				postUrl = "/a0000006/teacher/insertJoin.do";
			} else if ($("#newYn").val() == "N") {
				msg = "수정하시겠습니까?";
				postUrl = "/a0000006/teacher/updateJoin.do";
			}

			if (!confirm(msg)) {
				return;
			}

			// Smart Editor 사용 Script ( textarea id = 'editor' )
			editor_object.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);

			$.post(postUrl, $("#editor_Form").serialize(), function(data) {
				if (data.result == "success") {
					alert("등록되었습니다.");
					if ($("#newYn").val() == "Y")
						$("#boardSn").val(data.boardSn);
					ComSubmit('joinList_Form', '/a0000006/teacher/joinView.do');
				} else {
					alert("실패하였습니다. 관리자에게 문의해주세요.");
					ComSubmit('joinList_Form', '/a0000006/teacher/joinList.do');
					return;
				}
			});
		});
	});
</script>
</head>
<body>
	<!-- 목록이동_Form -->
	<form id="joinList_Form">
		<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}"> 		<!-- 검색구분 -->
		<input type="hidden" id="searchWord" 	name="searchWord"		value="${item.searchWord}">	  		<!-- 검색어 -->
		<input type="hidden" id="selectCategory"name="selectCategory"	value="${item.selectCategory}">	  	<!-- 검색카테고리  -->
		<input type="hidden" id="bsnsCode" 		name="bsnsCode" 		value="${sessionScope.bsnsCode}">	<!-- 세션_업체코드 -->
		<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
		<input type="hidden" id="boardSn" 		name="boardSn" 			value="${joinView.BOARD_SN}">		<!-- 게시판_번호 -->
		
		
	</form>
	
	<div id="content">
		
		<input type="hidden" id="newYn" name="newYn" value="${item.newYn}"><!-- 신규등록여부 ( 신규 : Y / 수정 : N ) -->
		
		<h3 class="book-title"> 작성</h3>
		
		
		<form id="editor_Form">
			<input type="hidden" id="bsnsCode" 		name="bsnsCode" 	value="${sessionScope.bsnsCode}"> 	<!-- 세션_업체코드 -->
			<input type="hidden" id="boardGbnCd" 	name="boardGbnCd" 	value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
			<input type="hidden" id="sessionId" 	name="sessionId"	value="${sessionScope.sessionId}">	<!-- 세션_아이디(등록자/수정자) -->
			<input type="hidden" id="boardSn" 		name="boardSn"		value="${joinView.BOARD_SN}">		<!-- 게시판_번호 -->
			
			<h3>제  &nbsp;&nbsp;목 :</h3> &nbsp;&nbsp;
			<input type="text" id="subject" name="subject" size="86" value="${joinView.SUBJECT}"><br/><br/>
			
			카테고리 : 
			<select id="teacherGbnCd" name="teacherGbnCd">
				<option value="">선택</option>	
				<c:forEach items="${teacherGbnList}" var="rows">
					<option value="${rows.CMMN_CODE}" <c:if test="${rows.CMMN_CODE == joinView.BOARD_GBN_CD}">SELECTED</c:if>>${rows.DETAIL_CODE_NM}</option>
				</c:forEach>
			</select>
			<textarea id="editor" name="editor" style="HEIGHT: 300px; WIDTH: 90%" rows="10" cols="30">${joinView.CONTENT}</textarea>
		</form>
		
		<!-- 버튼  -->
		<div class="bookView">
			<div class="bookView-btn">
				<a href="#" id="fn_saveJoin">저장</a> 
				<a href="javascript:fn_joinList();" id="joinList">목록</a>
			</div>
		</div>
		
	</div>
</body>
</html>