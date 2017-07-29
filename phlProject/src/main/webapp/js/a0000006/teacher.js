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

