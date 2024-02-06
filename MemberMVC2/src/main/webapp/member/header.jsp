<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<c:set var="ctx" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />

</head>
<body>

	<header>
		<div class="row">
			<!--py-3(y축으로) 높이 column row )-->
			<div class="w-50 py-3" onclick="location.href='${ctx}/memberList.do'">
				회원목록</div>

			<c:if test="${empty log }">
				<div class="w-25 py-3" onclick="location.href='${ctx}/member/memberInsert.jsp'">
					회원가입</div>
				<div class="w-25 py-3" onclick="location.href='${ctx}/member/memberLogin.jsp'">
					로그인</div>
			</c:if>
			<c:if test="${!empty log }">
				<div class="w-25 py-3"
					onclick="location.href='${ctx}/memberContent.do?log=${log}'">
					내정보</div>
				<div class="w-25 py-3" onclick="location.href='${ctx}/memberLogout.do?log=${log}'">로그아웃</div>
			</c:if>
		</div>
	</header>