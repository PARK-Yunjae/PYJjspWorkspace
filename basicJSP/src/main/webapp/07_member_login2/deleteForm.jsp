<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./sessionCheck.jsp"%>
<%@ include file="./header.jsp" %>
<%
if (dao.getLog() == -1) {
%>
<script>
	System.out.println("여기");
	msgError();
</script>
<%
}else{%>
<script src="./common.js"></script>
	<h1>회원탈퇴</h1>
	<form action="DeletePro.jsp" method="post">
		<table border="1">		
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" required/></td>
			</tr>			
			<tr>
				<td colspan="2"><input type="submit" value="로그인"/></td>
			</tr>
		</table>
	</form>

<%@ include file="./footer.jsp"%>
<%} %>