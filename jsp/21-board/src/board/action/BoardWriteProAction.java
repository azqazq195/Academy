package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardWriteProAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. 데이터처리
		String realFolder = "";
		String saveFolder = "/boardUpload";
		int fileSize = 5*1024*1024;
		
		realFolder = request.getServletContext().getRealPath(saveFolder);
		// 파일 저장
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8", 
													new DefaultFileRenamePolicy());
		// 파라미터값 얻기
		BoardBean boardBean = new BoardBean();
		boardBean.setBoard_name(multi.getParameter("board_name"));
		boardBean.setBoard_pass(multi.getParameter("board_pass"));
		boardBean.setBoard_subject(multi.getParameter("board_subject"));
		boardBean.setBoard_content(multi.getParameter("board_content"));
		boardBean.setBoard_file(multi.getOriginalFileName("board_file"));
		// DB
		BoardDAO boardDAO = new BoardDAO();
		int insertCount = boardDAO.insertArticle(boardBean);
		//2. 데이터 공유
		// => 간단한 것은 굳이 jsp파일에서 작업을 안하고 여기서 HTML 문서 작업을 함
		String forward = null;
		if(insertCount == 0) {  // 저장 실패
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록 실패');");
			out.println("history.back();");
			out.println("</script>");
		} else {				// 저장 성공
			forward = "boardList.do";
		}
		//3. view 처리 파일이름 리턴
		return forward;
	}

}
