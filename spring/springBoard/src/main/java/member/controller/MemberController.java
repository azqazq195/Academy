package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/main/index.do")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:../main/index.jsp");
		return modelAndView;
	}
	@RequestMapping(value = "/member/writeForm.do")
	public ModelAndView writeForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("display", "../member/writeForm.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}
	@RequestMapping(value = "/member/write.do")
	public ModelAndView write(HttpServletRequest request) throws IOException{
		// 한글 설정
		request.setCharacterEncoding("utf-8");
		// 데이터 처리
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String addr = request.getParameter("addr");
		// DB 처리
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setAddr(addr);
		
		//MemberDAO memberDAO = new MemberDAO();
		int su = memberService.write(memberDTO);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.addObject("display", "../member/write.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("write.jsp");
		return modelAndView;
	}
	@RequestMapping(value = "/member/loginForm.do")
	public String loginForm() {
		return "loginForm.jsp";
	}
	@RequestMapping(value = "/member/login.do")
	public ModelAndView login(HttpServletRequest request) {
		// 데이터 처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// DB
		//MemberDAO memberDAO = new MemberDAO();
		String name = memberService.login(id, pwd);
		// 페이지 이동
		// 세션으로 공유데이터 사용
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		
		if(name != null) {  // 로그인 성공
			// 세션에 데이터 저장
			HttpSession session = request.getSession();
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			
			modelAndView.addObject("display", "../template/body.jsp");
			modelAndView.setViewName("../main/index.jsp");
			//modelAndView.setViewName("loginOk.jsp");
		} else {			// 로그인 실패
			modelAndView.addObject("display", "../member/loginFail.jsp");
			modelAndView.setViewName("../main/index.jsp");
			//modelAndView.setViewName("loginFail.jsp");
		}
		return modelAndView;
	}
	@RequestMapping(value = "/member/logout.do")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 세션 삭제
		session.removeAttribute("memName");
		session.removeAttribute("memId");
		
		session.invalidate();	// 무효화 : 모두 지우기
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("display", "../template/body.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("logout.jsp");
		return modelAndView;
	}
	@RequestMapping(value = "/member/checkId.do")
	public ModelAndView checkId(HttpServletRequest request) {
		// 데이터 처리
		String id = request.getParameter("id");
		// DB 처리
		//MemberDAO memberDAO = new MemberDAO();
		boolean exist = memberService.isExistId(id); // true : id가 있음, 사용불가
												 // false: id가 없음, 사용가능
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", id);
		modelAndView.addObject("exist", exist);
		modelAndView.setViewName("checkId.jsp");
		return modelAndView;
	}
	@RequestMapping(value = "/member/modifyForm.do")
	public ModelAndView modifyForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		// DB : 1명 데이터 가져오기
		//MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberService.getMember(id);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("memberDTO", memberDTO);
		modelAndView.addObject("display", "../member/modifyForm.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("modifyForm.jsp");
		return modelAndView;
	}
	@RequestMapping(value = "/member/modify.do")
	public ModelAndView modify(HttpServletRequest request) throws IOException{
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
		
		//MemberDAO memberDAO = new MemberDAO();
		int su = memberService.modify(memberDTO);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.addObject("display", "../member/modify.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("modify.jsp");
		return modelAndView;
	}
	@RequestMapping(value = "/member/memberList.do")
	public ModelAndView memberList(HttpServletRequest request) {
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));

		/** DB **/	
		// 목록은 5개씩
		// pg=1 : rn>=1 and rn<=5
		// pg=2 : rn>=6 and rn<=10 : 10 -> pg * 5
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		//MemberDAO memberDAO = new MemberDAO();
		List<MemberDTO> list = memberService.selectList(startNum, endNum);
		
		// 페이징 처리
		// 총페이지수 = (총회원수 + 4) / 5;
		int totalMember = memberService.getTotalMember();	// 총회원수
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
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("list", list);
		modelAndView.addObject("display", "../member/memberList.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("memberList.jsp");
		return modelAndView;
	}
	@RequestMapping(value = "/member/deleteForm.do")
	public ModelAndView deleteForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("display", "../member/deleteForm.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/delete.do")
	public ModelAndView delete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");
		// DB
		//MemberDAO memberDAO = new MemberDAO();
		int su = memberService.delete(id);
		
		// 세션 삭제
		if(su > 0) {
			session.removeAttribute("memId");
			session.removeAttribute("memName");
		}
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		modelAndView.addObject("display", "../member/delete.jsp");
		modelAndView.setViewName("../main/index.jsp");
		//modelAndView.setViewName("delete.jsp");
		return modelAndView;
	}
}




















