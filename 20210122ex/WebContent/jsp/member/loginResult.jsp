<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <jsp:include page="../common/menu.jsp" />
 <div align="center">
 <h1>여기는 로그인 결과를 보여주는 페이지</h1>
	 입력한 아이디 :  ${param.id } <br/> <!-- param.?? -> 파라미터가 가지고 있는 무언가.. -->
	 입력한 비밀번호 : ${param.pw }<br/>
	 돌아올 메세지 : ${param.id }님 ${msg } <!-- 이것을 EL 표현식이라고 불린다. -->
 </div>
</body>
</html>