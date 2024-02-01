<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.BoardDAO"%>
<%@ include file="./sessionCheck.jsp"%>
<%
BoardDAO dao = (BoardDAO) session.getAttribute("dao");
int idx = Integer.parseInt(request.getParameter("idx"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<h1>게시글 수정하기</h1>
	<form action="_05_updateBoardPro.jsp" method="post">
		<table border="1">
			<tr>
				<td>번호</td>
				<td colspan="3"><%=dao.getbList().get(idx).getNo()%></td>
			</tr>
			<tr> 
				<td>작성자</td>
				<td><%=dao.getbList().get(idx).getWrite()%></td>
				<td>작성일</td>
				<td><%=dao.getbList().get(idx).getRegDate()%></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3"><input type="text" name="subject"
				value="<%=dao.getbList().get(idx).getSubject()%>"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3"><textarea cols="30" rows="10" name="contents">
				<%=dao.getbList().get(idx).getContents()%></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정하기" /></td>
			</tr>
		</table>
		<input type="hidden" name="idx" value="<%=idx%>"/>
	</form>
	<a href="_00_main.jsp">메인으로</a>
</body>
</html>