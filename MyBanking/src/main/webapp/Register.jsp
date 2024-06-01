<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
    <style>
        body {
            text-align: center;
        }
    </style>
    <script>
    	function validate()
    	{
			var pwd = document.register.password.value;
			var cnfm = document.register.confirmPassword.value;
			if(pwd != cnfm)
			{
				alert("Password not Match with Confirm Password");	
				return false;
			}
    	}
    </script>
</head>
<body>
    <div>
    	<img src="images/bank2.jpeg" alt="Image" width="900" height="350">
        <h2>Register</h2>
        <form name="register" action="RegisterServlet" method="post" onsubmit="return validate()">
            <input type="text" name="username" placeholder="Username" required>
            <br>
            <input type="password" name="password" placeholder="Password" required>
            <br>
            <input type="password" name="confirmPassword" placeholder="Confirm Password" required>
            <br>
            <input type="submit" value="Register">
        </form>
        <p>Already have an account? <a href="Login.jsp">Login</a></p>
    </div>
</body>
</html>
    