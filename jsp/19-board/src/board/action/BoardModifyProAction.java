package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyProAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		int page = Integer.parseInt(request.getParameter("page"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String board_pass = request.getParameter("board_pass");
		String board_subject = request.getParameter("board_subject");
		String board_content = request.getParameter("board_content");
		// 2. DB 
		BoardDAO boardDAO = new BoardDAO();
		// 글쓴이인지 확인
		System.out.println("board_pass : " + board_pass);
		boolean isRightUser = boardDAO.isArticleBoardWriter(board_num, board_pass);
		String forward = null;
		int updateCount = 0;
		
		if(isRightUser) {  // 비밀번호 맞음
			// 수정
			BoardBean boardBean = new BoardBean();
			boardBean.setBoard_num(board_num);
			boardBean.setBoard_subject(board_subject);
			boardBean.setBoard_content(board_content);
			updateCount = boardDAO.updateArticle(boardBean);
			
			if(updateCount > 0) { // 수정 성공
				forward = "boardDetail.do?board_num=" + board_num + "&page=" + page;
			} else { // 수정 실패 : jsp파일을 만들어서 해도 되지만. 간단한 HTML 문서는 여기서 처리해도 됨
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패')");
				out.println("history.back()");
				out.println("</script>");
			}
		} else { // 비밀번호 다름
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}		
		// 3. 데이터 공유		
		// 4. view 처리 파일 이름 리턴
		// => ~.jsp : 최종 결과를 보여주기 위함
		// => ~.do : 데이터 처리할 게 있음
		return forward;
	}

}
