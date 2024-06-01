<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Update Account Information</title>
</head>
<body>
	<h1> Update Account Information</h1>
	<form action="UpdateNameServlet" method="post">
	<label>Account Number:</label>
	<input type="text" name ="accountNumber" value="${param.accountNumber}" readonly><br><br>
	<label >Account Name:</label>
	<input type ="text" name="accountName" value="${requestScope.accountname}"/><br><br>
	<input type="submit" value="Update">
	</form>
</body>
</html>