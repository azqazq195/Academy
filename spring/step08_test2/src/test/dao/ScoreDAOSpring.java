package test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import test.bean.ScoreVO;

// aop around로 동작함
@Transactional
@Repository
public class ScoreDAOSpring {	
	@Autowired
	private SqlSessionTemplate sqlSession;	
	
	/** crud 기능의 메소드 구현 **/
	// 성적 등록
	public int insertScore(ScoreVO vo) {		
		return sqlSession.insert("mybatis.scoreMapper.insertScore", vo);
	}	
	// 성적 수정
	public int updateScore(ScoreVO vo) {		
		return sqlSession.update("mybatis.scoreMapper.updateScore", vo);		
	}	
	// 성적 삭제
	public int deleteScore(ScoreVO vo) {		
		return sqlSession.delete("mybatis.scoreMapper.deleteScore", vo);
	}	
	// 성적 목록보기
	public List<ScoreVO> getScoreList() {
		return sqlSession.selectList("mybatis.scoreMapper.getScoreList");
	}	
	// 성적 상세보기
	public ScoreVO getScore(ScoreVO vo) {		
		return sqlSession.selectOne("mybatis.scoreMapper.getScore", vo);
	}
}







