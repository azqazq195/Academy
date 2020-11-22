package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDeleteFormAction  implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 화면 네비게이션
		request.setAttribute("req_page", "../member/deleteForm.jsp");
		return "../main/index.jsp";
	}

}
