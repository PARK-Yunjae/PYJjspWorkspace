<%@ page import="java.util.ArrayList"%>
<%@ page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./sessionCheck.jsp"%>
<script src="./common.js"></script>
<%
MemberDAO dao = (MemberDAO) session.getAttribute("dao");
String pw = request.getParameter("pw");

int idx = dao.pwCheck(pw);

if(idx == dao.getLog()){
	%>
	<script>
	msgGoMain("회원 탈퇴 성공");
	</script>
<% } else{%>
	<script>
	msgUrl("비밀번호가 틀렸습니다", "deleteForm.jsp");
	</script>
<%} %>