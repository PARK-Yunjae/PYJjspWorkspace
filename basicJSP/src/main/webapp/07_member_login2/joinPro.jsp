<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./sessionCheck.jsp"%>
<%@ page import="member.MemberDAO"%>
<%@ page import="member.Member"%>
<script src="./common.js"></script>
<%
MemberDAO dao = (MemberDAO) session.getAttribute("dao");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String gender = request.getParameter("gender");
boolean pass = dao.idCheck(id);

if (pass) {
	dao.getmList().add(new Member(id, pw, name, gender));
%>
<script>
	msgUrl("회원 가입 완료", "main.jsp");
</script>
<%
} else {
%>
<script>
	msgUrl("중복 ID 존재", "main.jsp");
</script>
<%
}
%>
