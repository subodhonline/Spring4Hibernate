<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css'/>" />
<script src="<c:url value="/resources/javascript/jquery-2.1.1.js"/>"></script>
<script
	src="<c:url value="/resources/javascript/jquery-ui-1.10.4.min.js"/>"></script>
<script src="<c:url value="/resources/javascript/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/javascript/constant.js"/>"></script>
<script src="<c:url value="/resources/javascript/comman.js"/>"></script>
<script src="<c:url value="/resources/javascript/createUser.js"/>"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-fluid margin-top-from-page">
		<div class="row">

			<div class="col-md-10">

				<form:form id="createUserForm" method="post" action="createUser.htm"
					commandName="user" class="form  form-horizontal" role="form">
					<div class="form-group required">
						<spring:message code="label.firstName" var="firstName" />
						<label class="col-sm-2 control-label">${firstName}</label>
						<div class="col-md-2">
							<form:input path="firstName" type="text" class="form-control"
								id="firstName" placeholder="${firstName}" value="" />
							<span class="help-inline  errorMessage" id="firstNameMessage" value=""></span>
							<form:errors path="firstName" cssClass="help-inline  errorMessage"/>
						</div>
					</div>

					<div class="form-group required">
						<spring:message code="label.lastName" var="lastName" />
						<label class="col-sm-2 control-label">${lastName}</label>
						<div class="col-md-2">
							<form:input path="lastName" type="text" class="form-control"
								id="lastName" placeholder="${lastName}" value='${user.lastName}' />
							<span class="help-inline  errorMessage" id="lastNameMessage" value=""></span>
							<form:errors path="lastName" cssClass="help-inline  errorMessage" />
						</div>
					</div>
					<div class="form-group required">
						<spring:message code="label.email" var="email" />
						<label class="col-sm-2 control-label">${email}</label>
						<div class="col-md-2">
							<form:input path="email" type="email" class="form-control"
								id="email" placeholder="${email}" value="" />
							<span class="help-inline  errorMessage" id="emailMessage" value=""></span>
						</div>
					</div>
					<div class="form-group required">
						<spring:message code="label.password" var="password" />
						<label class="col-sm-2 control-label">${password}</label>
						<div class="col-md-2">
							<form:input path="password" type="password" class="form-control"
								id="password" placeholder="${password}" value="" />
							<span class="help-inline  errorMessage" id="passwordMessage" value=""></span>
						</div>
					</div>
					<div class="form-group required">
						<spring:message code="label.select.with.dashes"
							var="selectWithDashes" />
						<label class="col-sm-2 control-label"><spring:message
								code="label.role" /></label>
						<div class="col-md-2">
							<form:select path="role.id" id="role" class="form-control">
								<option value="-1" selected>${selectWithDashes}</option>
								<form:options items="${roleMap}" />
							</form:select>
							<span class="help-inline  errorMessage" id="roleMessage" value=""></span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2">
							<button id="submit"
								class="btn btn-default margin-left-submit-button">
								<spring:message code="label.submit" />
							</button>
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>