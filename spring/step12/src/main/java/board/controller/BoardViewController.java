package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB
		BoardDAO boardDAO = new BoardDAO();	
		boardDAO.updateHit(seq); // 조회수 증가
		BoardDTO boardDTO = boardDAO.boardView(seq);
		
		// 화면 네비게이션
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg); 
		request.setAttribute("boardDTO", boardDTO); 
		
		return "boardView";		// "../board/boardView.jsp";
	}

}






