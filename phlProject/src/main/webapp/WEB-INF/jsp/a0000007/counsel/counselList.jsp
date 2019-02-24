<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="/js/a0000007/counsel.js"></script>


<!-- 
	상담 신청 ( 비회원 게시판 )
	등록 - 모두
	읽기 - 글쓴이(비밀번호), 관리자(G01999)
 -->
<c:set var="authYn" value="N"/>
<c:if test="${loginInfo.MEM_GBN_CD ge 'G01999' && !empty sessionScope.sessionId}">
	<c:set var="authYn" value="Y"/>
</c:if>

<div id="content">
	
	<h3 id="default_title">상담 신청</h3>
	<hr width="920px" color="#efefef">
	
	<div id="default_list_form">
		<form id="boardList_Form">
			<input type="hidden" id="bsnsCode"    	name="bsnsCode"       	value="${sessionScope.bsnsCode}" >	<!-- 세션_업체코드 	-->
			<input type="hidden" id="boardGbnCd" 	name="boardGbnCd"		value="${item.boardGbnCd}">			<!-- 게시판_구분 	-->
			
			<!-- 검색조건 -->
			<div class="default_search">
				<select id="searchSelect" name="searchSelect">
					<option value="searchSubject" 	 <c:if test="${item.searchSelect eq 'searchSubject'}">selected</c:if>>제목</option>
					<option value="searchContent" 	 <c:if test="${item.searchSelect eq 'searchContent'}">selected</c:if>>내용</option>
					<option value="searchSubCon"  	 <c:if test="${item.searchSelect eq 'searchSubCon'}">selected</c:if>>제목+내용</option>
				</select>
				<input type="text" id="searchWord" name="searchWord" value="${item.searchWord}">
				<input type="button" class="button" value="검색" onclick="javascript:fn_counselList();">
			</div>
			
			<div class="default_list">
				<table>
					<tr>
						<th width="35px">번호</th>
						<th width="*">제목</th>
						<th width="80px">작성자</th>
						<th width="80px">날짜</th>
						<th width="50px">조회수</th>
					</tr>
					
					<c:if test="${empty boardList}">
						<tr>
							<td colspan="6">조회 된 내용이 없습니다.</td>
						</tr>
					</c:if>

					<c:if test="${not empty boardList}">
						<c:forEach items="${boardList}" var="row" varStatus="status">
							<tr>
								<td>${boardListCount - ( ( requestPageNumber -1 ) * countPerPage + status.index)}</td>
								<c:if test="${authYn eq 'Y'}">
									<td><a href="javascript:fn_counselView('${row.BOARD_SN}')">${row.SUBJECT}</a></td>
								</c:if>
								<c:if test="${authYn eq 'N'}">
									<td><a href="javascript:fn_counselPwdCheck('${row.BOARD_SN}')">${row.SUBJECT}</a></td>
								</c:if>
								<td>${row.REG_NM}</td>
								<td>${row.REG_DT}</td>
								<td>${row.HIT_COUNT}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				
				<div class="default_paging">
					<c:if test="${beginPageNum > 10}">
						<a href="<c:out value="/a0000007/counsel/counselList.do?requestPageNumber=${beginPageNum-1}"/>">◀</a>
					</c:if>
					
					<c:if test="${endPageNum eq 0}">
						<a>${requestPageNumber}</a>
					</c:if>
					<c:forEach var="requestPageNumber" begin="${beginPageNum}" end="${endPageNum}">
						<a href="<c:out value="/a0000007/counsel/counselList.do?requestPageNumber=${requestPageNumber}"/>">${requestPageNumber}</a>
					</c:forEach>
					
					<c:if test="${endPageNum < totalPageCount}">
						<a href="<c:out value="/a0000007/counsel/counselList.do?requestPageNumber=${endPageNum+1}"/>">▶</a>
					</c:if>
				</div>
				
				<div class="default_regbtn">
					<a href="javascript:fn_counselFormI();" id="counselFormI">신규등록</a>
				</div>
			</div>
		</form>
	</div>
	
</div>