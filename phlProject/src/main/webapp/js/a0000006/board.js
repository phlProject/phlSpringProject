/* 책소개 신규등록 */
function fn_bookView(board_sn){
	
	var input = $("<input>").attr("type", "hidden").attr("name", "board_Sn").attr("id", "board_Sn").val(board_sn);
	$("#bookList_Form").attr({action:"/a0000006/board/bookView.do" ,method:'post'}).append($(input)).submit();
	
}