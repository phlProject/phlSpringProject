<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

	$(function(){
		$("#left_sidebar h3").click(function(){
			$("#left_sidebar ul ul").slideUp(100);
			if(!$(this).next().is(":visible"))
				{
					$(this).next().slideDown(100);
				}
		});
	});
</script>
<title>교육나눔꿈두레</title>
</head>
<body>
	<div id="left_sidebar">
	 	
		<c:set var="url" value="<%= request.getServletPath() %>"/>	<!-- 현재 URL Path -->
		<c:set var="ext" value="${fn:split(url,'/')}" /> 	<!-- '/' 단위로 자르기 (배열) -->
		<c:set var="urlPath" value="/${ext[0]}/${ext[1]}"/>	
		
		<c:forEach var="row_dept1" items="${menuList}" varStatus="status"> <!-- 부모 -->
			<c:if test="${row_dept1.MENU_LEVEL eq '1' && fn:contains(row_dept1.MENU_LINK, urlPath)}">
				<c:forEach var="row_dept2" items="${menuList}" varStatus="status">	<!-- 자식 -->
					<!-- path :  / ? / ? 포함한 단어의 부모 메뉴명 뿌림 -->
					<c:choose>
						<c:when test="${fn:contains(row_dept2.MENU_LINK, urlPath) eq true && row_dept2.MENU_LEVEL eq '1'}">
							<h2>${row_dept1.MENU_NM}</h2> 
						</c:when>
					</c:choose>
				</c:forEach>
			</c:if>
		</c:forEach>
		
		<!-- 해당하는 메뉴로 active 추후 예정 -->
		<ul>
			<c:forEach var="row_dept2" items="${menuList}" varStatus="status">
				<c:if test="${row_dept2.MENU_LEVEL eq '2' && fn:contains(row_dept2.MENU_LINK, urlPath)}">
					<li>
						<a href="javascript:TopMenuMove('${row_dept2.MENU_LINK}')"><h3>${row_dept2.MENU_NM}</h3></a>
					</li> 
				</c:if>
			</c:forEach>
		</ul> 
       	<%--  
       	<ul>
			<c:forEach var="row_dept1" items="${menuList}" varStatus="status">
				<c:if test="${row_dept1.MENU_LEVEL eq '1'}">
					<li>
						<h3>${row_dept1.MENU_NM}</h3>
						<ul>
							<c:forEach var="row_dept2" items="${menuList}" varStatus="status">
								<c:if test="${(row_dept2.MENU_LEVEL eq '2') && (row_dept1.MENU_CD eq row_dept2.UPPER_MENU_CD) }">
									<li>
										<a href="javascript:TopMenuMove('${row_dept2.MENU_LINK}')">${row_dept2.MENU_NM}</a>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</li>
				</c:if>
			</c:forEach>
		</ul> 
		--%>
	</div>
</body>
</html>