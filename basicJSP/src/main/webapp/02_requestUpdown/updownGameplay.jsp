<%@ page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	Random rd = new Random();
	String com = request.getParameter("com");
	int rNum = 0;
	if(com == "" || com == null){
		rNum = rd.nextInt(100)+1;
  	}else{
	  	rNum = Integer.parseInt(com);
  	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<p> 치트키 <%= rNum %></p>
	<form action="updownGameplaypro.jsp" method="get">
		<input type="number" name="num" required min="1" max="100"/>
		<input type="submit" value="전송">
		<input type="hidden" name="com" value="<%= rNum %>">
	</form>
</body>
</html>