<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="deco" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>

<page:applyDecorator id="topLeft" name="topLeft"/>
<deco:head />

<body>

	<page:applyDecorator id="header" name="header"/>
	
	<div id="bg">
		<img src="/img/back-img.png" width="100%">
	</div>
	
	<div id="container">	
		<page:applyDecorator id="left" name="left"/>
		<div id="left_content">
			<deco:body/>
		</div>
	</div>
	
	<page:applyDecorator id="footer" name="footer"/>
	
</body>
