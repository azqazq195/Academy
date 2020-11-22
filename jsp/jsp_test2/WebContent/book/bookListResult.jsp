<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
      <tr bgcolor="ffcccc">
         <th>도서코드</th>
         <th>도서명</th>
         <th>저자</th>
         <th>출판사</th>
         <th>가격</th>
      </tr>

	<c:forEach var="bookDTO" items="${list}">
	  <tr align="center" bgcolor="ffeeee">
         <td>${bookDTO.bookCode}</td>
         <td>${bookDTO.bookName}</td>
         <td>${bookDTO.artist}</td>
         <td>${bookDTO.publisher}</td>
         <td>${bookDTO.bookPrice}</td>
      </tr>
	</c:forEach>      
      
      <tr>
      <td colspan="6" align = "center">
      <c:if test="${startPage>3}">
      		[<a id="paging" href="/jsp_test2/book/bookList.jsp?pg=${startPage-1}">이전</a>]
      </c:if>
         
      <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
       	<c:if test="${pg == i}">
       		[<a id="currentPaging" href="/jsp_test2/book/bookList.jsp?pg=${i}">${i}</a>]
       	</c:if>
       	
       	<c:if test="${pg != i}">
       		[<a id="paging" href="/jsp_test2/book/bookList.jsp?pg=${i}">${i}</a>]
       	</c:if>
      </c:forEach>   
         
      <c:if test="${endPage< totalListPage}">
      		[<a id="paging" href="/jsp_test2/book/bookList.jsp?pg=${endPage+1}">다음</a>]
      </c:if>   
      </td>
   </tr>   

   </table>
   <a href="../index.jsp">메인 화면으로 이동</a>
</body>
</html>