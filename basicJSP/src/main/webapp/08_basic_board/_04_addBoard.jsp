<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.BoardDAO"%>
<%@ include file="./sessionCheck.jsp"%>
<%
BoardDAO dao = (BoardDAO) session.getAttribute("dao");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<h1>게시글 추가하기</h1>
	<form action="_04_addBoardPro.jsp" method="post">
		<table border="1">			
			<tr>
				<td>번호</td>
				<td colspan="3"><%=dao.getCnt() %></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td colspan="3"><input type="text" name="write"/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3"><input type="text" name="subject"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3"><textarea cols="30" rows="10" name="contents"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="작성완료" /></td>
			</tr>
		</table>
		<input type="hidden" name="cnt" value="<%=dao.getCnt()%>"/>
	</form>
	<a href="_00_main.jsp">메인으로</a>
</body>
</html>