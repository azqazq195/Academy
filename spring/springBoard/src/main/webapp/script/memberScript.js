// 회원가입화면에서 입력 검사 : 이름, 아이디, 비밀번호
function checkWrite() {
	//alert("test");
	var frm = document.writeForm;  // form 내장객체 생성
	if(!frm.name.value) {
		alert("이름을 입력하세요.");
		frm.name.focus();
	} else if(!frm.id.value) {
		alert("아이디를 입력하세요.");
		frm.id.focus();
	} else if(!frm.pwd.value) {
		alert("비밀번호를 입력하세요.");
		frm.pwd.focus();
	} else if(frm.pwd.value != frm.repwd.value) {
		alert("비밀번호가 맞지 않습니다.");		
		frm.repwd.focus();
	} else {
		frm.submit();	// 데이터 전송
	}
}
// 수정화면에서 입력값 검사
function checkModify() {
	//alert("test");
	var frm = document.modifyForm;  // form 내장객체 생성
	if(!frm.name.value) {
		alert("이름을 입력하세요.");
		frm.name.focus();
	} else if(!frm.pwd.value) {
		alert("비밀번호를 입력하세요.");
		frm.pwd.focus();
	} else if(frm.pwd.value != frm.repwd.value) {
		alert("비밀번호가 맞지 않습니다.");		
		frm.repwd.focus();
	} else {
		frm.submit();	// 데이터 전송
	}
}

// 로그인 화면에서 입력 검사
function checkLogin() {
	frm = document.loginForm; // form 객체 생성
	if(!frm.id.value) {
		alert("아이디를 입력하세요.");
		frm.id.focus();
	} else if (!frm.pwd.value) {
		alert("비밀번호를 입력하세요.");
		frm.pwd.focus();
	} else {
		frm.submit();
	}
}

// 아이디 중복 검사 버튼 클릭
function checkId() {
	// 아이디 읽어오기
	var sId = document.writeForm.id.value;
	// 입력값이 있는 지 검사
	if(sId == "") {
		alert("먼저 아이디를 입력하세요.")
	} else {
		window.open("checkId.do?id="+sId, "",
				"width=350 height=100 left=500 top=200")
	}
}












