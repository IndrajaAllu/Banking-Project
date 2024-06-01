<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>TransferAmount</title>
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
        <form action ="TransferAmountServlet" method="post">
        <label> Enter  Source Account:</label>
        <input type="text" name="src" required><br/><br/>
        
        <label>Enter Amount:</label>
        <input type="text" name="amount" required><br/><br/>
        
        <label> Enter Destination Account:</label>
        <input type="text" name="dest" required><br/><br/>
        
           <input type="submit" value="Transfer amount">
        </form>
        </div>


</body>
</html>