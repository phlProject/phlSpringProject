<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="content" align="center">
		myPage : <br>
			${myPageInfo.MEM_ID}<br>
			${myPageInfo.MEM_PW}<br>
			${myPageInfo.MEM_NM}<br>
			${myPageInfo.MEM_NICKNM}<br>
			${myPageInfo.MEM_GRADE}<br>
			${myPageInfo.MEM_GRADE_NM}<br>
			${myPageInfo.MEM_EMAIL}<br>
			${myPageInfo.MEM_PHONE}<br>
	</div>
</body>
</html>