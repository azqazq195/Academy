package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;

public class BoardDeleteProAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		int page = Integer.parseInt(request.getParameter("page"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String pw = request.getParameter("pw");
		// 2. DB
		BoardDAO boardDAO = new BoardDAO();
		// 글쓴이 인지 확인
		boolean isWriter = boardDAO.isArticleBoardWriter(board_num, pw);
		int deleteCount = 0;
		
		if(isWriter) {  // 비밀번호가 맞으면
			deleteCount = boardDAO.deleteArticle(board_num); // 글 삭제
		}
		// 3. 데이터 공유		
		// 4. view 처리 파일 이름 리턴
		String forward = null;
		if(deleteCount > 0) { // 삭제 성공
			forward = "boardList.do?page=" + page;
		} else { // 삭제 실패
			forward = "boardDetail.do?page=" + page + "&board_num=" + board_num;
		}
		return forward;
	}

}


