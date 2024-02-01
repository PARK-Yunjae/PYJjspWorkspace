<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.BoardDAO"%>
<%@ include file="./sessionCheck.jsp"%>
<%
BoardDAO dao = (BoardDAO) session.getAttribute("dao");

int pNum = 1;
int startPaging = 1;
int endPaging = 3;
dao.pagingBoard();

if (request.getParameter("pNum") == null) {
	pNum = 1;
} else {
	pNum = Integer.parseInt(request.getParameter("pNum"));
	if (pNum < 0) {
		pNum = 1;
		startPaging = 1;
		endPaging = 3;
	} else if (pNum > 2 && pNum - 2 < dao.getPageCount()) {
		startPaging = pNum - 1;
		endPaging = pNum + 1;
	} else if (pNum > dao.getPageCount()) {
		pNum = dao.getPageCount() - 2;
		startPaging = pNum - 1;
		endPaging = pNum + 1;
	}
	if (dao.getPageCount() < 3) {
		endPaging = dao.getPageCount();
	}
	dao.setCurPageNum(pNum);
}
dao.pagingBoard();

int count = dao.getCount(); // 전체 게시글 수
int pageSize = dao.getPageSize(); // 한 페이지에 보여줄 게시글 수
int curPageNum = dao.getCurPageNum(); // 현재 페이지 번호
int pageCount = dao.getPageCount(); // 전체 페이지 개수
int startRow = dao.getStartRow(); // 현재 페이지의 게시글 시작 번호
int endRow = dao.getEndRow(); // 현재 페이지의 게시글 마지막 번호

if(endPaging > pageCount) endPaging = pageCount;

System.out.println("count = " +count);
System.out.println("pageSize = " +pageSize);
System.out.println("curPageNum = " +curPageNum);
System.out.println("pageCount = " +pageCount);
System.out.println("startRow = " +startRow);
System.out.println("endRow = " +endRow);
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
		<%
		if (count > 0) {
			for (int i = startRow; i < endRow; i++) {
		%>
		<tr>
			<th><%=dao.getbList().get(i).getNo()%></th>
			<th><%=dao.getbList().get(i).getWrite()%></th>
			<th><%=dao.getbList().get(i).getRegDate()%></th>
			<th><a href="_05_updateBoard.jsp?idx=<%=i%>"><%=dao.getbList().get(i).getSubject()%></a></th>
			<th><%=dao.getbList().get(i).getContents()%></th>
			<th><button
					onclick="location.href='_06_deleteBoardPro.jsp?idx=<%=i%>'">삭제하기</button></th>
		</tr>
		<%
		}
		}
		%>
		<tr>
			<th colspan="6">
				<%
				if (dao.getbList().size() > 0) {
					if (pNum-2 > 1) {
				%> <a href="_07_boardListPaging.jsp?pNum=<%=pNum - 3%>">[이전]</a> <%
 }
 for (int i = startPaging; i <= endPaging; i++) {
 %> <a href="_07_boardListPaging.jsp?pNum=<%=i%>">[<%=i%>]
			</a> <%
 }
 if (pNum + 2 < pageCount) {
 %> <a href="_07_boardListPaging.jsp?pNum=<%=pNum + 3%>">[다음]</a> <%
 }
 }
 %>
			</th>
		</tr>
	</table>
	<a href="_00_main.jsp">메인으로</a>
</body>
</html>