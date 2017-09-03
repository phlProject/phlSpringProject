/***** 게시판 - 자유게시판 *****/

/* 자유게시판 > 리스트 조회 */
function fn_freeBoardList(){
	ComSubmit('freeBoardList_Form','/a0000006/open/freeBoardList.do');
}

/* 자유게시판 > 상세 폼  */
function fn_freeBoardView(boardSn){
	var input = $("<input>").attr("type", "hidden").attr("name", "boardSn").attr("id", "boardSn").val(boardSn);
	$("#freeBoardList_Form").attr({action:"/a0000006/open/freeBoardView.do" ,method:'post'}).append($(input)).submit();
}

/* 자유게시판 > 신규등록 폼 */
function fn_freeBoardFormI(){
	ComSubmit('freeBoardList_Form','/a0000006/open/freeBoardFormI.do');
}

/* 자유게시판 > 수정 폼 */
function fn_freeBoardFormU(){
	ComSubmit('freeBoardList_Form','/a0000006/open/freeBoardFormU.do');
}

/* 자유게시판 > 삭제 */
function fn_deleteFreeBoard(){
	if(!confirm("삭제하시겠습니까? ")){
		return;
	}
	
	var postUrl = "/a0000006/open/deleteFreeBoard.do";
	$.post(postUrl, $("#freeBoardList_Form").serialize(), function(data){
		if(data.result == "success" ){
			alert("삭제되었습니다.");
			ComSubmit('freeBoardList_Form','/a0000006/open/freeBoardList.do');
		} else{
			alert("실패하였습니다. 관리자에게 문의해주세요.");
			return;
		}
	});
}
