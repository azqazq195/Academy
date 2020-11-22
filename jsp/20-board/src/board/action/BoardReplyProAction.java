package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardReplyProAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardBean boardBean = new BoardBean();
		boardBean.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		boardBean.setBoard_name(request.getParameter("board_name"));
		boardBean.setBoard_pass(request.getParameter("board_pass"));
		boardBean.setBoard_subject(request.getParameter("board_subject"));
		boardBean.setBoard_content(request.getParameter("board_content"));
		boardBean.setBoard_re_ref(Integer.parseInt(request.getParameter("board_re_ref")));
		boardBean.setBoard_re_lev(Integer.parseInt(request.getParameter("board_re_lev")));
		boardBean.setBoard_re_seq(Integer.parseInt(request.getParameter("board_re_seq")));
		
		// 2. DB
		BoardDAO boardDAO = new BoardDAO();
		int insertCount = boardDAO.insertReplyArticle(boardBean);
		// 3. 데이터 공유		
		// 4. view 처리 파일 이름 리턴 : 1) ~.jsp   2) ~.do
		String forward = null;
		
		if(insertCount > 0) { // 답글 저장 성공
			forward = "boardList.do?page=" + page;
		} else { // 답글 저장 실패
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답글 저장 실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
