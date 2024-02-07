<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<h1 class="py-3">회원 가입</h1>
<form action="${ctx}/memberInsert.do" method="post">
	<table class="table table-bordered">
		<tr>
			<td>아이디</td>
			<td><input class="col-5" type="text" name="id" id="id" autofocus
				required /> <input type="button" value="중복체크" id="checkId"
				class="btn btn-outline-dark"></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input class="col-5" type="password" name="pass" id="pw"
				required /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input class="col-5" type="text" name="name" id="name"
				required /></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input class="col-5" type="number" name="age" id="age"
				required /></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input class="col-5" type="email" name="email" id="email"
				required /></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input class="col-5" type="tel" name="phone" id="phone"
				required /></td>
		</tr>
		<tr>
			<td colspan="2" id="btns">
				<input type="button" value="가입" class="col-3 btn btn-primary" onclick="validCheck(form)" /> 
				<input type="reset" value="취소" class="col-3 btn btn-warning" /></td>
		</tr>
	</table>
</form>
</body>
</html>

<script type="text/javascript">
let check = 0;

function validCheck(form){
	if(!form.id.value.trim()){
		alert("아이디를 입력해 주세요");
		form.id.focus();
		return false;
	}
	if(!form.pass.value.trim()){
		alert("패스워드를 입력해 주세요");
		form.id.focus();
		return false;
	}
	if(!form.name.value.trim()){
		alert("이름를 입력해 주세요");
		form.id.focus();
		return false;
	}
	if(!form.age.value.trim()){
		alert("나이를 입력해 주세요");
		form.id.focus();
		return false;
	}else{
		if(Number(form.age.value.trim()) < 10 || Number(form.age.value.trim()) > 99){
			alert("나이값 (10-99) 를 정확하게 입력하세요");
			form.age.focus();
			return false;
		}
	}
	/*
	@ 앞에는 영어소문자,숫자 . _ % + - 만 허용
	@ 골뱅이 필수.
	@ 뒤 . 앞에는 영어소문자,숫자 . - 만 허용
	. 점 필수
	. 뒤에는 영어소문자 2자리 이상
	*/
	if(!form.email.value.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/)){
		alert("이메일 형식이 다릅니다");
		form.email.focus();
		return false;
	}
	if(!form.phone.value.match(/010-\d{3,4}-\d{4}/)){
		alert("전화번호 형식이 다릅니다");
		form.phone.focus();
		return false;
	}
	
	// 중복 버튼 체크
	if(check == 0){
		alert("ID 중복체크 해주세요");
		return false;
	}else if(check == -1){
		alert("ID 중복체크 다시 해주세요");
		return false;
	}
	form.submit();
}

//중복 체크 버튼 클릭 이벤트
document.getElementById("checkId").addEventListener("click", () =>{
	let id = document.getElementById("id").value.trim();
	
	if(id.length === 0){
		alert("id 값을 입력해 주세요");
		document.getElementById("id").focus();
		document.getElementById("id").style.border="";
		return;
	}
	// 원격 API 를 간단하게 호출할 수 있도록 브라우저에서 제공하는 라이브러리
	fetch("vaildIdAjax.do",{
		method: "POST",
		headers:{
			"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
		},
		body: "id=" + id
	})
	.then(response => response.text()) // 여기서 응답이 오는걸
	.then(getResult)				   // 이녀석이 받아서 실행
	.catch( () => alert("에러"));
});

// false true 값 받아와서 가능 불가능 체크
function getResult(data){
	if(data === "valid"){
		alert("이 아이디는 사용 가능 합니다");
		document.getElementById("pw").focus();
		document.getElementById("id").style.border ="3px solid blue";
		check = 1;
	} else if(data === "notValid"){
		alert("이 아이디는 사용 불가능 합니다");
		document.getElementById("id").value = "";
		document.getElementById("id").focus();
		document.getElementById("id").style.border ="3px solid red";
		check = -1;
	}
}

// 백스페이스 키 입력 시 ? 아이디 변경이 되니 체크 해제
document.getElementById("id").addEventListener("keyup", (e)=> {
    if (e.keyCode === 8) {
      check = 0;
    }
    document.getElementById("id").style.border = "";
});
</script>