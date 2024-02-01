<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDAO"%>
<%@ include file="./sessionCheck.jsp"%>
<%
BoardDAO dao = (BoardDAO)session.getAttribute("dao");

String write = request.getParameter("write");
String subject = request.getParameter("subject");
String contents = request.getParameter("contents");
int cnt = Integer.parseInt(request.getParameter("cnt"));

dao.addBoard(write, subject, contents);
%>  
<script type="text/javascript">
alert(<%=cnt%>+"번글 추가 완료");
location.href = "_00_main.jsp";
</script>
