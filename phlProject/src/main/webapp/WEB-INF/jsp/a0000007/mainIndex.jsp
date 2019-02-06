<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" type="text/css" href="/css/pkhl.css" />


<form id="topMenu_Form" name="topMenu_Form">
	<input type="hidden" id="bsnsCode" 		name="bsnsCode" 	value="${sessionScope.bsnsCode}">
</form>
 <div style="position: relative; float: left;" class="w80r h70r pr10r pl10r" >
	<div style="position: relative; float: left; cursor: pointer; border: 1px solid black;" class="w20r h100r mr2d5r ml2d5r" 	onclick="javascript:TopMenuMove('/a0000007/intro/introduce.do')">
		소개
	</div>
	
	<div style="position: relative; float: left; cursor: pointer; border: 1px solid black;"	class="w20r h100r mr2r ml2r"		onclick="javascript:TopMenuMove('/a0000007/program/programList.do')">
		활동프로그램
	</div>

	<div style="position: relative; float: left; cursor: pointer; border: 1px solid black;"	class="w20r h100r mr2r ml2r"		onclick="javascript:TopMenuMove('/a0000007/schedule/scheduleList.do')">
		일정
	</div>

	<div style="position: relative; float: left; cursor: pointer; border: 1px solid black;"	class="w20r h100r mr2d5r ml2d5r"	onclick="javascript:TopMenuMove('/a0000007/counsel/counselList.do')">
		상담신청
	</div>

</div>