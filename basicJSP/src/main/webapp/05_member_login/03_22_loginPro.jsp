<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
function printMsg( url ,msg) {
	alert(msg);
	location.href=url;
}
</script>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");

@SuppressWarnings("unchecked")
ArrayList<String> idList = (ArrayList<String>)session.getAttribute("idList");
@SuppressWarnings("unchecked")
ArrayList<String> pwList = (ArrayList<String>)session.getAttribute("pwList");

int log = 0;

boolean pass = false;

// 아이디 일치 확인
for(int i=0 ; i < idList.size() ; i++){
	if(id.equals(idList.get(i)) && pw.equals(pwList.get(i))){
		session.removeAttribute("log");
		if(id.equals("admin")){
			log = -2;
		}else{
			log = i;
		}
		session.setAttribute("log", log);
		pass = true;
		break;
	}
}

// 로그인 성공
if(pass && log == -2){ %>
<script>
printMsg( '01_11_adminMain.jsp' ,"로그인 성공");
</script>

<%}else if(pass && log != -1){ %>
<script>
printMsg( '02_main.jsp' ,"로그인 성공");
</script>

<%}else{ %>
<script>
printMsg( '03_21_loginForm.jsp' ,"로그인 실패");
</script>
<%} %>