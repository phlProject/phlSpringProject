<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="/resources/editor/js/HuskyEZCreator.js"></script>
	<script>
    $(function(){
        //전역변수선언
        var editor_object = [];
         
        nhn.husky.EZCreator.createInIFrame({
            oAppRef: editor_object,
            elPlaceHolder: "editor",
            sSkinURI: "/resources/editor/SmartEditor2Skin.html",
            htParams : {
                // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
                bUseToolbar : true,            
                // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
                bUseVerticalResizer : true,    
                // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
                bUseModeChanger : true,
            }
        });
         
        //저장버튼 클릭이벤트
        $("#fn_updateBook").click(function(){
            
        	if(!bookValidation()){
        		return;
        	}
        	
        	if(!confirm("수정하시겠습니까? ")){
        		return;
        	}
        	
            //id가 smarteditor인 textarea에 에디터에서 대입
            editor_object.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
       		
            var postUrl = "/a0000006/board/updateBook.do";
        	$.post(postUrl, $("#editor_Form").serialize(), function(data){
        		if(data.result == "success" ){
        			alert("수정되었습니다.");
        			ComSubmit('bookList_Form','/a0000006/board/bookView.do');
        		} else{
        			alert("실패하였습니다. 관리자에게 문의해주세요.");
        			return;
        		}
        	});
        });
    }); 
	</script>
</head>
<body>

<!-- 이전화면이동_Form -->
<form id="bookList_Form">
	<input type="hidden" id="searchSelect" 	name="searchSelect" 	value="${item.searchSelect}">
	<input type="hidden" id="searchWord" 	name="searchWord" 		value="${item.searchWord}">
	<input type="hidden" id="board_Sn" 		name="board_Sn" 		value="${bookView.BOARD_SN}">
	<input type="hidden" id="bsns_code"    name="bsns_code"       value="${sessionScope.bsns_code}" >
    <input type="hidden" id="session_id"    name="session_id"       value="${sessionScope.session_id}" >
</form>

<div id="content">
	<!-- 책소개 Main 사진  -->
	<form name="upload_Form" id="upload_Form" method="post" enctype="multipart/form-data">
		<div>
			<img src="${bookView.FL_PATH}/${bookView.FL_NM}" id="mainImage" name="mainImage" width="150" height="200"><br>
			<input type="file" id="uploadFile" name="uploadFile" onchange="javascript:fn_bookUploadFile();">
			<input type="hidden" id="sPath" name="sPath" value="/board/book/">
		</div>
	</form>
	
	<form id="editor_Form">
		<input type="hidden" id="board_Sn" name="board_Sn" value="${bookView.BOARD_SN}">
		<input type="hidden" id="board_Fl_Sn" name="board_Fl_Sn" value="${bookView.BOARD_FL_SN}">
		
		<input type="hidden" id="fl_nm" name="fl_nm" value="${bookView.FL_NM}">
	    <input type="hidden" id="fl_path" name="fl_path" value="${bookView.FL_PATH}">
	    <input type="hidden" id="origin_fl_nm" name="origin_fl_nm" value="${bookView.ORIGIN_FL_NM}">
	    <input type="hidden" id="board_gbn_cd" name="board_gbn_cd" value="B01001">
	    <input type="hidden" id="uploadYn" name="uploadYn" value="N">
	    <input type="hidden" id="bsns_code"    name="bsns_code"       value="${sessionScope.bsns_code}" >
      	<input type="hidden" id="session_id"    name="session_id"       value="${sessionScope.session_id}" >
	    
                  제목      <input type="text" id="subject" name="subject" size="86" value="${bookView.SUBJECT}"><br>
	    <textarea id="editor" name="editor" style="HEIGHT: 220px; WIDTH: 610px" rows="10" cols="30">${bookView.CONTENTS}</textarea>
	</form>
	
	<a href="#" id="fn_updateBook" >수정</a>
	<a href="javascript:fn_bookView(${bookView.BOARD_SN});" id="bookView">이전</a>
</div>

</body>
</html>