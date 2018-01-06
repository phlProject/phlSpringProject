<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table>
	<tr>
		<td>일자</td>
		<td>시간</td>
		<td>내용</td>
	</tr>
	<c:if test="${empty periodList}">
		<tr>
			<td colspan="3">조회 된 일정이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="rows" items="${periodList}" varStatus="status">
		
		<tr>
			<td>${rows.SCHEDULE_DT}</td>
			<td>${rows.ST_HOUR}시 ~ ${rows.END_HOUR}시</td>
			<td>${rows.SUBJECT}</td>
		</tr>
	</c:forEach>
</table>