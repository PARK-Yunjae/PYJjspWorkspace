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
	<table border = 1>
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
				<td><a href="${ctx}/BoardContent.do?no=${b.no}">${b.subject}</a></td>
				<td>${b.writer}</td>
				<td>${b.regDate}</td>
				<td>${b.contents}</td>
				<td>
					<button
					onclick="location.href='${ctx}/BoardOneDelete.do?no=${b.no }'">삭제</button>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	<c:if test="${start > cnt }">
		[<a href="${ctx}/BoardListPaging.do?start=${start - 1}&curNum=${start - cnt}">이전</a>]
	</c:if>
	<c:forEach var="i" begin="${start}" end="${end}">
		[<a href="${ctx}/BoardListPaging.do?start=${i}&curNum=${start}">${i}</a>]
	</c:forEach>
	<c:if test="${end < totalCnt}">
		[<a href="${ctx}/BoardListPaging.do?start=${start + cnt}&curNum=${start + cnt}">이후</a>]
	</c:if>
	<br>
	<button onclick="location.href='${ctx}/board/main.jsp'"> 메인으로 </button>

</body>
</html>