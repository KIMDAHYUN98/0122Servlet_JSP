<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
<script type="text/javascript">
	function formCheck() {
		
		if (frm.mPassword.value == "") {
			alert("패스워드는 반드시 입력해야 합니다.");
			frm.mPassword.focus();

			return false;
		}
		if (frm.mPassword.value != frm.mPasswordc.value) {
			alert("패스워드가 일치하지 않습니다.");

			frm.mPasswordc.value = null;
			frm.mPasswordc.focus();

			return false;
		}

		if (frm.mName.value == "") {
			alert("이름은 반드시 입력해야 합니다.");
			frm.mName.focus();

			return false;
		}

		return true;
	}

	function idCheck(str) {
		var url = "idCheck.do?mId=" + str;
		if(str == "") {
			alert("아이디를 입력하세요!");
			frm.mId.focus();
		} else {
		window.open(url, "아이디 중복 체크", "width=600, height=400, top=100, left=100");			
		}
	}
</script>

</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<h1>회 원 가 입</h1>
		<form id="frm" name="frm" onsubmit="return formCheck()" action="memberJoin.do" method="post">
			<table border="1">
				<tr>
					<th width="100">아이디</th>
					<td width="325"><input type="text" id="mId" name="mId" required="required" size="30">
						<button type="button" onclick="idCheck(mId.value)">중복체크</button></td>
				</tr>
				<tr>
					<th width="100">비밀번호</th>
					<td width="150"><input type="password" id="mPassword" name="mPassword" required="required" size="30"></td>
				</tr>
				<tr>
					<th width="150">비밀번호 확인</th>
					<td width="150"><input type="password" id="mPasswordc" name="mPasswordc" size="30"></td>
				</tr>
				<tr>
					<th width="150">이 름</th>
					<td width="150"><input type="text" id="mName" name="mName" size="30"></td>
				</tr>
			</table>
			<br />
			<div>
				<input type="submit" value="가입">&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">
			</div>
		</form>
	</div>
</body>
</html>