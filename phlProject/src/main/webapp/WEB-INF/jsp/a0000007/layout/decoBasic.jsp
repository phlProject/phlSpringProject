<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="deco" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>

<page:applyDecorator id="A0000007_Require" name="A0000007_Require"/>
<deco:head />

<body oncontextmenu="return false">
	
	<page:applyDecorator id="A0000007_Header" name="A0000007_Header"/>
	
	<div id="container">
		<deco:body/>
	</div>
	
	<page:applyDecorator id="A0000007_Footer" name="A0000007_Footer"/>
	
</body>