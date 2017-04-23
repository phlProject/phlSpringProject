// 회원 등록
function fn_insertMemRegist(){
	// 입력 유효성 검사
	if(!fn_validation()){
		return;
	}
	
	/*alert("환영합니다. 회원 가입이 완료되었습니다.");
	
	// 회원 등록
	ComSubmit('memRegist_Form','/a0000006/mem/insertMemRegist.do');*/
	
	var postUrl = "/a0000006/mem/insertMemRegist.do";
	$.post(postUrl, $("#memRegist_Form").serialize(), function(data){
		if(data.result == "success" ){
			alert("환영합니다. 회원 가입이 완료되었습니다. 로그인 페이지로 이동합니다.");
			ComSubmit('memRegist_Form','/a0000006/mem/memLoginForm.do');
		} else{
			alert("회원 가입에 실패하였습니다. 관리자에게 문의해주세요.");
			return;
		}
	});

	
}

// 마이페이지 수정
function fn_updateMemRegist(){
	
	var postUrl = "/a0000006/mem/updateMemRegist.do";
	$.post(postUrl, $("memMypage_Form").serialize(), function(data){
		if(data.result == "success" ){
			alert("수정되었습니다.");
			ComSubmit('memMypage_Form','/a0000006/mem/memMyPage.do');
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
		var postUrl = "/a0000006/mem/deleteMemRegist.do";
		$.post(postUrl, $("memMypage_Form").serialize(), function(data){
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


// 유효성 검사
function fn_validation(){
	if($("#mem_id").val() == ""){
		alert(" * 아이디를 입력해주세요. ");
		$("#mem_id").focus();
		return false;
	}
	
	// 아이디 중복 검사 여부 
	if($("#usableId_yn").val() == "N"){
		alert(" * 아이디 중복검사를 해주세요.");
		return false;
	}
	
	if($("#mem_pw").val() == ""){
		alert(" * 비밀번호를 입력해주세요. ");
		$("#mem_pw").focus();
		return false;
	}
	
	if($("#conf_mem_pw").val() == ""){
		alert(" * 비밀번호 확인란을 입력해주세요. ");
		$("#conf_mem_pw").focus();
		return false;
	}
	
	if($("#mem_nm").val() == ""){
		alert(" * 이름을 입력해주세요. ");
		$("#mem_nm").focus();
		return false;
	}
	
	if($("#mem_email").val() == ""){
		alert(" * 이메일을 입력해주세요. ");
		$("#mem_email").focus();
		return false;
	}
	
	// 이메일 형식 체크
	if(!emailCheck()){
		//$("#mem_email").val("");
		$("#mem_email").focus();
		return false;
	}
	
	if($("#mem_nicknm").val() == ""){
		alert(" * 닉네임을 입력해주세요. ");
		$("#mem_nicknm").focus();
		return false;
	}
	
	if($("#mem_grade").val() == ""){
		alert(" * 회원구분을 선택해주세요. ");
		$("#mem_grade").focus();
		return false;
	}
	
	if($("#mem_phone").val() == ""){
		alert(" * 핸드폰번호를 입력해주세요. ");
		$("#mem_phone").focus();
		return false;
	}
	
	return true;
}

/* 이메일 정규식 */
function emailCheck() {		

	var email = $("#mem_email").val();
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

	//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
	if(exptext.test(email)==false){
		alert("이 메일형식이 올바르지 않습니다. 다시 작성해주세요.");
		return false;
	}
	return true;
}

// 아이디가 변경되었을 때 usableId_yn 값을 'N'으로 변경함으로써 아이디 중복검사를 다시 하게 함.
function changedId(){
	
	// 아이디 검사
	// 영문소문자와 숫자로만 이루어져야한다.
    // 첫 글자는 반드시 영문 소문자, 4~12자로 이루어지고, 숫자가 하나 이상 포함되어야 한다. 
    // \d : [0-9]와 같다.       {n,m} : n에서 m까지 글자수
    
	var id = document.getElementById('mem_id');
	if(!chk(/^[a-z][a-z\d]{3,11}$/, id, 
    		"첫글자는 영문 소문자여야 하고, 아이디는 4~12자여야합니다.")){
    	return false;
    }
    if(!chk(/[0-9]/, id, 
    		"반드시 숫자가 하나 이상 포함되어야 합니다.")){
    	return false;
    }

	$("#usableId_yn").val("N");
	$("#idDupText").text("");
	
}

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
	$.ajax({
		url		: "/a0000006/mem/idDupChk.do",
		type 	: "post",
		data : {
					mem_id : $("#mem_id").val()
				},
		dataType : "json",
		success : function(data){
			if(data.result == "success"){
				$("#idDupText").text("사용할 수 있는 아이디입니다.");
				$("#usableId_yn").val("Y");
			}else{
				$("#idDupText").Text("중복된 아이디입니다. 다른 아이디를 입력해주세요.");
				$("#mem_id").focus();
			}
		}
	});
}

// 비밀번호 확인
function confirmPw(){
	var mem_pw = $("#mem_pw").val();
	var conf_mem_pw = $("#conf_mem_pw").val();
	if(mem_pw != conf_mem_pw && conf_mem_pw != ""){
		$("#confPwText").text("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
		$("#conf_mem_pw").val("");
		$("#conf_mem_pw").focus();
		return false;
	}else{
		$("#confPwText").text("");
	}
	return true;
}

// 로그인 유효성
function fn_loginVal(){
	
	if($("#mem_id").val() == ""){
		alert(" * 아이디를 입력해주세요. ");
		$("#mem_id").focus();
		return;
	}
	
	if($("#mem_pw").val() == ""){
		alert(" * 비밀번호를 입력해주세요. ");
		$("#mem_pw").focus();
		return;
	}
	
	ComSubmit('loginActionForm','/a0000006/mem/loginAction.do');
	
}
