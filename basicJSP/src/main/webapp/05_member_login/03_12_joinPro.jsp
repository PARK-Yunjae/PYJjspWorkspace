<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String gender = request.getParameter("gender");

ArrayList<String> idList = (ArrayList<String>)session.getAttribute("idList");
ArrayList<String> pwList = (ArrayList<String>)session.getAttribute("pwList");
ArrayList<String> namelist = (ArrayList<String>)session.getAttribute("namelist");
ArrayList<String> genderList = (ArrayList<String>)session.getAttribute("genderList");

int idx = -1;
for(int i=0 ; i<idList.size() ; i++){
	if(idList.get(i).equals(id)){
		idx = i;
		break;
	}
}

if(idx == -1){
	idList.add(id);
	pwList.add(pw);
	namelist.add(name);
	genderList.add(gender);
	
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
		alert("회원 가입 완료");
		location.href = "02_main.jsp";
	</script>
<% } else{%>
<script>
		alert("중복 ID 있음");
		location.href = "02_main.jsp";
	</script>
<%} %>
