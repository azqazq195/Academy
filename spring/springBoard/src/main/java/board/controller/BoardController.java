package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/boardWriteForm.do")
	public ModelAndView boardWriteForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("display", "../board/boardWriteForm.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;		
	}
	@RequestMapping(value = "/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request) throws IOException {
		// 데이터
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String name = (String)session.getAttribute("memName");
		String id = (String)session.getAttribute("memId");
		// DB
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		boardDTO.setName(name);
		boardDTO.setId(id);
		
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardWrite(boardDTO);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.addObject("display", "../board/boardWrite.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("boardWrite.jsp");
		return modelAndView;
	}
	@RequestMapping(value = "/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request) {
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));

		// 목록보기 => 1페이지당 몇개의 목록을 보여줄지를 설정해야함.
		// 1페이지당 5개씩
		// pg=1 : rn>=1 and rn<=5
		// pg=2 : rn>=6 and rn<=10
		// pg=3 : rn>=11 and rn<=15
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		//BoardDAO boardDAO = new BoardDAO();
		List<BoardDTO> list = boardService.boardList(startNum, endNum);
		
		// 페이징 처리 : 1페이지당 목록5개표시
		// 총글수 : 12
		// 총페이지수 : 3       [1][2][3]   => (총글수+4)/5
			
		// 총글수 : 23
		// 총페이지수 : 5       [1][2][3][4][5]   => (총글수+4)/5
		
		// 총글수 : 25
		// 총페이지수 : 5       [1][2][3][4][5]   => (총글수+4)/5
		int totalA = boardService.getTatalA();	// 총글수 구하기
		int totalP = (totalA + 4) / 5;		// 총페이지수 계산
		
		/** 페이지 번호를 몇개씩 보여줄지 설정 **/
		// 3블럭 표시
		// 총페이지수 : 8
		//		[1][2][3][다음]
		// [이전][4][5][6][다음]
		// [이전][7][8]
		// startPage 계산 결과
		// (1-1)/3*3 + 1 => 1, (2-1)/3*3 + 1 => 1, (3-1)/3*3 + 1 => 1
		// (4-1)/3*3 + 1 => 4, (5-1)/3*3 + 1 => 4, (6-1)/3*3 + 1 => 4
		int startPage = (pg-1)/3*3 + 1;  
		int endPage = startPage + 2;
		if(endPage > totalP) endPage = totalP;
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("list", list);
		modelAndView.addObject("display", "../board/boardList.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("boardList.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		//BoardDAO boardDAO = new BoardDAO();
		// 조회수 증가
		boardService.updateHit(seq);
		BoardDTO boardDTO = boardService.boardView(seq);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.addObject("display", "../board/boardView.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("boardView.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardModifyForm.do")
	public ModelAndView boardModifyForm(HttpServletRequest request) {
		//데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB 
		// 1줄 데이터 얻어옴
		//BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = boardService.boardView(seq);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("boardDTO", boardDTO);
		modelAndView.addObject("display", "../board/boardModifyForm.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("boardModifyForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardModify.do")
	public ModelAndView boardModify(HttpServletRequest request) throws Exception {
		// 데이터
		request.setCharacterEncoding("utf-8");  // 한글 엔코딩 설정
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		boardDTO.setSeq(seq);
		
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardModify(boardDTO);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("su", su);
		//modelAndView.setViewName("boardModify.jsp");
		modelAndView.addObject("display", "../board/boardModify.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		//BoardDAO boardDAO = new BoardDAO();
		int su = boardService.boardDelete(seq);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("su", su);
		modelAndView.addObject("display", "../board/boardDelete.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("boardDelete.jsp");
		return modelAndView;
	}
}















