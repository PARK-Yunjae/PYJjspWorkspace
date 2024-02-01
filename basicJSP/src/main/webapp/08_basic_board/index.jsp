<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
BoardDAO dao = new BoardDAO();

session.setAttribute("dao", dao);
response.sendRedirect("_00_main.jsp");
%>
