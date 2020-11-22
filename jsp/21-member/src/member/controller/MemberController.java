package member.controller;

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

import member.action.Action;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> commandMap = new HashMap<String, Object>();
    
    public MemberController() {
        super();
    }
    
    // 명령어와 명령어 처리 클래스가 매핑되어 있는 properties파일을 읽어서 Map 클래스에 저장
    @Override
    public void init(ServletConfig config) throws ServletException {
    	String realFolder = config.getServletContext().getRealPath("/property");
    	String realPath = realFolder + "/command.properties";
    	
    	Properties properties = new Properties();
    	FileInputStream fis = null;
    	try {
			fis = new FileInputStream(realPath);
			properties.load(fis);
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
    	
    	Iterator<?> iterator = properties.keySet().iterator();
    	
    	while(iterator.hasNext()) {
    		String command = (String) iterator.next();
    		String className = properties.getProperty(command);
    		
    		try {
				Class<?> commandClass = Class.forName(className);
				// Action 클래스 객체 생성
				Object commandInstance = commandClass.newInstance();
				// Map 객체에 커맨드와 Action 객체 저장
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
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	// 웹브라우저의 요청을 분석을 하고, 해당 요청의 처리를 수행할 model 설정하고, 실행함
	// => 처리 결과를 보여줄 view 처리 작업
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = null;  	// view 처리 파일 이름 저장
		Action action = null;	// 해당 요청의 처리를 수행할 model 객체 저장
		
		// 요청 정보 확인
		String command = request.getServletPath();
		// command : /main/memberWriteForm.do		
		command = command.substring(command.lastIndexOf("/"));
		// command : /memberWriteForm.do
		System.out.println("command : " + command);
		
		// 요청 작업 처리		
		action = (Action) commandMap.get(command);
		
		if(action != null) {
			try {
				result = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// view 처리 : forward 이동
		if(result != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(result);
			dispatcher.forward(request, response); 
		}
	}
}










