<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Deposit Amount</title>
	<style>
	 body
	 {
	   text-align:center;
	 } 
</style>
</head>
<body>
	<div>
    	<img src="images/bank3.jpeg" alt="Image" width="1000" height="200">
        <h2>Welcome <%= session.getAttribute("username") %>!</h2>
        <h3>Enter Account Details : </h3>
      <form action="DepositAmountServlet" method="post">
      <label> Enter Account Number:</label>
      <input type="text" name="num" required><br/><br/>
        
      <label>  Enter Amount:</label>
      <input type="text" name="amount" required><br/><br/>
      
      <input type="submit" value="Deposit Amount">
      </form>
	</div>
</body>
</html>