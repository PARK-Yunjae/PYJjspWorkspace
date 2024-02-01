<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDAO"%>
<%@ include file="./sessionCheck.jsp"%>
<%
BoardDAO dao = (BoardDAO)session.getAttribute("dao");
dao.AddDummy();
%>
<script type="text/javascript">
alert("더미 글 10개 추가 완료");
location.href = "_00_main.jsp";
</script>
