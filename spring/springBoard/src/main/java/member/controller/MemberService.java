package member.controller;

import java.util.List;
import member.bean.MemberDTO;

public interface MemberService {
	// 데이터 추가하기
	public int write(MemberDTO memberDTO);
	// 회원정보 수정
	public int modify(MemberDTO memberDTO);
	// 로그인 처리
	public String login(String id, String pwd);
	// id 확인
	public boolean isExistId(String id);
	// 1명데이터 가져오기
	public MemberDTO getMember(String id);
	// 회원 5명씩 데이터 얻기
	public List<MemberDTO> selectList(int startNum, int endNum);
	// 총회원수 구하기
	public int getTotalMember();
	// 회원 삭제
	public int delete(String id);
}





