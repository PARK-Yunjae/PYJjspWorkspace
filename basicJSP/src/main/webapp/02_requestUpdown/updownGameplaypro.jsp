<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%
  String com = request.getParameter("com");
  String msg = "";
  String text = "�ڷΰ���";
  int rNum = Integer.parseInt(com);
  int num = Integer.parseInt(request.getParameter("num"));

  String link = "updownGameplay.jsp?com="+rNum;
  
  if(rNum > num) {
	  msg = "UP";
  }
  if(rNum < num) {
	  msg = "DOWM";
  }
  if(rNum == num) {
	  msg = "����";
	  text = "ó������";
	  link = "index.jsp";
	  com = null;
  }
  
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1><%= msg %></h1>
	<a href="<%= link%>"><%= text%></a>

</body>
</html>
