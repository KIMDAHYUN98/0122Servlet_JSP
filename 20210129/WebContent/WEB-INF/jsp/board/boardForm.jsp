<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 작성</title>
</head>
<body>
<div align="center"><h1>게시글 작성</h1></div>
	<div align="center">
	<form id="frm" name="frm" action="boardInsert.do" method="post">
		<table border="1">
			<tr>
				<th width="100">작성자</th>
				<td width="150"><input type="text" id="bName" name="bName" size="20" required="required"></td>
				<th width="100">작성일자</th>
				<td width="150"><input type="date" id="bDate" name="bDate" size="20" required="required"></td>
			</tr>
			<tr>
				<th width="100">제목</th>
				<td colspan="3"><input type="text"  id="bTitle" name="bTitle" size="70" required="required"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">
					<textarea id="bContent" name="bContent" rows= "7" cols="76" required="required"></textarea>
				</td>
			</tr>
			
			
		</table><br/>
		<button type="submit">등록</button> &nbsp;&nbsp;&nbsp;
		<button type="reset">취소</button> &nbsp;&nbsp;&nbsp;
		<button type="button" onclick="location.href='boardList.do'">목록</button>
	</form>
	</div>
</body>
</html>