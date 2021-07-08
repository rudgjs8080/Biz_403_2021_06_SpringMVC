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
<title>회원가입</title>
</head>
<style>
*, *:before, *:after {
	box-sizing: border-box;
}

figure.snip1432 * {
	-webkit-transition: all 0.4s ease;
	transition: all 0.4s ease; /* 호버속도조절 */
}

figure.snip1432 h1:nth-of-type(2) {
	opacity: 0;
	-webkit-transform: translateY(100%);
	transform: translateY(150%); /* 회원정보수정 사라지는반경 */
}

figure.snip1432:hover figcaption h1:first-of-type, figure.snip1432.hover figcaption h1:first-of-type
	{
	transform: translateY(200%); /* changing 사라지는반경 */
	opacity: 0;
}

figure.snip1432:hover figcaption h1:nth-of-type(2), figure.snip1432.hover figcaption h1:nth-of-type(2)
	{
	opacity: 1;
	-webkit-transform: translateY(0%);
	transform: translateY(-450%); /* 회원정보수정 높낮이*/
}

body {
	background: linear-gradient(130deg, #7389d0, #eebdc3);
	background-repeat: no-repeat;
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
	/* 개인정보 등록하는 부분을 감싼 옅은 선 */
	display: grid;
	justify-items: center;
}

fieldset {
	/* 개인정보 등록하는 부분을 감싼 옅은 선 */
	border-radius: 20px;
	display: grid;
	justify-items: center;
	border: 5px solid grey;
	box-shadow: 0px 0px 100px grey;
}

table {
	border-collapse: collapse;
}

.joinTable th, .joinTable td {
	padding: 10px;
	box-sizing: border-box;
	border-bottom: 1px solid #ddd;
}

.joinTable th {
	text-align: center;
	background-color: gray;
	border-radius: 15px;
}

.joinTable td {
	width: 400px;
}

.joinTable .textForm {
	width: 300px;
	height: 30px;
	border: 0;
	border-radius: 5px;
}

.joinTable:hover .textForm:hover {
	animation: sparkle 4s infinite linear;
	background: linear-gradient(90deg, #7389d0, #eebdc3, #7389d0);
	background-size: 300% 100%;
	border-radius: 4px;
	z-index: -1;
	transform: scale(0.99) translateY(3px);
}

.joinTable .btn {
	width: 70px;
	cursor: pointer;
	border: 0;
	border-radius: 5px;
}

.btn {
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

.btn:hover {
	background-position: 99% 50%;
}

button {
	cursor: pointer;
	margin-top: 10px;
	border-radius: 5px;
}
</style>
<body>
	<figure class="snip1432">
		<figcaption>
			<div>
				<h1>Sign Up</h1>
				<h1>회원가입</h1>
			</div>
			<div>
				<h4>WEATHER & OOTD</h4>
			</div>
		</figcaption>
	</figure>
	<section id="join_wrap">
		<form method="POST" class="form_join">
			<fieldset>
				<table class="joinTable">
					<tr>
						<th class="first"><label for="user_id">ID</label></th>
						<td><input
								type="text"
								id="user_id"
								class="textForm"
								placeholder="ID를 입력..." />
							<button
								id="id_check"
								type="button">중복확인</button></td>
					</tr>
					<tr>
						<th><label for="user_pwd">PW</label></th>
						<td><input
								type="password"
								id="user_pwd"
								class="textForm"
								placeholder="비밀번호를 입력..." /></td>
					</tr>
					<tr>
						<th><label for="user_pwd_check">PW(check)</label></th>
						<td><input
								type="password"
								id="user_pwd_ch"
								class="textForm"
								placeholder="비밀번호를 재확인..." /></td>
					</tr>
					<tr>
						<th>지역선택</th>
						<td><select
							name="user_country"
							class="textForm">
								<option>선택</option>
								<option>서울</option>
								<option>대전</option>
								<option>대구</option>
								<option>부산</option>
								<option>광주</option>
								<option>경기도</option>
								<option>강원도</option>
								<option>충청북도</option>
								<option>충청남도</option>
								<option>전라북도</option>
								<option>전라남도</option>
								<option>경상북도</option>
								<option>경상남도</option>
						</select></td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td><input class="textForm" /></td>
					</tr>
				</table>
				<button
					type="button"
					class="btn" id="btn_join">가입하기</button>
			</fieldset>
		</form>
	</section>
</body>
<script>

let user_id = document.querySelector("td input#user_id");
let user_pwd = document.querySelector("td input#user_pwd");
let user_pwd_ch = document.querySelector("td input#user_pwd_ch");

document.querySelector("button#id_check").addEventListener("click", ()=>{
	let json = {user_id}
	let jsonString = JSON.stringify(json);
	fetch("${rootPath}/idcheck/" + user_id.value)
	.then(res=>res.text())
	.then(result=>{
	if(result == "1"){
	alert("이미 사용중인 아이디 입니다")
	user_id.focus();
	user_id.value=""
	return false;
	} else {
	alert("사용할 수 있는 아이디 입니다")
	
	}
	})
})
document.querySelector("button.btn").addEventListener("click",()=>{
	
	if((user_id) == ""){
	alert("ID를 입력하세요")
	user_id.focus();
	return false
	}
	if((user_pwd) == ""){
	alert("비밀번호를 입력해주세요")
	user_pwd.focus();
	return false
	}
	if((user_pwd_ch) == ""){
	alert("비밀번호 확인이 맞지 않습니다")
	user_pwd_ch.focus();
	return false
	}
    document.querySelector("form.form_join").submit();
})

    /*document.addEventListener("DOMContentLoaded", () => {
      document.querySelector("button").addEventListener("click", (ev) => {
        alert("회원가입을 환영합니다!");
        alert("상세 날씨 페이지로 이동합니다");
        document.location.href =
          "http://127.0.0.1:5501/weather_ootd/logout.html";
      });
    });
    document.addEventListener("DOMContentLoaded", () => {
      document
        .querySelector("select.textForm")
        .addEventListener("change", (ev) => {
          alert("상세주소를 선택해주세요");

          window.open(
             회원가입 팝업창 생성 

            "popup.html",
            "popup01",
            "width=500, height=400, fullscreen=yes",
            "scrollbars= 0, toolbar=0, menubar=no"
          );
        });
    });*/
  </script>
</html>