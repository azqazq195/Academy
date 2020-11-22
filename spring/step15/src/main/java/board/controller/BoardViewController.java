package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardViewController{

	@RequestMapping(value = "/board/boardView.do")
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






