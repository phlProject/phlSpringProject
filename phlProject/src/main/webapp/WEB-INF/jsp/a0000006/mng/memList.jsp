<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function aaa(){
		alert(1);
	}
</script>
<body>
<div id="content">
		<table border="1">
			<tr>
				<!-- 검색조건 -->
				<td colspan="8" style="text-align: right">
					<select id="searchSelect" name="searchSelect">
						<option value="searchId" 		<c:if test="${searchSelect eq 'searchId'}">selected</c:if>>아이디</option>
						<option value="searchNick" 		<c:if test="${searchSelect eq 'searchNick'}">selected</c:if>>닉네임</option>
						<option value="searchIdNick"  	<c:if test="${searchSelect eq 'searchIdNick'}">selected</c:if>>아이디+닉네임</option>
						<option value="searchEmail"  	<c:if test="${searchSelect eq 'searchEmail'}">selected</c:if>>이메일</option>
						<option value="searchPhone"  	<c:if test="${searchSelect eq 'searchPhone'}">selected</c:if>>연락처</option>
						<option value="searchAuthor"  	<c:if test="${searchSelect eq 'searchAuthor'}">selected</c:if>>권한</option>
						<option value="searchRemark"  	<c:if test="${searchSelect eq 'searchRemark'}">selected</c:if>>계정상태</option>
					</select>
					<input type="text" id="searchWord" name="searchWord" value="${searchWord}">
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>닉네임</td>
				<td>이메일</td>
				<td>연락처</td>
				<td>권한</td>
				<td>계정상태</td>
				<td>승인처리</td>
				
			</tr>
			<c:forEach items="${memList}" var="row">
				<tr>
		              <td>${row.MEM_ID}</td>
		              <td>${row.MEM_NM}</td>
		              <td>${row.MEM_NICKNM}</td>
		              <td>${row.MEM_EMAIL}</td>
		              <td>${row.MEM_PHONE}</td>
		              <td>${row.MEM_GRADE_NM}</td>
		              <td>${row.REMARK_NM}</td>
		              <td>
		              	<c:if test="${row.USE_YN == 'S'}">
		              		승인처리
		              	</c:if>
		              </td>
		        </tr>
			</c:forEach>
			<tr>
				<td colspan="8">
					<c:if test="${beginPageNum > 10}">
						<a href="<c:out value="/a0000006/mng/memList.do?requestPageNumber=${beginPageNum-1}"/>">◀</a>
					</c:if>
					
					<c:forEach var="requestPageNumber" begin="${beginPageNum}" end="${endPageNum}">
						<a href="<c:out value="/a0000006/mng/memList.do?requestPageNumber=${requestPageNumber}"/>">${requestPageNumber}</a>
					</c:forEach>
					
					<c:if test="${endPageNum < totalPageCount}">
						<a href="<c:out value="/a0000006/mng/memList.do?requestPageNumber=${endPageNum+1}"/>">▶</a>
					</c:if>
				</td>
			</tr>
		</table>
</div>
</body>
</html>