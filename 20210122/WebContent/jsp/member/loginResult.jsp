<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String msg = null;
	if(id.equals("hong") && pw.equals("1234")) {
		msg = "님 환영합니다.";
	} else {
		msg = "님 존재하지 않습니다.";
	}
%>
<div align="center">
	<%= id + msg %>
	
	<h3><a href="../../index.jsp">홈 가기</a></h3>
</div>
</body>
</html>