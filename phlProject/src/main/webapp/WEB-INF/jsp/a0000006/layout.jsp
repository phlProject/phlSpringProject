<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title><decorator:title default="교육나눔 꿈두레" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/common.js"></script>
<script src="/js/a0000006/member.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<decorator:head />
</head>
<body>
<div id="header">
	<header id="masthead" class="site-header">
		<div class="body_bg"><img src="/img/bg8.png" alt=""></div>
		<div class="container">
			<a href="/a0000006/mainIndex.do" class="img_logo"> <img src="/img/logo3.png" alt="" /></a>
		
			<nav id="main_lnb">
				<ul class="menu_one">
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
					<li><a href="#">신청 및 문의</a>
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
			</nav>
		</div>
	</header><!-- #masthead -->
</div>
<div id="contentBody">
   <decorator:body />
</div>
   <div id="footer">
   <footer id="main_footer">
      <h3>교육나눔꿈두레</h3>
      <address>Website Layout Basic</address>
   </footer>
   </div>
</body>
</html>
