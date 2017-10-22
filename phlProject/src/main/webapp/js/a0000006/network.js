
/* 네트워크게시판 > 리스트 조회 */
function fn_networkBoardList(){
	ComSubmit('networkBoardList_Form','/a0000006/network/networkBoardList.do');
}

/* 네트워크게시판 > 상세 폼  */
function fn_networkBoardView(boardSn){
	var input = $("<input>").attr("type", "hidden").attr("name", "boardSn").attr("id", "boardSn").val(boardSn);
	$("#networkBoardList_Form").attr({action:"/a0000006/network/networkBoardView.do" ,method:'post'}).append($(input)).submit();
}

/* 네트워크게시판 > 신규등록 폼 */
function fn_networkBoardFormI(){
	ComSubmit('networkBoardList_Form','/a0000006/network/networkBoardFormI.do');
}

/* 네트워크게시판 > 수정 폼 */
function fn_networkBoardFormU(){
	ComSubmit('networkBoardList_Form','/a0000006/network/networkBoardFormU.do');
}

/* 네트워크게시판 > 삭제 */
function fn_deleteNetworkBoard(){
	if(!confirm("삭제하시겠습니까? ")){
		return;
	}
	
	var postUrl = "/a0000006/network/deleteNetworkBoard.do";
	$.post(postUrl, $("#networkBoardList_Form").serialize(), function(data){
		if(data.result == "success" ){
			alert("삭제되었습니다.");
			ComSubmit('networkBoardList_Form','/a0000006/network/networkBoardList.do');
		} else{
			alert("실패하였습니다. 관리자에게 문의해주세요.");
			return;
		}
	});
}
