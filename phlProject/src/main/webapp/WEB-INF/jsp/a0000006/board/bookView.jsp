<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<!-- 목록이동_Form -->
	<form id="bookList_Form">
		<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}">
		<input type="hidden" id="searchWord" 	name="searchWord" 		value="${item.searchWord}">
	</form>
	
	<!-- 수정이동_Form -->
	<form id="bookView_Form">
		<input type="hidden" id="BSNS_CODE" 	name="BSNS_CODE" 		value="${bookView.BSNS_CODE}">	<!-- 업체코드 -->
		<input type="hidden" id="board_Sn" 		name="board_Sn" 		value="${bookView.BOARD_SN}">	<!-- 게시판 번호 -->
	</form>
	
	<div id="content">
		<h3 class="cont-title">책 소개</h3>
		<p class="book-view">제목 : ${bookView.SUBJECT}</p>
		<div class="view">
			<img src="${bookView.FL_PATH}/${bookView.FL_NM}" width="100%" height="auto">
		</div>
		<%-- 제목 : ${bookView.SUBJECT}<br> --%>
			 ${bookView.CONTENTS}
		<div class="bookView">	
			<div class="bookView-btn">
				<a href="javascript:fn_bookFormU();" id="bookFormU">수정</a>
				<a href="javascript:fn_deleteBook();" id="deleteBook">삭제</a>		
				<a href="javascript:fn_bookList();" id="bookList">목록</a>
			</div>
		</div>
	</div>
	
</body>
</html>