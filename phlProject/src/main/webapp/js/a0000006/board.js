/***** 게시판 - 책소개 *****/

/* 책소개 > 조회 */
function fn_searchBookList(){
	ComSubmit('bookList_Form','/a0000006/board/bookList.do');
}

/* 책소개 > 상세 폼 이동 */
function fn_bookView(board_Sn){
	var input = $("<input>").attr("type", "hidden").attr("name", "board_Sn").attr("id", "board_Sn").val(board_Sn);
	$("#bookList_Form").attr({action:"/a0000006/board/bookView.do" ,method:'post'}).append($(input)).submit();
}

/* 책소개 > 목록 이동 */
function fn_bookList(){
	ComSubmit('bookList_Form','/a0000006/board/bookList.do');
}

/* 책소개 > 신규등록 폼 이동 */
function fn_bookFormI(){
	ComSubmit('bookList_Form','/a0000006/board/bookForm.do');
}

/* 책소개 > 신규등록/수정 > 파일업로드 */
function fn_bookUploadFile(){
	var formData = new FormData($("#upload_Form")[0]);
	alert(formData);
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
            $("#uploadYn").val("Y");
            $("#mainImage").attr("src", data.fl_upload.FL_PATH+data.fl_upload.FL_NM);
        },
        error : function(error) {
            alert("파일 업로드에 실패하였습니다.");
            console.log(error);
            console.log(error.status);
        }
    });
}

/* 책소개 > 수정 폼 이동 */
function fn_bookFormU(){
	ComSubmit('bookView_Form','/a0000006/board/bookFormU.do');
}

/* 책소개 > 글 삭제 */
function fn_deleteBook(){
	
	if(!confirm("삭제하시겠습니까? ")){
		return;
	}
	
	var postUrl = "/a0000006/board/deleteBook.do";
	$.post(postUrl, $("#bookView_Form").serialize(), function(data){
		if(data.result == "success" ){
			alert("삭제되었습니다.");
			ComSubmit('bookList_Form','/a0000006/board/bookList.do');
		} else{
			alert("실패하였습니다. 관리자에게 문의해주세요.");
			return;
		}
	});
}

/* 책소개  > 등록/수정 > 유효성 체크 */
function bookValidation(){
	if($("#fl_nm").val()==""){
		alert("이미지를 선택해주시기 바랍니다.");
		return;
	}
	
	if($("#subject").val()==""){
		alert("제목을 입력해주세요.");
		$("#subject").focus();
		return;
	}
	
	if($("#editor").val()==""){
		alert("내용을 입력해주세요.");
		return;
	}
	
	return true;
}