function checkWrite(){
	var frm = document.bookWriteForm;		// form 내장객체 생성
	
	if(!frm.code.value || frm.code.value == "BC_") {
		alert("도서코드를 입력하세요.");
		frm.code.focus();
		
	} else if (!frm.title.value) {
		alert("도서명을 입력하세요.");
		frm.title.focus();
		
	}  else if (!frm.author.value) {
		alert("저자를 입력하세요.");
		frm.author.focus();
		
	} else if (!frm.publisher.value) {
		alert("출판사를 입력하세요.");
		frm.publisher.focus();
		
	} else if (!frm.price.value) {
		alert("가격을 입력하세요.");
		frm.price.focus();
		
	} else if (!frm.publiDate.value) {
		alert("출판일을 입력하세요.");
		frm.publiDate.focus();
		
	} 
	
	//입력 확인하기
		else if(confirm("입력하신 내용이 맞습니까?")) {
			frm.submit();
	}
}