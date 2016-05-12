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
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
	
<script type="text/javascript">

	function deleteProduct(id) {
		id = id.split("_")[1];

		$.ajax({

			url : "${pageContext.request.contextPath}/deleteProduct",
			type : "POST",
			data : "productId=" + id,

			success : function(response) {
				var table = document.getElementById("productsTable");
				var tr = document.getElementById("tr_" + id);
				table.deleteRow(tr.rowIndex);
				alert(response);
			},

			error : function(error) {
				alert(error);
			}

		});
	}
	
	function addProduct() {

		$.ajax({

			url : "${pageContext.request.contextPath}/addProduct",
			type : "POST",
			data : "productId=" + id,

			success : function(response) {
				var table = document.getElementById("productsTable");
				var tr = document.getElementById("tr_" + id);
				table.addRow(tr.rowIndex);
				alert(response);
			},

			error : function(error) {
				alert(error);
			}

		});
	}
	
</script>

</head>
<body>
	<h2>List of Products</h2>

	<table id="productsTable" class="table table-striped" align="center"
		border="1">
		<thead>
			<tr bgcolor="lightgreen">
				<th>Name</th>
				<th>Price</th>
				<th>Description</th>
				<th>Image</th>
				<th>Action</th>
			</tr>
		</thead>

		<c:forEach items="${allProducts }" var="product">

			<tbody>

				<tr align="center" id="tr_${product.id}">
					<td>${product.name }</td>
					<td>${product.price }</td>
					<td>${product.description }</td>
					<td><img width="100px" height="100px"
						src="${pageContext.request.contextPath}/img/${product.image }"></td>
					<td><input id="btn_${product.id }" type="button"
						value="Delete" onclick="deleteProduct(this.id)"></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<div align="center">
		<input id="btn_${product.nid }" type="button"
			value="   Add new Product  " onclick="addProduct(this.id)">
	</div>
</body>
</html>

