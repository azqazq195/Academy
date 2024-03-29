package community.dao;

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

import community.bean.CommunityDTO;

@Repository
public class CommunityDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 입력내용 저장
	public int communityWrite(CommunityDTO communityDTO) {
		return sqlSession.insert("mybatis.communityMapper.communityWrite", communityDTO);
	}
	
	// 행 삭제
	public int communityDelete(int seq, String user_pwd) {	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("user_pwd", user_pwd);
		return sqlSession.delete("mybatis.communityMapper.communityDelete", map);
	}
	
	// 내용 수정
	public int communityModify(CommunityDTO communityDTO) {
		return sqlSession.update("mybatis.communityMapper.communityModify", communityDTO);
	}
	
	// 목록 확인 : 전체 
	public List<CommunityDTO> communityList() {
		return sqlSession.selectList("mybatis.communityMapper.communityList");
	}
	
	// 목록 확인 : 페이징 처리
	public List<CommunityDTO> communityIndexList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.communityMapper.communityIndexList", map);
	}	
	
	// 상세보기 : 행 한개 내용보기
	public CommunityDTO communitySelect(int seq) {
		return sqlSession.selectOne("mybatis.communityMapper.communitySelect", seq);
	}
}










