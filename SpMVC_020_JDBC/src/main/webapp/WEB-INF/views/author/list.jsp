<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
<style>
	
</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<section class="main_sec">
	
	<table>
		<tr>
			<th>저자코드</th>
			<th>저자명</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>주요장르</th>
		</tr>
		<tr>
			<td>저자코드</td>
			<td>저자명</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>주요장르</td>
		</tr>
	</table>
	<div class="btn_box">
		<button class="btn_insert author">저자등록</button>
	</div>
	</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>
</body>
<script>
document.querySelector("button.btn_insert.author").addEventListener("click", () =>{
	location.href = "${rootPath}/author/insert";
	
})


</script>








</html>