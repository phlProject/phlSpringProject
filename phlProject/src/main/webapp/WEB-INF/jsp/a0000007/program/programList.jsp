<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="/js/a0000007/program.js"></script>

<!-- 
	활동 프로그램 게시판
	등록 - 관리자 ( G01999 )
	읽기 - 모두 
 -->
<c:set var="authYn" value="N"/>
<c:if test="${loginInfo.MEM_GBN_CD ge 'G01999' && !empty sessionScope.sessionId}">
	<c:set var="authYn" value="Y"/>
</c:if>

<div id="content">

	<h3 id="default_title">활동 프로그램</h3>
	
	<form id="boardList_Form">
		<input type="hidden" id="bsnsCode"    	name="bsnsCode"       	value="${sessionScope.bsnsCode}" >	<!-- 세션_업체코드 	-->
		<input type="hidden" id="boardGbnCd" 	name="boardGbnCd"		value="${item.boardGbnCd}">			<!-- 게시판_구분 	-->
			
		<!-- 검색조건 -->
		<div class="default_search_top">
			<select id="searchSelect" name="searchSelect">
				<option value="searchSubject" 	 <c:if test="${item.searchSelect eq 'searchSubject'}">selected</c:if>>제목</option>
				<option value="searchContent" 	 <c:if test="${item.searchSelect eq 'searchContent'}">selected</c:if>>내용</option>
				<option value="searchSubCon"  	 <c:if test="${item.searchSelect eq 'searchSubCon'}">selected</c:if>>제목+내용</option>
			</select>
			<input type="text" id="searchWord" name="searchWord" value="${item.searchWord}">
			<input type="button" value="검색" onclick="javascript:fn_programList();" class="button">
		</div>
		<br> <!-- 확인부탁 -->
		<div id="default_image5_list_form">
				<c:if test="${empty boardList}">
					<div class="default_image5_list">
						<h4 style="text-align: center;">조회 된 내용이 없습니다.</h4>
					</div>
				</c:if>
				
				<c:if test="${!empty boardList}">
					<c:forEach items="${boardList}" var="row">
						<div class="default_image5_list">
							<div class="default_image5_list_left">
								<div class="imgBox">
									<img src="${row.FL_PATH}/${row.FL_NM}">
								</div>
								<div class="default_image5_list_like">
									<div class="count"><a href="javascript:fn_programView('${row.BOARD_SN}');">view</a></div>
									<div class="like">♥&nbsp;&nbsp;${row.LIKE_COUNT}</div>
								</div>
							</div>
							<div class="default_image5_list_right">
								<a href="javascript:fn_programView('${row.BOARD_SN}');">${row.SUBJECT} </a>
								<hr color="#e2d318" size="0.3">	
								<p class="default_image5_detail"></p>				
								<p>${row.CONTENT}</p>
							</div>
						</div>
					</c:forEach>
				</c:if>
				
				<div class="default_paging">
					<c:if test="${beginPageNum > 5}">
						<a href="<c:out value="/a0000007/program/programList.do?requestPageNumber=${beginPageNum-1}"/>">◀</a>
					</c:if>
						
					<c:if test="${endPageNum eq 0}">
						<a>1</a>
					</c:if>		
					<c:forEach var="requestPageNumber" begin="${beginPageNum}" end="${endPageNum}">
						<a href="<c:out value="/a0000007/program/programList.do?requestPageNumber=${requestPageNumber}"/>">${requestPageNumber}</a>
					</c:forEach>
								
					<c:if test="${endPageNum < totalPageCount}">
						<a href="<c:out value="/a0000007/program/programList.do?requestPageNumber=${endPageNum+1}"/>">▶</a>
					</c:if>	
				</div>	
				
				<div style="position:relative; float: left; width:100%; vertical-align: middle;">
					<!-- 권한 Y 일 경우 신규등록 -->
					<c:if test="${authYn eq 'Y'}">			
						<div class="bookForm">
							<a href="javascript:fn_programFormI();" id="programFormI">신규등록</a>
						</div>
					</c:if>
				</div>
			
		</div>
	</form>
</div>