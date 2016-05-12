<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<title>Products</title>
</head>
<body>
	<h2>List of Products</h2>

	<table class="table table-striped" align="center" border="1" >
		<thead>
		<tr bgcolor="lightgreen">
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
			<th>Image</th>
		</tr>
		</thead>

		<c:forEach items="${allProducts }" var="product">
		
		<tbody>

			<tr align="center">
				<td>${product[1] }</td>
				<td>${product[2]}</td>
				<td>${product[3]}</td>
				<td><img width="100px" height="100px"
					src="${pageContext.request.contextPath}/img/${product[4]}"></td>
			</tr>
		</tbody>
		</c:forEach>
	</table>

</body>
</html>









