<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
	네트워크 게시판 리스트
	등록 - 선생님 이상 ( G01030 )
	읽기 - 선생님 이상 ( G01030 )
 -->
<c:set var="authYn" value="N"/>
<c:if test="${loginInfo.MEM_GBN_CD ge 'G01030'}">
	<c:set var="authYn" value="Y"/>
</c:if>

<div id="content">

	<h3 id="default_title">${item.boardGbnCdNm} 게시판</h3>

	<div id="default_list_form">
	
		<form id="networkBoardList_Form">
			<input type="hidden" id="bsnsCode"    	name="bsnsCode"       	value="${sessionScope.bsnsCode}" >	<!-- 세션_업체코드 -->
			<input type="hidden" id="sessionId"    	name="sessionId"       	value="${sessionScope.sessionId}" >	<!-- 세션_ID -->
			<input type="hidden" id="boardGbnCd" 	name="boardGbnCd"		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
			<input type="hidden" id="boardGbnCdNm" 	name="boardGbnCdNm"		value="${item.boardGbnCdNm}">		<!-- 게시판_구분_명 -->
			
			<!-- 검색조건 -->
			<div class="default_search">
				<select id="searchSelect" name="searchSelect">
					<option value="searchSubject" 	 <c:if test="${item.searchSelect eq 'searchSubject'}">selected</c:if>>제목</option>
					<option value="searchContent" 	 <c:if test="${item.searchSelect eq 'searchContent'}">selected</c:if>>내용</option>
					<option value="searchSubCon"  	 <c:if test="${item.searchSelect eq 'searchSubCon'}">selected</c:if>>제목+내용</option>
				</select>
				<input type="text" id="searchWord" name="searchWord" value="${item.searchWord}">
				<input type="button" class="button" value="검색" onclick="fn_networkBoardList();">
			</div>
			<br/>
			
			<div class="default_list">
				<table>
					<tr>
						<th width="7%">번호</th>
						<th width="55%">제목</th>
						<th width="15%">글쓴이</th>
						<th width="14%">날짜</th>
						<th width="9%">조회수</th>
					</tr>
					<c:if test="${empty networkBoardList}">
						<tr>
							<td colspan="6">조회 된 내용이 없습니다.</td>
						</tr>
					</c:if>
					<c:if test="${not empty networkBoardList}">
						<c:forEach items="${networkBoardList}" var="row" varStatus="status">
							<tr>
								<td>${totalListCount - ( ( requestPageNumber -1 ) * countPerPage + status.index)}</td>
								<td><a href="javascript:fn_networkBoardView('${row.BOARD_SN}')">${row.SUBJECT}</a></td>
								<td>${row.MEM_NM}</td>
								<td>${row.REG_DT}</td>
								<td>${row.HIT_COUNT}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				
				<div class="default_paging">
					<c:if test="${beginPageNum > 10}">
						<a href="<c:out value="/a0000006/network/networkBoardList.do?boardGbnCd=${item.boardGbnCd}&requestPageNumber=${beginPageNum-1}"/>">◀</a>
					</c:if>

					<c:if test="${endPageNum eq 0}">
						<a>${requestPageNumber}</a>
					</c:if>
					<c:forEach var="requestPageNumber" begin="${beginPageNum}" end="${endPageNum}">
						<a href="<c:out value="/a0000006/network/networkBoardList.do?boardGbnCd=${item.boardGbnCd}&requestPageNumber=${requestPageNumber}"/>">${requestPageNumber}</a>
					</c:forEach>
					
					<c:if test="${endPageNum < totalPageCount}">
						<a href="<c:out value="/a0000006/network/networkBoardList.do?boardGbnCd=${item.boardGbnCd}&requestPageNumber=${endPageNum+1}"/>">▶</a>
					</c:if>
				</div>
				
				<!-- 권한 Y 일 경우 신규등록 -->
				<c:if test="${authYn eq 'Y'}">
					<div class="default_regbtn">
						<a href="javascript:fn_networkBoardFormI();" id="joinFormI">신규등록</a>
					</div>
				</c:if>
			</div>
		</form>
	</div>
</div>
