package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ScoreWriteFormController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 화면 네비게이션 : 데이터 공유 + view 처리 파일
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.setViewName("scoreWriteForm.jsp");
				
		return modelAndView;
	}

}
