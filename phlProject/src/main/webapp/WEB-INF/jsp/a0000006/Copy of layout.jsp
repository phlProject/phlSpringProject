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
<script src="/js/commons.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<script type="text/javascript">
	
	$(document).ready(function(){
		/* 회원가입 폼 */
		$("#memRegistForm").on("click", function(e){
			e.preventDefault();
			fn_memRegistForm();
		});
		/* 로그인 폼 */
		$("#memLoginForm").on("click", function(e){
			e.preventDefault();
			fn_memLoginForm();
		});
		/* 회원리스트 */
		$("#memList").on("click", function(e){
			e.preventDefault();
			fn_memList();
		});
		/* 로그아웃 */
		$("#logoutAction").on("click", function(e){
			e.preventDefault();
			fn_logoutAction();
		});
		/* 마이페이지 */
		$("#memMyPage").on("click", function(e){
			e.preventDefault();
			fn_memMyPage();
		});
	});
	
	/* 회원가입 폼 이동 */
	function fn_memRegistForm(){
		var comSubmit = new ComSubmit();
		ComSubmit()
		comSubmit.setUrl("<c:url value='/a0000006/mem/memRegistForm.do'/>");
		comSubmit.submit();
	}
	
	/* 로그인 폼 이동 */
	function fn_memLoginForm(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/a0000006/mem/memLoginForm.do'/>");
		comSubmit.submit();
	}
	
	/* 회원리스트 */
	function fn_memList(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/a0000006/mem/selectMemList.do'/>");
		comSubmit.submit();
	}
	
	/* 로그아웃 */
	function fn_logoutAction(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/a0000006/mem/logoutAction.do'/>");
		comSubmit.submit();
	}
	
	/* 마이페이지 */
	function fn_memMyPage(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/a0000006/mem/memMyPage.do'/>");
		comSubmit.submit();
	}
	
	$(document).ready(function(){		
		$("#mainIndex").on("click", function(e){
			e.preventDefault();
			fn_mainIndex();
		});
		$("#loginAction").on("click", function(e){
			e.preventDefault();
			fn_loginAction();
		});
	});

	function fn_mainIndex(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/a0000006/mainIndex.do'/>");
		comSubmit.submit();
	}
	
	function fn_loginAction(){
		var comSubmit = new ComSubmit("loginActionForm");
		comSubmit.setUrl("<c:url value='/a0000006/mem/loginAction.do'/>");
		comSubmit.submit();
	}

</script>
<decorator:head />
</head>
<body style=" background-image: url('/img/bg5.png'); background-repeat: no-repeat; z-index:69; background-size:42%;">
	<header id="masthead" class="site-header">
		<div class="container">
			<a href="/a0000006/mainIndex.do" class="img_logo"> <img src="/img/logo2.png" alt="" /></a>
		
			<nav id="main_lnb">
				<ul class="menu_one">
				<c:choose>
				<c:when test="${not empty sessionScope.loginInfo}">
					<li><a href="#this" id="memMyPage">${sessionScope.loginInfo.MEM_NM}</a></li>
					<li><a href="#this" id="logoutAction">로그아웃</a></li>
					<li><a href="#this" id="memList">회원리스트</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="#this" id="memLoginForm">로그인</a></li>
					<li><a href="#this" id="memRegistForm">회원가입</a></li>
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
	<div class="gap"></div>
	<decorator:body />
	<footer id="main_footer">
		<h3>교육나눔꿈두레</h3>
		<address>Website Layout Basic</address>
	</footer>
</body>
</html>
