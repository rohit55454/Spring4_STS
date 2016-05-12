<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href='<c:url value="/css/style.css" />'>
<script type="text/javascript" src='<c:url value="js/demo.js"/>'></script>
<title>Index 2 Page</title>
</head>
<body>

	<!-- Hit Counter -->
	
	<%!
		private int hitCount = 0;
	%>

	<!-- *************************************************** -->

	<!-- Can not directly access content under WEB-INF -->
	<!-- <img alt="Koala" src="/WEB-INF/media/images/Koala.jpg"> -->

	<img alt="demo_pic" height="200" width="250"
		src='<c:url value="/img/Koala.jpg"></c:url>'>
	<br>
	<hr><h2>Hit Count on this page : </h2>
	<font size="10" color="green"><%=++hitCount %></font>
	<hr>
	<br>
	<a class="demo" href="${pageContext.request.contextPath }/login">LoginHere</a>
	<br>
	<a class="demo" href="${pageContext.request.contextPath }/signup">SignUp</a>
	<br>
	<a onclick="testJs()">Test JS</a>

</body>
</html>