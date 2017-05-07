<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
  #pop{
	  width:300px; height:400px; background:#3d3d3d; color:#fff; 
	  position:absolute; top:10px; left:100px; text-align:center; 
	  border:2px solid #000;
  }

</style>

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
		ComSubmit('mem_Form','/a0000006/mng/memList.do');
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
	
	function memManager(remark, bsns_code, mem_sn){
		
		if(remark == "S"){
			alert("레이어 예정");
		}else{
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
			var input2 = $("<input>").attr("type", "hidden").attr("name", "bsns_code").attr("id", "bsns_code").val(bsns_code);
			var input3 = $("<input>").attr("type", "hidden").attr("name", "mem_sn").attr("id", "mem_sn").val(mem_sn);
			
			var postUrl = "/a0000006/mng/memUpdateActive.do";
			$.post(postUrl, $("#mem_Form").append($(input1)).append($(input2)).append($(input3)).serialize(), function(data){
				if(data.result == "success" ){
					alert("수정되었습니다.");
					ComSubmit('mem_Form','/a0000006/mng/memList.do');
				} else{
					alert("수정에 실패하였습니다. 관리자에게 문의해주세요.");
					return;
				}
			});
			
		}
	}
</script>
</head>
<body>
	<div id="content">
		<form id="mem_Form">
			<table border="1">
			<tr>
				<!-- 검색조건 -->
				<td colspan="9" style="text-align: right">
					<select id="searchSelect" name="searchSelect" onchange="searchChange()">
						<option value="searchId" 		<c:if test="${searchSelect eq 'searchId'}">selected</c:if>>아이디</option>
						<option value="searchNm" 		<c:if test="${searchSelect eq 'searchNm'}">selected</c:if>>이름</option>
						<option value="searchNick" 		<c:if test="${searchSelect eq 'searchNick'}">selected</c:if>>닉네임</option>
						<option value="searchNmNick"  	<c:if test="${searchSelect eq 'searchNmNick'}">selected</c:if>>이름+닉네임</option>
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
							<option value="G01001" <c:if test="${searchAuthor eq 'G01001'}">selected</c:if>>학생</option>
							<option value="G01002" <c:if test="${searchAuthor eq 'G01002'}">selected</c:if>>선생님</option>
							<option value="G01003" <c:if test="${searchAuthor eq 'G01003'}">selected</c:if>>기타</option>
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
					<input type="button" value="검색" onclick="searchBtn();">
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>닉네임</td>
				<td>이메일</td>
				<td>연락처</td>
				<td>권한</td>
				<td>계정상태</td>
				<td colspan="3">비고</td>
			</tr>
			<c:forEach items="${memList}" var="row">
				<tr>
		              <td>${row.MEM_ID}</td>
		              <td>${row.MEM_NM}</td>
		              <td>${row.MEM_NICKNM}</td>
		              <td>${row.MEM_EMAIL}</td>
		              <td>${row.MEM_PHONE}</td>
		              <td>${row.MEM_GRADE_NM}</td>
		              <td>${row.REMARK_NM}</td>
		              <td width="70">
		              	<c:if test="${row.USE_YN == 'N'}">
		              		<input type="button" value="활성화처리" onclick="memManager('N','${row.BSNS_CODE}','${row.MEM_SN}')">
		              	</c:if>
		              	<c:if test="${row.USE_YN == 'Y'}">
		              		<input type="button" value="비활성화처리" onclick="memManager('Y','${row.BSNS_CODE}','${row.MEM_SN}')">
		              	</c:if>
		              </td>
		              <td width="70">
		              	<c:if test="${row.USE_YN == 'S'}">
		              		<input type="button" value="권한승인" onclick="memManager('S','${row.BSNS_CODE}','${row.MEM_SN}')">
		              	</c:if>
		              </td>
		        </tr>
			</c:forEach>
			<tr>
				<td colspan="9">
					<c:if test="${beginPageNum > 10}">
						<a href="<c:out value="/a0000006/mng/memList.do?requestPageNumber=${beginPageNum-1}"/>">◀</a>
					</c:if>
					
					<c:forEach var="requestPageNumber" begin="${beginPageNum}" end="${endPageNum}">
						<a href="<c:out value="/a0000006/mng/memList.do?requestPageNumber=${requestPageNumber}"/>">${requestPageNumber}</a>
					</c:forEach>
					
					<c:if test="${endPageNum < totalPageCount}">
						<a href="<c:out value="/a0000006/mng/memList.do?requestPageNumber=${endPageNum+1}"/>">▶</a>
					</c:if>
				</td>
			</tr>
			</table>
		</form>
	</div>
</body>
</html>