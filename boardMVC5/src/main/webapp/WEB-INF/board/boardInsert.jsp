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
	<h1>게시글 추가하기</h1>
	<form action="${ctx}/boardOneAdd.do" method="post" enctype="multipart/form-data" >
		<input type="hidden" name="no" value="${no}">
		<table border="1">
			<tr>
				<th>번호</th>
				<td>${no}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" id="writer"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" id="subject"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="20" name="contents" id="contents"></textarea>
				</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td> 
					<input type="file" name="uploadFile" accept="image/*">
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="작성완료" onclick="insertCheck(form)" /></td>
			</tr>
		</table>
	</form>
	<button onclick="location.href='${ctx}/boardIndex.do'">메인으로</button>
</body>
</html>
<script type="text/javascript">
function insertCheck(form){
	if(!form.writer.value.trim()){
		alert("작성자를 입력해 주세요");
		form.writer.focus();
		return false;
	}
	if(!form.subject.value.trim()){
		alert("제목을 입력해 주세요");
		form.subject.focus();
		return false;
	}	
	if(!form.subject.value.trim()){
		alert("제목을 입력해 주세요");
		form.subject.focus();
		return false;
	}
	if(!form.contents.value.trim()){
		alert("내용을 입력해 주세요");
		form.subject.focus();
		return false;
	}
/* 	else{
		if(!form.contents.value.match(/{10,}$/)){
			alert("10자 이상 입력해 주세요");
			form.contents.focus();
			return false;
		} 
	} */

	form.submit();
}
</script>