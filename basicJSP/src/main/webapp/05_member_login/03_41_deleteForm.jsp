<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 탈퇴</h1>
	<form action="03_42_deletePro.jsp" method="post">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw" required/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="탈퇴완료"/>
				</td>
			</tr>
		</table>
	</form>
	<button onclick="location.href='02_main.jsp'"> 메인화면 </button>
</body>
</html>