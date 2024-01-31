<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.MemberDAO"%>
<%@ include file="./sessionCheck.jsp"%>
<%
MemberDAO dao = (MemberDAO) session.getAttribute("dao");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 JSP 로그인 구현 실습 ver2</title>
<script src="./common.js"></script>
<link rel="stylesheet" href="./style.css">
</head>
<body>
	<a href="main.jsp">홈</a> &nbsp;

	<%
	if (dao.getLog() == -1) {
	%>
	<a href="joinForm.jsp">회원가입</a> &nbsp;
	<a href="loginForm.jsp">로그인</a>
	<%
	} else if (dao.getLog() == 0) {
	%>
	<a href="logoutPro.jsp">로그아웃</a> &nbsp;
	<a href="adminUserList.jsp">회원관리</a>
	<%
	} else if (dao.getLog() > 0) {
	%>
	<a href="logoutPro.jsp">로그아웃</a> &nbsp;
	<a href="updateForm.jsp">정보수정</a> &nbsp;
	<a href="deleteForm.jsp">회원탈퇴</a>
	<%
	}
	%>