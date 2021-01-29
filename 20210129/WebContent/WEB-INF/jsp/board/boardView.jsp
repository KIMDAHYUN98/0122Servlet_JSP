<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>

<script type="text/javascript">
	function deleteAlert() {
		var yn = confirm("정말 삭제하시겠습니까?");
		if (yn) {
			frm.action="boardDelete.do";
			frm.submit();
		}
	}
	function editAlert() {

		frm.action="boardEdit.do";
		frm.submit();
	}
</script>
</head>


<jsp:include page="../main/menu.jsp" />
<!-- Page content -->
<div class="w3-content" style="max-width: 2000px; margin-top: 46px" align="center">

	<div align="center">
		<div>
			<h1>게시글 상세 보기</h1>
		</div>

		<div>
		<form id="frm" name="frm" method="post">
			<table border="1">
				<tr>
					<th width="100">글 번호</th>
					<td width="100" align="center">
						<input type="text" id="bId" name="bId" value="${vo.bId }" readonly="readonly"></td>
					<th width="100">작성자</th>
					<td width="140" align="center">${vo.bName }</td>
					<th width="100">작성일자</th>
					<td width="120" align="center">${vo.bDate }</td>
					<th width="100">조회수</th>
					<td width="100" align="center">${vo.bHit }</td>
				</tr>
				<tr>
					<th width="100">제목</th>
					<td colspan="7">${vo.bTitle }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="7"><textarea rows="7" cols="90">${vo.bContent }</textarea>
					</td>
				</tr>
			</table><br />
			<div>
				<c:if test="${not empty list }">
					<c:forEach var="rvo" items="${list }">
						<table border="1">
							<tr>
								<td width="500">${rvo.subject }</td>
								<td width="100">${rvo.rdate }</td>
							</tr>
						</table>
					</c:forEach>
				</c:if>
			</div><br/>
				<div>
					<button type="button" onclick="editAlert()">수정</button>&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="deleteAlert()">삭제</button>&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='boardList.do'">목록</button>
					<!--  <input type="hidden" id="bId" name="bId">-->
				</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>