package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.bean.MemberDTO;
@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 데이터 추가하기
	public int write(MemberDTO memberDTO) {		
		return sqlSession.insert("mybatis.member.write", memberDTO);
	}
	// 회원정보 수정
	public int modify(MemberDTO memberDTO) {		
		return sqlSession.update("mybatis.member.modify", memberDTO);
	}
	// 로그인 처리
	public String login(String id, String pwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		return sqlSession.selectOne("mybatis.member.login", map);
	}
	// id 확인
	public boolean isExistId(String id) {
		boolean exist = false;		
		if(sqlSession.selectOne("mybatis.member.isExistId", id) != null) {
			exist = true;
		}
		return exist;
	}
	// 1명데이터 가져오기
	public MemberDTO getMember(String id) {
		return sqlSession.selectOne("mybatis.member.getMember", id);
	}
	// 회원 5명씩 데이터 얻기
	public List<MemberDTO> selectList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.member.selectList", map);
	}
	// 총회원수 구하기
	public int getTotalMember() {
		return sqlSession.selectOne("mybatis.member.getTotalMember");
	}
	// 회원 삭제
	public int delete(String id) {
		return sqlSession.delete("mybatis.member.delete", id);
	}
}











