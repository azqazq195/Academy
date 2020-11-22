package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

@Controller
public class ScoreModifyController{

	@RequestMapping(value = "/score/scoreModify.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터
		request.setCharacterEncoding("UTF-8");  // 한글 설정
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		int pg = Integer.parseInt(request.getParameter("pg"));
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int tot = kor + eng + mat;
		double avg = (double)tot / 3;
		
//		System.out.println("studNo = " + studNo);
//		System.out.println("name = " + name);
//		System.out.println("pg = " + pg);
//		System.out.println("kor = " + kor);
//		System.out.println("eng = " + eng);
//		System.out.println("mat = " + mat);
		
		// 2. DB
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo); 
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		dto.setTot(tot);
		dto.setAvg(avg);
		
		ScoreDAO scoreDAO = new ScoreDAO();
		int result = scoreDAO.updateScore(dto);
		
		// 3. 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("studNo", studNo);
		modelAndView.addObject("result", result);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("scoreModify.jsp");
		return modelAndView;
	}

}





