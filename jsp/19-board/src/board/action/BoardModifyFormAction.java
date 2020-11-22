package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyFormAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int page = Integer.parseInt(request.getParameter("page"));
		// 2. DB
		BoardDAO boardDAO = new BoardDAO();
		BoardBean boardBean = boardDAO.selectArticle(board_num);
		// 3. 데이터 공유
		request.setAttribute("page", page); 
		request.setAttribute("boardBean", boardBean);
		// 4. view 처리 파일이름 리턴
		return "/board/board_modify.jsp";
	}

}
