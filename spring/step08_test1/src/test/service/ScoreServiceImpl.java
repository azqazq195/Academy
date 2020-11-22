package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.ScoreVO;
import test.dao.ScoreDAOSpring;

@Service
public class ScoreServiceImpl implements ScoreService{
	@Autowired
	ScoreDAOSpring scoreDAOSpring;

	@Override
	public int insertScore(ScoreVO vo) {
		return scoreDAOSpring.insertScore(vo);
	}
	@Override
	public int updateScore(ScoreVO vo) {
		return scoreDAOSpring.updateScore(vo);
	}
	@Override
	public int deleteScore(ScoreVO vo) {
		return scoreDAOSpring.deleteScore(vo);
	}
	@Override
	public List<ScoreVO> getScoreList() {
		return scoreDAOSpring.getScoreList();
	}
	@Override
	public ScoreVO getScore(ScoreVO vo) {
		return scoreDAOSpring.getScore(vo);
	}

}
