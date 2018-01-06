/**
 *	로그인
 *	회원가입
 *	마이페이지
 *	아이디/비밀번호 찾기
 */

/*************************** 로그인 Start ***************************/

//로그인 유효성
function fn_loginVal(){
	
	if($("#memId").val() == ""){
		alert(" * 아이디를 입력해주세요. ");
		$("#memId").focus();
		return;
	}
	
	if($("#memPw").val() == ""){
		alert(" * 비밀번호를 입력해주세요. ");
		$("#memPw").focus();
		return;
	}
	
	ComSubmit('loginActionForm','/a0000006/member/loginAction.do');
}

/*************************** 로그인 End ***************************/




/*************************** 회원가입 Start ***************************/

// 회원 정보 변경 체크
function memValidChk(param){
    
	var data = document.getElementById(param);
	
	if(param == "memId"){ // 영문 소문자 시작, 숫자 포함, 4~12자
		if(data.value == ""){
			$("#memIdDupText").text("아이디를 입력해주세요.");
			$("#memIdSuitYn").val("N");
			return false;
		}
		if(!chkText(/^[a-z][a-z\d]{3,11}$/, data, "영문 소문자로 시작하고 숫자가 포함 된  4~12자여야합니다.", param)){
			$("#memIdSuitYn").val("N");
	    	return false;
	    }
	    if(!chkText(/[0-9]/, data, "반드시 숫자가 하나 이상 포함되어야 합니다.", param)){
	    	$("#memIdSuitYn").val("N");
	    	return false;
	    }
	}else if(param == "memEmail"){ // 이메일 형식 (***@***.***)
		if(data.value == ""){
			$("#memEmailDupText").text("이메일을 입력해주세요.");
			$("#memEmailSuitYn").val("N");
			return false;
		}
		if(!chkText(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/, data, "이메일 형식이 올바르지 않습니다. 다시 작성해주세요.", param)){
			$("#memIdSuitYn").val("N");
	    	return false;
	    }
	}
	
    $("#" + param + "SuitYn").val("Y");
	$("#" + param + "UseYn").val("N");
	$("#" + param + "DupText").text("");
	
	return true;
}

// 회원 중복 검사
function memDupChk(param){
	
	if(!memValidChk(param)){
		return;
	}
	
	var paramTxt = "";
	if(param == "memId") 		 paramTxt = "아이디";
	else if(param == "memEmail") paramTxt = "이메일";
	
	$.ajax({
		url		: "/a0000006/member/memDupChk.do",
		type 	: "post",
		data : {
					paramName: param,
					paramVal : $("#"+param).val(),
					bsnsCode : $("#bsnsCode").val()
				},
		dataType : "json",
		success : function(data){
			if(data.result == "success"){
				$("#" + param + "DupText").text("사용 할 수 있는 " + paramTxt + "입니다.");
				$("#" + param + "UseYn").val("Y");
			}else if(data.result == "fail"){
				$("#" + param + "DupText").text("중복 된 " + paramTxt + "입니다.");
				$("#" + param).focus();
			}
		}
	});
}

// 유효성 Text 체크
function chkText(re, e, msg, param) {
	if (re.test(e.value)) return true;
    
    $("#" + param + "DupText").text(msg);
    e.focus();
    return false;
}


