<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/style.css'/>" />
<script src="<c:url value="/resources/javascript/jquery-2.1.1.js"/>"></script>
<script
	src="<c:url value="/resources/javascript/jquery-ui-1.10.4.min.js"/>"></script>
<script src="<c:url value="/resources/javascript/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/javascript/home.js"/>"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-fluid margin-top-from-page">
	</div>
</body>
</html>