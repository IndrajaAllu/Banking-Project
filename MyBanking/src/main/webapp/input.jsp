<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<title>Account Information</title>
</head>
<body>
 	<h1>Account Information</h1>
 	<form action ="GetDetailsServlet" method ="post">
 	<label>Enter Account Number:</label>
 	<input type="text" name="accountNumber" required><br><br>
 	<input type ="submit" value="Get Info">
 	</form>
</body>
</html>