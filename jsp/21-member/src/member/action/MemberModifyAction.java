package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class MemberModifyAction  implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 한글 설정
		request.setCharacterEncoding("utf-8");
		// 데이터 처리
		String name = request.getParameter("name");
		//String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		// DB 처리
		HttpSession session = request.getSession();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId((String)session.getAttribute("memId"));
		memberDTO.setPwd(pwd);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setAddr(addr);
		
		MemberDAO memberDAO = new MemberDAO();
		int su = memberDAO.modify(memberDTO);
		// 데이터 공유
		request.setAttribute("su", su);
		
		// 화면 네비게이션
		request.setAttribute("req_page", "../member/modify.jsp");
		return "../main/index.jsp";
	}

}
