<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	/*
		form 태그의 enctype="multipart/form-data"로 설정되어 있으면,
		request 객체로는 문자열을 읽어올 수 없음
	*/
	//String imageId = request.getParameter("imageId");
	
	/* 파일 저장 */
	// 실제 폴더위치
	String realFolder = request.getServletContext().getRealPath("/storage");
	// realFolder : D:\android_ycs\jsp\workspace\.metadata\.plugins
	// \org.eclipse.wst.server.core\tmp0\wtpwebapps\17-imageboard\storage
	System.out.println("realFolder : " + realFolder);
	// 파일 저장
	MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024, 
						"UTF-8", new DefaultFileRenamePolicy());
	// 데이터 읽기
	String imageId = multi.getParameter("imageId");
	String imageName = multi.getParameter("imageName");
	int imagePrice = Integer.parseInt(multi.getParameter("imagePrice"));
	int imageQty = Integer.parseInt(multi.getParameter("imageQty"));
	String imageContent = multi.getParameter("imageContent");
	String image1 = multi.getOriginalFileName("image1");
	// DB
	ImageboardDTO dto = new ImageboardDTO();
	dto.setImageId(imageId);
	dto.setImageName(imageName);
	dto.setImagePrice(imagePrice);
	dto.setImageQty(imageQty);
	dto.setImageContent(imageContent);
	dto.setImage1(image1);
	
	ImageboardDAO imageboardDAO = new ImageboardDAO();
	int su = imageboardDAO.imageboardWrite(dto);
	// view 처리 화면으로 이동 : forward 방식 
	// 1. 데이터 공유 : request 내장객체 사용, 다음 페이지까지만 공유
	request.setAttribute("su", su);
	request.setAttribute("imageName", imageName);
	// 2. 화면 이동
	RequestDispatcher dispatcher = 
		request.getRequestDispatcher("../main/index.jsp?req=imageboardWriteResult");
	dispatcher.forward(request, response);
%>











