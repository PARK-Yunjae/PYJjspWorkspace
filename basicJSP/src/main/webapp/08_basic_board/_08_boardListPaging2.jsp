<%@page import="board.Board"%>
<%@page import="board.BoardDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("dao") == null){
 	 response.sendRedirect("index.jsp");
 	 return;
 }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	     BoardDAO dao = (BoardDAO)session.getAttribute("dao");

		if(request.getParameter("start") != null) {
			dao.setCurPageNum(request.getParameter("start"));
		}
		int[] row = dao.getRowData();
	%>
	
	전체 게시글 수 : <%=  dao.getTotalData() %>개
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>제목</th>
			<th>내용</th>
			<th>삭제</th>
		</tr>
	<%
		for(int i=row[0]; i<row[1]; i++) {
			Board b = dao.getOneBoard(i);
	%>	
		<tr>
			<td><%= b.getNo() %></td>
			<td><%= b.getWriter() %></td>
			<td><%= b.getRegDate() %></td>
	     	<td><a href="_05_updateBoard.jsp?index=<%= i %>"><%= b.getSubject() %></a></td>
			<td><%= b.getContents() %></td>
			<td><button onClick="location.href='_06_deleteBoardPro.jsp?index=<%= i %>'">삭제하기</button></td>
		</tr>
	
	<%	} %>
		<tr>
			<td colspan="6">
				<button onclick="window.location.href='_00_main.jsp'">메인화면</button>
			</td>
		</tr>
	</table>
	
	<%

		if(request.getParameter("curNum") != null){
			dao.setStartPageNum(request.getParameter("curNum"));
		}
	    int start = dao.startPageNum;
	    int end = dao.getEndPageNum();
	    int cnt = dao.pageNumCnt;
	
	%>
	
	<%  if(start > cnt ) { %>
		[<a href="_08_boardListPaging2.jsp?start=<%= start - 1 %>&curNum=<%= start - cnt %>">이전</a>]
	<%	} %>
	
	<%  for(int i=start; i<=end; i++) {
		%>
			[<a href="_08_boardListPaging2.jsp?start=<%= i %>&curNum=<%= start %>"><%= i %></a>]
	<%	} %>
	
	<%  if(end < dao.getTotalPageCnt()) { %>
		[<a href="_08_boardListPaging2.jsp?start=<%= start + cnt %>&curNum=<%= start + cnt %>">이후</a>]
	<%	} %>
</body>
</html>