<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/gsap/1.19.1/TweenMax.min.js"></script>

<script type='text/javascript' src='/js/jquery.mobile.customized.min.js'></script>
<script type='text/javascript' src='/js/jquery.easing.1.3.js'></script> 
<script type='text/javascript' src='/js/camera.min.js'></script> 

<style>
	body {
		margin: 0;
		padding: 0;
	}
	a {
		color: #09f;
	}
	a:hover {
		text-decoration: none;
	}
	#back_to_camera {
		clear: both;
		display: block;
		height: 80px;
		line-height: 40px;
		padding: 20px;
	}
	.fluid_container {
		margin: 0 auto;
		max-width:1100px;
		width: 100%;
	}
</style>
   
   
<script>
	jQuery(function(){
		jQuery('#camera_wrap_1').camera({
			thumbnails: true
		});
	});
</script>

<div class="fluid_container">
	<div class="camera_wrap camera_azure_skin" id="camera_wrap_1">
		<div data-thumb="/img/slides/thumbs/bridge.jpg" 	data-src="/img/slides/bridge.jpg"></div>
		<div data-thumb="/img/slides/thumbs/leaf.jpg" 		data-src="/img/slides/leaf.jpg"></div>
		<div data-thumb="/img/slides/thumbs/road.jpg" 		data-src="/img/slides/road.jpg"></div>
		<div data-thumb="/img/slides/thumbs/sea.jpg" 		data-src="/img/slides/sea.jpg"></div>
		<div data-thumb="/img/slides/thumbs/shelter.jpg" 	data-src="/img/slides/shelter.jpg"></div>
		<div data-thumb="/img/slides/thumbs/tree.jpg" 		data-src="/img/slides/tree.jpg"></div>
	</div>
</div>

<div class="content">
	<div id="tab_menu">	
		<ul id="tab">
			<li class="on"><a href="javascript:void(0);" 	id="tabScheduleToday" 	name="tabScheduleToday">오늘</a></li>
			<li><a href="javascript:void(0);" 				id="tabScheduleWeek"	name="tabScheduleWeek">이번주</a></li>
			<li><a href="javascript:void(0);" 				id="tabScheduleMonth" 	name="tabScheduleMonth">이번달</a></li>
		</ul>
	</div>
	
	<div id="main_calendar">
		<form id="calendarForm" name="calendarForm" method="post" action="#;">
			<iframe id="ifrmCalendar" name="ifrmCalendar" frameborder="0" hspace="0" vspace="0" width="100%" height="800" scrolling="no"></iframe>
		</form>
	</div>
</div>
  
<div id="main_sidebar">
	<div class="sidebar-1">
		<a href="javascript:TopMenuMove('/a0000006/intro/sponsor.do');">
			<img src="/img/sidebar7.png"  alt="sponsor"/>      		
		</a>
	</div>
	
	<div class="sidebar-2">
	</div>
	
	<div class="sidebar-3">
		<a href="#">
			<img src="/img/books.jpg" alt="books">
		</a>
	</div>
</div>

<script type="text/javascript">
		
	window.onload = function() {
		$("#calendarForm").attr({action:'<c:url value="/mngtsys/itsm/aops/incidentmng/requst/iframeRequstRcept.do"/>' ,method:'post', target:'ifrmProgrs'}).submit();
	};

	$(function(){
		$("#tabScheduleToday").click(function(){
			alert(1);
		});	

		$("#tabScheduleWeek").click(function(){
			alert(2);
		});	
		
		$("#tabScheduleMonth").click(function(){
			alert(3);
		});	
	});
</script>