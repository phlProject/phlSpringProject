<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
	자료 게시판 리스트
	등록 - 선생님 이상 ( G01030 )
	읽기 - 모두 
 -->
<c:set var="authYn" value="N"/>
<c:if test="${loginInfo.MEM_GBN_CD ge 'G01030'}">
	<c:set var="authYn" value="Y"/>
</c:if>

<div id="content">

	<h3 id="default_title">${item.boardGbnCdNm}</h3>
	
	<div id="defalut_image8_list_form">
	
		<form id="dataList_Form">
			<input type="hidden" id="bsnsCode"    	name="bsnsCode"       	value="${sessionScope.bsnsCode}" >	<!-- 세션_업체코드 -->
			<input type="hidden" id="boardGbnCd" 	name="boardGbnCd"		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
			<input type="hidden" id="boardGbnCdNm" 	name="boardGbnCdNm"		value="${item.boardGbnCdNm}">		<!-- 게시판_구분_명 -->
			
			<div class="defalut_image8_list">
				<c:if test="${empty dataList}">
					<center><h4>조회 된 내용이 없습니다.</h4></center>
				</c:if>
			</div>
			<%-- <div class="book-tab">
			
				<c:if test="${empty dataList}">
					<div class="bookList">
						<center><h4>조회 된 내용이 없습니다.</h4></center>
					</div>
				</c:if>
				
				<c:if test="${not empty dataList}">
<<<<<<< HEAD
					<div class="public">
						
						<c:forEach items="${dataList}" var="row" varStatus="status">
							<div class="public-list">
								<div class="public-img">
									<a href="javascript:fn_dataView('${row.BOARD_SN}')">Image</a>
								</div>
								
								<div class="public-title">
									${row.SUBJECT}
								</div>
								
								<div class="public-down">
									<a href="javascript:fn_boardFlDown('${row.BSNS_CODE}','${row.BOARD_SN}','${row.BOARD_FL_SN}');">Download</a>
								</div>
								<div class="public-view">
									<a href="javascript:fn_dataView('${row.BOARD_SN}')">View</a>
								</div>
=======
				<div class="public">
					
					<c:forEach items="${dataList}" var="row" varStatus="status">
						<div class="public-list">
							<div class="public-img">
								<a href="javascript:fn_dataView('${row.BOARD_SN}')">
								<img src="/img/word.png" alt="word"> 
								</a>
>>>>>>> branch 'master' of https://github.com/phlProject/phlSpringProject.git
							</div>
							
							<c:if test="${status.count%4 != 0}">
								<div style="position:relative; float:left; background-color: ; width: 10px; height: 220px;">
								 &nbsp;
								</div>
							</c:if>
							
						</c:forEach>	
					</div>
				</c:if>		
				
				<!-- 권한 Y 일 경우 신규등록 -->
				<c:if test="${authYn eq 'Y'}">			
					<div class="bookForm">
						<a href="javascript:fn_dataFormI();" id="dataFormI">신규등록</a>
					</div>
				</c:if>
				
				<div class="book_paging">${requestPageNumber}
					<c:if test="${beginPageNum > 5}">
						<a href="<c:out value="/a0000006/board/dataList.do?requestPageNumber=${beginPageNum-1}"/>">◀</a>
					</c:if>
								
					<c:forEach var="requestPageNumber" begin="${beginPageNum}" end="${endPageNum}">
						<a href="<c:out value="/a0000006/board/dataList.do?requestPageNumber=${requestPageNumber}"/>">${requestPageNumber}</a>
					</c:forEach>
								
					<c:if test="${endPageNum < totalPageCount}">
						<a href="<c:out value="/a0000006/board/dataList.do?requestPageNumber=${endPageNum+1}"/>">▶</a>
					</c:if>	
				</div>
			</div> --%>
		</form>	
	</div>	
</div>
