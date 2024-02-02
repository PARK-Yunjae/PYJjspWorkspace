<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
@SuppressWarnings("unchecked")
ArrayList<String> idList = (ArrayList<String>)session.getAttribute("idList");
@SuppressWarnings("unchecked")
ArrayList<String> pwList = (ArrayList<String>)session.getAttribute("pwList");
@SuppressWarnings("unchecked")
ArrayList<String> namelist = (ArrayList<String>)session.getAttribute("namelist");
@SuppressWarnings("unchecked")
ArrayList<String> genderList = (ArrayList<String>)session.getAttribute("genderList");

int log = (int)session.getAttribute("log");

String id = "";
String pw = "";
String name = "";
String gender = "";

for(int i=0 ; i<idList.size() ; i++){
	if(i == log){
		id = idList.get(i);
		pw = pwList.get(i);
		name = namelist.get(i);
		gender = genderList.get(i);
	}
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form action="03_32_updatePro.jsp" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="<%=id %>" readonly/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw" required/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%=name %>" required/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" name="gender" value="남성" <%if(gender.equals("남성")) {%>checked<%} %>/>남성
					<input type="radio" name="gender" value="여성" <%if(gender.equals("여성")) {%>checked<%} %>/>여성
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정완료"/>
				</td>
			</tr>
		</table>
	</form>
	<button onclick="location.href='02_main.jsp'"> 메인화면 </button>
</body>
</html>