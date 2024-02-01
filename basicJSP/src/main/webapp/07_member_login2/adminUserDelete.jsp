<%@ page import="java.util.ArrayList"%>
<%@ page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./sessionCheck.jsp"%>
<%
MemberDAO dao = (MemberDAO) session.getAttribute("dao");
String idx = request.getParameter("idx");
dao.DeleteMember(Integer.parseInt(idx));
if (dao.getLog() == -1) {
%>
<script>
	msgError();
</script>
<%
} else {
%>

<script src="./common.js"></script>
<script>
	msgUrl("회원 삭제 완료", "adminUserList.jsp");
</script>

<%
}
%>