package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;

public class LoginAction  implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// DB
		MemberDAO memberDAO = new MemberDAO();
		String name = memberDAO.login(id, pwd);
		// 페이지 이동
		// 세션으로 공유데이터 사용
		if(name != null) {  // 로그인 성공
			// 세션에 데이터 저장
			HttpSession session = request.getSession();
			
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			request.setAttribute("req_page", "../member/loginOk.jsp");
			//response.sendRedirect("loginOk.jsp");
		} else {			// 로그인 실패
			request.setAttribute("req_page", "../member/loginFail.jsp");
			//response.sendRedirect("loginFail.jsp");
		}
		return "../main/index.jsp";
	}

}
