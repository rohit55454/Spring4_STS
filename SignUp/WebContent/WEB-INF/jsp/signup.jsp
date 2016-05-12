<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp here</title>
</head>
<body>

<label style="color:red; font-size: 5">${error_msg }</label>
<label style="color:green;"><font size=10>${message }</font></label>

<form action="${pageContext.request.contextPath }/signup" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>Username : </td><td><input type="text" name="username" placeholder="enter username" required></td>
		</tr>
		<tr>	
			<td>Password : </td><td><input type="password" name="password" placeholder="enter password" required></td>
		</tr>
		<tr>	
			<td>Enter Password Again : </td><td><input type="password" name="repassword" placeholder="re-enter password" required></td>
		</tr>
		
		<tr>	
			<td>Email : </td><td><input type="email" name="email" placeholder="enter email" required></td>
		</tr>
		
		<tr>	
			<td>Phone : </td><td><input type="text" name="phone" placeholder="enter phone" length="10" required></td>
		</tr>
		
		<tr>	
			<td>Date of Birth: </td><td><input type="date" name="dob" required></td>
		</tr>
		
		<tr>	
			<td>Gender : </td><td><input type="radio" name="gender" value="male" required>Male</td>
							  <td><input type="radio" name="gender" value="female" required>Female</td>
		</tr>
		
		<tr>	
			<td>Vehicle : </td><td><input type="checkbox" name="vehicle" value="car">Car</td>
							   <td><input type="checkbox" name="vehicle" value="bike">Bike</td>
		</tr>
		
		<tr>	
			<td>Country: </td><td><select name="country">
									  <option value="india">INDIA</option>
									  <option value="USA" selected="selected">USA</option>
									  <option value="UK">UK</option>
								  </select>
							  </td>
		</tr>
		
		<tr>	
			<td>Photo : </td><td><input type="file" name="image" value="car" required></td>
		</tr>
		

		<tr><td></td><td><input type="submit" value="SignUp"> </td> </tr>
	</table>
</form>	

</body>
</html>