function check() {
	var form = document.writeForm;
		
	if(!form.bookCode.value) {
		alert('코드를 입력하세영');
		form.bookCode.focus();
	}
	else if(!form.bookName.value) {
		alert('제목을 입력하세영');
		form.bookName.focus();
	}
	else if(!form.artist.value) {
		alert('작가를 입력하세영');
		form.artist.focus();
	}
	else if(!form.publisher.value) {
		alert('출판사를 입력하세영');
		form.publisher.focus();
	}
	else if(!form.bookPrice.value) {
		alert('가격을 입력하세영');
		form.bookPrice.focus();
	}
	
	else if(confirm('입력하신 내용이 맞습니까?')) {
			form.submit();
	}
}