<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	ComSubmit('bookList_Form','/a0000006/board/bookFormU.do');
</script>
</head>
<body>
	<form id="bookList_Form">
		<input type="hidden" id="BOARD_SN" name="BOARD_SN" value="${bookView.BOARD_SN}">
	</form>
	
	<div id="content">
	<img src="${bookView.FL_PATH}/${bookView.FL_NM}" width="150" height="200">
	제목 : ${bookView.SUBJECT}<br>
		 ${bookView.CONTENTS}
		 <br>
		 <input type="button" value="수정" onclick="bookFormU()">
		 <a href="/a0000006/board/bookList.do" id="bookList">목록</a>
	</div>
</body>
</html>