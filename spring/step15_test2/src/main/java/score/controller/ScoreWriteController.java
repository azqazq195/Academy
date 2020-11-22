package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

@Controller
public class ScoreWriteController{

	@RequestMapping(value = "/score/scoreWrite.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터
		request.setCharacterEncoding("UTF-8");	// 한글 설정
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int tot = kor + eng + mat;
		double avg = (double)tot / 3;
		
		// DB
		ScoreDTO dto = new ScoreDTO();
		dto.setStudNo(studNo);
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		dto.setTot(tot);
		dto.setAvg(avg);
		
		
		ScoreDAO scoreDAO = new ScoreDAO();
		int result = scoreDAO.insertScore(dto);	
		
		// 화면 네비게이션 : 데이터 공유 + view 처리 파일
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("scoreWrite.jsp");
		
		return modelAndView;
	}

}