// 회원가입 유효성 검사
function fn_validation(){
	
	var memId 			= $("#memId");			// 아이디
	var memIdUseYn 		= $("#memIdUseYn");		// 아이디 중복 검사 여부 
	var memIdSuitYn		= $("#memIdSuitYn");	// 아이디 적합성 여부
	
	var memPw 			= $("#memPw");			// 비밀번호
	var confMemPw 		= $("#confMemPw");		// 비밀번호 확인
	
	var memNm 			= $("#memNm");			// 이름
	
	var memEmail 		= $("#memEmail");		// 이메일
	var memEmailUseYn 	= $("#memEmailUseYn");	// 이메일 중복 검사 여부
	var memEmailSuitYn	= $("#memEmailSuitYn");	// 이메일 적합성 여부
	
	var memGbnCd 		= $("#memGbnCd");		// 회원 구분
	var memPhone 		= $("#memPhone");		// 휴대폰번호
	
	var memIdExt		= /^[a-z][a-z\d]{3,11}$/;
	var memPwExt		= /^[a-zA-Z0-9]{8,12}$/;
	var memEmailExt		= /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	
	if($.trim(memId.val()) == ""){
		alert(" * 아이디를 입력해주세요. ");
		memId.focus();
		return false;
	}
	
	// 아이디 적합성 여부
	if( ($.trim(memIdSuitYn.val()) == "N") || !memIdExt.test(memId.val())){
		alert(" * 아이디가 적합하지 않습니다. \n 영문 소문자로 시작하고 숫자가 포함 된 4~12자여야합니다.");
		return false;
	}
	
	// 아이디 중복 검사 여부 
	if($.trim(memIdUseYn.val()) == "N"){
		alert(" * 아이디 중복검사를 해주세요.");
		return false;
	}
	
	if($.trim(memPw.val()) == ""){
		alert(" * 비밀번호를 입력해주세요. ");
		memPw.focus();
		return false;
	}
	
	if(!memPwExt.test(memPw.val())){
		alert(" * 비밀번호는 영문 , 숫자로 이루어진 8~12자리입니다. ");
		memPw.focus();
		return false;
	}
	
	if($.trim(confMemPw.val()) == ""){
		alert(" * 비밀번호 확인란을 입력해주세요. ");
		confMemPw.focus();
		return false;
	}
	
	if($.trim(memNm.val()) == ""){
		alert(" * 이름을 입력해주세요. ");
		memNm.focus();
		return false;
	}
	
	if($.trim(memEmail.val()) == ""){
		alert(" * 이메일을 입력해주세요. ");
		memEmail.focus();
		return false;
	}
	
	// 이메일 적합성 여부
	if( ($.trim(memEmailSuitYn.val()) == "N") || !memEmailExt.test(memEmail.val()) ){
		alert("이메일형식이 올바르지 않습니다. 다시 입력해주세요.");
		memEmail.focus();
		return false;
	}
	
	// 이메일 중복 검사 여부 
	if($.trim(memEmailUseYn.val()) == "N"){
		alert(" * 이메일 중복검사를 해주세요.");
		return false;
	}
	
	if($.trim(memGbnCd.val()) == ""){
		alert(" * 회원구분을 선택해주세요. ");
		memGbnCd.focus();
		return false;
	}
	
	if($.trim(memPhone.val()) == ""){
		alert(" * 핸드폰번호를 입력해주세요. ");
		memPhone.focus();
		return false;
	}
	
	return true;
}


