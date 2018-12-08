<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="/css/pkhl.css" />
<script src="/js/common.js"></script>



<form id="topMenu_Form" name="topMenu_Form">
	<input type="hidden" id="bsnsCode" 		name="bsnsCode" 	value="${sessionScope.bsnsCode}">
</form>

<div style="position: relative; float: left;" class="w80r h70r pr10r pl10r">
	<div style="position: relative; float: left; cursor: pointer; border: 1px solid black;" class="w20r h100r mr2d5r ml2d5r" 	onclick="javascript:TopMenuMove11('/a0000006/member/memMyPage.do')">
		1
	</div>
	
	<div style="position: relative; float: left; cursor: pointer; border: 1px solid black;"	class="w20r h100r mr2r ml2r"		onclick="javascript:fnLink('2');">
		2
	</div>

	<div style="position: relative; float: left; cursor: pointer; border: 1px solid black;"	class="w20r h100r mr2r ml2r"		onclick="javascript:fnLink('3');">
		3
	</div>

	<div style="position: relative; float: left; cursor: pointer; border: 1px solid black;"	class="w20r h100r mr2d5r ml2d5r"	onclick="javascript:fnLink('4');">
		4
	</div>

</div>