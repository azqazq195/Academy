package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteFormAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("req_page", "board/boardDelete.jsp");
		return "index.jsp";
	}

}
