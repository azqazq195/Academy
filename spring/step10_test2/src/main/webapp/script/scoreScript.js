function checkScoreWrite() {
	var frm = document.scoreForm;
	
	if(!frm.studNo.value) {
		alert("학번을 입력하세요");
		frm.studNo.focus();
	} else if(!frm.name.value) {
		alert("이름을 입력하세요");
		frm.name.focus();
	} else {
		frm.submit();
	}
}