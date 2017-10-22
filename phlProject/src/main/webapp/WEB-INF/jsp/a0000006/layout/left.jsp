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
		
		<c:if test="${fn:contains(urlPath, 'member') || fn:contains(urlPath, 'manage')}">
			<h2>마이페이지</h2>
			<ul>
				<li>
					<a href="javascript:TopMenuMove('/a0000006/member/memMyPage.do');" id="memMyPage">마이페이지</a>
				</li>
				<li>
					<a href="javascript:TopMenuMove('/a0000006/member/logoutAction.do');" id="logoutAction">로그아웃</a>
				</li>
				<!-- 관리자만 관리자모드 사용 가능 ( G01998 : 홈페이지 관리자 / G01999 : PHL 관리자 ) -->
				<c:if test="${loginInfo.MEM_GBN_CD eq 'G01998' || loginInfo.MEM_GBN_CD eq 'G01999'}">
					<li>
						<a href="javascript:TopMenuMove('/a0000006/manage/memList.do');" id="memList">관리자화면</a>
					</li>
				</c:if>
			</ul>
		</c:if>
		
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
		
		<ul>
			<c:forEach var="row_dept2" items="${menuList}" varStatus="status">
				<c:if test="${row_dept2.MENU_LEVEL eq '2' && fn:contains(row_dept2.MENU_LINK, urlPath)}">
					<li>
						<a href="javascript:TopMenuMove('${row_dept2.MENU_LINK}')"><h3>${row_dept2.MENU_NM}</h3></a>
					</li> 
					<c:forEach var="row_dept3" items="${menuList}" varStatus="status">
						<c:if test="${row_dept3.MENU_LEVEL eq '3' && 
									  fn:contains(row_dept3.MENU_LINK, urlPath) && 
									  row_dept2.MENU_CD eq row_dept3.UPPER_MENU_CD}">
							<li>
								<a href="javascript:TopMenuMove('${row_dept3.MENU_LINK}')"> - ${row_dept3.MENU_NM}</a>
							</li> 
						</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>
		</ul> 
	</div>
</body>
</html>