<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="kahv.view.title"/></title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
</head>	
<body>
	<div id="langsel">
		<a href="?lang=en">en</a> | <a href="?lang=fi">fi</a>
	</div>
	
	<h1>
		<spring:message code="kahv.view.heading"/>
	</h1>
	
	<p><spring:message code="kahv.view.maara"/><c:out value="${kahvi.maara}" default="-----"/>
	<br><spring:message code="kahv.view.paiva"/><c:out value="${kahvi.paiva}" default="-----"/>
	<p><a href="paivakirja"><spring:message code="kahv.view.takaisin"/></a>

</body>
</html>