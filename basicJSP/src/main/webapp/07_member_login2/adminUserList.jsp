<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.MemberDAO"%>
<%@ include file="./sessionCheck.jsp"%>
<%@ include file="./header.jsp"%>
	<h1>관리자 페이지(회원 정보 확인하기)</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
			<th>성별</th>
			<th>삭제</th>
		</tr>
		<%for(int i=0 ; i<dao.getmList().size() ; i++){ 
			if(!dao.getmList().get(i).getId().equals("admin")){%>
		<tr>
			<td><%= dao.getmList().get(i).getId()%></td>
			<td><%= dao.getmList().get(i).getPw()%></td>
			<td><%= dao.getmList().get(i).getName()%></td>
			<td><%= dao.getmList().get(i).getGender()%></td>
			<td><button id="<%=i%>" onclick="location.href='adminUserDelete.jsp?idx=<%=i%>'">삭제</button></td>
		</tr>
		<%}} %>
	</table>
<%@ include file="./footer.jsp"%>
