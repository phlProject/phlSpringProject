/* 파일 업로드 */
function fn_uploadFile(){
	alert(1);
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
            console.log(error);
            console.log(error.status);
        }
    });
}
