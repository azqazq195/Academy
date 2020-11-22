$(function() {
	// id 속성이 join인 <form> 태그 안의 submit 버튼을 누른 경우, 이벤트 처리
	$("#join").submit(function() {		
		// 입력검사
		var user_id = $("input[name='user_id']").val();
		if(!user_id) {
			alert("아이디를 입력하세요.");
			$("input[name='user_id']").focus();
			return false;  // submit 동작 무효화
		} else if(!$("input[name='user_pw']").val()) {
			alert("비밀번호를 입력하세요.");
			$("input[name='user_pw']").focus();
			return false; 
		} else if(!$("input[name='jumin_no']").val()) {
			alert("주민번호를 입력하세요.");
			$("input[name='jumin_no']").focus();
			return false; 
		} 
		// 라디오 버튼 입력 검사
		if(!$("input[name='gender']").is(":checked")) {
			alert("성별을 선택하세요.");
			$("input[name='gender']:eq(0)").focus();
			return false;
		} else if(!$("input[name='email']").val()) {
			alert("이메일을 입력하세요.");
			$("input[name='email']").focus();
			return false; 
		} else if(!$("input[name='url']").val()) {
			alert("홈페이지 주소를 입력하세요.");
			$("input[name='url']").focus();
			return false; 
		} else if(!$("input[name='hpno']").val()) {
			alert("핸드폰 번호를 입력하세요.");
			$("input[name='hpno']").focus();
			return false; 
		} 
		// 체크박스 선택여부 검사
		if(!$("input[name='hobby']").is(":checked")) {
			alert("취미를 선택해 주세요.")
			$("input[name='hobby']:eq(0)").focus();
			return false;
		}
		// select 태그의 선택 여부 검사
		if($("select[name='job'] > option:selected").index() < 1) {
			alert("직업을 선택해 주세요.");
			$("select[name='job']").focus();
			return false;
		}
		
		// 입력 내용을 화면에 출력		
		var user_id = $("input[name='user_id']").val();
		var user_pw = $("input[name='user_pw']").val();
		var jumin_no = $("input[name='jumin_no']").val();
		var gender = $("input[name='gender']:checked").val();
		var email = $("input[name='email']").val();
		var url = $("input[name='url']").val();
		var hpno = $("input[name='hpno']").val();
		var job = $("select[name='job'] > option:selected").val();		
		// 체크박스의 선택항목 값들을 추출
		var hobby = $("input[name='hobby']:checked");
		// 추출된 값을 누적하여 저장할 문자열 변수		
		var select_hobby = "";
		//each(function() {}) : 체크박스의 선택된 개수만큼 function()이 실행된다.		
		hobby.each(function() {
			// $(this) : 현재 선택된 태그를 나타냄
			select_hobby += $(this).val() + " ";
		});		
		// 출력할 HTML 문자열 만들기
		var result = "<ul>";
		result += "<li>아이디 : " + user_id + "</li>";
		result += "<li>비밀번호 : " + user_pw + "</li>";
		result += "<li>주민번호 : " + jumin_no + "</li>";
		result += "<li>성별 : " + gender + "</li>";
		result += "<li>이메일 : " + email + "</li>";
		result += "<li>홈페이지 : " + url + "</li>";
		result += "<li>핸드폰번호 : " + hpno + "</li>";
		result += "<li>취미 : " + select_hobby + "</li>";
		result += "<li>직업 : " + job + "</li>";
		result += "</ul>";
				
		$("body").html(result);
		return false; // submit 무효화
	});
});











