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
</head>
<body>
	<h1>게시글 추가하기</h1>
	<form action="${ctx}/BoardOneAdd.do">
		<table border="1">
			<tr>
				<th>번호</th>
				<td>${no+1}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" required></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="20" name="contents" required></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성완료"></td>
			</tr>
		</table>
	</form>
	<button onclick="location.href='${ctx}/board/main.jsp'">메인으로</button>

</body>
</html>