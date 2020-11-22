package board.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardWriteController{

	@RequestMapping(value = "/board/boardWrite.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터 처리
		// 한글 설정
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");

		// DB
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setName(name);
		boardDTO.setId(id);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		int su = boardDAO.boardWrite(boardDTO);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.setViewName("../board/boardWrite.jsp");
		
		return modelAndView;
	}

}






