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
	<c:if test="${empty vo }">
		<h1>일치하는 회원이 없습니다</h1>
	</c:if>
	<c:if test="${!empty vo }">
		<form method="post" action="${ctx}/boardUpdate.do" enctype="multipart/form-data" >
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
						<input type="text" name="subject" id="subject" value="${vo.subject}">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">
						<textarea rows="10" cols="20" name="contents" id="contents">${vo.contents}</textarea>
					</td>
				</tr>
				<tr>
					<td>이미지</td>
					<td colspan="3">
					<c:if test="${vo.sFileName!=null}">
						<img src="image/${vo.sFileName}" id="photo" />
					</c:if>
					<c:if test="${vo.sFileName==null}">
						<img src="https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg" id="photo" class="defalut">
					</c:if>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<input type="hidden" name="no" id="no" value="${vo.no }">
						<input type="button" value="사진 업로드" class='col-3 btn btn-success' id="uploadBtn" />
						<input type="submit" value="수정하기" class='col-3 btn btn-primary' />
						<input type="button" value="사진 삭제" class='col-3 btn btn-warning' id="deleteBtn" />
					</td>
				</tr>
			</table>
		</form>
		<div id="upload">
			<form id="imgForm" enctype="multipart/form-data">
				<input id="uploadFile" type="file" name="uploadFile" accept="image/*"> 
				<input type="hidden" name="no" value="${vo.no}" />
			</form>
		</div>
		<button onclick="location.href='${ctx}/boardIndex.do'">메인으로</button>
	</c:if>
</body>
<script type="text/javascript">
function updateCheck(form){
	
	if(!form.subject.value.trim()){
		alert("제목을 입력해 주세요");
		form.subject.focus();
		return false;
	}
	if(!form.contents.value.trim()){
		alert("내용을 입력해 주세요");
		form.contents.focus();
		return false;
	}
	alert("수정 완료");
	form.submit();
}

let uploadDiv = document.querySelector("#upload");
uploadDiv.style.display = "none";
let uploadBtn = document.querySelector("#uploadBtn");
let deleteBtn = document.querySelector("#deleteBtn");

let input = document.querySelector("#uploadFile");
//  input type ='file' =>> files => 리스트 안에 파일 객체들이 들어가있다 
input.addEventListener("change" , ()=> {
	let fName= input.files[0].name;
    let fSize= input.files[0].size;
    console.log("fileName =" + fName);
    console.log("fileSize =" + fSize);

	let fileForm = /(.*?)\.(jpg|jpeg|png|gif|PNG)$/;
	let maxSize = 5 * 1024 * 1024;
	
	if(fName != "" && fName != null) {
		if(!fName.match(fileForm)) {
	    	alert("이미지 파일만 업로드 가능");
	        return false;
	    }
	    if(fSize >= maxSize) {
	    	alert("파일 사이즈는 5MB까지 가능");
	        return false;
	    }
	}else{
		return false;
	}
	
	let form = document.querySelector("#imgForm");
		let formData = new FormData(form);
	
	    fetch('boardUploadImg.do', {
		    method: 'POST',
		    body: formData,
		})
		.then(response => response.text())
		.then(data => {
			if (data === 'fail') {
				alert('이미지 업로드 실패');
		    } else {
		        alert('이미지 업로드 성공');
		        
		        let beforeName = document.querySelector('#photo').src;
		        beforeName = beforeName.substring(beforeName.lastIndexOf("/")+1);
		        let src = 'image/' + data;
		        document.querySelector('#photo').setAttribute('src', src);
		        document.querySelector('#photo').classList.remove("defalut");
		        
		        deleteBeforeImg(beforeName);
		    }
		})
		.catch(error => {
			console.log('error=', error);
		});
})

uploadBtn.addEventListener("click" , ()=> {
   uploadDiv.style.display = "block";
});

deleteBtn.addEventListener("click" , ()=> {
   if(document.querySelector('.defalut')){
	   alert('기본이미지는 삭제할 수 없습니다');
	   return;
   }
   fetch('boardDeleteImg.do', {   
	   method: "POST",
	   headers: {
		   "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
	   },
	   body: "no=" + document.querySelector('#no').value,
   }) 
   .then(response => response.text())
   .then(data => { 
	   if (data === 'fail') { 
		   alert('이미지 삭제 실패'); 
	   } else { 
		   alert('이미지 삭제 성공');
		   let src = 'https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg';
		   document.querySelector('#photo').setAttribute('src', src);
		   document.querySelector('#photo').classList.add("defalut"); 
	   }
   }) 
   .catch(error => { 
	   console.log('error=', error);
   });
});

function deleteBeforeImg(savedFileName){
   let url ='boardUploadImg.do?sName='+ savedFileName;
   fetch(url).then(response => console.log(response)) 
   .catch(error => {      
	   console.log('error=', error);
   });
}
</script>
</html>