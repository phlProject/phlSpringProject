<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교육나눔 꿈두레 - 기관 탐방</title>
</head>
<body>
	<div id="content">
		<h3 class="cont-title">기관 탐방 신청</h3>
		<form id="visitList_Form">
			<input type="hidden" id="bsnsCode"    	name="bsnsCode"       	value="${sessionScope.bsns_code}" >	<!-- 세션_업체코드 -->
			<input type="hidden" id="boardGbnCd" 	name="boardGbnCd"		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
			
			<!-- 검색조건 -->
			<div class="search">
				<select id="searchSelect" name="searchSelect">
					<option value="searchSubject" <c:if test="${item.searchSelect eq 'searchSubject'}">selected</c:if>>제목</option>
					<option value="searchContent" <c:if test="${item.searchSelect eq 'searchContent'}">selected</c:if>>내용</option>
					<option value="searchSubCon"  <c:if test="${item.searchSelect eq 'searchSubCon'}">selected</c:if>>제목+내용</option>
				</select>
				<input type="text" id="searchWord" name="searchWord" value="${item.searchWord}">
				<input type="button" value="검색" onclick="fn_visitList();" class="button">
			</div>
			<br/>
			<div class="book-tab">
				<c:if test="${empty visitList}">
					<div class="bookList">
						<center><h4>조회 된 내용이 없습니다.</h4></center>
					</div>
				</c:if>
				<c:if test="${not empty visitList}">
					<table>
						<tr>
							<td> 번호 </td>
							<td> 제목 </td>
							<td> 작성자 </td>
							<td> 조회수 </td>
						</tr>
						
						<c:forEach items="${visitList}" var="row" varStatus="status">
						<tr>
							<td>
								${fn:replace(row.ROWNUM,".0","")}
							</td>
							<td>
								${row.SUBJECT}
							</td>
							<td>
								${row.REG_ID}
							</td>
							<td>
								${row.HIT_COUNT}
							</td>
						</tr>
						</c:forEach>
						
					</table>
				<br/><br/><br/>	
				</c:if>
				
				<div class="bookForm">
					<a href="javascript:fn_visitFormI();" id="visitFormI">신규등록</a>
				</div>
				
				<div class="book_paging">
					<c:if test="${beginPageNum > 5}">
						<a href="<c:out value="/a0000006/apply/visitList.do?requestPageNumber=${beginPageNum-1}"/>">◀</a>
					</c:if>
								
					<c:forEach var="requestPageNumber" begin="${beginPageNum}" end="${endPageNum}">
						<a href="<c:out value="/a0000006/apply/visitList.do?requestPageNumber=${requestPageNumber}"/>">${requestPageNumber}</a>
					</c:forEach>
								
					<c:if test="${endPageNum < totalPageCount}">
						<a href="<c:out value="/a0000006/apply/visitList.do?requestPageNumber=${endPageNum+1}"/>">▶</a>
					</c:if>	
				</div>
			</div>
			
		</form>
	</div>
</body>
</html>