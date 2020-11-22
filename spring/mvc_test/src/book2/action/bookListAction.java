package book2.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book2.bean.book2DTO;
import book2.dao.book2DAO;

public class bookListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// <<<<<<< 데이터 >>>>>>>
		int pg = 1;		
		
		if(request.getParameter("pg") != null) {			
			pg = Integer.parseInt(request.getParameter("pg"));			
		}
		
		// 목록보기 => 한 페이지당 목록을 몇개 보여줄지 설정
		int endNum = pg * 7;
		int startNum = endNum - 6;
		
		book2DAO dao = new book2DAO();
		List<book2DTO> list = dao.selectList(startNum, endNum);
		
		int totalBook = dao.getListCount();		// 총 도서 수 구하기 
		int totalPage = (totalBook + 6)/7;		// 총 페이지 수 구하기
		
		
		 int startPage = (pg-1)/3*3 +1; 		
		 int endPage = startPage + 2;
		 if(endPage > totalPage) endPage = totalPage;
		
		 
		    //데이터 공유
		    request.setAttribute("pg", pg);
		    request.setAttribute("list", list);
		    request.setAttribute("totalPage", totalPage);
		    request.setAttribute("startPage", startPage);
		    request.setAttribute("endPage", endPage);
		    
		    //화면 네비게이션
			request.setAttribute("req_page", "../book2/bookList.jsp");
			return "../main/book2Index.jsp";
	}
}
