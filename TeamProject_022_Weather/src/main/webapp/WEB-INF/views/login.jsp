<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<c:set
	var="rootPath"
	value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta
	http-equiv="X-UA-Compatible"
	content="IE=edge" />
<meta
	name="viewport"
	content="width=device-width, initial-scale=1.0" />
<title>로그인</title>
</head>
<style>
*, *:before, *:after {
	box-sizing: border-box;
}

figure.logo * {
	-webkit-transition: all 0.4s ease;
	transition: all 0.4s ease; /* 호버속도조절 */
}

figure.logo h1:nth-of-type(2) {
	opacity: 0;
	-webkit-transform: translateY(100%);
	transform: translateY(150%); /* 로그인 사라지는반경 */
}

figure.logo:hover figcaption h1:first-of-type, figure.logo.hover figcaption h1:first-of-type
	{
	transform: translateY(200%); /* Log In 사라지는반경 */
	opacity: 0;
}

figure.logo:hover figcaption h1:nth-of-type(2), figure.logo.hover figcaption h1:nth-of-type(2)
	{
	opacity: 1;
	-webkit-transform: translateY(0%);
	transform: translateY(-450%); /* 로그인 높낮이*/
}

body {
	background: linear-gradient(130deg, #7389d0, #eebdc3) no-repeat;
	background-attachment: fixed;
}

h1, h4 {
	/* 상단 로고 부분 */
	color: white;
	text-shadow: 0px 0px 20px rgb(234, 237, 176);
}

h1 {
	text-align: center;
	font-size: 70px;
	height: 10px;
}

h4 {
	font-size: 28px;
	text-align: center;
}

@
keyframes sparkle {from { background-position:0%100%;
	
}

to {
	background-position: 200% 100%;
}

}
section {
	display: grid;
	justify-items: center;
}

fieldset {
	border-radius: 20px;
	display: grid;
	justify-items: center;
	border: 5px solid grey;
	box-shadow: 0px 0px 100px grey;
}

table {
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	box-sizing: border-box;
	border-bottom: 1px solid #ddd;
}

th {
	text-align: center;
	background-color: gray;
	border-radius: 15px;
}

td {
	width: 300px;
}

.input .user {
	width: 300px;
	height: 30px;
	border: 0;
	border-radius: 5px;
}

.input:hover .user:hover {
	animation: sparkle 4s infinite linear;
	background: linear-gradient(90deg, #7389d0, #eebdc3, #7389d0);
	background-size: 300% 100%;
	border-radius: 4px;
	z-index: -1;
	transform: scale(0.99) translateY(3px);
}

#btn_login, #btn_join {
	display: inline-block;
	color: rgb(90, 90, 90);
	transition: all 0.3s ease-out;
	background: linear-gradient(270deg, rgba(223, 190, 106, 0.8),
		rgba(146, 111, 52, 0.8), rgba(34, 34, 34, 0), rgba(34, 34, 34, 0));
	background-position: 1% 50%;
	background-size: 300% 300%;
	border: 1px solid rgba(223, 190, 106, 0.3);
	padding: 5px;
	font-weight: bold;
	font-size: 15px;
}

#btn_login:hover, #btn_join:hover {
	background-position: 99% 50%;
}

button {
	cursor: pointer;
	margin-top: 10px;
	border-radius: 5px;
}
</style>
<body>
	<form
		id="login"
		method="POST">
		<figure class="logo">
			<figcaption>
				<h1>Log In</h1>
				<h1>로그인</h1>
				<h4>WEATHER & OOTD</h4>
			</figcaption>
		</figure>
		<section>
			<fieldset>
				<table class="input">
					<div class="msg">${MSG}</div>
					<tr>
						<th><label>ID</label></th>
						<td><input
								type="text"
								name="us_id"
								class="user"
								placeholder="ID를 입력해주세요" /></td>
					</tr>
					<tr>
						<th><label>PW</label></th>
						<td><input
								type="password"
								name="us_pw"
								class="user"
								placeholder="PW를 입력해주세요" /></td>
					</tr>
				</table>
				<button id="btn_login">LogIn</button>
				<button id="btn_join">Join Us</button>
			</fieldset>
		</section>
	</form>
</body>
</html>