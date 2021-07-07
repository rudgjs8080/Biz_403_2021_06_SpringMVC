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
<style>
* {
	box-sizing: border-box;
	margin: 1px;
	padding: 0;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	color: red;
}

.input_img {
	text-align: right;
}

div.head {
	padding-top: 25px;
	height: 100px;
	background-color: #ffff00;
	margin-bottom: 20px;
	vertical-align: middle;
	text-align: center;
	height: 100px;
}

div.item_1 {
	margin: 0 auto;
}
</style>
</head>
<body>
	<div class="head">
		<h1>내 갤러리</h1>
	</div>

	<div class="main">
		<c:choose>
			<c:when test="${BODY eq 'GA-INPUT'}">
				<%@ include file="/WEB-INF/views/gallery/input.jsp"%>
			</c:when>
			<c:when test="${BODY eq 'GA-LIST'}">
				<div class="input_img">
					<a href="${rootPath}/gallery/input">이미지 등록</a>
				</div>
				<%@ include file="/WEB-INF/views/gallery/list.jsp"%>
			</c:when>
			<c:when test="${BODY eq 'GA-DETAIL'}">
				<div class="input_img">
					<a href="${rootPath}/gallery">리스트로</a>
				</div>
				<%@ include file="/WEB-INF/views/gallery/detail.jsp"%>
			</c:when>
			<c:otherwise>

			</c:otherwise>
		</c:choose>
		<c:forEach
			items="${FILES}"
			var="FILE">
			<a
				href="${rootPath}/files/${FILE}"
				target="_NEW"> <img
				src="${rootPath}/files/${FILE}"
				width="200px;"
				height="100px;" /></a>
		</c:forEach>
	</div>
</body>
</html>