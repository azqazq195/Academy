package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction  implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 세션 삭제
		HttpSession session = request.getSession();
		
		session.removeAttribute("memName");
		session.removeAttribute("memId");
		
		session.invalidate();	// 무효화 : 모두 지우기
	 
		request.setAttribute("req_page", "../member/logout.jsp");
		return "../main/index.jsp";
	}

}
