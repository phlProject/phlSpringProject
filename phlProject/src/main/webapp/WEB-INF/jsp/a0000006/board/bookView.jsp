<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function fn_updateBookForm(){
	ComSubmit('bookView_Form','/a0000006/board/bookFormU.do');
}
</script>
</head>
<body>
	<!-- 목록이동_Form -->
	<form id="bookList_Form">
		<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}">
		<input type="hidden" id="searchWord" 	name="searchWord" 		value="${item.searchWord}">
	</form>
	
	<!-- 수정이동_Form -->
	<form id="bookView_Form">
		<input type="hidden" id="bsns_code" 	name="bsns_code" 		value="${bookView.BSNS_CODE}">	<!-- 업체코드 -->
		<input type="hidden" id="board_sn" 		name="board_sn" 		value="${bookView.BOARD_SN}">	<!-- 게시판 번호 -->
		<input type="hidden" id="board_gbn_cd" 	name="board_gbn_cd" 	value="${bookView.BOARD_SN}">	<!-- 게시판 구분 -->
	</form>
	
	<div id="content">
		<img src="${bookView.FL_PATH}/${bookView.FL_NM}" width="150" height="200">
		제목 : ${bookView.SUBJECT}<br>
			 ${bookView.CONTENTS}
			 <br>
		<a href="javascript:fn_updateBookForm();" id="updateBookForm">수정</a>
		<a href="javascript:fn_bookList();" id="bookList">목록</a>
	</div>
	
</body>
</html>