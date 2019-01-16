/************************ 활동 프로그램 ************************/

/* 활동 프로그램 조회 */
function fn_programList(){
	ComSubmit('boardList_Form','/a0000007/program/programList.do');
}

/* 활동 프로그램 상세 */
function fn_programView(boardSn){
	var input = $("<input>").attr("type", "hidden").attr("name", "boardSn").attr("id", "boardSn").val(boardSn);
	$("#boardList_Form").attr({action:"/a0000007/program/programView.do" ,method:'post'}).append($(input)).submit();
}

/* 활동 프로그램 신규등록폼 */
function fn_programFormI(){
	ComSubmit('boardList_Form','/a0000007/program/programFormI.do');
}

/* 활동 프로그램 신규등록폼 */
function fn_programFormU(){
	ComSubmit('boardList_Form','/a0000007/program/programFormU.do');
}

/* 활동 프로그램 삭제 */
function fn_deleteProgram(){
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

/* 활동 프로그램 이전/다음 이동 */
function fn_pageMoveProgram(move){
	
	var postUrl = "/phl/pageMove.do?move="+move;
	
	$.post(postUrl, $("#boardList_Form").serialize(), function(data){
		if(data.result != "N" ){
			ComSubmit('boardList_Form','/a0000007/program/programView.do?moveBoardSn='+data.result);
		}else{
			if(move == "pre") 			alert("이전 글이 없습니다.");
			else if(move == "after") 	alert("다음 글이 없습니다.");
			return;
		}
	});
}