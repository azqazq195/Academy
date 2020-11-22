package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));

		/* DB */
		// 1. 목록 가져오기
		// => 1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		BoardDAO boardDAO = new BoardDAO();
		List<BoardDTO> list = boardDAO.boardList(startNum, endNum);
		
		// 2. 페이징 처리
		// => 3블럭
		int totalA = boardDAO.getTotalA();  // 총 글수
		int totalP = (totalA + 4) / 5; 		// 총 페이지수
		int startPage = (pg-1)/3*3 + 1;
		int endPage = startPage + 2;
		if(endPage > totalP) endPage = totalP;
		
		// 화면 네비게이션 : 데이터 공유 + view 처리 파일
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.setViewName("../board/boardList.jsp");
		return modelAndView;
	}
}







