package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.ScoreVO;
import test.dao.ScoreDAO;
/*
	<bean id="scoreService" class="test.service.ScoreServiceImpl">
		<property name="scoreDAO" ref="scoreDAO">
	</bean>
	=>
	main() 함수에서 일반적인 방법으로 객체 생성을 할 경우
	
	ScoreServiceImpl scoreService = new ScoreServiceImpl();
	scoreService.setScoreDAO(scoreDAO);
*/
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{
	@Autowired
	ScoreDAO scoreDAO;

	@Override
	public int insertScore(ScoreVO vo) {
		return scoreDAO.insertScore(vo);
	}
	@Override
	public int updateScore(ScoreVO vo) {
		return scoreDAO.updateScore(vo);
	}
	@Override
	public int deleteScore(ScoreVO vo) {
		return scoreDAO.deleteScore(vo);
	}
	@Override
	public List<ScoreVO> getScoreList() {
		return scoreDAO.getScoreList();
	}
	@Override
	public ScoreVO getScore(ScoreVO vo) {
		return scoreDAO.getScore(vo);
	}
}
