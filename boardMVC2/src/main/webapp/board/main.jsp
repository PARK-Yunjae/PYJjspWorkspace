<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<c:set var="ctx" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardMVC2</title>

</head>
<body>
	<h3><a href="${ctx}/BoardList.do">전체 게시글</a></h3>
	<h3><a href="${ctx}/BoardAddDummy.do">더미 게시글</a></h3>
	<h3><a href="${ctx}/BoardAllDelete.do">전체 게시글 삭제하기</a></h3>
	<h3><a href="${ctx}/BoardInsert.do">게시글 추가하기</a></h3>
	<hr>
	<h3><a href="${ctx}/BoardListPaging.do">페이징 게시판</a></h3>
</body>
</html>