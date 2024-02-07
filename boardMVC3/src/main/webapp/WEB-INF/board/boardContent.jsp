<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardContent</title>
</head>
<body>
	<c:if test="${empty vo }">
		<h1>일치하는 회원이 없습니다</h1>
	</c:if>
	<c:if test="${!empty vo }">
		<form method="post" action="${ctx}/boardUpdate.do">
			<table border="1">
				<tr>
					<th>번호</th>
					<td colspan="3">${vo.no}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${vo.writer}</td>
					<th>작성일</th>
					<td>${vo.regDate}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3">
						<input type="text" name="subject" value="${vo.subject}">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">
						<textarea rows="10" cols="20" name="contents">${vo.contents}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<input type="hidden" name="no" value="${vo.no }">
						<input type="submit" value="수정하기">
					</td>
				</tr>
			</table>
		</form>
		<button onclick="location.href='${ctx}/index.jsp'">메인으로</button>
		
	</c:if>
</body>
</html>