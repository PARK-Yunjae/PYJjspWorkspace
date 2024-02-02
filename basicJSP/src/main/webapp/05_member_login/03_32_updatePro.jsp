<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String gender = request.getParameter("gender");
int log = (int)session.getAttribute("log");

@SuppressWarnings("unchecked")
ArrayList<String> idList = (ArrayList<String>)session.getAttribute("idList");
@SuppressWarnings("unchecked")
ArrayList<String> pwList = (ArrayList<String>)session.getAttribute("pwList");
@SuppressWarnings("unchecked")
ArrayList<String> namelist = (ArrayList<String>)session.getAttribute("namelist");
@SuppressWarnings("unchecked")
ArrayList<String> genderList = (ArrayList<String>)session.getAttribute("genderList");

if(pwList.get(log).equals(pw)){
	idList.set(log , id);
	pwList.set(log , pw);
	namelist.set(log , name);
	genderList.set(log , gender);
	
	session.removeAttribute("idList");
	session.removeAttribute("pwList");
	session.removeAttribute("namelist");
	session.removeAttribute("genderList");
	session.setAttribute("idList", idList);
	session.setAttribute("pwList", pwList);
	session.setAttribute("namelist", namelist);
	session.setAttribute("genderList", genderList);
	%>
	<script>
		alert("회원 수정 완료");
		location.href = "02_main.jsp";
	</script>
<% } else{%>
<script>
		alert("비밀번호 틀림");
		location.href = "03_31_updateForm.jsp";
	</script>
<%} %>