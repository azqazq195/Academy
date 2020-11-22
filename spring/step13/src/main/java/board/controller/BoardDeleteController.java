package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;

public class BoardDeleteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		BoardDAO boardDAO = new BoardDAO();
		int su = boardDAO.boardDelete(seq);
		
		// 화면 네비게이션
		request.setAttribute("pg", pg);
		request.setAttribute("su", su);
		
		return "boardDelete";		// "../board/boardDelete.jsp";
	}

}








