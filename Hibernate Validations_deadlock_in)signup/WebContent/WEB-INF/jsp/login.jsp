<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login here</title>
</head>
<body>

	<label style="color: red; font-size: 20">${error_msg }</label>

	<form:form action="${pageContext.request.contextPath }/login"
		commandName="user" method="post">
		<table>
			<tr>
				<td>Username :</td>
				<td><form:input type="text" path="username" name="username"
						placeholder="enter username" required="required" /></td>
				<td><form:errors path="username" style="color:red" /> </td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input type="password" path="password" name="password"
						placeholder="enter password" required="required" /></td>
				<td><form:errors path="password" style="color:red" /> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>