// 비밀번호 확인 체크
function confirmPw(){
	var memPw 		= $("#memPw").val();
	var confMemPw 	= $("#confMemPw").val();
	if(confMemPw != "" && memPw != confMemPw){
		$("#confPwText").text("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
		$("#confMemPw").val("");
		$("#confMemPw").focus();
		return false;
	}else{
		$("#confPwText").text("");
	}
	return true;
}


// 회원 등록
function fn_insertMemRegist(){
	// 입력 유효성 검사
	if(!fn_validation()){
		return;
	}

	if($.trim($("#memGbnCd").val()) == "G01030"){
		if ( !confirm(" * 회원 구분을 '선생님'으로 선택 시 관리자의 권한승인을 받을 때까지 로그인이 불가능합니다. 계속 하시겠습니까?") ){
			return;
		}
	}
	
	var postUrl = "/a0000006/member/insertMemRegist.do";
	$.post(postUrl, $("#memRegist_Form").serialize(), function(data){
		if(data.result == "success" ){
			alert("환영합니다. 회원 가입이 완료되었습니다. 로그인 페이지로 이동합니다.");
			ComSubmit('memRegist_Form','/a0000006/member/memLoginForm.do');
		} else{
			alert("회원 가입에 실패하였습니다. 관리자에게 문의해주세요.");
			return;
		}
	});
}

/*************************** 회원가입 End ***************************/





/*************************** 마이페이지 Start ***************************/

// 정보 변경 여부를 확인할 전역 변수
var is_input_changed = false;

$(document).ready(function(){
	
	// 정보 변경이 있었을 경우 true 로 바꿔줌.
	$("input, select").change(function(){
		is_input_changed = true;
	});
	
});

// 마이페이지 유효성
function fn_updateMemValid(){
	
	var memPw 			= $("#memPw");			// 비밀번호
	var confMemPw 		= $("#confMemPw");		// 비밀번호 확인
	var memNm 			= $("#memNm");			// 이름
	var memGbnCd 		= $("#memGbnCd");		// 회원 구분
	var memPhone 		= $("#memPhone");		// 전화번호
	
	var memPwExt		= /^[a-zA-Z0-9]{8,12}$/;
	
	
	if($.trim(memPw.val()) == ""){
		alert(" * 비밀번호를 입력해주세요. ");
		memPw.focus();
		return;
	}
	
	if(!memPwExt.test(memPw.val())){
		alert(" * 비밀번호는 영문 , 숫자로 이루어진 8~12자리입니다. ");
		memPw.focus();
		return;
	}
	
	if($.trim(confMemPw.val()) == ""){
		alert(" * 비밀번호 확인란을 입력해주세요. ");
		confMemPw.focus();
		return;
	}
	
	if($.trim(memNm.val()) == ""){
		alert(" * 이름을 입력해주세요. ");
		memNm.focus();
		return;
	}
	
	if($.trim(memGbnCd.val()) == "G01030"){
		if ( !confirm(" * 회원 구분을 '선생님'으로 선택 시 관리자의 권한승인을 받을 때까지 로그인이 불가능합니다. 계속 하시겠습니까?") ){
			return;
		}
	}
	
	if($.trim(memPhone.val()) == ""){
		alert(" * 핸드폰번호를 입력해주세요. ");
		memPhone.focus();
		return;
	}
	
	
	// 1. 정보 수정이 있었을 경우에만 수정 쿼리를 탐.
	if ( is_input_changed ) {
		fn_updateMemRegist();
	
	// 2. 정보 수정이 없었을 경우에는 로그인 페이지로 이동.
	}else{
		alert("수정 내역이 없습니다.");
	}
	
}

// 마이페이지 수정
function fn_updateMemRegist(){

	var memGbnCd = $.trim( $("#memGbnCd").val() );
	
	if(confirm("수정하시겠습니까?")){
		var postUrl = "/a0000006/member/updateMemRegist.do";
		$.post(postUrl, $("#memMypage_Form").serialize(), function(data){
			if(data.result == "success" ){
				
				alert("수정되었습니다.");
				// 선생님으로 권한 변경을 신청한 경우 : 로그아웃
				if ( memGbnCd == 'G01030' ){
					ComSubmit('memMypage_Form','/a0000006/member/logoutAction.do');
				// 단순 정보 변경일 경우 마이 페이지 홈으로 이동
				} else {
					ComSubmit('memMypage_Form','/a0000006/member/memMyPage.do');
				}
				
			} else{
				alert("수정에 실패하였습니다. 관리자에게 문의해주세요.");
				return;
			}
		});
	}
}

// 회원 탈퇴
function fn_deleteMemRegist(){
	
	if(confirm("회원 탈퇴 하시겠습니까?")){
		var postUrl = "/a0000006/member/deleteMemRegist.do";
		$.post(postUrl, $("#memMypage_Form").serialize(), function(data){
			if(data.result == "success" ){
				alert("탈퇴 처리 되었습니다.");
				ComSubmit('memMypage_Form','/a0000006/mainIndex.do');
			} else{
				alert("탈퇴 처리에 실패하였습니다. 관리자에게 문의해주세요.");
				return;
			}
		});
	}
}

/*************************** 마이페이지 End ***************************/



/*************************** 아이디/비밀번호 찾기 Start ***************************/


/* 아이디 / 비밀번호 찾기 S */
$(document).ready(function() {
	
	// 아이디 찾기 검색 클릭
	$('#btnIdSearch').click(function(){
		
		var postUrl = "/a0000006/member/memInfoSearch.do";
		
		$.post(postUrl, $("#idSearchForm").serialize(), function(data){
			if(data.result == "Y" ){
				$("#memSearchId").text("회원님의 아이디는 ' " + data.memInfo + " ' 입니다.");
			}else{
				$("#memSearchId").text("일치하는 정보가 없습니다.");
				return;
			}
		});
		
	});
	
	
	// 비밀번호 찾기 검색 클릭
	$('#btnPwSearch').click(function(){
		
		var postUrl = "/a0000006/member/memInfoSearch.do";
		
		$.post(postUrl, $("#pwSearchForm").serialize(), function(data){
			if(data.result == "Y" ){
				$("#memSearchPw").text("회원님의 비밀번호는 ' " + data.memInfo + " ' 입니다.");
			}else{
				$("#memSearchPw").text("일치하는 정보가 없습니다.");
				return;
			}
		});
		
	});
	
});

// 정보 초기화
function memInfoInit(){
	$("input[name='memNm']").val("");
	$("input[name='memEmail']").val("");
	$("#memId").val("");
	$("#memSearchId").text("");
	$("#memSearchPw").text("");
}


/*************************** 아이디/비밀번호 찾기 End ***************************/