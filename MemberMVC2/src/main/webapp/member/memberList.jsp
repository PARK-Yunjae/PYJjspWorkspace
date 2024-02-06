<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<h1 class="py-3">회원 목록</h1>

<table class=" py-10 table table-bordered">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>나이</td>
		<td>이메일</td>
		<td>전화번호</td>
		<td>삭제</td>
	</tr>
	<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.num}</td>
			<td><a href="${ctx}/memberContent.do?log=${vo.num}">${vo.id}</a></td>
			<td>${vo.pass}</td>
			<td>${vo.name}</td>
			<td>${vo.age}</td>
			<td>${vo.email}</td>
			<td>${vo.phone}</td>
			<td><input type="button" value="삭제" class="btn btn-outline-dark"
				onclick="location.href='${ctx}/memberDelete.do?log=${vo.num}'"></td>
		</tr>
	</c:forEach>

</table>
</body>
</html>