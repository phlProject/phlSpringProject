<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
.calendar_tb { font-family:"Noto Sans KR", sans-serif; }
.calendar_tb th{ background-color: #e2d318; width:270px; height:30px;  font-size:14px; }
.calendar_tb td { background-color: #faf5c5; font-size:12px; height:30px; text-align: center; }
</style>

<table class="calendar_tb">
	<tr>
		<th>일자</th>
		<th>시간</th>
		<th>제목</th>
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
