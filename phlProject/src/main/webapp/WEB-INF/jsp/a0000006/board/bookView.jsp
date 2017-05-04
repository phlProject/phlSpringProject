<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

제목 : ${bookView.SUBJECT}<br>
	 ${bookView.CONTENTS}
	 <br>
	 <a href="/a0000006/board/updateBook.do" id="updateBook">수정</a>
	 <a href="/a0000006/board/bookList.do" id="bookList">목록</a>
</body>
</html>