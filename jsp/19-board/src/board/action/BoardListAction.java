package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.bean.PageInfo;
import board.dao.BoardDAO;

public class BoardListAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. 데이터처리
		int page = 1;
		int limit = 10;	// 목록의 갯수 : 5개씩
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		// DB
		// 목록 얻어오기
		int endNum = page * limit;			// 1 * 5 = 5
		int startNum = endNum - (limit - 1);// 5 - (5-1) = 1
		
		BoardDAO boardDAO = new BoardDAO();
		List<BoardBean> list = boardDAO.selectArticleList(startNum, endNum);
		
		// 페이징: 3블럭 표시
		int listCount = boardDAO.selectListCount();    // 총글수 얻기
		int maxPage = (listCount + (limit-1)) / limit; // 총페이지수 계산 : (26 + (5-1)) / 5
		
		// 페이징의 시작페이지 끝페이지 계산
		int startPage = (page-1)/3*3 + 1;
		int endPage = startPage + 2;
		if(endPage > maxPage) endPage = maxPage;
		// 페이징 처리 변수를 한묶음으로 묶음
		PageInfo pageInfo = new PageInfo();
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		//2. 데이터 공유
		request.setAttribute("list", list);
		request.setAttribute("pageInfo", pageInfo);
		//3. view 처리 파일이름 리턴
		String forward = "/board/boardList.jsp";
		return forward;
	}

}
