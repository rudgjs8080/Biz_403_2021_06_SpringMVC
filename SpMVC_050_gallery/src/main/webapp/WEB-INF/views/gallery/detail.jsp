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
<style>
form {
	
	display: flex;
	padding-left: 20%;
}

div#gallery_files {
	display: flex;
	felx-wrap: wrap;
}

div#gallery_files img {
	margin: 2px;
	text-align: center;
}

div .#gallery_info {
	text-align: center;
}

fieldset {
	width: 60%;
	border-radius: 10px;
	padding: 0.7rem;
	border: 1px solid green;
	padding-left: 10%;
}

legend {
	text-align: center;
	font-size: 50px;
}

form label {
	display: inline-block;
	margin: 5px;
	padding: 8px 16px;
}

form label {
	width: 30%;
	text-align: left;
	font-weight: bold;
}
</style>
<form>
	<fieldset>

		<legend>제목 : ${GFLIST[0].g_subject}</legend>
		<div id="gallery_info">
			<div>
				<label>작성일 : ${GFLIST[0].g_date}</label>
			</div>
			<div>
				<label>작성시각 : ${GFLIST[0].g_time}</label>
			</div>
			<div>
				<label>작성자 : ${GFLIST[0].g_writer}</label>
			</div>
			<div>
				<label>작성내용 : ${GFLIST[0].g_content}</label>
			</div>
		</div>

		<div id="gallery_files">
			<c:forEach
				items="${GFLIST}"
				var="FILE">
				<img
					src="${rootPath}/files/${FILE.f_upname}"
					height="100px">

			</c:forEach>
		</div>
	</fieldset>
</form>
