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

function fn_bookFormU(){
	ComSubmit('bookView_Form','/a0000006/board/bookFormU.do');
}