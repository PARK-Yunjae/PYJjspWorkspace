<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDAO"%>
<%@ include file="./sessionCheck.jsp"%>
<%
BoardDAO dao = (BoardDAO)session.getAttribute("dao");
int idx = Integer.parseInt(request.getParameter("idx"));
dao.deleteBoard(idx);
%>
<script type="text/javascript">
alert(<%=idx%>+"번글 삭제 완료");
location.href = "_01_boardList.jsp";
</script>
