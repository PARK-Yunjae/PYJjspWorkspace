<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./sessionCheck.jsp"%>
<%@ include file="./header.jsp"%>
<script src="./common.js"></script>
<%
if (dao.getLog() == -1) {
%>
<script>
	msgError();
</script>
<%
} else {
int idx = dao.getLog();
String id = dao.getmList().get(idx).getId();
String name = dao.getmList().get(idx).getName();
String gender = dao.getmList().get(idx).getGender();
%>
<h1>정보수정</h1>
<form action="updatePro.jsp" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="<%=id%>" readonly /></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pw" required /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="<%=name%>" required /></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><input type="radio" name="gender" value="남성"
				<%if (gender.equals("남성")) {%> checked <%}%> />남성 <input
				type="radio" name="gender" value="여성" <%if (gender.equals("여성")) {%>
				checked <%}%> />여성</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="입력완료" /></td>
		</tr>
	</table>
</form>

<%@ include file="./footer.jsp"%>
<%
}
%>