<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
body{
	text-align : center;
}
table{
	margin : auto;
	border : 1px solid black;
}
</style>
</head>
<body>
	<form action="03_22_loginPro.jsp" method="post">
		<h1>로그인 페이지</h1>
		<table>
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
	<button onclick="location.href='02_main.jsp'"> 메인화면 </button>
</body>
</html>