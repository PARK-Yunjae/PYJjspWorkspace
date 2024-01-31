<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./sessionCheck.jsp"%>
<%@ page import="member.MemberDAO"%>
<script src="./common.js"></script>
<%
MemberDAO dao = (MemberDAO) session.getAttribute("dao");

dao.setLog(-1);
%>
<script>
	msgGoMain("로그아웃");
</script>
