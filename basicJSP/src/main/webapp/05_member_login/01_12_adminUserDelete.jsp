<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript" src="commom.js"></script>
<% 
if(request.getParameter("idx") == null){
	%>
	<script type="text/javascript">
    msgError();
</script>
	<%
}

int idx = Integer.parseInt(request.getParameter("idx"));
@SuppressWarnings("unchecked")
ArrayList<String> pwlist = (ArrayList<String>)session.getAttribute("pwList");
@SuppressWarnings("unchecked")
ArrayList<String> idlist = (ArrayList<String>)session.getAttribute("idList");
@SuppressWarnings("unchecked")
ArrayList<String> namelist = (ArrayList<String>)session.getAttribute("namelist");
@SuppressWarnings("unchecked")
ArrayList<String> genderlist = (ArrayList<String>)session.getAttribute("genderList");
String name = namelist.get(idx);
pwlist.remove(idx);
idlist.remove(idx);
namelist.remove(idx);
genderlist.remove(idx);

%>

	<script>
	msgUrl( "<%= name %> 회원 삭제 완료" ,"01_13_adminUserList.jsp" );
	</script>