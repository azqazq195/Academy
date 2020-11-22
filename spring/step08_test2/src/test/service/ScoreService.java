package test.service;

import java.util.List;

import test.bean.ScoreVO;

public interface ScoreService {
	/** crud 기능의 메소드 구현 **/
	// 성적 등록
	public int insertScore(ScoreVO vo);	
	// 성적 수정
	public int updateScore(ScoreVO vo);	
	// 성적 삭제
	public int deleteScore(ScoreVO vo);	
	// 성적 목록보기
	public List<ScoreVO> getScoreList();	
	// 성적 상세보기
	public ScoreVO getScore(ScoreVO vo);
}





