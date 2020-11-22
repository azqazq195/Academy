package test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

@Repository
public class ScoreDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// sql 명령어들
	String score_insert = "insert into score values (?,?,?,?,?,?,?,sysdate)";
	String score_update = "update score set kor=?,eng=?,mat=?,tot=?,avg=? " 
						+ " where studno=?";
	String score_delete = "delete score where studno=?";
	String score_get = "select * from score where studno=?";
	String score_list = "select * from score";
	
	/** crud 기능의 메소드 구현 **/
	// 성적 등록
	public int insertScore(ScoreVO vo) {
		Object[] args = {vo.getStudNo(), vo.getName(), vo.getKor(), vo.getEng(),
					vo.getMat(), vo.getTot(), vo.getAvg()};
		return jdbcTemplate.update(score_insert, args);
	}
	
	// 성적 수정
	public int updateScore(ScoreVO vo) {
		Object[] args = {vo.getKor(), vo.getEng(), vo.getMat(), 
		         vo.getTot(), vo.getAvg(), vo.getStudNo()};
		return jdbcTemplate.update(score_update, args);		
	}
	
	// 성적 삭제
	public int deleteScore(ScoreVO vo) {
		Object[] args = {vo.getStudNo()};
		return jdbcTemplate.update(score_delete, args);
	}
	
	// 성적 목록보기
	public List<ScoreVO> getScoreList() {
		return jdbcTemplate.query(score_list, new ScoreRowMapper());
	}
	
	// 성적 상세보기
	public ScoreVO getScore(ScoreVO vo) {
		Object[] args = {vo.getStudNo()};
		return jdbcTemplate.queryForObject(score_get, args, new ScoreRowMapper());
	}
}







