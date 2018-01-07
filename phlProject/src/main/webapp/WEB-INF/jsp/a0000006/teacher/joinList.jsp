<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	window.onload = function(){
		if($("#searchSelect").val()=="searchCategory"){
			$("#spanWord").val("");
			$("#spanWord").hide();
			$("#spanCategory").show();
		}else{
			$("#spanWord").show();
			$("#spanCategory").hide();
		}
	}

	function searchChange(){
		if($("#searchSelect").val()=="searchCategory"){
			$("#spanWord").val("");
			$("#spanWord").hide();
			$("#spanCategory").show();
		}else{
			$("#spanWord").show();
			$("#spanCategory").hide();
		}
	}
</script>

<!-- 
	참여 게시판 리스트
	등록 - 선생님 이상 ( G01030 )
	읽기 - 모두 
 -->
<c:set var="authYn" value="N"/>
<c:if test="${loginInfo.MEM_GBN_CD ge 'G01030'}">
	<c:set var="authYn" value="Y"/>
</c:if>

<div id="content">

	<h3 id="default_title">참여게시판</h3>
	
	<div id="default_list_form">
		<form id="joinList_Form">
			<input type="hidden" id="bsnsCode"    	name="bsnsCode"       	value="${sessionScope.bsnsCode}" >		<!-- 세션_업체코드 -->
			<input type="hidden" id="boardGbnCd" 	name="boardGbnCd"		value="${item.boardGbnCd}">				<!-- 게시판_구분 -->
			
			<!-- 검색조건 -->
			<div class="default_search">
				<select id="searchSelect" name="searchSelect" onchange="searchChange()">
					<option value="searchCategory" 	<c:if test="${item.searchSelect eq 'searchCategory'}">selected</c:if>>카테고리</option>
					<option value="searchSubject"  	<c:if test="${item.searchSelect eq 'searchSubject'}">selected</c:if>>제목</option>
					<option value="searchMemNm"  	<c:if test="${item.searchSelect eq 'searchMemNm'}">selected</c:if>>글쓴이</option>
				</select>
				<span id="spanCategory">
					<select id="selectCategory" name="selectCategory">
						<option value="">전체</option>	
						<c:forEach items="${teacherGbnList}" var="rows">
							<option value="${rows.CMMN_CODE}" <c:if test="${rows.CMMN_CODE eq item.selectCategory}">selected</c:if>>${rows.DETAIL_CODE_NM}</option>
						</c:forEach>
					</select>
				</span>
				<span id="spanWord">
					<input type="text" id="searchWord" name="searchWord" value="${item.searchWord}">
				</span>
				<input type="button" class="button" value="검색" onclick="fn_joinList();">
			</div>
			
			<div class="default_list">
				<table>
					<tr>
						<th>번호</th>
						<th>카테고리</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
					<c:if test="${empty joinList}">
						<tr>
							<td colspan="6">조회 된 내용이 없습니다.</td>
						</tr>
					</c:if>
					<c:if test="${not empty joinList}">
						<c:forEach items="${joinList}" var="row" varStatus="status">
							<tr>
								<td>${totalListCount - ( ( requestPageNumber -1 ) * countPerPage + status.index)}</td>
								<td>${row.BOARD_GBN_CD_NM}</td>
								<td><a href="javascript:fn_joinView('${row.BOARD_SN}')">${row.SUBJECT}</a></td>
								<td>${row.MEM_NM}</td>
								<td>${row.REG_DT}</td>
								<td>${row.HIT_COUNT}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				
				<!-- 권한 Y 일 경우 신규등록 -->
				<c:if test="${authYn eq 'Y'}">
					<div class="default_regbtn">
						<a href="javascript:fn_joinFormI();" id="joinFormI">신규등록</a>
					</div>
				</c:if>
				
				<div class="default_paging">
					<c:if test="${beginPageNum > 10}">
						<a href="<c:out value="/a0000006/teacher/joinList.do?requestPageNumber=${beginPageNum-1}"/>">◀</a>
					</c:if>
					
					<c:forEach var="requestPageNumber" begin="${beginPageNum}" end="${endPageNum}">
						<a href="<c:out value="/a0000006/teacher/joinList.do?requestPageNumber=${requestPageNumber}"/>">${requestPageNumber}</a>
					</c:forEach>
					
					<c:if test="${endPageNum < totalPageCount}">
						<a href="<c:out value="/a0000006/teacher/joinList.do?requestPageNumber=${endPageNum+1}"/>">▶</a>
					</c:if>
				</div>
				
			</div>
			
		</form>
		
	</div>
	
</div>
