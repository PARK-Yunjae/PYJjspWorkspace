<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>내용</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.no}</td>
				<td><a href="${ctx}/boardContent.do?no=${vo.no}">${vo.subject}</a></td>
				<td>${vo.writer}</td>
				<td>${vo.regDate}</td>
				<td>${vo.contents}</td>
				<td><button onclick="deleteCheck('${ctx}','${vo.no}')">삭제</button></td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="6"><c:if test="${start > cnt}">
					[<a
						href="${ctx}/boardListPaging.do?start=${start-1}&curNum=${start-cnt}">이전</a> ]
				</c:if> 
				<c:forEach var="i" begin="${start}" end="${end}">
					[<a href="${ctx}/boardListPaging.do?start=${i}&curNum=${start}">${i}</a>]
				</c:forEach> 
				<c:if test="${end < totalCnt}">
					[<a
						href="${ctx}/boardListPaging.do?start=${start+cnt}&curNum=${start+cnt}">이후</a>]
				</c:if></th>
		</tr>
	</table>
	<button onclick="location.href='${ctx}/boardIndex.do'">메인으로</button>
</body>
</html>
<script type="text/javascript">
function deleteCheck(ctx,no){
	alert("삭제 완료");
	location.href = ctx+"/boardOneDelete.do?no="+no;
}
</script>
