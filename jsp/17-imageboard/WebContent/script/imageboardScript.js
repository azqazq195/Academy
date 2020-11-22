function checkImageboardWrite() {
	var frm = document.imageboardWriteForm;
	
	if(!frm.imageId.value || frm.imageId.value == "img_") {
		alert("상품코드를 입력하세요.");
		frm.imageId.focus();
	} else if(!frm.imageName.value) {
		alert("상품명을 입력하세요.");
		frm.imageName.focus();
	} else if(!frm.imagePrice.value) {
		alert("상품가격을 입력하세요.");
		frm.imagePrice.focus();
	} else if(!frm.imageQty.value) {
		alert("상품개수를 입력하세요.");
		frm.imageQty.focus();
	} else if(!frm.imageContent.value) {
		alert("상품내용을 입력하세요.");
		frm.imageContent.focus();
	} else if(!frm.image1.value) {
		alert("파일을 선택하세요");
		frm.image1.focus();
	} else {
		frm.submit();
	} 
}

function checkImageboardModify() {
	var frm = document.imageboardModifyForm;
	
	if(!frm.imageId.value || frm.imageId.value == "img_") {
		alert("상품코드를 입력하세요.");
		frm.imageId.focus();
	} else if(!frm.imageName.value) {
		alert("상품명을 입력하세요.");
		frm.imageName.focus();
	} else if(!frm.imagePrice.value) {
		alert("상품가격을 입력하세요.");
		frm.imagePrice.focus();
	} else if(!frm.imageQty.value) {
		alert("상품개수를 입력하세요.");
		frm.imageQty.focus();
	} else if(!frm.imageContent.value) {
		alert("상품내용을 입력하세요.");
		frm.imageContent.focus();
	} else {
		frm.submit();
	} 
}

function reset1() {
	var frm = document.imageboardModifyForm;
	frm.imageId.value = "";
	frm.imageName.value = "";
	frm.imagePrice.value = "";
	frm.imageQty.value = "";
	frm.imageContent.value = "";
}








