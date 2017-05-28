<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교육나눔 꿈두레 - 간행물</title>
</head>
<body>
	<div id="content">
		<h3 class="cont-title">간행물</h3>
		<form id="publiList_Form">
			<input type="hidden" id="bsnsCode"    	name="bsnsCode"       	value="${sessionScope.bsns_code}" >	<!-- 세션_업체코드 -->
			<input type="hidden" id="boardGbnCd" 	name="boardGbnCd"		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
			<input type="hidden" id="sessionId"     name="sessionId"       	value="${sessionScope.session_id}">	<!-- 세션_아이디(등록자/수정자) -->
			
			<!-- 검색조건 -->
			<div class="search">
				<select id="searchSelect" name="searchSelect">
					<option value="searchSubject" <c:if test="${item.searchSelect eq 'searchSubject'}">selected</c:if>>제목</option>
					<option value="searchContent" <c:if test="${item.searchSelect eq 'searchContent'}">selected</c:if>>줄거리</option>
					<option value="searchSubCon"  <c:if test="${item.searchSelect eq 'searchSubCon'}">selected</c:if>>제목+줄거리</option>
				</select>
				<input type="text" id="searchWord" name="searchWord" value="${item.searchWord}">
				<input type="button" value="검색" onclick="fn_publiList();" class="button">
			</div>
			<br/>
			<div class="book-tab">
				<c:if test="${empty publiList}">
					<div class="bookList">
						<center><h4>조회 된 내용이 없습니다.</h4></center>
					</div>
				</c:if>
				<c:if test="${not empty publiList}">
				<div style="position: relative; float: left; width: 100%;">
					
					<c:forEach items="${publiList}" var="row" varStatus="status">
						<div style="position:relative; float:left; background-color: ; width: 200px; height: 220px;">
							<div style="position:relative; background-color: ; width: 200px; height: 150px;">
								<a href="javascript:fn_publiView('${row.BOARD_SN}')">
									이미지
								</a>
							</div>
							
							<div style="position:relative; background-color: ; width: 200px; height: 30px;">
								${row.SUBJECT}
							</div>
							<div style="position:relative; float:left; background-color: ; width: 100px; height: 40px;">
								다운로드
							</div>
							<div style="position:relative; float:left; background-color: ; width: 100px; height: 40px;">
								<a href="javascript:fn_publiView('${row.BOARD_SN}')">
									상세보기
								</a>
							</div>
						</div>
						<c:if test="${status.count%4 != 0}">
							<div style="position:relative; float:left; background-color: ; width: 10px; height: 220px;">
							 &nbsp;
							</div>
						</c:if>
					</c:forEach>	
				</div>
				</c:if>				
				<div class="bookForm">
					<a href="javascript:fn_publiFormI();" id="publiFormI">신규등록</a>
				</div>
				<div class="book_paging">
					<c:if test="${beginPageNum > 5}">
						<a href="<c:out value="/a0000006/board/publiList.do?requestPageNumber=${beginPageNum-1}"/>">◀</a>
					</c:if>
								
					<c:forEach var="requestPageNumber" begin="${beginPageNum}" end="${endPageNum}">
						<a href="<c:out value="/a0000006/board/publiList.do?requestPageNumber=${requestPageNumber}"/>">${requestPageNumber}</a>
					</c:forEach>
								
					<c:if test="${endPageNum < totalPageCount}">
						<a href="<c:out value="/a0000006/board/publiList.do?requestPageNumber=${endPageNum+1}"/>">▶</a>
					</c:if>	
				</div>
			</div>
		</form>		
	</div>
</body>
</html>