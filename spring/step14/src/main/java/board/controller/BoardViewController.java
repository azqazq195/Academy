package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB
		BoardDAO boardDAO = new BoardDAO();	
		boardDAO.updateHit(seq); // 조회수 증가
		BoardDTO boardDTO = boardDAO.boardView(seq);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.setViewName("../board/boardView.jsp"); 
		
		return modelAndView;
	}

}






