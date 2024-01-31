<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int log = -1;
session.removeAttribute("log");
session.setAttribute("log", log);
%>
<script>
   alert("로그아웃 성공 ");
   location.href="02_main.jsp";
</script>