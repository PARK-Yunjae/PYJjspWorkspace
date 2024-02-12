<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<style>
tr :last-child {
	text-align: left;
}

input[type=submit], input[type=reset] {
	text-align: center;
}

#btns {
	text-align: center;
}
</style>
<c:if test="${vo==null}">
	<h1 class="py-3">일치하는 회원이 없습니다</h1>
</c:if>
<c:if test="${vo ne null}">
	<h1 class="py-3">${vo.name}회원의상세보기</h1>
	<form action="${ctx}/memberUpdate.do" method="post">
		<input type="hidden" name="num" value="${vo.num}" />
		<table class='table table-bordered'>
			<tr>
				<td>번호</td>
				<td class="left">${vo.num}</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td class="left">${vo.id}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td class="left">${vo.pass}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td class="left">${vo.name}</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input class="col-12" type="text" name="age"
					value="${vo.age}" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input class="col-12" type="text" name="email"
					value="${vo.email}" /></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input class="col-12" type="text" name="phone"
					value="${vo.phone}" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="button"
					value="수정하기" class='col-5 btn btn-primary'
					onclick="updateCheck(form)" /></td>
			</tr>
		</table>
	</form>
</c:if>

</body>
</html>
<script type="text/javascript">

let check = 0;
function updateCheck(form){
	
	if(!form.age.value.trim()){
		alert("나이를 입력해주세요");
		form.age.focus();
		return false;
	}else{
		if(Number(form.age.value.trim()) < 10 || Number(form.age.value.trim()) > 99 ){
			alert("나이 값(10-99)을 정확하게 입력하세요");
			form.age.focus();
			return false;
		}
	}
	
	if(!form.email.value.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/)){
		alert("이메일 형식이 다릅니다");
		form.email.value="test@test.com";
		form.email.focus();
		return false;
	}
	
	if(!form.phone.value.match(/010-\d{3,4}-\d{4}/)){
		alert("전화번호 형식이 다릅니다");
		form.phone.value="010-1234-1234";
		form.phone.focus();
		return false;
	}

	form.submit();
}

</script>