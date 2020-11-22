package book2.controller;

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

import book2.action.Action;



@WebServlet("*.do")
public class book2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 명령어와 명령어 처리 객체를 쌍으로 저장할 Map 클래스
	private Map<String, Object> commandMap = new HashMap<String, Object>();
    
	public book2Controller() {
        
    }

	// 서블릿 초기화
    // => properties 파일을 읽어와서, 요청명령과 해당되는 객체를 생성한후, Map 객체에 저장
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// "/property" 폴더의 절대 경로를 구함
    	String realFolder = config.getServletContext().getRealPath("/property");
    	// 절대경로로 파일이름을 작성
    	String realPath = realFolder + "/command.properties";
    	
    	// 명령어와 처리 클래스의 매핑정보를 저장할 Properties 객체 생성
    	Properties properties = new Properties();
    	// 파일을 읽어올 IO 클래스
    	FileInputStream fis = null;
    	try {
			fis = new FileInputStream(realPath);
			// command.properties 파일의 내용을 읽어와서 Properties 객체에 저장
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
	
    	// Set 객체의 iterator() 메소드를 사용하여 Iterator 객체를 얻어냄
    	// => properties 파일의 command 값이 저장되어 있음
    	Iterator<?> iterator = properties.keySet().iterator();
    	
    	// Iterator 객체에 저장된 명령어와 명령어 처리 객체를 Map 객체에 저장
    	while(iterator.hasNext()) {
    		String command = (String) iterator.next();  		// properties 파일의 command 값
    		String className = properties.getProperty(command); // properties 파일의 command 값에 해당하는 클래스 이름
    		// 결과 확인
    		//System.out.println("command : " + command);
    		//System.out.println("className : " + className);
    		
    		// 객체 생성
    		try {
    			// Class.forName(className) : 클래스가 있는 지 확인하고, 없으면 예외 발생시키고, 있으면 Class 객체
				Class<?> commandClass = Class.forName(className); 
				// 객체 생성
				Object commandInstance = commandClass.newInstance();
				// Map 객체에 저장
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

	
	//1. 웹브라우저 요청받기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = null;
		Action action = null;
		
		//요청 정보 확인
		String command = request.getServletPath();
		//command : /main/memberWriteForm.do
		command = command.substring(command.lastIndexOf("/"));
		// command : /memberWriteForm.do
		System.out.println("command :" + command);
		
		
		//요청 작업 처리
		action = (Action) commandMap.get(command);
		
		if(action != null) {
			try {
				result = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//view처리
		if(result != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(result);
			dispatcher.forward(request, response);
		}
		
	}
}
