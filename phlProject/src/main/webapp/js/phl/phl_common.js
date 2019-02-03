/* 파일 업로드 */
function gfn_uploadFile(){
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
            $("#flNm").val(data.fl_upload.FL_NM);					// 파일 원본명
            $("#flPath").val(data.fl_upload.FL_PATH);				// 파일 경로
            $("#originFlNm").val(data.fl_upload.ORIGIN_FL_NM);		// 파일 명
            $("#uploadYn").val("Y");								// 업로드 여부
            $("#mainImage").attr("src", data.fl_upload.FL_PATH+data.fl_upload.FL_NM);
        },
        error : function(error) {
            alert("파일 업로드에 실패하였습니다.");
        }
    });
}

/* input Type 제어 */

// 영어, 숫자 입력 가능 ( 대/소문자 css 제어 : text-transform )
function engNumber(obj){
	$(obj).keyup(function(event){ 
		if (!(event.keyCode >=37 && event.keyCode<=40)) {
			$(this).val($(this).val().replace(/[^a-z0-9]/gi,""));
		}
	});
}

// 숫자만 입력 가능 (전화번호)
function onlyNumber(obj) {
	$(obj).keyup(function(){
		$(this).val($(this).val().replace(/[^0-9]/g,""));
	}); 
}

//한글 불가 (이메일)
function notHangeul(obj){
	$(obj).keyup(function(){
		$(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g,""));
	});
}

/**
 *	gfnIsNull ( Null Check ) 
 */
function gfnIsNull(obj){
	if($.trim(obj) == null ||  $.trim(obj) == "")
	{
		return false;
	}
	return true;
}
