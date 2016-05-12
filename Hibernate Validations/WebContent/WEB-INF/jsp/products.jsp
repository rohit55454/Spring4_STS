<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
	<table align="center" border="1" bordercolor="red">
		<tr bgcolor="lightgreen">
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
			<th>Image</th>
		</tr>

		<c:forEach items="${allProducts }" var="product">

			<tr align="center">
				<td>${product.name }</td>
				<td>${product.price }</td>
				<td>${product.description }</td>
				<td><img width="250px" height="250px"
					src="${pageContext.request.contextPath}/img/${product.image }"></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>









