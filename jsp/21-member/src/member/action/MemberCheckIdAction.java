package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

public class MemberCheckIdAction  implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 처리
		String id = request.getParameter("id");
		// DB 처리
		MemberDAO memberDAO = new MemberDAO();
		boolean exist = memberDAO.isExistId(id); // true : id가 있음, 사용불가
												 // false: id가 없음, 사용가능
		// 데이터 공유
		request.setAttribute("id", id);
		request.setAttribute("exist", exist); 
		// 화면이동
		return "../member/checkId.jsp";
	}

}

