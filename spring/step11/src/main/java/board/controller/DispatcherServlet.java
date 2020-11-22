package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import member.dao.MemberDAO;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트의 요청 path 정보 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		// uri = /step11/member/login.do
		// path = /login.do
		System.out.println("uri = " + uri);
		System.out.println("path = " + path);
		
		// 2. 클라이넡의 요청 path에 따른 분기 처리
		// => if-else 방식
		String viewPage = "";  // jsp 파일이름 저장
		
		if(path.equals("/login.do")) {
			// 데이터 읽기
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			// DB
			MemberDAO memberDAO = new MemberDAO();
			String name = memberDAO.login(id, pwd);
			// 화면 네비게이션
			if(name == null) { // 로그인 실패
				//response.sendRedirect("loginForm.jsp");
				viewPage = "loginForm.jsp";
			} else {  // 로그인 성공
				HttpSession session = request.getSession();
				session.setAttribute("memId", id);
				session.setAttribute("memName", name);
				// 폴더 이름을 바꾸기 위해서 sendRedirect를 사용
				response.sendRedirect("../board/boardList.do?pg=1");
				return;
				//viewPage = "/board/boardList.do?pg=1";
			}
		} else if(path.equals("/boardWriteForm.do")) {
			viewPage = "../board/boardWriteForm.jsp";
		} else if(path.equals("/boardWrite.do")) {
			// 데이터 처리
			// 한글 설정
			request.setCharacterEncoding("UTF-8");
			
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
			request.setAttribute("su", su); 
			
			viewPage = "../board/boardWrite.jsp";
		} else if(path.equals("/boardDelete.do")) {
			// 데이터
			int seq = Integer.parseInt(request.getParameter("seq"));
			int pg = Integer.parseInt(request.getParameter("pg"));
			// DB
			BoardDAO boardDAO = new BoardDAO();
			int su = boardDAO.boardDelete(seq);
			
			// 화면 네비게이션
			request.setAttribute("pg", pg);
			request.setAttribute("su", su);
			
			viewPage = "../board/boardDelete.jsp";
		} else if(path.equals("/boardView.do")) {
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
			
			viewPage = "../board/boardView.jsp";
		} else if(path.equals("/boardList.do")) {
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
			request.setAttribute("pg", pg);
			request.setAttribute("list", list);
			request.setAttribute("totalP", totalP);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			
			viewPage = "../board/boardList.jsp";
		}
		
		// 3. 페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}












