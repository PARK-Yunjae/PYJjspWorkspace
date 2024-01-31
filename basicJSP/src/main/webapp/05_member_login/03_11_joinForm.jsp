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
}
</style>
</head>
<body>
	<h1>회원 가입</h1>
	<form action="03_12_joinPro.jsp" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" required/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw" required/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="남성" checked/>남성
					<input type="radio" name="gender" value="여성"/>여성
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력완료"/>
				</td>
			</tr>
		</table>
	</form>
	<button onclick="location.href='02_main.jsp'"> 메인화면 </button>
</body>
</html>