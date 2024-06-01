

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
	if(session!=null)
	{
		String user=(String)session.getAttribute("username");  
        out.print("<h1 align='center'>Welcome," + user + " Continue with your transactions</h1>");
		Connection con = null;
		try
		{
			con=DBConnection.get();
			int num=Integer.parseInt(request.getParameter("num"));
			
			 String q1 = "select balance from account where num=?";
		     PreparedStatement ps1=con.prepareStatement(q1);
		     
		    ps1.setInt(1,num);
		    ps1.executeQuery();
		    ResultSet rs1= ps1.executeQuery();
		    if (rs1.next())
		  	{
		  	  int balance=rs1.getInt(1);
		  	  out.println("enter amt to withdraw:");
		  	  int amount=Integer.parseInt(request.getParameter("amount"));
		  	  if(amount<=balance)
		  	  {
		  		  String q2= "update account set balance =balance-? where num=?";
		  		   PreparedStatement ps2=con.prepareStatement(q2);
		  		   ps2.setInt(1,amount);
		  		   ps2.setInt(2,num);
		  		   ps2.executeUpdate();
		  	  } 
		  		   out.print("<h3 align='center'>Withdraw Successfully</h3>");  
			        RequestDispatcher rd=request.getRequestDispatcher("/User.jsp");  
			        rd.include(request, response);  
		 
		  	}
		  	  else
		  	  {
		  		out.print("<h3 align='center'>insufficient balance - Try Again</h3>");  
		        request.getRequestDispatcher("/User.jsp").include(request, response);  

		  	  }
		}
		catch(Exception e)
		{
			out.print("<h3 align='center'>No such account - Try Again</h3>");  
			request.getRequestDispatcher("/User.jsp").include(request, response);
		}
		finally
		{
			if(con != null)
			{
				try {
					con.close();
				} 
				catch (SQLException e) {}
			}
		}
    }
    else
    {
    	 out.print("<h3>You logged out from previous Session - Please Login</h3>");  
         request.getRequestDispatcher("Login.jsp").include(request, response);  
    }
}
}
