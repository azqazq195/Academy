package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreDeleteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		String studNo = request.getParameter("studNo");
		// DB
		ScoreDAO scoreDAO = new ScoreDAO();
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo);
		
		int su = scoreDAO.deleteScore(dto);
		
		// 화면 네비게이션
		request.setAttribute("su", su);						
								
		return "scoreDelete";		// "scoreDelete.jsp";
	}

}






