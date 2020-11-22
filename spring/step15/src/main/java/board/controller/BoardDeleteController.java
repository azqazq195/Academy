package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import board.dao.BoardDAO;

@Controller
public class BoardDeleteController{

	@RequestMapping(value = "/board/boardDelete.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		BoardDAO boardDAO = new BoardDAO();
		int su = boardDAO.boardDelete(seq);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("su", su);
		modelAndView.setViewName("../board/boardDelete.jsp");
		
		return modelAndView;
	}

}








