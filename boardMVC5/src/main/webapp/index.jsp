<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<a href="${ctx}/boardList.do">전체 게시글 확인하기</a>
	</h1>
	<h1>
		<a href="${ctx}/boardAddDummy.do">더미 게시글 추가하기</a>
	</h1>
	<h1>
		<a href="${ctx}/boardAllDelete.do">전체 게시글 삭제하기</a>
	</h1>
	<h1>
		<a href="${ctx}/boardOneAdd.do">게시글 추가하기</a>
	</h1>
	<hr>
	<h1>
		<a href="${ctx}/boardListPaging.do">페이징 게시판</a>
	</h1>
</body>
</html>