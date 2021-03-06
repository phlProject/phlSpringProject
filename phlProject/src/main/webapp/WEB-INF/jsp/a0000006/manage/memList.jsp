<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	window.onload = function(){
		if($("#searchSelect").val()=="searchAuthor"){
			$("#spanWord").val("");
			$("#spanWord").hide();
			$("#spanAuthor").show();
			$("#spanRemark").hide();
		}else if($("#searchSelect").val()=="searchRemark"){
			$("#spanWord").val("");
			$("#spanWord").hide();
			$("#spanAuthor").hide();
			$("#spanRemark").show();
		}else{
			$("#spanWord").show();
			$("#spanAuthor").hide();
			$("#spanRemark").hide();
		}
	}
	
	function searchBtn(){
		ComSubmit('mem_Form','/a0000006/manage/memList.do');
	}
	
	function searchChange(){
		if($("#searchSelect").val()=="searchAuthor"){
			$("#spanWord").val("");
			$("#spanWord").hide();
			$("#spanAuthor").show();
			$("#spanRemark").hide();
		}else if($("#searchSelect").val()=="searchRemark"){
			$("#spanWord").val("");
			$("#spanWord").hide();
			$("#spanAuthor").hide();
			$("#spanRemark").show();
		}else{
			$("#spanWord").show();
			$("#spanAuthor").hide();
			$("#spanRemark").hide();
		}
	}
	
	/* 활성화/비활성화 수정 */
	function memActiveYn(remark, memSn){

		if(remark == "Y"){
			if(!confirm("* 해당하는 ID를 비활성화하시겠습니까?")){
				return;
			}
		}else if(remark == "N"){
			if(!confirm("* 해당하는 ID를 활성화하시겠습니까?")){
				return;
			}
		}
		
		var input1 = $("<input>").attr("type", "hidden").attr("name", "remark").attr("id", "remark").val(remark);
		var input2 = $("<input>").attr("type", "hidden").attr("name", "memSn").attr("id", "memSn").val(memSn);
		

		var postUrl = "/a0000006/manage/memActiveYn.do";
		$.post(postUrl, $("#mem_Form").append($(input1)).append($(input2)).serialize(), function(data){
			if(data.result == "success" ){
				alert("수정되었습니다.");
				ComSubmit('mem_Form','/a0000006/manage/memList.do');
			} else{
				alert("수정에 실패하였습니다. 관리자에게 문의해주세요.");
				return;
			}
		});
	}
	
	/* 권한 승인/해제 수정 */
	function memAuthorYn(remark, memSn){

		if(remark == "Y"){
			if(!confirm("* 해당하는 ID를 '선생님' 권한을 해제 하시겠습니까?")){
				return;
			}
		}else if(remark == "S"){
			if(!confirm("* 해당하는 ID를 '선생님' 권한을 승인 하시겠습니까?")){
				return;
			}
		}
		
		var input1 = $("<input>").attr("type", "hidden").attr("name", "remark").attr("id", "remark").val(remark);
		var input2 = $("<input>").attr("type", "hidden").attr("name", "memSn").attr("id", "memSn").val(memSn);
		

		var postUrl = "/a0000006/manage/memAuthorYn.do";
		$.post(postUrl, $("#mem_Form").append($(input1)).append($(input2)).serialize(), function(data){
			if(data.result == "success" ){
				alert("수정되었습니다.");
				ComSubmit('mem_Form','/a0000006/manage/memList.do');
			} else{
				alert("수정에 실패하였습니다. 관리자에게 문의해주세요.");
				return;
			}
		});
	}
</script>

