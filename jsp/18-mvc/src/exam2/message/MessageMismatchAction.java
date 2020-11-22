package exam2.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageMismatchAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 1. 클라이언트에서 전달된 데이터 확인
		// 2. 데이터 처리 작업
		// 3. 결과값을 request 객체에 저장
		request.setAttribute("result", "타입이 맞지 않습니다.");
		// 4. view 처리 파일 이름 리턴
		return "/messageView.jsp";
	}

}
