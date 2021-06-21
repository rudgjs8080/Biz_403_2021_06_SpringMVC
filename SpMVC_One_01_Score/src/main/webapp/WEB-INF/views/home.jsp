<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/views/include/header.jspf"%>
	<table class="main_table">
		<tr class="main_tr">
			<td>학번</td>
			<td>이름</td>
			<td>전공</td>
			<td>학년</td>
			<td>응시과목</td>
			<td>총점</td>
			<td>평균</td>
		</tr>

		<tr class="list_tr">
			<c:forEach items="${LI}" var="LI">
				<td>${LI.st_num }</td>
				<td>${LI.st_name}</td>
				<td>${LI.st_dept}</td>
				<td>${LI.st_grade}</td>
				<td>${LI.st_subjects}</td>
				<td>${LI.sc_score_sum}</td>
				<td>${LI.sc_score_avg}</td>
			</c:forEach>
		</tr>
	</table>
</body>

</html>