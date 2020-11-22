<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	/* 파일 저장 */
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
	int seq = Integer.parseInt(multi.getParameter("seq"));
	int pg = Integer.parseInt(multi.getParameter("pg"));
	
	// DB
	ImageboardDTO dto = new ImageboardDTO();
	dto.setSeq(seq);
	dto.setImageId(imageId);
	dto.setImageName(imageName);
	dto.setImagePrice(imagePrice);
	dto.setImageQty(imageQty);
	dto.setImageContent(imageContent);
	dto.setImage1(image1);
	
	ImageboardDAO imageboardDAO = new ImageboardDAO();
	int su = imageboardDAO.imageboardModify(dto);
	
	// view 처리 화면으로 이동 : forward 방식 
	// 1. 데이터 공유 : request 내장객체 사용, 다음 페이지까지만 공유
	request.setAttribute("su", su);	
	request.setAttribute("seq", seq);	
	request.setAttribute("pg", pg);	
	// 2. 화면 이동
	RequestDispatcher dispatcher = 
		request.getRequestDispatcher("../main/index.jsp?req=imageboardModifyResult");
	dispatcher.forward(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>