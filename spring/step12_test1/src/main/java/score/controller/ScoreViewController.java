package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreViewController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		ScoreDAO scoreDAO = new ScoreDAO();
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo);
		
		dto = scoreDAO.getScore(dto);
		
		// 화면 네비게이션
		request.setAttribute("pg", pg);
		request.setAttribute("studNo", studNo);
		request.setAttribute("dto", dto);
					
		return "scoreView";		// "scoreView.jsp";
	}

}



