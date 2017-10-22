/* 회원등록  S */

// 아이디 변경 체크
function changedId(){
	
	// 아이디가 변경되었을 때 useableIdYn 값을 'N'으로 변경함으로써 아이디 중복검사를 다시 하게 함.
	// 영문소문자와 숫자로만 이루어져야한다.
    // 첫 글자는 반드시 영문 소문자, 4~12자로 이루어지고, 숫자가 하나 이상 포함되어야 한다. 
    // \d : [0-9]와 같다.       {n,m} : n에서 m까지 글자수
    
	var id = document.getElementById('memId');
	if(id.value == ""){
		$("#idDupText").text("아이디를 입력해주세요.");
		$("#suitableIdYn").val("N");
		return false;
	}
	if(!chk(/^[a-z][a-z\d]{3,11}$/, id, 
    		"영문 소문자로 시작하고 숫자가 포함 된  4~12자여야합니다.")){
		$("#suitableIdYn").val("N");
    	return false;
    }
    if(!chk(/[0-9]/, id, 
    		"반드시 숫자가 하나 이상 포함되어야 합니다.")){
    	$("#suitableIdYn").val("N");
    	return false;
    }

    $("#suitableIdYn").val("Y");
	$("#useableIdYn").val("N");
	$("#idDupText").text("");
	
	return true;
}

// ID 유효성 체크
function chk(re, e, msg) {
    if (re.test(e.value)) {
    	return true;
    }
    $("#idDupText").text(msg);
    e.focus();
    return false;
}
	
// 아이디 중복 검사
function idDupChk(){
	
	// 아이디 유효성검사
	if(!changedId()){
		return;
	}
	
	$.ajax({
		url		: "/a0000006/member/idDupChk.do",
		type 	: "post",
		data : {
					memId : $("#memId").val(),
					bsnsCode : $("#bsnsCode").val()
				},
		dataType : "json",
		success : function(data){
			if(data.result == "success"){
				$("#idDupText").text("사용할 수 있는 아이디입니다.");
				$("#useableIdYn").val("Y");
			}else if(data.result == "fail"){
				$("#idDupText").text("중복된 아이디입니다. 다른 아이디를 입력해주세요.");
				$("#memId").focus();
			}
		}
	});
}

// 회원가입 유효성 검사
function fn_validation(){
	
	var memId 			= $("#memId");			// 아이디
	var suitableIdYn	= $("#suitableIdYn");	// 아이디 적합성 여부
	var useableIdYn 	= $("#useableIdYn");	// 아이디 중복 검사 여부
	var memPw 			= $("#memPw");			// 비밀번호
	var confMemPw 		= $("#confMemPw");		// 비밀번호 확인
	var memNm 			= $("#memNm");			// 이름
	var memEmail 		= $("#memEmail");		// 이메일
	var memGbnCd 		= $("#memGbnCd");		// 회원 구분
	var memPhone 		= $("#memPhone");		// 전화번호
	
	var memIdEx			= /^[a-z][a-z\d]{3,11}$/;
	var memPwExt		= /^[a-zA-Z0-9]{8,12}$/;
	
	if($.trim(memId.val()) == ""){
		alert(" * 아이디를 입력해주세요. ");
		memId.focus();
		return false;
	}
	
	// 아이디 적합성 여부
	if( ($.trim(suitableIdYn.val()) == "N") || !memIdEx.test(memId.val())){
		alert(" * 아이디가 적합하지 않습니다. \n 영문 소문자로 시작하고 숫자가 포함 된 4~12자여야합니다.");
		return false;
	}
	
	// 아이디 중복 검사 여부 
	if($.trim(useableIdYn.val()) == "N"){
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
	
	// 이메일 형식 체크
	if(!emailCheck()){
		memEmail.focus();
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

// 이메일 정규식
function emailCheck() {		

	var email = $.trim($("#memEmail").val());
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

	//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
	if(!exptext.test(email)){
		alert("이 메일형식이 올바르지 않습니다. 다시 작성해주세요.");
		return false;
	}
	return true;
}

// 비밀번호 확인 체크
function confirmPw(){
	var memPw = $("#memPw").val();
	var confMemPw = $("#confMemPw").val();
	if(memPw != confMemPw && confMemPw != ""){
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
			return false;
		}
	}
	
	var postUrl = "/a0000006/member/insertMemRegist.do";
	$.post(postUrl, $("#memRegist_Form").serialize(), function(data){
		if(data.result == "success" ){
			alert("" +
					"환영합니다. 회원 가입이 완료되었습니다. 로그인 페이지로 이동합니다.");
			ComSubmit('memRegist_Form','/a0000006/member/memLoginForm.do');
		} else{
			alert("회원 가입에 실패하였습니다. 관리자에게 문의해주세요.");
			return;
		}
	});
}

/* 회원등록  E */



/* 로그인 S */

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

/* 로그인 E */


/* 마이페이지 S */



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
	var memEmail 		= $("#memEmail");		// 이메일
	var memGbnCd 		= $("#memGbnCd");		// 회원 구분
	var memPhone 		= $("#memPhone");		// 전화번호
	
	var memPwExt		= /^[a-zA-Z0-9]{8,12}$/;
	
	
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
	
	if(memPw.val() != confMemPw.val() && confMemPw.val() != ""){
		alert(" * 비밀번호가 일치하지 않습니다. 다시 입력해주세요. ");
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
	
	// 이메일 형식 체크
	if(!emailCheck()){
		memEmail.focus();
		return false;
	}
	
	if($.trim(memGbnCd.val()) == "G01030"){
		if ( !confirm(" * 회원 구분을 '선생님'으로 선택 시 관리자의 권한승인을 받을 때까지 로그인이 불가능합니다. 계속 하시겠습니까?") ){
			return false;
		}
	}
	
	if($.trim(memPhone.val()) == ""){
		alert(" * 핸드폰번호를 입력해주세요. ");
		memPhone.focus();
		return false;
	}
	
	
	
	// 1. 정보 수정이 있었을 경우에만 수정 쿼리를 탐.
	if ( is_input_changed ) {
		fn_updateMemRegist();
	
	// 2. 정보 수정이 없었을 경우에는 로그인 페이지로 이동.
	}else{
		alert("수정할 내용이 없습니다.");
	}
	
}

// 마이페이지 수정
function fn_updateMemRegist(){

	var memGbnCd = $.trim( $("#memGbnCd").val() );
	
	
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

// 회원 탈퇴
function fn_deleteMemRegist(){
	
	if(confirm("회원 탈퇴 하시겠습니까?")){
		
		//ComSubmit('memMypage_Form','/a0000006/mem/deleteMemRegist.do');
		
		//alert("탈퇴 처리 되었습니다.");
		
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

/* 마이페이지 E */