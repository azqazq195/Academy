package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class MemberModifyFormReadyAction  implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("memId");
		// DB : 1명 데이터 가져오기
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberDAO.getMember(id);
		
		// 데이터 공유
		request.setAttribute("memberDTO", memberDTO);
		
		// 화면 네비게이션
		request.setAttribute("req_page", "../member/modifyForm.jsp");
		return "../main/index.jsp";
	}

}
