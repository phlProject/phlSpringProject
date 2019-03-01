<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="/css/DureStyle.css" />

  </head>

	<!-- 헤더 -->
	<div class="Dure_hd">
		<div class="Du_logo">
			<a href="/a0000007/mainIndex.do"><img src="/img/a0000007/logo2.png"></a>
		</div>
		<div class="Du_menu">
			<nav>
				<ul>
					<c:if test="${not empty sessionScope.loginInfo}">
					<li><a href="">${sessionScope.loginInfo.MEM_NM} 님</a></li>
					</c:if>
					<li><a href="/a0000007/intro/introduce.do">소개</a></li>
					<li><a href="/a0000007/program/programList.do">활동프로그램</a></li>
					<li><a href="/a0000007/schedule/scheduleList.do">일정</a></li>
					<li><a href="/a0000007/counsel/counselList.do">상담신청</a></li>
				</ul>
			</nav>
		</div>
		</div>
	</div>
    <!-- Navigation -->
    
     
