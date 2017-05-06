<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div id="content">
		<form id="bookList_Form">
			<table border="1">
				<c:if test="${empty bookList}">
					<tr>
						<td width="150" height="200">&nbsp;</td>
						<td width="700" height="200">조회 된 내용이 없습니다.</td>
					</tr>
					
				</c:if>
				<c:if test="${not empty bookList}">
					<c:forEach items="${bookList}" var="row">
					<tr>
						<td rowspan = "2" width="150" height="200"><img src="${row.FL_PATH}/${row.FL_NM}" width="150" height="200"></td>
						<td width="700" height="30"><a href="javascript:fn_bookView('${row.BOARD_SN}')">${row.SUBJECT}</a></td>
					</tr>
					<tr>
						<td width="700" height="170">${row.CONTENTS}</td>
					</tr>
					</c:forEach>
				</c:if>
			</table>
		</form>
		<a href="/a0000006/board/bookForm.do" id="bookForm">신규등록</a>
	</div>
</body>
</html>