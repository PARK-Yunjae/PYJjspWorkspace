<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("dao")== null){
	response.sendRedirect("index.jsp");
	return;
}
%>