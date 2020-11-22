package score.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreWriteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		try {
			request.setCharacterEncoding("UTF-8");  // 한글 설정
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		
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
		
		// 화면 네비게이션
		request.setAttribute("result", result);
		
		return "scoreWrite";		// "scoreWrite.jsp";
	}

}










