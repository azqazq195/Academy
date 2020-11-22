package score.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

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
		System.out.println("path = " + path);
		
		// 2. 클라이언트의 요청 path에 따라 분기 처리
		String viewPage = "";
		
		if(path.equals("/scoreWriteForm.do")) {
			viewPage = "scoreWriteForm.jsp";
		} else if(path.equals("/scoreWrite.do")) {
			// 데이터
			request.setCharacterEncoding("UTF-8");	// 한글 설정
			String studNo = request.getParameter("studNo");
			String name = request.getParameter("name");
			int kor = Integer.parseInt(request.getParameter("kor"));
			int eng = Integer.parseInt(request.getParameter("eng"));
			int mat = Integer.parseInt(request.getParameter("mat"));
			int tot = kor + eng + mat;
			double avg = (double)tot / 3;
			
			// DB
			ScoreDTO dto = new ScoreDTO();
			dto.setStudNo(studNo);
			dto.setName(name);
			dto.setKor(kor);
			dto.setEng(eng);
			dto.setMat(mat);
			dto.setTot(tot);
			dto.setAvg(avg);			
			
			ScoreDAO scoreDAO = new ScoreDAO();
			int result = scoreDAO.insertScore(dto);	
			
			// 화면 네비게이션
			request.setAttribute("result", result);
			
			viewPage = "scoreWrite.jsp";
		} else if(path.equals("/scoreList.do")) {
			int pg = Integer.parseInt(request.getParameter("pg"));
			
			// 목록 : 5개씩
			int endNum = pg * 5;
			int startNum = endNum - 4;
			
			ScoreDAO scoreDAO = new ScoreDAO();
			List<ScoreDTO> list = scoreDAO.getScoreList(startNum, endNum);
			
			// 페이징 : 3블럭
			int listCount = scoreDAO.selectListCount();  // 총 저장 데이터 수
			int maxPage = (listCount + 4) / 5;			 // 총 페이지 수
			int startPage = (pg-1)/3*3 + 1;
			int endPage = startPage + 2;
			if(endPage > maxPage) endPage = maxPage;
			
			// 화면 네비게이션
			request.setAttribute("pg", pg);
			request.setAttribute("list", list); 
			request.setAttribute("maxPage", maxPage); 
			request.setAttribute("startPage", startPage); 
			request.setAttribute("endPage", endPage); 
			
			viewPage = "scoreList.jsp";
		} else if(path.equals("/scoreView.do")) {
			// 데이터
			String studNo = request.getParameter("studNo");
			int pg = Integer.parseInt(request.getParameter("pg"));
			// DB
			ScoreDAO scoreDAO = new ScoreDAO();
			ScoreDTO dto = new ScoreDTO();
			dto.setStudNo(studNo);
			
			dto = scoreDAO.getScore(dto);
			
			// 화면 네비게이션
			request.setAttribute("pg", pg);
			request.setAttribute("studNo", studNo);
			request.setAttribute("dto", dto);
						
			viewPage = "scoreView.jsp";
		} else if(path.equals("/scoreDelete.do")) {
			// 데이터
			String studNo = request.getParameter("studNo");
			// DB
			ScoreDAO scoreDAO = new ScoreDAO();
			ScoreDTO dto = new ScoreDTO();
			dto.setStudNo(studNo);
			
			int su = scoreDAO.deleteScore(dto);
			
			// 화면 네비게이션
			request.setAttribute("su", su);						
									
			viewPage = "scoreDelete.jsp";
		}
		
		// 3. 페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}











