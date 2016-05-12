<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp here</title>

<script type="text/javascript">

	function doValidations(){
		var un = document.getElementById("username").value;
		if(parseInt(un.length) < 4){
			alert("username must be atleast 4 character long");
			return false;
		}
		
		var pw = document.getElementById("password").value;
		if(parseInt(pw.length) < 6){
			alert("Password must be atleast 6 caharater long");
			return false;
		}
		
		var rpw = document.getElementById("repassword").value;
		if(pw!=rpw){
			alert("password does not match..plz try again");
			return false;
		}
		
		var phone = document.getElementById("phone").value;
		if(phone.length < 10){
			alert("phone no. must be of 10 digits");
			return false;
		}
		
		var pin = document.getElementById("pin").value;
		if(pin.length < 6){
			alert("pin code must be of 6 digits");
			return false;
		}
		
		return true;
		
	}

</script>

</head>

<body>
<div>

	<label style="color: red; font-size: 5">${error_msg }</label>
	<label style="color: green;"><font size=10>${message }</font></label>

	<form action="${pageContext.request.contextPath }/signup" method="post"
		enctype="multipart/form-data" onsubmit="return doValidations()">

		<table>
			<tr>
				<td>Username :</td>
				<td><input type="text" id ="username" name="username" value="enter username"
					maxlength="20" size="20" required></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" id="password" name="password"
					placeholder="enter password" min="6" maxlength="20" required></td>
			</tr>
			<tr>
				<td>Enter Password Again :</td>
				<td><input type="password" id="repassword" name="repassword"
					placeholder="re-enter password" required></td>
			</tr>

			<tr>
				<td>Email :</td>
				<td><input type="email" name="email" placeholder="enter email"
					required></td>
			</tr>

			<tr>
				<td>Phone :</td>
				<!-- min="111111111" max="9999999999" -->
				<td><input type="number" id="phone" name="phone" placeholder="enter phone"
					maxlength="10" required></td>
			</tr>

			<tr>
				<td>Date of Birth:</td>
				<td><input type="date" name="dob" min="1-Jan-2000" required></td>
			</tr>

			<tr>
				<td>Gender :</td>
				<td><input type="radio" name="gender" value="male" required>Male</td>
				<td><input type="radio" name="gender" value="female" required>Female</td>
			</tr>

			<tr>
				<td>Vehicle :</td>
				<td><input type="checkbox" name="vehicle" value="car">Car</td>
				<td><input type="checkbox" name="vehicle" value="bike">Bike</td>
			</tr>

			<tr>
				<td>Country:</td>
				<td><select name="country">
						<option value="india">INDIA</option>
						<option value="USA" selected="selected">USA</option>
						<option value="UK">UK</option>
				</select></td>
			</tr>

			<tr>
				<td>Pin Code :</td>
				<td><input type="number" id="pin" name="pin" placeholder="6 digit"
					size="6" maxlength="6" required="required"></td>
			</tr>

			<tr>
				<td>Photo :</td>
				<td><input type="file" name="image" required></td>
				<td><font color="red" size="5">Size upto 800 KB</font> </td>
			</tr>
	
			<tr>
				<td>Resume :</td>
				<td><input type="file" name="resume" required></td>
				<td><font color="red" size="5">Size upto 800 KB</font> </td>
			</tr>
		
			<tr>
				<td></td>
				<td><input type="submit" value="SignUp"></td>
			</tr>
		</table>
		<br>
		<%-- 	<input type="image" src='<c:url value="/submit.png" />'
			alt="SignUp" height="50" width="100">
		<!-- image also used to submit -->
 --%>
	</form>
</div>
</body>


</html>