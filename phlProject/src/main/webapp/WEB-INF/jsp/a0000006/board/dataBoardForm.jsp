<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교육나눔 꿈두레</title>

	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="/resources/editor/js/HuskyEZCreator.js"></script>
	<script>
    $(function(){
		
    	/* Smart Editor 사용 */
    	var editor_object = [];
        nhn.husky.EZCreator.createInIFrame({
            oAppRef: editor_object,
            elPlaceHolder: "editor",
            sSkinURI: "/resources/editor/SmartEditor2Skin.html",
            htParams : {
                bUseToolbar : true,   		// 툴바 사용 여부 (true:사용/ false:사용하지 않음)         
                bUseVerticalResizer : true,	// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)    
                bUseModeChanger : true,		// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
            }
        });
         
        //저장버튼 클릭이벤트
        $("#fn_saveData").click(function(){
            
        	/* if(!pulbiValidation()){
        		return;
        	} */
        	
        	var msg = "";
        	var postUrl = "";
        	
        	if($("#newYn").val() == "Y"){
        		msg = "저장하시겠습니까?";
        		postUrl = "/a0000006/board/insertData.do";
        	}else if($("#newYn").val() == "N"){
        		msg = "수정하시겠습니까?";
        		postUrl = "/a0000006/board/updateData.do";
        	}
        	
        	if(!confirm(msg)){
        		return;
        	}
        	
        	// 파일업로드 ( if문으로 에러처리 잡기 )
        	fn_uploadFile();
        	
            // id가 smarteditor인 textarea에 에디터에서 대입
            editor_object.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
       		
        	$.post(postUrl, $("#editor_Form").serialize(), function(data){
        		if(data.result == "success" && data.resultFlYn == "success"){
        			alert("등록되었습니다.");
        			if($("#newYn").val() == "Y") $("#boardSn").val(data.boardSn);
        			ComSubmit('dataList_Form','/a0000006/board/dataView.do');
        		} else{
        			alert("실패하였습니다. 관리자에게 문의해주세요.");
        			ComSubmit('dataList_Form','/a0000006/board/dataList.do');
        			return;
        		}
        	});
        });
    }); 
	</script>
</head>

	<body>
		<form id="dataList_Form">
			<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}">		<!-- 검색구분 -->
			<input type="hidden" id="searchWord" 	name="searchWord" 		value="${item.searchWord}">			<!-- 검색어 -->
			<input type="hidden" id="bsnsCode"      name="bsnsCode"         value="${sessionScope.bsns_code}">	<!-- 세션_업체코드 -->
			<input type="hidden" id="boardGbnCd" 	name="boardGbnCd"		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
			<input type="hidden" id="boardGbnCdNm" 	name="boardGbnCdNm"		value="${item.boardGbnCdNm}">		<!-- 게시판_구분_명 -->
			<input type="hidden" id="boardSn" 		name="boardSn"			value="${dataView.BOARD_SN}">		<!-- 게시판_번호 -->
			<input type="hidden" id="boardFlSn" 	name="boardFlSn"		value="${dataView.BOARD_FL_SN}">	<!-- 게시판_파일_번호 -->
		</form>
		
		<div id="content">
			<!-- 신규등록여부 ( 신규 : Y / 수정 : N ) -->	
			<input type="hidden" id="newYn" name="newYn" value="${item.newYn}">
			
			<h3 class="book-title">${item.boardGbnCdNm} 등록/수정</h3>
			<br/><br/>
			<!-- Editor_Form -->
			<form id="editor_Form">
				<input type="hidden" id="bsnsCode"    	name="bsnsCode"       	value="${sessionScope.bsns_code}" >	<!-- 세션_업체코드 -->
				<input type="hidden" id="boardGbnCd" 	name="boardGbnCd"		value="${item.boardGbnCd}">			<!-- 게시판_구분 -->
				<input type="hidden" id="sessionId"     name="sessionId"       	value="${sessionScope.session_id}">	<!-- 세션_아이디(등록자/수정자) -->
				<input type="hidden" id="boardSn" 		name="boardSn"			value="${dataView.BOARD_SN}">		<!-- 게시판_번호 -->
				<input type="hidden" id="boardFlSn" 	name="boardFlSn"		value="${dataView.BOARD_FL_SN}">	<!-- 게시판_파일_번호 -->
				<input type="hidden" id="flNm" 			name="flNm"				value="${dataView.FL_NM}">			<!-- 파일 명 -->
			    <input type="hidden" id="flPath" 		name="flPath"			value="${dataView.FL_PATH}">		<!-- 파일 경로 -->
			    <input type="hidden" id="originFlNm" 	name="originFlNm" 		value="${dataView.ORIGIN_FL_NM}">	<!-- 파일 원본명 -->
			    <input type="hidden" id="uploadYn" 		name="uploadYn" 		value="N">							<!-- 업로드 여부 -->
			    <br/><br/><br/>
				<h3> 제목  :</h3>&nbsp;&nbsp;<input type="text" id="subject" name="subject" size="86" value="${dataView.SUBJECT}">
				<br/><br/>
				<textarea id="editor" name="editor" style="HEIGHT: 300px; WIDTH: 90%" rows="10" cols="30">${dataView.CONTENT}</textarea>
			</form>
			
			<!-- Upload_Form -->
			<form name="upload_Form" id="upload_Form" method="post" enctype="multipart/form-data">
				<div class="book-Form">
					<input type="file" id="uploadFile" name="uploadFile">
					<input type="hidden" id="sPath" name="sPath" value="/board/publi/">
				</div>
			</form>
			<div class="bookView">	
				<div class="bookView-btn">
					<a href="#" id="fn_saveData" >저장</a>
					<a href="javascript:fn_dataList();" id="dataList">목록</a>
				</div>
			</div>		
		</div>
	</body>
</html>