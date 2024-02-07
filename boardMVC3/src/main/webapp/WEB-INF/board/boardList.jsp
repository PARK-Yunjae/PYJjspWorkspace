<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>내용</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="b" items="${list}">
			<tr>
				<td>${b.no}</td>
				<td><a href="${ctx}/boardContent.do?no=${b.no}">${b.subject}</a></td>
				<td>${b.writer}</td>
				<td>${b.regDate}</td>
				<td>${b.contents}</td>
				<td>
					<button onclick="location.href='${ctx}/boardOneDelete.do?no=${b.no}'">삭제</button>
				</td>
			</tr>		
		</c:forEach>
	</table>
	<button onclick="location.href='${ctx}/boardIndex.do'"> 메인으로 </button>
</body>
</html>