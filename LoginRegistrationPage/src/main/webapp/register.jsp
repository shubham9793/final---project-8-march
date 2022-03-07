<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Emp</title>
</head>
<body>
	<div align = "center">
		<form method="get" action = "main">
				
			Full Name : <input name="Name" type="text" placeholder ="Full name"><br>
			Email Address :<input name="email" type="text" placeholder= "Email address"><br>
			Phone Number : <input name="phone" type ="text "placeholder="Phone number"><br>
			<label for="jobs">Select Job type:</label> 
  				<select name="jobs" id="jobs">
    			<option value="Hr">Hr</option>
    			<option value="SDE">SDE</option>
    			<option value="Data Eng.">Data Eng.</option>
    			<option value="Ml Eng.">Ml Eng.</option>
 	 			</select> <br>
			UserName : <input name="uname" type="text" placeholder =uname><br>
			Password: <input name="upass" type="password" placeholder ="pass"><br> 	
			<input type="submit" value="Register">
			<input type="submit" value="Cancle">

		</form>
	</div>
</body>
</html>