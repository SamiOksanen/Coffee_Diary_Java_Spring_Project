<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title><spring:message code="kahv.create.title"/></title>
<link rel="stylesheet" type="text/css" href="../resources/styles/common.css">
<link rel="stylesheet" type="text/css" href="../resources/styles/form.css">
</head>	
<body>

	<div id="langsel">
		<a href="?lang=en">en</a> | <a href="?lang=fi">fi</a>
	</div>

	<h1><spring:message code="kahv.create.heading"/></h1>
		<form:form modelAttribute="kahvi" method="post">
		  	<fieldset>		
				<legend><spring:message code="kahv.create.legend"/></legend>
				<p>
					<form:label	path="maara"><spring:message code="kahv.create.maara"/></form:label><br/>
					<form:input path="maara" cssErrorClass="VirheellinenKentta"/> <form:errors path="maara" cssClass="Virheteksti"/>
				</p>
				<p>	
					<form:label path="paiva"><spring:message code="kahv.create.paiva"/></form:label><br/>
					<form:input path="paiva" cssErrorClass="VirheellinenKentta"/> <form:errors path="paiva" cssClass="Virheteksti"/>
				</p>
				<p>	
					<button type="submit"><spring:message code="kahv.create.add"/></button>
					<a href="paivakirja"><spring:message code="kahv.create.peru"/></a>
				</p>
			</fieldset>
		</form:form>
</body>
</html>