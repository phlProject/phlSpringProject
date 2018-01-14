<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
				
				<c:if test="${not empty dataList}">
					<div class="image8_data_form">
						<c:forEach items="${dataList}" var="row" varStatus="status">
							<div class="image8_data_list">
								<div class="image8_data_img">
									<a href="javascript:fn_dataView('${row.BOARD_SN}')">
										<c:set var="fnExt" value="${fn:split(row.FL_NM,'.')}"/>
										<c:choose>
											<c:when test="${fnExt[1] eq 'xls' || fnExt[1] eq 'xlsx'}"><img src="/img/docu/xls.png"></c:when>
											<c:when test="${fnExt[1] eq 'ppt' || fnExt[1] eq 'pptx'}"><img src="/img/docu/ppt.png"></c:when>
											<c:when test="${fnExt[1] eq 'doc' || fnExt[1] eq 'docx'}"><img src="/img/docu/doc.png"></c:when>
											<c:when test="${fnExt[1] eq 'pdf'}"><img src="/img/docu/pdf.png"></c:when>
											<c:when test="${fnExt[1] eq 'hwp'}"><img src="/img/docu/hwp.png"></c:when>
										</c:choose>
									</a>
								</div>
								<div class="image8_data_title">
									${row.SUBJECT}
								</div>
								<div class="image8_data_down">
									<a href="javascript:fn_boardFlDown('${row.BSNS_CODE}','${row.BOARD_SN}','${row.BOARD_FL_SN}');">Download</a>
								</div>
								<div class="image8_data_view">
									<a href="javascript:fn_dataView('${row.BOARD_SN}')">View</a>
								</div>
							</div>
							<c:if test="${status.count%4 != 0}">
								<div class="image8_data_blank"></div>
							</c:if>
						</c:forEach>
					</div>
				</c:if>
			</div>
			
			<div class="default_paging">${requestPageNumber}
				<c:if test="${beginPageNum > 5}">
					<a href="<c:out value="/a0000006/board/dataList.do?requestPageNumber=${beginPageNum-1}"/>">◀</a>
				</c:if>
						
				<c:if test="${endPageNum eq 0}">
					<a>1</a>
				</c:if>	
				<c:forEach var="requestPageNumber" begin="${beginPageNum}" end="${endPageNum}">
					<a href="<c:out value="/a0000006/board/dataList.do?requestPageNumber=${requestPageNumber}"/>">${requestPageNumber}</a>
				</c:forEach>
							
				<c:if test="${endPageNum < totalPageCount}">
					<a href="<c:out value="/a0000006/board/dataList.do?requestPageNumber=${endPageNum+1}"/>">▶</a>
				</c:if>	
			</div>	
			
			<!-- 검색조건 -->
			<div style="position:relative; float: left; width:100%; vertical-align: middle;">
				<div class="default_search" style="float: none; margin-top: 20px;">
					<select id="searchSelect" name="searchSelect">
						<option value="searchSubject" <c:if test="${item.searchSelect eq 'searchSubject'}">selected</c:if>>제목</option>
						<option value="searchContent" <c:if test="${item.searchSelect eq 'searchContent'}">selected</c:if>>내용</option>
						<option value="searchSubCon"  <c:if test="${item.searchSelect eq 'searchSubCon'}">selected</c:if>>제목+내용</option>
					</select>
					<input type="text" id="searchWord" name="searchWord" value="${item.searchWord}">
					<input type="button" value="검색" onclick="fn_dataList();" class="button">
				</div>
				
				<!-- 권한 Y 일 경우 신규등록 -->
				<c:if test="${authYn eq 'Y'}">
					<div class="default_regbtn">
						<a href="javascript:fn_dataFormI();" id="dataFormI">신규등록</a>
					</div>
				</c:if>
			</div>
		</form>	
	</div>
</div>
