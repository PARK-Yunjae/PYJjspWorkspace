<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./sessionCheck.jsp"%>
<%@ page import="member.MemberDAO"%>
<script src="./common.js"></script>
<%
MemberDAO dao = (MemberDAO) session.getAttribute("dao");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
int idx = dao.loginCheck(id, pw);

dao.setLog(idx);
if (idx != -1) {
	String name = dao.nameValue(idx); 
	if(idx == 0)
		dao.setTitle("관리자 로그인중");
	if(idx > 0)
		dao.setTitle(name + " 로그인중");
%>
<script>
	msgUrl("로그인 성공", "main.jsp");
</script>
<%
} else {
%>
<script>
	msgUrl("로그인 실패", "main.jsp");
</script>
<%
}
%>
