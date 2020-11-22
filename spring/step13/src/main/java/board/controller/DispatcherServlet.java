package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import member.dao.MemberDAO;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;
   
    public DispatcherServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	handlerMapping = new HandlerMapping();
    	viewResolver = new ViewResolver();
    	viewResolver.setPrefix("./");
    	viewResolver.setSuffix(".jsp");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트의 요청 path 정보 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		// uri = /step11/member/login.do
		// path = /login.do
		System.out.println("uri = " + uri);
		System.out.println("path = " + path);
		
		// 2. 클라이언트의 요청 path에 따른 Controller 검색
		Controller controller = handlerMapping.getController(path);
		
		// 3. 검색된 Controller 실행 (데이터 처리)
		// => viewName = "boardList";
		String viewName = controller.handleRequest(request, response);
		
		// 4. ViewResolver 클래스를 통해 viewName에 해당하는 view 처리 파일이름을 완성
		String view = null;
		if(viewName.contains(".do")) {
			view = viewName;
		} else {
			view = viewResolver.getView(viewName);   //"./boardList.jsp";
		}
		
		// 5. 페이지 이동
		if(path.equals("/login.do")) {
			response.sendRedirect(view);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
}












