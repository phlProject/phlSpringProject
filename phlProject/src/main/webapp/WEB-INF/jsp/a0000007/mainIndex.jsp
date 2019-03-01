<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" type="text/css" href="/css/pkhl.css" />
<link rel="stylesheet" type="text/css" href="/css/mainIndex.css" />
<!-- <link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script" rel="stylesheet"> -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">


<form id="topMenu_Form" name="topMenu_Form">
	<input type="hidden" id="bsnsCode" name="bsnsCode"
		value="${sessionScope.bsnsCode}">
</form>

<div class="heading">
	<div class="main_logo">
		<a href="/a0000007/mainIndex.do"><img src="/img/a0000007/logo.png"></a>
	</div>
</div>
<div id="bg">
	<div id="container">
			
		<div class="menu_box">
			<div class="box" onclick="javascript:TopMenuMove('/a0000007/intro/introduce.do')">
				<a href="#" class="button cta hvr-float-shadow">소개<br/>
					<i class="far fa-handshake" style="color:#012754;font-size:50px;padding-top:30px;"></i><br/><br/>
						<hr style="width:70px; border:2px solid #012754;"><br/>
						<h3 class="fontone">두레꿈학교를  소개합니다.</h3>
						<h3 class="fonttwo">Introduction</h3>
						
				</a>
			</div>
			<div class="box" onclick="javascript:TopMenuMove('/a0000007/program/programList.do')">
				<a href="#" class="button cta hvr-float-shadow">활동프로그램<br/>
					<i class="fas fa-tasks" style="color:#4CC8D2;font-size:50px;padding-top:30px;"></i><br/><br/>
						<hr style="width:70px; border:2px solid #4CC8D2;"><br/>
						<h3 class="fontone">두레꿈학교 활동프로그램입니다.</h3>
						<h3 class="fonttwo">Activity Program</h3>
						
				</a>
			</div>
			<div class="box" onclick="javascript:TopMenuMove('/a0000007/schedule/scheduleList.do')">
				<a href="#" class="button cta hvr-float-shadow">일정<br/>
					<i class="far fa-calendar-alt" style="color:#7B025F;font-size:50px;padding-top:30px;"></i><br/><br/>
						<hr style="width:70px; border:2px solid #7B025F;"><br/>
						<h3 class="fontone">두레꿈학교 일정을 확인하세요!</h3>
						<h3 class="fonttwo">Schedule</h3>
				</a>
			</div>
			<div class="box" onclick="javascript:TopMenuMove('/a0000007/counsel/counselList.do')">
				<a href="#" class="button cta hvr-float-shadow">상담신청<br/>
					<i class="fas fa-edit" style="color:#DEE075;font-size:50px;padding-top:30px;"></i><br/><br/>
						<hr style="width:70px; border:2px solid #DEE075;"><br/>
						<h3 class="fontone">두레꿈학교 상담신청입니다.</h3>
						<h3 class="fonttwo">Consultation Application</h3>
				</a>
			</div>
			<br/>
			<p class="foot1">Copyrightⓒ 2019 두레꿈학교  All rights reserved.</p>
		</div>
		
	</div>
	
</div>