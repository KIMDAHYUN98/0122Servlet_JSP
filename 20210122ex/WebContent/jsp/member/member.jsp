<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function Passcheck() {
		var form = document.frm;
		var pw = form.pw.value;
		var pwc = form.pwc.value;
		
		if(pw == pwc) {
			form.submit();
		} else {
			alert("패스워드가 일치하지 않습니다.");
			form.pw.value = null;
			form.pwc.value = null;
			form.pw.focus();
		}
	}
</script>
</head>
<body>
<jsp:include page="../common/menu.jsp"/>
<div align="center">
	<div><h1>회 원 가 입</h1></div>
	<div>
		<form id="frm" name="frm" action="../../MemberRegister" method="post">
		<div>
			<table border="1">
				<tr>
					<th width="100">이 름</th>
					<td width="500"><input type="text" id="name" name="name" size="20"></td>
 				</tr>
 				<tr>
					<th width="100">아 이 디</th>
					<td width="500"><input type="text" id="id" name="id" size="20"></td>
 				</tr>
 				<tr>
					<th width="100">패스워드</th>
					<td width="500"><input type="password" id="pw" name="pw" size="20"></td>
 				</tr>
 				<tr>
					<th width="100">패스워드 확인</th>
					<td width="500"><input type="password" id="pwc" name="pwc" size="20"></td>
 				</tr>
 				<tr>
					<th width="100">취 미</th>
					<td width="500">
						<input type="checkbox" id="hobbys" name="hobbys" value="등산">등산
						<input type="checkbox" id="hobbys" name="hobbys" value="낚시">낚시
						<input type="checkbox" id="hobbys" name="hobbys" value="바둑">바둑
						<input type="checkbox" id="hobbys" name="hobbys" value="스포츠">스포츠
						<input type="checkbox" id="hobbys" name="hobbys" value="돌보기">돌보기
						<input type="checkbox" id="hobbys" name="hobbys" value="취미없음" checked="checked">취미없음
					</td>
 				</tr>
 				<tr>
					<th width="100">성 별</th>
					<td width="500">
						<input type="radio" id="gender" name="gender" value="여">여
						<input type="radio" id="gender" name="gender" value="남" checked="checked">남
					</td>
 				</tr>
 				<tr>
					<th width="100">전 화 번 호</th>
					<td width="500"><input type="tel" id="tel" name="tel" size="20"></td>
 				</tr>		
			</table>
		  </div><br/>
		   <div>
		   		<button type="button" onclick="Passcheck()">회 원 가 입</button> &nbsp;&nbsp;&nbsp;
		   		<button type="reset">취소하기</button>
		  </div>
		</form>
	</div><br/>
</div>
</body>
</html>