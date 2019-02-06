<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" type="text/css" href="/css/pkhl.css" />
<link rel="stylesheet" type="text/css" href="/css/mainIndex.css" />


<form id="topMenu_Form" name="topMenu_Form">
	<input type="hidden" id="bsnsCode" name="bsnsCode"
		value="${sessionScope.bsnsCode}">
</form>

<div class="container">
	<div class="heading">
		<a href="/a0000007/mainIndex.do"><h2>두레꿈학교</h2></a>
	</div>
	
	<div class="grid">
			<div class="mainMenu" onclick="javascript:TopMenuMove('/a0000007/intro/introduce.do')">
				<figure class="effect-ming" >
						<img src="/img/a0000007/portfolio-1.jpg" alt="img09"/>
							<figcaption>
								<h2>소개</h2>
								<p>Ming sits in the corner the whole day. She's into crochet.</p>
							</figcaption>						
				</figure>
			</div>	
		
		<div class="mainMenu"	onclick="javascript:TopMenuMove('/a0000007/program/programList.do')">
				<figure class="effect-ming" >
					<img class="img-fluid" src="/img/a0000007/portfolio-2.jpg" alt="">
					<figcaption>
						<h2>활동프로그램</h2>
						<p>Ming sits in the corner the whole day. She's into crochet.</p>
						</figcaption>			
					</figure>
				</div>
		<div class="mainMenu"	onclick="javascript:TopMenuMove('/a0000007/schedule/scheduleList.do')">
			<figure class="effect-ming" >
					<img class="img-fluid" src="/img/a0000007/portfolio-3.jpg" alt="">
					<figcaption>
						<h2>일정</h2>
						<p>Ming sits in the corner the whole day. She's into crochet.</p>
					</figcaption>			
			</figure>
		</div>
		<div class="mainMenu"	onclick="javascript:TopMenuMove('/a0000007/counsel/counselList.do')">
			<figure class="effect-ming" >
					<img class="img-fluid" src="/img/a0000007/portfolio-4.jpg" alt="">
					<figcaption>
						<h2>상담신청</h2>
				<p>Ming sits in the corner the whole day. She's into crochet.</p>
					</figcaption>			
			</figure>
		</div>
	</div>
</div>	