<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href='<c:url value="/css/style.css" />'>
	<script type="text/javascript" src='<c:url value="js/demo.js"/>' ></script>
	<title>Home Page</title>
</head>
<body>
	<!-- Can not directly access content under WEB-INF -->
	<!-- <img alt="Koala" src="/WEB-INF/media/images/Koala.jpg"> -->

	<img alt="demo_pic" height="200" width="250"
		src='<c:url value="/img/Koala.jpg"></c:url>'>
	<br>

	<a class="demo" href="${pageContext.request.contextPath }/login">LoginHere</a>
	<br>
	<a onclick="testJs()">Test JS</a>

</body>
</html>