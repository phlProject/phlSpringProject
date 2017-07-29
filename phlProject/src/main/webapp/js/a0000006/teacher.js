/* 참여게시판 > 상세 폼  */
function fn_joinView(boardSn){
	var input = $("<input>").attr("type", "hidden").attr("name", "boardSn").attr("id", "boardSn").val(boardSn);
	$("#joinList_Form").attr({action:"/a0000006/teacher/joinView.do" ,method:'post'}).append($(input)).submit();
}

/* 참여게시판 > 신규등록 폼 */
function fn_joinFormI(){
	ComSubmit('joinList_Form','/a0000006/teacher/joinFormI.do');
}