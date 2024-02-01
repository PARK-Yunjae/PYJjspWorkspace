<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDAO"%>
<%@ include file="./sessionCheck.jsp"%>
<%
BoardDAO dao = (BoardDAO)session.getAttribute("dao");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>제목</th>
			<th>내용</th>
			<th>삭제</th>
		</tr>
		<%for(int i=0 ; i<dao.getbList().size() ; i++){ %>
		<tr>
			<th><%=dao.getbList().get(i).getNo()%></th>
			<th><%=dao.getbList().get(i).getWrite()%></th>
			<th><%=dao.getbList().get(i).getRegDate()%></th>
			<th><a href="_05_updateBoard.jsp?idx=<%=i%>"><%=dao.getbList().get(i).getSubject()%></a></th>
			<th><%=dao.getbList().get(i).getContents()%></th>
			<th><button
				onclick="location.href='_06_deleteBoardPro.jsp?idx=<%=i%>'">삭제하기</button></th>
		</tr>
		<%} %>
	</table>
	<a href="_00_main.jsp">메인으로</a>
</body>
</html>