package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardWriteFormController{

	@RequestMapping(value = "/board/boardWriteForm.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("../board/boardWriteForm.jsp");
		return modelAndView;
	}

}
