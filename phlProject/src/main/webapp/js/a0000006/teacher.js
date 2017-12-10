/* 참여게시판 > 리스트 조회 */
function fn_joinList(){
	ComSubmit('joinList_Form','/a0000006/teacher/joinList.do');
}

/* 참여게시판 > 상세 폼  */
function fn_joinView(boardSn){
	var input = $("<input>").attr("type", "hidden").attr("name", "boardSn").attr("id", "boardSn").val(boardSn);
	$("#joinList_Form").attr({action:"/a0000006/teacher/joinView.do" ,method:'post'}).append($(input)).submit();
}

/* 참여게시판 > 신규등록 폼 */
function fn_joinFormI(){
	ComSubmit('joinList_Form','/a0000006/teacher/joinFormI.do');
}

/* 참여게시판 > 수정 폼 */
function fn_joinFormU(){
	ComSubmit('joinList_Form','/a0000006/teacher/joinFormU.do');
}

/* 참여게시판 > 삭제 */
function fn_deleteJoin(){
	if(!confirm("삭제하시겠습니까? ")){
		return;
	}
	
	var postUrl = "/a0000006/teacher/deleteJoin.do";
	$.post(postUrl, $("#joinList_Form").serialize(), function(data){
		if(data.result == "success" ){
			alert("삭제되었습니다.");
			ComSubmit('joinList_Form','/a0000006/teacher/joinList.do');
		} else{
			alert("실패하였습니다. 관리자에게 문의해주세요.");
			return;
		}
	});
}

/* 참여게시판  > 댓글 등록/수정/삭제 */
function fn_saveJoinRe(){
	if($("#contents").val() == null || $("#contents").val() == ""){
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
		url		: "/a0000006/teacher/saveJoinRe.do",
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
				ComSubmit('joinList_Form','/a0000006/teacher/joinView.do');
			}else{
				alert("실패하였습니다. 관리자에게 문의해주세요.");
				return;
			}
		}
	});
}

/* 참여게시판 > 댓글 수정 변경 */
function fn_updateJoinRe(boardReSn, content){
	$("#boardReSn").val(boardReSn);
	$("#contents").val(content);
	$("#boardReType").val("update");
	$("#regNm").text("수정");
}

/* 참여게시판 > 댓글 삭제 변경 */
function fn_deleteJoinRe(boardReSn){
	$("#boardReSn").val(boardReSn);
	$("#contents").val("");
	$("#boardReType").val("delete");
	fn_saveJoinRe();
}

/* 참여게시판 > 댓글 답변 변경 */
function fn_insertJoinReRe(memNm, boardReSn){
	$("#contents").val("@"+memNm);
	$("#boardReSn").val(boardReSn);
	$("#regNm").text("답변등록");
	$("#boardReType").val("insert");
}

/* 참여게시판 > 댓글 취소 */
function fn_cancelJoinRe(){
	$("#boardReSn").val("");
	$("#contents").val("");
	$("#boardReType").val("insert");
	$("#regNm").text("등록");
}
