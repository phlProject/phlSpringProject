/************************ 상담신청 ( 비회원 ) ************************/

/* 상담신청 조회 */
function fn_counselList(){
	ComSubmit('boardList_Form','/a0000007/counsel/counselList.do');
}

/* 상담신청 상세 비밀번호 확인 */
function fn_counselPwdCheck(boardSn){
	var input = $("<input>").attr("type", "hidden").attr("name", "boardSn").attr("id", "boardSn").val(boardSn);
	$("#boardList_Form").attr({action:"/a0000007/counsel/counselPwdCheck.do" ,method:'post'}).append($(input)).submit();
}

/* 상담신청 상세조회 */
function fn_counselView(boardSn){
	var input = $("<input>").attr("type", "hidden").attr("name", "boardSn").attr("id", "boardSn").val(boardSn);
	$("#boardList_Form").attr({action:"/a0000007/counsel/counselView.do" ,method:'post'}).append($(input)).submit();
}

/* 상담신청 신규등록폼 */
function fn_counselFormI(){
	ComSubmit('boardList_Form','/a0000007/counsel/counselFormI.do');
}

/* 상담신청 수정폼 */
function fn_counselFormU(){
	ComSubmit('boardList_Form','/a0000007/counsel/counselFormU.do');
}

/* 상담신청 삭제 */
function fn_deleteCounsel(){
	if(!confirm("삭제하시겠습니까? ")){
		return;
	}
	
	var postUrl = "/a0000007/counsel/deleteCounsel.do";
	$.post(postUrl, $("#boardList_Form").serialize(), function(data){
		if(data.result == "success" ){
			alert("삭제되었습니다.");
			ComSubmit('boardList_Form','/a0000007/counsel/counselList.do');
		} else{
			alert("실패하였습니다. 관리자에게 문의해주세요.");
			return;
		}
	});
}

/* 상담신청 댓글 등록/수정/삭제 */
function fn_saveBoardReply(){
	if(($("#contents").val() == null || $("#contents").val() == "") && $("#boardReType").val() != "delete") {
		alert("댓글 내용을 입력해주세요.");
		$("#contents").focus();
		return;
	}
	
	var strMsg = "";
	
	if($("#boardReType").val() == "update"){
		strMsg = "수정";
	}else if($("#boardReType").val() == "delete"){
		strMsg = "삭제"
	}else{
		strMsg = "등록";
	}
	
	
	if(!confirm("댓글을 "+strMsg+"하시곘습니까 ? ")){
		$("#boardReSn").val("");
		$("#boardReType").val("insert");
		$("#regNm").text("등록");
		return;
	}
	
	$.ajax({
		url		: "/a0000007/counsel/saveCounselReply.do",
		type 	: "post",
		data : {
					bsnsCode 	: $("#bsnsCode").val(),		// 사업코드
					boardSn		: $("#boardSn").val(),		// 게시판 번호
					boardReSn	: $("#boardReSn").val(),	// 게시판 댓글 번호
					boardReType : $("#boardReType").val(),	// 게시판 댓글 타입
					content		: $("#contents").val(),		// 게시판 내용
					sessionId	: $("#sessionId").val()		// 세션 ID 
				},
		dataType : "json",
		success : function(data){
			if(data.result == "success"){
				alert(strMsg+"되었습니다.");
				ComSubmit('boardList_Form','/a0000007/counsel/counselView.do');
			}else{
				alert("실패하였습니다. 관리자에게 문의해주세요.");
				return;
			}
		}
	});
}


/* 상담 게시판 댓글 수정 변경 */
function fn_updateBoardReply(boardReSn, content){
	$("#boardReSn").val(boardReSn);
	$("#contents").val(content);
	$("#boardReType").val("update");
	$("#regNm").text("수정");
}

/* 상담 게시판 댓글 삭제 변경 */
function fn_deleteBoardReply(boardReSn){
	$("#boardReSn").val(boardReSn);
	$("#contents").val("");
	$("#boardReType").val("delete");
	fn_saveBoardReply(); 
}

/* 상담 게시판 댓글 답변 변경 */
function fn_insertBoardReReply(memNm, boardReSn){
	$("#boardReSn").val(boardReSn);
	$("#regNm").text("답변");
	$("#boardReType").val("insert");
}

/* 상담 게시판 댓글 취소 */
function fn_cancelBoardReply(){
	$("#boardReSn").val("");
	$("#contents").val("");
	$("#boardReType").val("insert");
	$("#regNm").text("등록");
}
