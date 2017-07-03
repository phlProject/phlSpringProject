<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="deco" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교육나눔 꿈두레</title>
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/jquery-ui.js"></script>
<script src="/js/common.js"></script>
<script src="/js/a0000006/member.js"></script>
<script src="/js/phl/phl_common.js"></script>

<link rel="stylesheet" type="text/css" href="/css/style.css" />
<!-- <link rel="stylesheet" type="text/css" href="/css/jquery-ui.css" /> -->
<deco:head />
</head>
<body>
	<page:applyDecorator id="header" name="header"/>
	<div id="container">
		<%-- <page:applyDecorator id="header" name="header"/> --%>	
			<deco:body/>
	</div>
		<page:applyDecorator id="footer" name="footer"/>
	
</body>
</html>
