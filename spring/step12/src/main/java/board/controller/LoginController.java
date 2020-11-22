package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터 읽기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// DB
		MemberDAO memberDAO = new MemberDAO();
		String name = memberDAO.login(id, pwd);
		// 화면 네비게이션
		if(name == null) { // 로그인 실패
			return "loginForm";		//"loginForm.jsp";
		} else {  // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);
			session.setAttribute("memName", name);			
			return "../board/boardList.do?pg=1";			
		}		
	}

}
