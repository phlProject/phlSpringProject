<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" type="text/css" href="/css/pkhl.css" />
<link rel="stylesheet" type="text/css" href="/css/mainIndex.css" />
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" media="all">


<form id="topMenu_Form" name="topMenu_Form">
	<input type="hidden" id="bsnsCode" name="bsnsCode"
		value="${sessionScope.bsnsCode}">
</form>

<div class="heading">
	<div class="main_logo">
		<a href="/a0000007/mainIndex.do"><img src="/img/logo10.png"></a>
	</div>
</div>
<div id="bg">
	<div id="container">
			
		<div class="menu_box">
			<div class="box" onclick="javascript:TopMenuMove('/a0000007/intro/introduce.do')">
				<a href="#" class="button cta hvr-float-shadow">소개</a>
			</div>
			<div class="box" onclick="javascript:TopMenuMove('/a0000007/program/programList.do')">
				<a href="#" class="button cta hvr-float-shadow">활동프로그램</a>
			</div>
			<div class="box" onclick="javascript:TopMenuMove('/a0000007/schedule/scheduleList.do')">
				<a href="#" class="button cta hvr-float-shadow">일정</a>
			</div>
			<div class="box" onclick="javascript:TopMenuMove('/a0000007/counsel/counselList.do')">
				<a href="#" class="button cta hvr-float-shadow">상담신청</a>
			</div>
		</div>	
		
	</div>
</div>