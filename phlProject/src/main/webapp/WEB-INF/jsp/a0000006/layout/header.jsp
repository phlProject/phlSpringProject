<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교육나눔 꿈두레</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div id="header">
	<header id="masthead" class="site-header">
			<div id="logo"><a href="/a0000006/mainIndex.do"><img src="/img/logo5.png"></a></div>
			<nav>
				<ul>
				<c:choose>
				<c:when test="${not empty sessionScope.loginInfo}">
					<li><a href="/a0000006/mem/memMyPage.do" id="memMyPage">${sessionScope.loginInfo.MEM_NM}</a></li>
					<li><a href="/a0000006/mem/logoutAction.do" id="logoutAction">로그아웃</a></li>
					<li><a href="/a0000006/mem/selectMemList.do" id="memList">회원리스트</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/a0000006/mem/memLoginForm.do" id="memLoginForm">로그인</a></li>
					<li><a href="/a0000006/mem/memRegistForm.do" id="memRegistForm">회원가입</a></li>
				</c:otherwise>
				</c:choose>
				</ul>
			</nav>
			<div id="menu">
				<ul>
					<li><a href="/sample/go.do">활동</a>
						<ul>
							<li><a href="#">헝겊원숭이 연대</a></li>
							<li><a href="#">지역교육네트워크</a></li>
							<li><a href="#">교사학교</a></li>
							<li><a href="#">청년학교</a></li>
							<li><a href="#">청소년학교</a></li>
							<li><a href="#">오시는 길</a></li>
						</ul>
					</li>
					<li><a href="#">소개</a>
						<ul>
							<li><a href="#">교육나눔 꿈두레 소개</a></li>
							<li><a href="#">운영주체</a></li>
							<li><a href="#">기관탐방/대관 신청</a></li>
							<li><a href="#">주요사업 담당 연락처</a></li>
							<li><a href="#">오시는 길</a></li>
						</ul>		
					</li>
					<li><a href="/a0000006/apply/applyList.do">신청 및 문의</a>
						<ul>
							<li><a href="#">프로그램 신청</a></li>
							<li><a href="#">소공연장</a></li>
							<li><a href="#">강연회</a></li>
							<li><a href="#">세미나실</a></li>
							<li><a href="#">밴드연습실</a></li>
							<li><a href="#">댄스연습실</a></li>
						</ul>
					</li>
					<li><a href="#">자료</a>
						<ul>
							<li><a href="#">책소개</a></li>
							<li><a href="#">간행물</a></li>
							<li><a href="#">기타자료</a></li>
						</ul>
					</li>
					<li><a href="#">후원</a>
						<ul>
							<li><a href="#">햇빛</a></li>
							<li><a href="#">바람</a></li>
							<li><a href="#">물</a></li>
						</ul>
					</li>
				</ul>
			</div>
	</header><!-- #masthead -->
</div>
</body>
</html>