<div id="content">
	
	<h3 id="default_title">회원관리</h3>
	
	<div id="default_list_form">
	
		<form id="mem_Form">	
			<input type="hidden" value="${sessionScope.bsnsCode}" 	id="bsnsCode" 	name="bsnsCode" >
			<input type="hidden" value="${sessionScope.sessionId}"  id="sessionId" 	name="sessionId" >
			
			<div class="default_search">
				<!-- 검색조건 -->
				<select id="searchSelect" name="searchSelect" onchange="searchChange()">
					<option value="searchId" 		<c:if test="${searchSelect eq 'searchId'}">selected</c:if>>아이디</option>
					<option value="searchNm" 		<c:if test="${searchSelect eq 'searchNm'}">selected</c:if>>이름</option>
					<option value="searchEmail"  	<c:if test="${searchSelect eq 'searchEmail'}">selected</c:if>>이메일</option>
					<option value="searchPhone"  	<c:if test="${searchSelect eq 'searchPhone'}">selected</c:if>>연락처</option>
					<option value="searchAuthor"  	<c:if test="${searchSelect eq 'searchAuthor'}">selected</c:if>>권한</option>
					<option value="searchRemark"  	<c:if test="${searchSelect eq 'searchRemark'}">selected</c:if>>계정상태</option>
				</select>
				<span id="spanWord">
					<input type="text" id="searchWord" name="searchWord" value="${searchWord}">
				</span>
				<span id="spanAuthor">
					<select id="searchAuthor" name="searchAuthor">
						<option value="G01010" <c:if test="${searchAuthor eq 'G01010'}">selected</c:if>>손님</option>
						<option value="G01020" <c:if test="${searchAuthor eq 'G01020'}">selected</c:if>>학생</option>
						<option value="G01030" <c:if test="${searchAuthor eq 'G01030'}">selected</c:if>>선생님</option>
						<option value="G01998" <c:if test="${searchAuthor eq 'G01998'}">selected</c:if>>홈페이지관리자</option>
					</select>
				</span>
				<span id="spanRemark">
					<select id="searchRemark" name="searchRemark">
						<option value="Y" <c:if test="${searchRemark eq 'Y'}">selected</c:if>>활성화</option>
						<option value="N" <c:if test="${searchRemark eq 'N'}">selected</c:if>>비활성화</option>
						<option value="S" <c:if test="${searchRemark eq 'S'}">selected</c:if>>승인대기</option>
					</select>
				</span>
				<input type="button" class="button" value="검색" onclick="searchBtn();">
			</div>
			
			<div class="default_list">	
				<table>			
					<tr>
						<th width="10%">아이디</th>
						<th width="10%">이름</th>
						<th width="25%">이메일</th>
						<th width="11%">연락처</th>
						<th width="8%">권한</th>
						<th width="12%">계정상태</th>
						<th colspan="3">비고</th>
					</tr>
					<c:if test="${empty memList}">
						<tr>
							<td colspan="9">조회 된 내용이 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach items="${memList}" var="row">
						<tr>
				              <td>${row.MEM_ID}</td>
				              <td>${row.MEM_NM}</td>
				              <td>${row.MEM_EMAIL}</td>
				              <td>${row.MEM_PHONE}</td>
				              <td>${row.MEM_GBN_CD_NM}</td>
				              <td>${row.REMARK_NM}</td>
				              <td width="10%">
				              	<c:if test="${row.MEM_GBN_CD != 'G01030' && row.USE_YN == 'N'}">
				              		<input type="button" value="활성화" 	onclick="memActiveYn('N','${row.MEM_SN}')" class="button">
				              	</c:if>
				              	<c:if test="${row.MEM_GBN_CD != 'G01030' && row.USE_YN == 'Y'}">
				              		<input type="button" value="비활성화" 	onclick="memActiveYn('Y','${row.MEM_SN}')" class="button">
				              	</c:if>
				              </td>
				              <td width="10%">
				              	<c:if test="${row.MEM_GBN_CD == 'G01030' && row.USE_YN == 'S'}">
				              		<input type="button" value="권한승인" onclick="memAuthorYn('S','${row.MEM_SN}')" class="button">
				              	</c:if>
				              	<c:if test="${row.MEM_GBN_CD == 'G01030' && row.USE_YN == 'Y'}">
				              		<input type="button" value="권한해제" onclick="memAuthorYn('Y','${row.MEM_SN}')" class="button">
				              	</c:if>
				              </td>
				        </tr>
					</c:forEach>
				</table>	
				<div class="default_paging">
					<c:if test="${beginPageNum > 10}">
						<a href="<c:out value="/a0000006/manage/memList.do?requestPageNumber=${beginPageNum-1}"/>">◀</a>
					</c:if>
					<c:if test="${endPageNum eq 0}">
						<a>${requestPageNumber}</a>
					</c:if>
					<c:forEach var="requestPageNumber" begin="${beginPageNum}" end="${endPageNum}">
						<a href="<c:out value="/a0000006/manage/memList.do?requestPageNumber=${requestPageNumber}"/>">${requestPageNumber}</a>
					</c:forEach>
					
					<c:if test="${endPageNum < totalPageCount}">
						<a href="<c:out value="/a0000006/manage/memList.do?requestPageNumber=${endPageNum+1}"/>">▶</a>
					</c:if>
				</div>
			</div>
		</form>
	</div>
</div>
