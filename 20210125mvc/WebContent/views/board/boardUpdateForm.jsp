<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- boardselect.jsp 와 유사하지만 수정할 수 있는 form -->

<jsp:include page="../common/menu.jsp" />
<div align="center">
	<div><h1>게시글 수정 화면</h1></div>
	<div>
	<form id="frm" name="frm" action="/20210125mvc/BoardUpdateSave.do" method="post">
		<table border="1">
			<tr>
				<th width="70">글번호</th>
				<td align="center" width="50">
					<input type="text" id="No" name="No" value="${vo.boardNo }" readonly>
				</td>
				<th width="70">작성자</th>
				<td align="center" width="150">${vo.writer }</td>
				<th width="70">작성일자</th>
				<td align="center" width="150">${vo.creationDate }</td>
			</tr>
			<tr>
				<th width="70">제목</th>
				<td colspan="5">
					<input type="text" id="title" name="title" value="${vo.title }" size="95">
				</td>
			</tr>
			<tr>
				<th width="70">내용</th>
				<td colspan="5">
					<textarea rows="5" cols="80" id="content" name="content" cols="95">${vo.content }</textarea>
				</td>
			</tr>
		 </table><br/>
			<input type="submit" value="수정"> &nbsp;&nbsp;&nbsp;
			<input type="button" value="목록가기" onclick="location.href='/20210125mvc/BoardList.do'">
		</form>
	</div>
</div>

</body>
</html>