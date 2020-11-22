function doSubmit() {
  var tb = document.table;

  if (!tb.user_name.value) {
    alert("이름을 입력해 주세요");
    tb.user_name.focus();
    return false; // 함수 강제 종료
  } else if (!tb.user_id.value) {
    alert("아이디를 입력해 주세요");
    tb.user_id.focus();
    return false; // 함수 강제 종료
  } else if (!tb.user_pw.value) {
    alert("비밀번호를 입력해 주세요");
    tb.user_pw.focus();
    return false; // 함수 강제 종료
  } else if (tb.user_pw.value != tb.user_pwCheck.value) {
    alert("비밀번호가 맞지 않습니다.");
    tb.user_pwCheck.focus();
    return false; // 함수 강제 종료
  } else if (!tb.gender[0].checked && !tb.gender[0].checked) {
    alert("성별을 입력해 주세요");
    tb.gender[0].checked = true;
    return false; // 함수 강제 종료
  } else if (!tb.user_email1.value) {
    alert("이메일을 입력해 주세요");
    tb.user_email1.focus();
    return false; // 함수 강제 종료
  } else if (!tb.user_phone2.value) {
    alert("휴대폰을 입력해 주세요");
    tb.user_phone2.focus();
    return false; // 함수 강제 종료
  } else if (!tb.user_phone3.value) {
    alert("휴대폰을 입력해 주세요");
    tb.user_phone3.focus();
    return false; // 함수 강제 종료
  } else if (confirm("입력하신 내용이 맞습니까?")) {
    tb.submit();
  }
}
