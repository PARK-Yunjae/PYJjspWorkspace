<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
ArrayList<String> idList = (ArrayList<String>)session.getAttribute("idList");
ArrayList<String> pwList = (ArrayList<String>)session.getAttribute("pwList");
ArrayList<String> namelist = (ArrayList<String>)session.getAttribute("namelist");
ArrayList<String> genderList = (ArrayList<String>)session.getAttribute("genderList");

int idx = 0;
for(int i=0 ; i<namelist.size(); i++){
	if(id.equals(idList.get(i))){
		idx = i;
		break;
	}
}

idList.remove(idx);
pwList.remove(idx);
namelist.remove(idx);
genderList.remove(idx);

session.removeAttribute("idList");
session.removeAttribute("pwList");
session.removeAttribute("namelist");
session.removeAttribute("genderList");
session.setAttribute("idList", idList);
session.setAttribute("pwList", pwList);
session.setAttribute("namelist", namelist);
session.setAttribute("genderList", genderList);
%>

<script>
alert("<%=id%> 회원 삭제 완료");
location.href = "01_12_adminUserList.jsp";
</script>