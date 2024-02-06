<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<c:set var="ctx" value="${ pageContext.request.contextPath }" />

<c:if test="${empty b }">
	<h1 class="py-3">일치하는 회원이 없습니다</h1>
</c:if>

<c:if test="${!empty b }">
	<h1>게시글 수정하기</h1>
	<form method="post" action="${ctx}/BoardUpdate.do">
		<table border="1">
			<tr>
				<th>번호</th>
				<td colspan="3">${b.no }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${b.writer}</td>
				<th>작성일</th>
				<td>${b.regDate}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3"><input type="text" name="subject"
					value="${b.subject}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><textarea rows="10" cols="20" name="contents">${b.contents}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4"><input type="hidden" name="no" value="${b.no}">
					<input type="submit" value="수정하기"></td>
			</tr>
		</table>
	</form>
	<button onclick="location.href='${ctx}/board/main.jsp'">메인으로</button>

</c:if>
</body>
</html>