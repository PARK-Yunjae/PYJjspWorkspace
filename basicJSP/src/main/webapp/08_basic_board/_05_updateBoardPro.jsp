<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDAO"%>
<%@ include file="./sessionCheck.jsp"%>
<%
BoardDAO dao = (BoardDAO)session.getAttribute("dao");
String subject = request.getParameter("subject");
String contents = request.getParameter("contents");
int idx = Integer.parseInt(request.getParameter("idx"));

dao.getbList().get(idx).setSubject(subject);
dao.getbList().get(idx).setContents(contents);
%> 
<script type="text/javascript">
alert(<%=idx%>+"번글 수정 완료");
location.href = "_01_boardList.jsp";
</script>
