/***** 게시판 - 책소개 *****/

/* 책소개 > 리스트 조회 */
function fn_bookList(){
	ComSubmit('bookList_Form','/a0000006/board/bookList.do');
}

/* 책소개 > 상세 폼  */
function fn_bookView(boardSn){
	var input = $("<input>").attr("type", "hidden").attr("name", "boardSn").attr("id", "boardSn").val(boardSn);
	$("#bookList_Form").attr({action:"/a0000006/board/bookView.do" ,method:'post'}).append($(input)).submit();
}

/* 책소개 > 신규등록 폼 */
function fn_bookFormI(){
	ComSubmit('bookList_Form','/a0000006/board/bookFormI.do');
}

/* 책소개 > 수정 폼 */
function fn_bookFormU(){
	ComSubmit('bookList_Form','/a0000006/board/bookFormU.do');
}

/* 책소개 > 삭제 */
function fn_deleteBook(){
	if(!confirm("삭제하시겠습니까? ")){
		return;
	}
	
	var postUrl = "/a0000006/board/deleteBook.do";
	$.post(postUrl, $("#bookList_Form").serialize(), function(data){
		if(data.result == "success" ){
			alert("삭제되었습니다.");
			ComSubmit('bookList_Form','/a0000006/board/bookList.do');
		} else{
			alert("실패하였습니다. 관리자에게 문의해주세요.");
			return;
		}
	});
}

/* 책소개 > 좋아요 등록/수정  */
function fn_bookLike(){
	
	var saveLike = ""; // 저장 될 라이크 유무	
	
	if($("#likeYn").val() == "Y"){
		saveLike = 'N';
	}else{
		saveLike = 'Y';
	}
	$.ajax({
		url		: "/a0000006/board/bookLike.do",
		type 	: "post",
		data : {
					bsnsCode 	: $("#bsnsCode").val(),
					boardSn		: $("#boardSn").val(),
					saveLike	: saveLike
				},
		dataType : "json",
		success : function(data){
			if(data.result == "success"){
				if(saveLike == "Y"){
					$("#likeImage").text("♥");
				}else if(saveLike == "N"){
					$("#likeImage").text("♡");
				}
				$("#likeYn").val(saveLike);
			}
		}
	});
	
}

/* 책소개 > 신규등록/수정 > 파일업로드 */
/*function fn_bookUploadFile(){
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
            $("#uploadYn").val("Y");
            $("#mainImage").attr("src", data.fl_upload.FL_PATH+data.fl_upload.FL_NM);
        },
        error : function(error) {
            alert("파일 업로드에 실패하였습니다.");
            console.log(error);
            console.log(error.status);
        }
    });
}*/

/* 책소개  > 등록/수정 > 유효성 체크 */
/*function bookValidation(){
	if($("#fl_nm").val()==""){
		alert("이미지를 선택해주시기 바랍니다.");
		return;
	}
	
	if($("#subject").val()==""){
		alert("제목을 입력해주세요.");
		$("#subject").focus();
		return;
	}
	
	return true;
}
*/

/***** 게시판 - 자료공통 *****/

/* 자료공통 > 리스트 조회 */
function fn_dataList(){
	ComSubmit('dataList_Form','/a0000006/board/dataList.do');
}

/* 자료공통 > 상세 폼 */
function fn_dataView(boardSn){
	var input = $("<input>").attr("type", "hidden").attr("name", "boardSn").attr("id", "boardSn").val(boardSn);
	$("#dataList_Form").attr({action:"/a0000006/board/dataView.do" ,method:'post'}).append($(input)).submit();
}

/* 자료공통 > 신규등록 폼 */
function fn_dataFormI(){
	ComSubmit('dataList_Form','/a0000006/board/dataFormI.do');
}

/* 자료공통 > 수정 폼 */
function fn_dataFormU(){
	ComSubmit('dataList_Form','/a0000006/board/dataFormU.do');
}

/* 자료공통 > 삭제 */
function fn_deleteData(){
	if(!confirm("삭제하시겠습니까? ")){
		return;
	}
	
	var postUrl = "/a0000006/board/deleteData.do";
	$.post(postUrl, $("#dataList_Form").serialize(), function(data){
		if(data.result == "success" ){
			alert("삭제되었습니다.");
			ComSubmit('dataList_Form','/a0000006/board/dataList.do');
		} else{
			alert("실패하였습니다. 관리자에게 문의해주세요.");
			return;
		}
	});
}

/* 자료공통 > 게시글 이동 */
function fn_pageMoveData(move){
	
	var postUrl = "/phl/pageMove.do?move="+move;
	
	$.post(postUrl, $("#dataList_Form").serialize(), function(data){
		if(data.result != "N" ){
			ComSubmit('dataList_Form','/a0000006/board/dataView.do?moveBoardSn='+data.result);
		}else{
			if(move == "pre") 			alert("이전 글이 없습니다.");
			else if(move == "after") 	alert("다음 글이 없습니다.");
			return;
		}
	});
}


/***** 게시판 - 공통 *****/

/* 게시판 공통 > 파일다운로드 */
function fn_boardFlDown(bsnsCode, boardSn, boardFlSn){
	var strUrl  = "/a0000006/board/downloadFile.do";
		strUrl += "?bsnsCode="+bsnsCode;
		strUrl += "&&boardSn="+boardSn;
		strUrl += "&&boardFlSn="+boardFlSn;
	
	document.location.href=strUrl;
}
