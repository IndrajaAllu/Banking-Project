<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
    <style>
        body
         {
            text-align: center;
         }
    </style>
</head>
<body>
    <div>
        <img src="images/bank1.jpeg" alt="Image" width="900" height="350">
        <h2>Login</h2>
        <form action="LoginServlet" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <br>
            <input type="password" name="password" placeholder="Password" required>
            <br>
            <input type="submit" value="Login">
        </form>
        <p>Not registered yet? <a href="Register.jsp">Register</a></p>
    </div>
</body>
</html>
	