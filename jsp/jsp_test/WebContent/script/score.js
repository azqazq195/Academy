function check(){
	var frm = document.scoreInputForm;
	
	if(!frm.hak.value){
		alert("학번을 입력해주세요");
		return false;
	} else if(!frm.name.value){
		alert("이름을 입력해주세요");
		return false;
	} else {
		frm.submit();
	}
		
}