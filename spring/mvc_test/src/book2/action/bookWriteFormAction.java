package book2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class bookWriteFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("req_page", "../book2/bookWriteForm.jsp");
		return "../main/book2Index.jsp";
	}
	
}
