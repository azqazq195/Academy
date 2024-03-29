package exam4.mvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/ControllerURI", "*.do"})
public class ControllerURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 명령어와 명령어 처리 클래스를 쌍으로 저장할 Map 클래스
	private Map<String, Object> commandMap = new HashMap<String, Object>();
	
    public ControllerURI() {
        super();
    }
    
    // 명령어와 명령어 처리 클래스가 매핑되어 있는 properties 파일을 읽어서 Map 클래스에 저장
    @Override
    public void init(ServletConfig config) throws ServletException {
    	String realFolder = config.getServletContext().getRealPath("/property");
    	String realPath = realFolder + "/commandURI.properties";
    	
    	FileInputStream fis = null;
    	Properties properties = new Properties();
    	try {
			fis = new FileInputStream(realPath);
			properties.load(fis);  // properties 파일 읽어오기
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	// iterator 객체 얻기
    	Iterator<?> iterator = properties.keySet().iterator();
    	while(iterator.hasNext()) {
    		String command = (String) iterator.next();
    		String className = properties.getProperty(command);
    		
    		try {
    			// 객체 생성
				Class<?> commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				// 맵 클래스에 저장
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
    	}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	// 1. 웹브라우저의 요청을 분석
	// 2. 해당 요청의 처리를 수행할 model 실행
	// 3. 처리결과를 view에 보냄 - forward 이동
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		Action action = null;
		
		String command = request.getRequestURI();
		String contextPath = request.getContextPath();
		int contextPathLength = contextPath.length();
		// command : /18-mvc/exam4/message.do
		// contextPath : /18-mvc
		// contextPathLength : 7
		System.out.println("command before: " + command);
		System.out.println("contextPath : " + contextPath);
		System.out.println("contextPathLength : " + contextPathLength);
		
		if(command.indexOf(contextPath) == 0) {
			command = command.substring(contextPathLength);
		}
		// command after: /exam4/message.do
		System.out.println("command after: " + command);
		
		// model 얻기
		action = (Action) commandMap.get(command);
		// model 실행
		try {
			view = action.process(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		// view 처리 - forward 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}












