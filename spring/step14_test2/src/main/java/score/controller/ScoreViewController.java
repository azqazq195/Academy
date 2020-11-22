package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreViewController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		ScoreDAO scoreDAO = new ScoreDAO();
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo);
		
		dto = scoreDAO.getScore(dto);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("studNo", studNo);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("scoreView.jsp");
		return modelAndView;
	}

}








