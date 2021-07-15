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
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
<script>

document.addEventListener("DOMContentLoaded", ()=>{
	document.querySelector("div.log_join").addEventListener("click", (e)=> {
		let tagName = e.target.tagName;
		//alert(tagName)
		
		if(tagName === "BUTTON") {
			let menuText = e.target.textContent;
			if (menuText === "login") {
				document.location.href="$redirect:/";
			} else if (menuText === "Join") {
				document.location.href="${rootPath}/join"
			}  else if (menuText === "logout") {
				document.location.href="${rootPath}/logout"
			} else if(menuText ==="MyPage"){
				alert("${MEMVO.us_id}")
				location.href="${rootPath}/mypage?us_id=" + "${MEMVO.us_id}"
			}
		}
	})

	/*
	document.querySelector("li#li_log").addEventListener("click",(e)=>{
		document.location.href="${rootPath}/login"
	})
	document.querySelector("li#li_join").addEventListener("click",(e)=>{
		document.location.href="${rootPath}/join"
	})
	document.querySelector("li#li_logout").addEventListener("click",(e)=>{
		document.location.href="${rootPath}/logout"
	})
	*/
})
</script>
</head>
<link
	href="${rootPath}/static/css/home_A.css?ver=2021-07-15-007"
	rel="stylesheet" />
<body>
	<div>
		<div class="container">
			<div class="item-1">
				<div class="log_join">
					<button class="logout">logout</button>
					<button class="mypage">MyPage</button>
				</div>
				<div class="header">
					<h1 style="font-size: 90px; text-align: center">W O O</h1>
					<h4 style="font-size: 32px; text-align: center">WEATHER & OOTD</h4>
				</div>
			</div>
			<div class="item-2">
				<div
					class="w_1"
					style="border: 1px solid black;">
					<c:forEach
						items="${TODAY}"
						var="TD">
						<c:choose>
							<c:when
								test="${TD.fcstTime == '1200' && TD.category == '3시간 기온'}">
								<div>${TD.fcstValue}</div>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
				<div
					class="w_2"
					style="border: 1px solid black;">

					<c:forEach
						items="${TODAY}"
						var="TD">

						<c:choose>
							<c:when
								test="${TD.category == '하늘상태' && TD.fcstValue =='맑음' && TD.fcstTime == '1200'}">
								<div>
									<img
										src="${rootPath}/static/icon/size-large/맑음.png"
										width="100px">
								</div>
							</c:when>
							<c:when
								test="${TD.category == '하늘상태' && TD.fcstValue =='구름많음'&&TD.fcstTime == '1200' }">
								<div>
									<img
										src="${rootPath}/static/icon/size-large/구름많음.png"
										width="100px">
								</div>
							</c:when>
							<c:when
								test="${TD.category == '하늘상태' && TD.fcstValue =='흐림' &&TD.fcstTime == '1200'}">
								<div>
									<img
										src="${rootPath}/static/icon/size-large/흐림.png"
										width="100px">
								</div>
							</c:when>
							<c:otherwise>

							</c:otherwise>
						</c:choose>
					</c:forEach>

				</div>
				<div
					class="w_3"
					style="border: 1px solid black;">위치시간</div>
				<div class="w_4">
					<div class="w_4_a">
						<div>온도</div>
						<div>
							<img src="${rootPath}/static/images/온도계.png" />
						</div>
						<div>
							<c:forEach
								items="${TODAY}"
								var="TD">
								<c:choose>
									<c:when
										test="${TD.fcstTime == '1200' && TD.category == '3시간 기온'}">
										<div>${TD.fcstValue}</div>
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
					</div>
					<div class="w_4_a">
						<div>습도</div>
						<div>
							<img src="${rootPath}/static/images/온도계.png" />
						</div>
						<div>
							<c:forEach
								items="${TODAY}"
								var="TD">
								<c:choose>
									<c:when
										test="${TD.fcstTime == '1200' && TD.category == '습도'}">
										<div>${TD.fcstValue}</div>
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</div>
					</div>
					<div class="w_4_a">
						<div>강수확률</div>
						<div>
							<img src="${rootPath}/static/images/온도계.png" />
						</div>
						<div><c:forEach
						items="${TODAY}"
						var="TD">
						<c:choose>
							<c:when
								test="${TD.fcstTime == '1200' && TD.category == '강수확률'}">
								<div>${TD.fcstValue}</div>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</c:forEach></div>
					</div>
					<div class="w_4_a">
						<div>바람</div>
						<div>
							<img src="${rootPath}/static/images/온도계.png" />
						</div>
						<div>21</div>
					</div>
				</div>
			</div>
			<div class="item-3">
				<figure class="snip1200">
					<div>
						<img
							class="clothes"
							src="${rootPath}/static/images/clothes.png"
							alt="clothes"
							style="padding-top: 3%" />
						<p style="margin: 10px; font-size: 20px">OOTD 추천을 원하시면 화면에 커서를
							올려주세요</p>
					</div>
					<figcaption class="o">
						<div class="w_data_o">
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/formal-shirt.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/male-clothes.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/polo-shirt.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/polo-shirt.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/polo-shirt.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/polo-shirt.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/polo-shirt.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/polo-shirt.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/polo-shirt.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/polo-shirt.png" />
							</div>
						</div>
						<div class="heading_o">
							<h1>
								<span> OOTD</span>
							</h1>
						</div>
					</figcaption>
				</figure>
			</div>
		</div>
		<div class="item-4">3</div>
	</div>
</body>
</html>