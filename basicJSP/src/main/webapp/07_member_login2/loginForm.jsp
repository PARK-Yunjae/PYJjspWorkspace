<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./sessionCheck.jsp"%>
    
<%@ include file="./header.jsp" %>
	<h1>로그인</h1>
	<form action="loginPro.jsp" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" required/></td>
			</tr>			
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