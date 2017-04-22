<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="content">

	<!-- 월간 일정 -->
	<div class="tblWrap mt15" id="monthDiv">
		<div class='btn-holder'>
			<a href="javascript:void(0)"><img src="/myFarm/images/btn_calendarPrev.png" alt="" id="btnPrev"/></a>
			<span id='currentDate'></span>
			<a href="javascript:void(0)"><img src="/myFarm/images/btn_calendarNext.png" alt="" id="btnNext"/></a>
		</div>
		
		<!-- 달력 -->
		<div id="calendar"></div>
	</div>

	<!-- 주간 일정 -->
	<div class="tblWrap mt15" id="weekDiv" style="display: none">
		<div id="mondayDate"></div>
		<table id="weekTable"></table>
	</div>

	<!-- 일일 일정 -->
	<div class="tblWrap mt15" id="dailyDiv" style="display: none">
		<div id="dailyDateDiv"></div>
		<table id="dailyTable"></table>
	</div>

</div>
</body>
</html>