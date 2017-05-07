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
         
        //전송버튼 클릭이벤트
        $("#fn_insertBook").click(function(){
            
            //id가 smarteditor인 textarea에 에디터에서 대입
            editor_object.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
       		
            var postUrl = "/a0000006/board/insertBook.do";
        	$.post(postUrl, $("#editor_Form").serialize(), function(data){
        		if(data.result == "success" ){
        			alert("등록되었습니다.");
        			ComSubmit('editor_Form','/a0000006/board/bookList.do');
        		} else{
        			alert("실패");
        			return;
        		}
        	});
        });
    }); 

    function aa(){
    	var formData = new FormData($("#upload_Form")[0]);
        $.ajax({
            type : 'post',
            url : "/phl/uploadFile.do",
            data : formData,
            enctype: "multipart/form-data",
            async: false,
            processData : false,
            contentType : false,
            success : function(data) {
                $("#fl_nm").val(data.fl_upload.FL_NM);
                $("#fl_path").val(data.fl_upload.FL_PATH);
                $("#origin_fl_nm").val(data.fl_upload.ORIGIN_FL_NM);
                $("#mainImage").attr("src", data.fl_upload.FL_PATH+data.fl_upload.FL_NM);
            },
            error : function(error) {
                alert("파일 업로드에 실패하였습니다.");
                console.log(error);
                console.log(error.status);
            }
        });
    }
	</script>
</head>
<body>
<div id="content">
	
	<!-- 책소개 Main 사진  -->
	<form name="upload_Form" id="upload_Form" method="post" enctype="multipart/form-data">
		<div>
			<img src="" id="mainImage" name="mainImage" width="150" height="200"><br>
			<input type="file" id="uploadFile" name="uploadFile" onchange="aa()">
		</div>
	</form>
	
	<form id="editor_Form">
		<input type="hidden" id="fl_nm" name="fl_nm">
	    <input type="hidden" id="fl_path" name="fl_path">
	    <input type="hidden" id="origin_fl_nm" name="origin_fl_nm">
	    
                  제목      <input type="text" id="subject" name="subject" size="86"><br>
	    <textarea id="editor" name="editor" style="HEIGHT: 220px; WIDTH: 610px" rows="10" cols="30"></textarea>
	</form>
	
	
	<a href="#" id="fn_insertBook" >저장</a>
</div>
</body>
</html>