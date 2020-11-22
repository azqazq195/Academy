package book2.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book2.bean.book2DTO;
import book2.dao.book2DAO;

public class bookWriteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");     
		
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		int price = Integer.parseInt(request.getParameter("price"));
		String publiDate = request.getParameter("publiDate");
		
		book2DTO dto = new book2DTO();
		dto.setCode(code);
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setPublisher(publisher);
		dto.setPrice(price);
		dto.setPubliDate(publiDate);
		
		book2DAO dao = new book2DAO();
		int su = dao.insertBook(dto);
		
		//데이터 공유
	  	request.setAttribute("su", su);
	  	request.setAttribute("title", title);
	  		
	    
		request.setAttribute("req_page", "../book2/bookWrite.jsp");
		return "../main/book2Index.jsp";
	}

}
