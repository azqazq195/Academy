package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;

public class MemberDeleteAction  implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("memId");
		// DB
		MemberDAO memberDAO = new MemberDAO();
		int su = memberDAO.delete(id);
		
		// 세션 삭제
		if(su > 0) {
			session.removeAttribute("memId");
			session.removeAttribute("memName");
		}
		
		// 데이터 공유
		request.setAttribute("su", su);
				
		// 화면 네비게이션
		request.setAttribute("req_page", "../member/delete.jsp");
		return "../main/index.jsp";
	}

}
