package com.example.a9_patterncheckerexam.helper;

import java.util.regex.Pattern;

public class RegexHelper {
    String numberPattern = "^[0-9]*$";
    String englishPattern = "^[a-zA-Z]*$";
    String koreanPattern = "^[가-힣]*$";
    String engnumPattern = "^[a-zA-Z0-9]*$";
    String kornumPattern = "^[가-힣0-9]*$";
    String emailPattern = "^[a-zA-Z0-9._%+-]+@[A-Za-z0-9.-]+\\.[a-zA-Z0-9]+$";
    String phonePattern = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$";

    // 싱글톤 패턴 시작
    private  static RegexHelper instance = null;
    public static RegexHelper getInstance(){
        if(instance == null) instance = new RegexHelper();

        return instance;
    }

    // 생성자를 private으로 작성하면, new에 의한 객체 생성이 불가능
    private RegexHelper() {
    }
    // 싱글톤 패턴 끝

    // 주어진 문자열이 공백이거나 null인지를 검사
    public boolean isValue(String str){
        boolean result = false;
        if(str != null){
            result = !str.trim().equals("");
        }
        return result;
    }

    // 숫자 모양에 대한 형식 검사
    public boolean isNum(String str){
        boolean result = false;
        if(isValue(str)){
            result = Pattern.matches(numberPattern, str);
        }
        return result;
    }

    // 영문으로만 구성되었는지에 대한 형식 검사
    public boolean isEng(String str){
        boolean result = false;
        if(isValue(str)){
            result = Pattern.matches(englishPattern, str);
        }
        return result;
    }

    // 한글로만 구성되었는지에 대한 형식 검사
    public boolean isKor(String str){
        boolean result = false;
        if(isValue(str)){
            result = Pattern.matches(koreanPattern, str);
        }
        return result;
    }

    // 영어와 숫자로만 구성되었는지에 대한 형식 검사
    public boolean isEngNum(String str){
        boolean result = false;
        if(isValue(str)){
            result = Pattern.matches(engnumPattern, str);
        }
        return result;
    }

    // 한글과 숫자로만 구성되었는지에 대한 형식 검사
    public boolean isKorNum(String str){
        boolean result = false;
        if(isValue(str)){
            result = Pattern.matches(kornumPattern, str);
        }
        return result;
    }

    // 이메일 형식인지에 대한 검사
    public boolean isEmail(String str){
        boolean result = false;
        if(isValue(str)){
            result = Pattern.matches(emailPattern, str);
        }
        return result;
    }

    // 핸드폰 번호인지에 대한 검사
    public boolean isPhone(String str){
        boolean result = false;
        if(isValue(str)){
            result = Pattern.matches(phonePattern, str);
        }
        return result;
    }
}
