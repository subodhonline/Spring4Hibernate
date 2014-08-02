<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<title>Users</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/smartpaginator.css'/>" />
<script src="<c:url value="/resources/javascript/jquery-2.1.1.js"/>"></script>
<script
	src="<c:url value="/resources/javascript/jquery-ui-1.10.4.min.js"/>"></script>
<script
	src="<c:url value="/resources/javascript/jquery.xdomainrequest.min.js"/>"></script>
<script src="<c:url value="/resources/javascript/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/javascript/smartpaginator.js"/>"></script>
<script src="<c:url value="/resources/javascript/constant.js"/>"></script>
<script src="<c:url value="/resources/javascript/user.js"/>"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-fluid margin-top-from-page">
		<div class="add-user-button">
			<h3>
				<spring:message code="label.usersList" /><a href="/createUser.htm"><spring:message code="label.addUser" /></a>
			</h3>
		</div>

		<table id="usersList" class="table" cellpadding="0" cellspacing="0">
			<thead>
				<tr class="table-header-background">
					<th><spring:message code="label.hash"/></th>
					<th><spring:message code="label.name"/></th>
					<th><spring:message code="label.email"/></th>
					<th><spring:message code="label.role"/></th>
					<th colspan="3" width="50%" style="text-align: center;"><spring:message code="label.action"/></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<div id="smart-paginator" class="paginator"></></div>
		<input type="hidden" id="userCount" name="userCount" value="${userCount}">
</body>
</html>