<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap
<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css" />'>
<script src='<c:url value="js/bootstrap.min.js"/>'></script>
<script src='<c:url value="js/jquery.min.js"/>'></script>
 -->
 
<!-- Bootstrap online -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<!--  -->

<link rel="stylesheet" href='<c:url value="/css/style.css" />'>
<script type="text/javascript" src='<c:url value="js/demo.js"/>'></script>

<title>Index Page</title>
<link rel="icon" type="image/png" href='<c:url value="/img/icon.jpg" />'>
</head>


<body>
	<div class="container">


		<!-- Hit Counter -->

		<%!private int hitCount = 0;%>

		<!-- *************************************************** -->

		<!-- Can not directly access content under WEB-INF -->
		<!-- <img alt="Koala" src="/WEB-INF/media/images/Koala.jpg"> -->

		<img alt="demo_pic" height="200" width="250"
			src='<c:url value="/img/Koala.jpg" />'> <br>
		<hr>
		<h2>Hit Count on this page : (Refresh for more Details)</h2>
		<font size="10" color="green"><%=++hitCount%></font>
		<hr>
		<br> <a class="demo"
			href="${pageContext.request.contextPath }/login">LoginHere</a>

		<button type="button" class="btn btn-success" data-toggle="modal"
			data-target="#popUpWindow">Login</button>

		<div class="modal fade" id="popUpWindow">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- header -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h3 class="modal-title">Log In</h3>
					</div>

					<!-- body (form) -->
					<div class="modal-body">
						<form role="form" action="">
							<div class="form-group">
								<input type="email" class="form-control" placeholder="Email">
							</div>
							<div class="form-group">
								<input type="password" class="form-control"
									placeholder="Password">
							</div>
						</form>
					</div>

					<!-- button -->
					<div class="modal-footer">
						<button href="${pageContext.request.contextPath }/login" class="btn btn-primary btn-block">Login</button>
					</div>

				</div>
			</div>
		</div>


		<br> <br> <br> <a class="demo"
			href="${pageContext.request.contextPath }/signup">SignUp</a> <br>
		<a onclick="testJs()">Test JS</a>
		
		<br><br><br>
		
		<br> <a href="${pageContext.request.contextPath }/tiles">Tiles Demo</a>
		

	</div>
</body>
</html>