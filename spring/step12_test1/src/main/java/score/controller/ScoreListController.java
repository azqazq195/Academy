package score.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		
		return "scoreList";		// "scoreList.jsp";
	}

}










