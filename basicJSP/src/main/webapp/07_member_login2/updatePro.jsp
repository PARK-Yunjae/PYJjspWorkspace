<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./sessionCheck.jsp"%>
<%@ page import="member.MemberDAO"%>
<script src="./common.js"></script>
<%
MemberDAO dao = (MemberDAO) session.getAttribute("dao");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String gender = request.getParameter("gender");

int idx = dao.loginCheck(id, pw);

if (idx != -1) {
	dao.getmList().get(idx).setName(name);
	dao.getmList().get(idx).setGender(gender);
%>
<script>
	msgUrl("수정 완료", "main.jsp");
</script>
<%
} else {
%>
<script>
	msgUrl("비밀번호 틀림", "updateForm.jsp");
</script>
<%
}
%>
