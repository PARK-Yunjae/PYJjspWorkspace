<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
MemberDAO dao = new MemberDAO();

session.setAttribute("dao", dao);
response.sendRedirect("main.jsp");
%>
