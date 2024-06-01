<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
     
    <title>Welcome User</title>
    <style>
        body 
        {
            text-align: center;
        }
        h1{ text-align : center }
			nav
			{
				width : 100%
			}
			ul.nav 
			{
	    		list-style:none;
	    		height:36px; line-height:36px;
	    		background:green; 
	    		font-family:Arial, Helvetica, sans-serif;
	    		font-size:16px;
			}
			ul.nav li 
			{
	    		border :2px solid white; 
	    		float:left;
			}
			ul.nav a 
			{
	    		display:block;
	    		padding:0 10px;
	    		color:white;
	    		text-decoration:none;
			}
			ul.nav a:hover, ul.nav li.current a 
				{
					color:green;
	    			background:white;
				} 
    </style>
</head>
<body>
    <div>
    	<img src="images/bank3.jpeg" alt="Image" width="1000" height="200">
        <h2>Welcome <%= session.getAttribute("username") %>!</h2>
        <h3>Select an option from the navigation menu:</h3>
        <ul class="nav">
  			<li><a href="CreateAccount.jsp">Create Account</a></li>
  			<li><a href="Withdraw.jsp">Withdraw Amount</a></li>
  			<li><a href="DepositAmount.jsp">Deposit Amount</a></li>
  			<li><a href="Getdata.jsp">Get Details</a></li>
  			<li><a href="input.jsp">Update Details</a></li>
  			<li><a href="DeleteRecord.jsp">Delete Account</a></li>
  			<li><a href="TransferAmount.jsp">Transfer Amount</a></li>
  			<li><a href="Logout.jsp">Logout</a></li>
		</ul>
    </div>
</body>
</html>
     