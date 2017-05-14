<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
		<c:set var="url" value="<%= request.getServletPath() %>"/>
		
		<c:forEach var="row_dept1" items="${menuList}" varStatus="status">
			<c:if test="${row_dept1.MENU_LEVEL eq '1' && row_dept1.MENU_LINK eq url}">
				<h2>${row_dept1.MENU_NM}</h2>
			</c:if>
		</c:forEach>
		
		<!-- 해당하는 메뉴로 active 추후 예정 -->
        <ul>
			<c:forEach var="row_dept1" items="${menuList}" varStatus="status">
				<c:if test="${row_dept1.MENU_LEVEL eq '1'}">
					<li><h3>${row_dept1.MENU_NM}</h3>
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
		
		<!-- 
			<c:forEach var="row_dept1" items="${menuList}" varStatus="status">
				<c:if test="${row_dept1.MENU_LEVEL eq '1' && row_dept1.MENU_LINK eq url}}">
					<li><h3>${row_dept1.MENU_NM}</h3>
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
		
		 -->
		<!-- 
	        <ul>
	          <li><h3><a href="/sample/go.do">활동</a></h3>
	          	<ul>
					<li><a href="javascript:void(0);">헝겊원숭이 연대</a></li>
					<li><a href="/a0000006/apply/applyList.do">지역교육네트워크</a></li>
					<li><a href="#">교사학교</a></li>
					<li><a href="#">청년학교</a></li>
					<li><a href="#">청소년학교</a></li>
					<li><a href="#">오시는 길</a></li>
				</ul>
			   </li>
	          <li><h3><a href="/a0000006/apply/applyList.do">소개</a></h3>
	          	<ul>
					<li><a href="#">교육나눔 꿈두레 소개</a></li>
					<li><a href="#">운영주체</a></li>
					<li><a href="#">기관탐방/대관 신청</a></li>
					<li><a href="#">주요사업 담당 연락처</a></li>
					<li><a href="#">오시는 길</a></li>
				</ul>
			  </li>
	          <li class="active"><h3><a href="/a0000006/apply/applyList.do">신청 및 문의</a></h3>
	          	<ul>
					<li><a href="#">프로그램 신청</a></li>
					<li><a href="#">소공연장</a></li>
					<li><a href="#">강연회</a></li>
					<li><a href="#">세미나실</a></li>
					<li><a href="#">밴드연습실</a></li>
					<li><a href="#">댄스연습실</a></li>
				</ul>
			  </li>
	          <li><h3><a href="/a0000006/board/bookList.do">자료</a></h3>
	          	<ul>
					<li><a href="#">책소개</a></li>
					<li><a href="#">간행물</a></li>
					<li><a href="#">기타자료</a></li>
				</ul>
			  </li>
	          <li><h3><a href="#">후원</a></h3>
	          	<ul>
					<li><a href="#">햇빛</a></li>
					<li><a href="#">바람</a></li>
					<li><a href="#">물</a></li>
				</ul>
			  </li>
	        </ul> -->
	</div>
</body>
</html>