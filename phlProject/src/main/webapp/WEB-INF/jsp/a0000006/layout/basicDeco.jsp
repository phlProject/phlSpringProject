<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="deco" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>

<page:applyDecorator id="topDefault" name="topDefault"/>
<deco:head />

<body oncontextmenu="return false">
	
	<page:applyDecorator id="header" name="header"/>
	
	<div id="container">
		<deco:body/>
	</div>
	
	<page:applyDecorator id="footer" name="footer"/>
	
</body>
