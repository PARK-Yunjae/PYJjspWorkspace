<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<String> idList = (ArrayList<String>)session.getAttribute("idList");
ArrayList<String> pwList = (ArrayList<String>)session.getAttribute("pwList");
ArrayList<String> namelist = (ArrayList<String>)session.getAttribute("namelist");
ArrayList<String> genderList = (ArrayList<String>)session.getAttribute("genderList");

%>
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
	<h1>관리자 페이지(회원 정보 확인하기)</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
			<th>성별</th>
			<th>삭제</th>
		</tr>
		<%for(int i=0 ; i<idList.size() ; i++){ 
			if(!idList.get(i).equals("admin")){%>
		<tr>
			<td><%= idList.get(i)%></td>
			<td><%= pwList.get(i)%></td>
			<td><%= namelist.get(i)%></td>
			<td><%= genderList.get(i)%></td>
			<td><button id="<%=i%>" onclick="location.href='01_12_adminUserDelete.jsp?id=<%=idList.get(i)%>'">삭제</button></td>
		</tr>
		<%}} %>
	</table>
	<button onclick="location.href='01_11_adminMain.jsp'"> 메인화면 </button>
</body>
</html>