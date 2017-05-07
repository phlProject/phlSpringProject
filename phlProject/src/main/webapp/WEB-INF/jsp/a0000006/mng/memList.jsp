<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){		
		$("#mainIndex").on("click", function(e){
			e.preventDefault();
			fn_mainIndex();
		});
	});

	function fn_mainIndex(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/a0000006/mainIndex.do'/>");
		comSubmit.submit();
	}
</script>
<body>
<div id="content">
	<table border="1">
		<c:forEach items="${memList}" var="row">
			<tr>
               <td>${row.BSNS_CODE }</td>
               <td>${row.MEM_ID }</td>
               <td>${row.MEM_PW }</td>
               <td>${row.MEM_NM }</td>
               <td>${row.MEM_EMAIL }</td>
               <td>${row.MEM_NICKNM }</td>
               <td>${row.MEM_GRADE }</td>
               <td>${row.MEM_PHONE }</td>
               <td>${row.USE_YN }</td>
            </tr>
		</c:forEach>	
	</table>
	<a href="#this" id="mainIndex">메인</a>
</div>
</body>
</html>