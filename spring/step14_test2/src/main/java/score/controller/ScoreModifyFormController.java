package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreModifyFormController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2. DB
		ScoreDAO scoreDAO = new ScoreDAO();
		ScoreDTO scoreDTO = new ScoreDTO();
		scoreDTO.setStudNo(studNo);
		scoreDTO = scoreDAO.getScore(scoreDTO);
		
		// 3. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("scoreDTO", scoreDTO);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("scoreModifyForm.jsp");
		return modelAndView;
	}

}







