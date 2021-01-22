<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
                #topMenu {
                        height: 30px;
                        width: 1000px;
                }

                #topMenu ul li {
                        list-style: none;
                        color: white;
                        background-color: #2d2d2d;
                        float: left;
                        line-height: 30px;
                        vertical-align: middle;
                        text-align: center;
                }

                #topMenu .menuLink {
                        text-decoration:none;
                        color: white;
                        display: block;
                        width: 150px;
                        font-size: 12px;
                        font-weight: bold;
                        font-family: "Trebuchet MS";
                }
                #topMenu .menuLink:hover {
                        color: red;
                        background-color: #4d4d4d;
                }

</style>

</head>
<body>
<div align="center">
 <nav id="topMenu" >
		<ul>
			<li><a class="menuLink" href="/20210122ex/index.jsp">Home</a></li>
			<li>|</li>
			<li><a class="menuLink" href="/20210122ex/jsp/member/login.jsp">Login</a></li>
			<li>|</li>
			<li><a class="menuLink" href="/20210122ex/jsp/member/member.jsp">Member Join</a></li>
			<li>|</li>
			<li><a class="menuLink" href="#">자유게시판</a></li>
			<li>|</li>
			<li><a class="menuLink" href="#">공지사항</a></li>
			<li>|</li>
			<li><a class="menuLink" href="#">Logout</a></li>
		</ul>
 </nav>
 </div>
</body>
</html>