package member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class MemberListAction  implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));

		/** DB **/	
		// 목록은 5개씩
		// pg=1 : rn>=1 and rn<=5
		// pg=2 : rn>=6 and rn<=10 : 10 -> pg * 5
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		MemberDAO memberDAO = new MemberDAO();
		List<MemberDTO> list = memberDAO.selectList(startNum, endNum);
		
		// 페이징 처리
		// 총페이지수 = (총회원수 + 4) / 5;
		int totalMember = memberDAO.getTotalMember();	// 총회원수
		int totalP = (totalMember + 4) / 5;				// 총페이지수
		// 3블럭으로 나눠서 보여주기
		// 총페이지수 : 8
		// 		[1][2][3][다음]
		// [이전][4][5][6][다음]
		// [이전][7][8]
		// pg=1 : (1-1)/3*3 + 1 -> 1
		// pg=2 : (2-1)/3*3 + 1 -> 1
		// pg=3 : (3-1)/3*3 + 1 -> 1
		// pg=4 : (4-1)/3*3 + 1 -> 4
		// pg=5 : (5-1)/3*3 + 1 -> 4
		// pg=6 : (6-1)/3*3 + 1 -> 4
		int startPage = (pg-1)/3*3 + 1;
		int endPage = startPage + 2;
		if(endPage > totalP) endPage = totalP;
		
		// 데이터 공유
		request.setAttribute("pg", pg);
		request.setAttribute("list", list);
		request.setAttribute("totalP", totalP);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		// 화면 네비게이션
		request.setAttribute("req_page", "../member/memberList.jsp");
		return "../main/index.jsp";
	}

}





