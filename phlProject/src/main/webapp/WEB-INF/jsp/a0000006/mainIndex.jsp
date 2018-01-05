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
		<form id="scheduleForm" name="scheduleForm" method="post" action="#;">
			<input type="hidden" name="searchPeriod" id="searchPeriod" value="today">
			<iframe id="ifrmSchedule" name="ifrmSchedule" frameborder="1" hspace="0" vspace="0" width="100%" height="100" scrolling="auto"></iframe>
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
		$("#scheduleForm").attr({action:"/a0000006/open/iframePeriodList.do" ,method:'post', target:'ifrmSchedule'}).submit();
	};

	// 일정기간 탭 클릭 
	$(function(){
		$("#tabScheduleToday").click(function(){
			fn_scheduleChange("today");
		});	

		$("#tabScheduleWeek").click(function(){
			fn_scheduleChange("week");
		});	
		
		$("#tabScheduleMonth").click(function(){
			fn_scheduleChange("month");
		});	
	});
	
	// 탭 전환 
	function fn_scheduleChange(strPeriod){
		$("#searchPeriod").val(strPeriod);
		$("#scheduleForm").attr({action:"/a0000006/open/iframePeriodList.do" ,method:'post', target:'ifrmSchedule'}).submit();
	}
</script>