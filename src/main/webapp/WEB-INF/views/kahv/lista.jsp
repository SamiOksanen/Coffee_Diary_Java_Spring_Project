<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="kahv.lista.title"/></title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
</head>	
<body>
	<div id="langsel">
		<a href="?lang=en">en</a> | <a href="?lang=fi">fi</a>
	</div>
	
	<table>
	<caption><spring:message code="kahv.lista.caption"/></caption>
	<thead>
		<tr>
			<td>ID</td>
			<td><spring:message code="kahv.lista.maara"/></td>
			<td><spring:message code="kahv.lista.paiva"/></td>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${kahvit}" var="kahv">
		<tr>
			<td><c:out value="${kahv.id}"/></td>
			<td><c:out value="${kahv.maara}"/></td>
			<td><c:out value="${kahv.paiva}"/></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	<p><a href="uusi"><spring:message code="kahv.lista.uusi"/></a>
</body>
</html>